package Galenos.classes;

import java.util.LinkedList;
import java.util.List;

import com.alejandrorg.phd.mdss.LogicMDSS;
import com.alejandrorg.phd.mdss.Consult;
import com.alejandrorg.phd.mdss.DiagnosisResult;
import java.util.ArrayList;


public class Diagnosis {
	 
	   public List<ClinicalElement> GetDiagnosis(List<ClinicalElement> elements, String Id_Doctor) throws Exception {
            Id_Doctor= "global";
	        LinkedList<String> diagnosticos = new LinkedList();
	        List codes = new ArrayList();
	        ClinicalElement ce;
	        for (int i = 0; i < elements.size(); i++) {
	            System.out.println(elements.get(i).getId() + " " + elements.get(i).getTipo());
	        }

	        try {
	            LogicMDSS consulta = new LogicMDSS();
	            Consult c = consulta.createConsult(elements);
	            DiagnosisResult res = consulta.execute(c, Id_Doctor);
	            diagnosticos = res.getDiagnosisResults();
	            
	            for (int i = 0; i < diagnosticos.size(); i++) {
	                System.out.println("diagnostico = "+diagnosticos.get(i).toString());
	            }
	            elements.clear();
	            String nombre;
	            codes = CreateCodeNamesFile.leerfichero2(diagnosticos);
	            for (int i = 0; i < diagnosticos.size(); i++) {
	                ce = new ClinicalElement();
	                nombre = diagnosticos.get(i).toString();
	                nombre = nombre.substring(0, nombre.indexOf("("));
	                ce.setId(codes.get(i).toString()); 
	                ce.setNombre(nombre);
	                ce.setTipo("diagnosis");
	                elements.add(ce);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            ce = new ClinicalElement();
	            ce.setMensaje("ERROR "+e.toString());
	            elements.add(ce);
	            return elements;
	        }

//	        if(Id_Doctor.equalsIgnoreCase("global"))
//	        { elements = (LinkedList<ClinicalElement>) new ClinicalElement().getDiagnosis(elements);    }
//	        else
//	        { elements = (LinkedList<ClinicalElement>) new ClinicalElement().getDiagnosisMD(elements, Id_Doctor); }
//	        
	        if (elements.isEmpty()) {
	            //response.sendError(404, "There are no results for this search");
	            ce = new ClinicalElement();
	            ce.setMensaje("ERROR There are no results for this search");
	            elements.add(ce);
	            return elements;
	        }
	        return elements;
	    }
}
