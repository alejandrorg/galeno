/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Galenos.classes;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;

/**
 *
 * @author Gandhi Hernandez
 */
@XmlRootElement
public class ClinicalElement {

    private String nombre;
    private String id;
    private String tipo;
    private String idMed;
    private String mensaje;
    List codes = new ArrayList();
    List names = new ArrayList();
    private String fichero = "";
    private static OntModel model = ModelFactory.createOntologyModel();

    @XmlAttribute(name = "idMed")
    public String getIdMed() {
        return idMed;
    }

    public void setIdMed(String idMed) {
        this.idMed = idMed;
    }

    @XmlElement(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        try{
        this.nombre = nombre.substring(0, nombre.indexOf("("));
        }
        catch(Exception e)
        {
          this.nombre = nombre;
        }
    }

    @XmlElement(name = "tipo")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String Tipo) {
        try{
        this.tipo = Tipo.substring(Tipo.indexOf("(")+1, Tipo.indexOf(")") );
        }
        catch(Exception e)
        {
          this.tipo = Tipo;
        }
    }
    public void setMensaje(String msg){
        this.mensaje = msg;
    }
    public String getMensaje(){
        return this.mensaje;
    }

   

    public List<ClinicalElement> getOriginalSigns(String Id_Disease) throws FileNotFoundException, IOException {

        List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
        elements.clear();
        codes.clear();
        names.clear();
        ClsSigns.loadKBS();
        System.out.println("Recibo " + Id_Disease);
        codes = ClsSigns.processKBSOriginal(Id_Disease);
        if (codes != null) {
            // names = ClsSigns.getSignsNames(codes);
            names = CreateCodeNamesFile.leerfichero(codes);
            for (int j = 0; j < codes.size(); j++) {
                System.out.println(codes.get(j).toString() + "----" + names.get(j).toString());
            }
            ClinicalElement ce;
            for (int i = 0; i < codes.size(); i++) {
                ce = new ClinicalElement();
                ce.setId(codes.get(i).toString());
                ce.setNombre(names.get(i).toString());
                //ce.setTipo("sign");
                ce.setTipo(names.get(i).toString());
                elements.add(ce);
            }
        } else {
            return null;
        }
        return elements;
    }

    public List<ClinicalElement> getDiseasesFromDoc(String Id_Doctor) throws Exception {
        String respuesta = "ok";
        codes.clear();
        names.clear();
        List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
        System.out.println("Id Doctor recibido en getDiseasesFromDoc " + Id_Doctor);

        ClsSigns.loadKBS();
        respuesta = Diseases.llenarlistdocdiseases(Id_Doctor);
        if (respuesta != null) {
            codes = Diseases.getDiseasesCodes();
            //names = Diseases.getDiseasesNames();
            names = CreateCodeNamesFile.leerfichero(codes);

            ClinicalElement ce;
            for (int i = 0; i < codes.size(); i++) {
                ce = new ClinicalElement();
                ce.setId(codes.get(i).toString());
                ce.setNombre(names.get(i).toString());
                ce.setTipo(names.get(i).toString());
                //ce.setTipo("disease");
                //System.out.println("------------------"+names.get(i).toString());
                elements.add(ce);
            }
        } else {
            return null;
        }

        return elements;
    }

    public List<ClinicalElement> getOriginalDiagnosticTest(String Id_Disease) throws FileNotFoundException, IOException {
        codes.clear();
        names.clear();
        List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
        ClsSigns.loadKBS();
        codes = ClsSigns.GetOriginalDiagTestCodes(Id_Disease);
        if (codes != null) {
            //names = ClsSigns.getTestNames(codes);
            names = CreateCodeNamesFile.leerfichero(codes);

            ClinicalElement ce;
            for (int i = 0; i < codes.size(); i++) {
                ce = new ClinicalElement();
                ce.setId(codes.get(i).toString());
                ce.setNombre(names.get(i).toString());
                ce.setTipo(names.get(i).toString());
                //ce.setTipo("test");
                elements.add(ce);
            }
            for (ClinicalElement p : elements) {
                System.out.println("" + p.getNombre());
            }
        } else {
            return null;
        }
        return elements;
    }

    public List<ClinicalElement> getSignsFromDiseasesFromDoc(String Id_Doctor, String Id_Disease) throws FileNotFoundException, IOException {
        List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
        codes.clear();
        names.clear();
        ClsSigns.loadKBS();
        codes = ClsSigns.processKBSMed(Id_Doctor, Id_Disease);
        if (codes != null) {
            // names = ClsSigns.getSignsNames(codes);
            names = CreateCodeNamesFile.leerfichero(codes);

            ClinicalElement ce;
            for (int i = 0; i < codes.size(); i++) {
                ce = new ClinicalElement();
                ce.setId(codes.get(i).toString());
                ce.setNombre(names.get(i).toString());
                ce.setTipo(names.get(i).toString());
                //ce.setTipo("sign");
                //System.out.println("------------------"+names.get(i).toString());
                elements.add(ce);
            }
        } else {
            return null;
        }
        return elements;
    }

    public List<ClinicalElement> getDiagnosticTestFromDiseasesFromDoc(String Id_Doctor, String Id_Disease) throws Exception {
        codes.clear();
        names.clear();
        List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
        ClinicalElement ce;
        ClsSigns.loadKBS();
        try {

            codes = ClsSigns.GetDoctorDiagnosticTestCodes(Id_Doctor, Id_Disease);
            //names = ClsSigns.getSignsNames(codes);
            names = CreateCodeNamesFile.leerfichero(codes);

            for (int i = 0; i < codes.size(); i++) {
                ce = new ClinicalElement();
                ce.setId(codes.get(i).toString());
                ce.setNombre(names.get(i).toString());
                ce.setTipo(names.get(i).toString());
                //ce.setTipo("Diagnostic Test");
                //System.out.println("------------------"+names.get(i).toString());
                elements.add(ce);
            }
        } catch (Exception e) {
            return null;
        }
        return elements;
    }

        
    public List<ClinicalElement> getDiagnosis(List<ClinicalElement> signs, List<ClinicalElement> tests) {
        List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
        try {

            ClinicalElement ce1 = new ClinicalElement();
            ce1.setId("1524367");
            ce1.setNombre("flu");
            elements.add(ce1);
            ClinicalElement ce2 = new ClinicalElement();
            ce2.setId("987603");
            ce2.setNombre("common cold");
            elements.add(ce2);
            ClinicalElement ce3 = new ClinicalElement();
            ce3.setId("7653864");
            ce3.setNombre("Influenza");
            elements.add(ce3);
        } catch (Exception e) {
            return null;
        }
        return elements;

    }

    public List<ClinicalElement> getDiagnosisMD(List<ClinicalElement> signs, List<ClinicalElement> test, String Id_Doctor) {
        List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
        try {
            ClinicalElement ce1 = new ClinicalElement();
            ce1.setId("1524367");
            ce1.setNombre("Arthritis");
            elements.add(ce1);
            ClinicalElement ce2 = new ClinicalElement();
            ce2.setId("987603");
            ce2.setNombre("Asthma");
            elements.add(ce2);
            ClinicalElement ce3 = new ClinicalElement();
            ce3.setId("7653864");
            ce3.setNombre("Brucellosis");
            elements.add(ce3);
        } catch (Exception e) {
            return null;
        }

        return elements;

    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ClinicalElement) {
            return ((ClinicalElement) o).getId().equals(getId());
        }
        return false;
    }
}
