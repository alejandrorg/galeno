package Galenos.classes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;



public class OnlySigns {
	
	List<String> codes = new ArrayList<String>();
	List<String> names = new ArrayList<String>();
	String ficherosigns = "";
	private static OntModel signsmodel = ModelFactory.createOntologyModel();
	public  List<ClinicalElement> clinicalsigns = new ArrayList<ClinicalElement>();
	
	public OnlySigns(){
			
	}
	
	public List<ClinicalElement> GetOnlySigns(){
		List<ClinicalElement> signs = new ArrayList<ClinicalElement>();
		signs = llenarlistsigns();
		ClinicalElement ce = new ClinicalElement();
		for(int i=0; i<signs.size(); i++){
			ce = signs.get(i);
			System.out.println(ce.getId()+"-"+ce.getNombre()+"-"+ce.getTipo());
		}
		return signs;
	}
  
	public List<ClinicalElement> llenarlistsigns(){
    	try {
    		codes.clear();
    		names.clear();
            ficherosigns = "C:/gandhi/kbmedglobal/signs.owl";   //Toma los signos de la ontolog√≠a original
            String signcode;
            signsmodel = ModelFactory.createOntologyModel();
            signsmodel.read(new File(ficherosigns).toURI().toString());
            ExtendedIterator<Individual> inds = signsmodel.listIndividuals();
            while (inds.hasNext()) {
                signcode = inds.next().toString();
                signcode = signcode.substring(signcode.indexOf("I"));
                codes.add(signcode);
            }

            // names = ClsSigns.getSignsNames(codes);
            names = CreateCodeNamesFile.leerfichero(codes);
            ClinicalElement ce;
            
            for (int i = 0; i < codes.size(); i++) {
                ce = new ClinicalElement();
                ce.setId(codes.get(i).toString());
                ce.setNombre(names.get(i).toString());
                ce.setTipo(names.get(i).toString());
                clinicalsigns.add(ce);
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
         
        System.out.println("dentro del mÈtodo llenarclinicalsigns signs = "+clinicalsigns.size());
        return clinicalsigns;
    }
}
