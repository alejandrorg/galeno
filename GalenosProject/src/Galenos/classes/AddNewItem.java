/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Galenos.classes;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gandhi
 */
public class AddNewItem {

    private OntModel globalmodel=null;
    private OntModel medmodel=null;
    private String file = "C:/gandhi/kbmedglobal/signs.owl";
    private String URI = "file:///C:/gandhi/kbmedglobal/signs.owl#";
    private String testfile = "C:/gandhi/kbmedglobal/dto.owl";
    private String testURI = "file:///C:/gandhi/kbmedglobal/dto.owl#";
    private String clase = "";
    private String individual = "";
    private String med_id = "";
    private String medfile = ""; //C:/gandhi/kbmed"+med_id+"/signs.owl";
    private String medURI = ""; //file:///C:/gandhi/kbmed"+med_id+"/signs.owl#";
    private String nombre="";
    private OutputStream out=null;
    private boolean band = false;
    List<ClinicalElement> signs = new ArrayList<ClinicalElement>();
    List<ClinicalElement> disorders = new ArrayList<ClinicalElement>();
    List<ClinicalElement> tests = new ArrayList<ClinicalElement>();
    List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
    ClinicalElement ce=null;

    public boolean serchcodename(String c_code, String c_name) throws Exception {
        band = false;
//Se leen todos los signs y disorders
        Logic Log = new Logic();
        signs = Log.getAllSigns();
        disorders = Log.getAllDisorders();
        tests = Log.getAllTest();
        //se busca concept_code o el concept_name dentro de los signs y los tests
        System.out.println("Los signs son ");
        for (ClinicalElement c : signs) {
            nombre = c.getNombre();
            System.out.println(nombre);
            if (c.getId().equalsIgnoreCase("I" + c_code) || nombre.equalsIgnoreCase(c_name+" ")) {
                System.out.println("the code of this sign is already in the database");
                band = true;
                
            }

        }
        System.out.println("Los disorders son ");
        for (ClinicalElement c : disorders) {
            nombre = c.getNombre();
            System.out.println(nombre);
            if (c.getId().equalsIgnoreCase("I" + c_code) || c.getNombre().equalsIgnoreCase(c_name+" ")) {
                System.out.println("the code of this sign is already in the database");
                band = true;
            }

        }
         System.out.println("Los test son ");
        for (ClinicalElement c : tests) {
            nombre = c.getNombre();
            System.out.println(nombre);
            if (c.getId().equalsIgnoreCase("I" + c_code) || c.getNombre().equalsIgnoreCase(c_name+" ")) {
                System.out.println("the code of this test is already in the database");
                band = true;
            }
        }
        return band;
    }
public boolean searchfinding(String c_code, String c_name){
	boolean band = false;
	//buscar en el fichero de codesandnames.txt
	try{
		 // Abrimos el archivo
        FileInputStream fstream = new FileInputStream("C:/gandhi/codesandnames.txt");
        // Creamos el objeto de entrada
        DataInputStream entrada = new DataInputStream(fstream);
        // Creamos el Buffer de Lectura
        BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
        String strLinea;
        // Leer el archivo linea por linea
        while ((strLinea = buffer.readLine()) != null) {
            // Imprimimos la línea por pantalla
        	strLinea = strLinea.substring(strLinea.indexOf(",")+1, strLinea.indexOf("(")-1);
            System.out.println(strLinea);
            
           if(strLinea.equalsIgnoreCase(c_name)){
        	   
        	   band = true;
        	   return band;
           }
        }
        // Cerramos el archivo
        buffer.close();
        fstream.close();
        entrada.close();
		 
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return band;
}
    public void newglobalsign(String sign, String name) throws IOException {
       
        try {
            System.out.println("Adding (newsign in global ontology) " + sign + " - " + name);
            globalmodel = null;
            globalmodel = ModelFactory.createOntologyModel();
            globalmodel.read(new File(file).toURI().toString());
            clase = sign;
            OntClass newSign = globalmodel.createClass(URI + clase);
            OntClass newsignsclass = globalmodel.getOntClass(URI + "NewSigns");
            //System.out.println(newsignsclass.getLocalName());
            newSign.setSuperClass(newsignsclass);
            individual = "I" + clase;
            globalmodel.createIndividual(URI + individual, newSign);
            out = new FileOutputStream(file);
            out.flush();
            //globalmodel.write(out, "RDF/XML-ABBREV");
            globalmodel.write(out, "RDF/XML");
            globalmodel.close();
            out.close();
            
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
           
        }
       
    }

    public void newdoctorsign(String sign, String name, String doctor_id) throws IOException {

        try {
            System.out.println("Adding (newsign in doctor ontology) " + sign + " - " + name + "in " + doctor_id);
            med_id = doctor_id;
            medfile = "C:/gandhi/kbmed" + med_id + "/signs.owl";
            medmodel=null;
            medmodel = ModelFactory.createOntologyModel();
            medmodel.read(new File(medfile).toURI().toString());
            medURI = "file:///C:/gandhi/kbmed" + med_id + "/signs.owl#";
            OntClass newSign = medmodel.createClass(medURI + clase);
            OntClass newsignsclass = medmodel.getOntClass(medURI + "NewSigns");
            System.out.println(newsignsclass.getLocalName());
            newSign.setSuperClass(newsignsclass);
            medmodel.createIndividual(medURI + individual, newSign);
            out = new FileOutputStream(medfile);
            out.flush();
            medmodel.write(out, "RDF/XML");
            medmodel.close();
            out.close();
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }
    //agreagr el código y el nombre al fichero codesandnames

    public boolean agregarsignenfichero(String ind, String name) throws IOException {
        boolean flag=false;
        try{
        file = "C:/gandhi/codesandnames.txt";
        individual = ind;
        FileWriter bw = new FileWriter(file, true);
        System.out.println("Adding indivudual " + individual + " - " + name + "in " + file);
        bw.write("\n" + individual + "," + name + " (finding)");
        bw.close();
        flag = true;
        }
        catch(Exception ex){
            ex.printStackTrace();
            flag = false;
        }
        return flag;
    }

    public boolean agregartestenfichero(String ind, String name) throws IOException {
        boolean flag = false;
        try{
        file = "C:/gandhi/codesandnames.txt";
        individual = "I" + ind;
        FileWriter bw = new FileWriter(file, true);
        System.out.println("Adding indivudual " + individual + " - " + name + "in " + file);
        bw.write("\n" + individual + "," + name + " (finding)");
        bw.close();
        flag = true;
        }
        catch(Exception ex){
            ex.printStackTrace();
            flag = false;
        }
        return flag;
    }

    public void newglobaltest(String sign, String name) throws IOException {
        try {
            System.out.println("Adding (newtest in global ontology) " + sign + " - " + name);
            globalmodel = null;
            globalmodel = ModelFactory.createOntologyModel();
            globalmodel.read(new File(testfile).toURI().toString());
            clase = sign;
            OntClass newSign = globalmodel.createClass(testURI + clase);
            OntClass newsignsclass = globalmodel.getOntClass(testURI + "NewTests");
            System.out.println(newsignsclass.getLocalName());
            newSign.setSuperClass(newsignsclass);
            individual = "I" + clase;
            globalmodel.createIndividual(testURI + individual, newSign);
            out = new FileOutputStream(testfile);
            globalmodel.write(out, "RDF/XML-ABBREV");
            globalmodel.close();
            out.close();
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }

    public void newdoctortest(String sign, String name, String doctor_id) throws IOException {
        try {
            System.out.println("Adding (newtest in doctor ontology) " + sign + " - " + name + "in " + doctor_id);
            med_id = doctor_id;
            medfile = "C:/gandhi/kbmed" + med_id + "/dto.owl";
            medmodel = null;
            medmodel = ModelFactory.createOntologyModel();
            medmodel.read(new File(medfile).toURI().toString());
            medURI = "file:///C:/gandhi/kbmed" + med_id + "/dto.owl#";
            OntClass newTest = medmodel.createClass(medURI + clase);
            OntClass newtestsclass = medmodel.getOntClass(medURI + "NewTests");
            System.out.println(newtestsclass.getLocalName());
            newTest.setSuperClass(newtestsclass);
            medmodel.createIndividual(medURI + individual, newTest);
            out = new FileOutputStream(medfile);
            medmodel.write(out, "RDF/XML-ABBREV");
            medmodel.close();
            out.close();
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }

//    public static void main(String args[]) throws IOException {
//        //newsign("35123612", "head pain (finding)", "jose");  
//    }
}
