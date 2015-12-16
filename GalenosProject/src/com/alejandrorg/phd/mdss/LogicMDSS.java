package com.alejandrorg.phd.mdss;

import Galenos.classes.ClinicalElement;
import java.util.LinkedList;

import com.alejandrorg.phd.ont.OWLInferenceManager;
import com.alejandrorg.phd.others.*;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.rdf.model.Resource;
import java.util.Iterator;
import java.util.List;

public class LogicMDSS {

    private LinkedList<Consult> consults;
    private OWLInferenceManager oim;

    public Consult createConsult(List<ClinicalElement> els) {
        Consult c = new Consult("c01");
        System.out.println("En createConsult");
        for (int i = 0; i < els.size(); i++) {
            System.out.println(els.get(i).getId().toString());
        }

        Iterator<ClinicalElement> it = els.iterator();
        while (it.hasNext()) {
            ClinicalElement e = it.next();
            if (e.getTipo().equalsIgnoreCase("sign")) {
                c.addSign(e.getId());
            }
            if (e.getTipo().equalsIgnoreCase("test")) {
                c.addDT(e.getId());
            }
        }
        return c;
    }

    public LinkedList<Consult> getConsults() {
        return this.consults;
    }

    public DiagnosisResult execute(Consult consToExec, String id) throws Exception {
        LinkedList<String> signos = consToExec.getSigns();
        System.out.println("en el método execute");
        for (int i = 0; i < signos.size(); i++) {
            System.out.println(signos.get(i).toString());
        }
        return executeConsult(consToExec, id);
    }

    /**
     * M�todo para ejecutar la consulta.
     * 
     * @param c
     *            Recibe la consulta principal (si hay medicamentos que provocan
     *            interacciones esta consulta se dividir�)
     * @param e
     *            Recibe si se va a mostrar explicaci�n.
     * @param dar
     * @throws Exception
     *             Puede lanzar excepci�n.
     */
    private DiagnosisResult executeConsult(Consult c, String id) throws Exception {
        WriteMeasures.write("Consult: " + c.getName());
        System.out.println("en el método excecuteConsult");
        LinkedList<String> signos = c.getSigns();
        for (int i = 0; i < signos.size(); i++) {
            System.out.println(signos.get(i).toString());
        }
        // MemoryTest.printMemory("Execute consult (start)");
        long t1 = System.currentTimeMillis();
        DiagnosisResult drs = new DiagnosisResult(c);
        oim = new OWLInferenceManager(id);
        Resource r = oim.createConsult(drs);
        oim.executeInference(r, drs);
        if (drs.getDiagnosisResults().size() > 0) {
            for (int j = 0; j < drs.getDiagnosisResults().size(); j++) {
                drs.appendDebug("\t[!] " + drs.getDiagnosisResults().get(j));
            }
        }
        long t2 = System.currentTimeMillis();
        WriteMeasures.write("Time: " + (t2 - t1) + " ms");
        WriteMeasures.write("Memory: "
                + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) + " bytes");
        LinkedList<String> results = drs.getDiagnosisResults();
        System.out.println("Los resultados ");
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i).toString());
        }

        return drs;
    }

    /**
     * M�todo para obtener que signos se han excluido debido a la interacci�n y
     * mostrarlo.
     * 
     * @param signs
     *            Recibe los signos originales.
     * @param consultSigns
     *            Recibe los signos que se han quedado en la consulta.
     * @return Devuelve una lista con los signos excluidos.
     */
    private String getExcludedSigns(LinkedList<String> signs, LinkedList<String> consultSigns) {
        @SuppressWarnings("unchecked")
        LinkedList<String> _signs = (LinkedList<String>) signs.clone();
        String ret = " ";
        for (int i = 0; i < consultSigns.size(); i++) {
            _signs.remove(consultSigns.get(i));
        }
        for (int i = 0; i < _signs.size(); i++) {
            ret += getInfoOfSign(_signs.get(i)) + ", ";
        }
        ret = ret.substring(0, ret.length() - (ret.length() > 2 ? 2 : 1));
        ret += " ";
        return ret;
    }

    /**
     * M�todo para obtener informaci�n de un signo
     * 
     * @param s
     *            Recibe el signo
     * @return Devuelve el valor
     */
    public String getInfoOfSign(String s) {
        OntClass or = oim.getOntModel().getOntClass(oim.getSignsURI() + s);
        if (or != null) {
            return or.getLabel(null) + " (" + s + ")";
        } else {
            OntClass ord = oim.getOntModel().getOntClass(
                    oim.getDiseasesURI() + s);
            if (ord != null) {
                return ord.getLabel(null) + " (" + s + ")";
            }
        }
        return "Not info avalaible (" + s + ")";
    }

    public String getInfoOfDT(String s) {
        OntClass or = oim.getOntModel().getOntClass(oim.getDTsURI() + s);
        if (or != null) {
            return or.getLabel(null) + " (" + s + ")";
        } else {
            OntClass ord = oim.getOntModel().getOntClass(
                    oim.getDiseasesURI() + s);
            if (ord != null) {
                return ord.getLabel(null) + " (" + s + ")";
            }
        }
        return "Not info avalaible (" + s + ")";
    }

    public String getInfoOfDrug(String s) {
        OntClass or = oim.getOntModel().getOntClass(oim.getDrugsURI() + s);
        if (or != null) {
            return or.getLabel(null) + " (" + s + ")";
        }
        return "Not info avalaible (" + s + ")";
    }

    public void restartRuleEngine() throws Exception {
        this.oim.loadRules();
    }
}