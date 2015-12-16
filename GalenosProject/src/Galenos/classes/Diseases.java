/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Galenos.classes;

import SnApi.Concepto;
import java.io.*;
import java.util.*;



import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Model;
//import com.hp.hpl.jena.ontology.Individual;
//import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.rdf.model.ModelFactory;
//import com.hp.hpl.jena.rdf.model.NodeIterator;

/**
 *
 * @author gandhi
 */
public class Diseases {

    private static Model model; 
    private static String fichero;
    static String propNs = "file:///C:/gandhi/kbmedglobal/ddxont.owl#";
    private static String relationshipUri = propNs;
    static List diseases = new ArrayList();
    static List names = new ArrayList();
    static int cont = 0;
    //private static String dirkb;
    private static List kbs = new ArrayList();
    //private static List sympthoms = new ArrayList();
    private static String d;
    private static final String DIR_BASE = "C://gandhi/";
    //private static String ONT_BASE = "ddxont.owl";
    //private static String ONT_DISEASES = "disont.owl";
    //private static String FILE_PREFIX = "file:///";
    //private static String kb;
    //private static ObjectProperty has_sign;
    private static String termino;
    //private static String dis;
    //private static String codigo;
    //private static Individual ind;
    //private static NodeIterator ni;
    //private static String rsc;
    //private static Individual indSign;
    static int num = -1;
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);
    static Concepto p = new Concepto();

    public static String llenarlistdiseases() //Llena la lista de enfermedades con la ontología original
    {
        String respuesta= "ok";
        try{
        model = ModelFactory.createDefaultModel();
        Property has_sign = model.createProperty(relationshipUri, "has_sign");
        
        fichero = "C:/gandhi/kbmedglobal/ddxont.owl";   //Toma las enfermedades de la ontología original
        try {
            FileInputStream fin = new FileInputStream(fichero);
            model.read(fin, null);
        } catch (IOException e) {
            System.out.println("Exception caught" + e.getMessage());
            respuesta = e.getMessage();
            return respuesta;
        }
// List everyone in the model who has a child:
        ResIterator parents = model.listSubjectsWithProperty(has_sign);

// Because subjects of statements are Resources, the method returned a ResIterator
        while (parents.hasNext()) {

            // ResIterator has a typed nextResource() method
            Resource person = parents.nextResource();
            diseases.add(person.getLocalName());
            cont++;
        }
        model.close();
        }
        catch(Exception e)
        {
          respuesta = e.getMessage();
        }
        return respuesta;
    }

    public static String llenarlistdocdiseases(String Id_Doctor) throws Exception //Llena la lista de enfermedades con la ontología original
    {
        String respuesta = "ok";
        diseases.clear();
        model = ModelFactory.createDefaultModel();
        System.out.println("Id Doctor recibido en llenarlistdocdiseases " + Id_Doctor);
        propNs = "file:///C:/gandhi/kbmed"+Id_Doctor+"/ddxont.owl#";
        relationshipUri = propNs;
        Property has_sign = model.createProperty(relationshipUri, "has_sign");
        fichero = "C:/gandhi/kbmed"+Id_Doctor+"/ddxont.owl";   //Toma las enfermedades de la ontología original
        try {
            FileInputStream fin = new FileInputStream(fichero);
            model.read(fin, null);
        } catch (IOException e) {
            System.out.println("Exception caught" + e.getMessage());
            return null;
        }
        // List everyone in the model who has a child:
        ResIterator parents = model.listSubjectsWithProperty(has_sign);

        // Because subjects of statements are Resources, the method returned a ResIterator
        while (parents.hasNext()) {

            // ResIterator has a typed nextResource() method
            Resource person = parents.nextResource();
            diseases.add(person.getLocalName());
            cont++;
        }
        model.close();
        return respuesta;
    }

    public static List getDiseasesCodes() {
        return diseases;
    }

    public static List getDiseasesNames() {
        names.clear();
        for (int i = 0; i < diseases.size(); i++) {
            termino = diseases.get(i).toString().substring(1);
            p.setTermino(termino);
            p.setDimension();
            names.add(p.getConcepto(0));
        }

        return names;
    }

    public static List loadKBS() {  //Llena la lista kbs con las rutas de todos los directorios
        /**
         * En primer lugar creamos un objeto File que apunta al directorio base.
         */
        File dir = new File(DIR_BASE);
        /*
         * Mediante un for con listFiles le decimos que nos devuelva todos los
         * ficheros y subdirectorios.
         */
        for (int i = 0; i < dir.listFiles().length; i++) {
            /*
             * Si el objeto actual es un directorio, asumimos que es el
             * correspondiente a la base de conocimiento de un m�dico
             * determinado.
             */
            if (dir.listFiles()[i].isDirectory()) {
                /*
                 * Si lo es, simplemente a�adimos el nombre del directorio a una
                 * lista y mostramos por pantalla.
                 */
                /*String*/ d = dir.listFiles()[i].toString();
                kbs.add(d);
                //System.out.println(i+".- Directorio (KB) cargado: " + d);
            }
        }
        return kbs;
    }

    public static void main(String args[]) {
        llenarlistdiseases();
        diseases = getDiseasesCodes();
        names = getDiseasesNames();
        for (int i = 0; i < diseases.size(); i++) {
            System.out.print(i + ".- " + diseases.get(i) + "\t");
            System.out.println(names.get(i).toString());
        }
        //El usuario debe seleccionar alguna enfermedad y el sistema debe mostrar sus síntomas
        System.out.print("Select a Disease ");
        try {
            num = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.out.print("The next error has ocurr " + e.getMessage());
        }
        System.out.println("You hace selected the " + names.get(num));
        //Show the signs of the selected disease

        loadKBS();



    }
}
