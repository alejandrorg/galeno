/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Galenos.classes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author gandhi
 */
public class CreateCodeNamesFile {

    private static List codes = new ArrayList();
    private static List names = new ArrayList();
    private static String fichero;
    private static String Sfichero;
    private static OntModel model = ModelFactory.createOntologyModel();
    private static Model model1;
    static String propNs = "file:///C:/gandhi/kbmedglobal/ddxont.owl#";
    private static String relationshipUri = propNs;
    static InputStreamReader isr = new InputStreamReader(System.in);

    public static void main(String args[]) throws IOException {
        List nombres = new ArrayList();
        llenarlistdiseases();
        WriteCodesNames();
        nombres = leerfichero(codes);
        for(int i=0; i<nombres.size(); i++)
        {
          System.out.println(codes.get(i).toString()+" - "+nombres.get(i).toString());
        }
        
    }

    public static void WriteCodesNames() throws IOException {

        names.clear();
        codes.clear();
        try {
            fichero = "C:/gandhi/kbmedglobal/signs.owl";   //Toma los signos de la ontología original
            String signcode;
            model = ModelFactory.createOntologyModel();
            model.read(new File(fichero).toURI().toString());
            ExtendedIterator inds = model.listIndividuals();
            while (inds.hasNext()) {
                signcode = inds.next().toString();
                signcode = signcode.substring(signcode.indexOf("I"));
                codes.add(signcode);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        try {
            fichero = "C:/gandhi/kbmedglobal/dto.owl";   //Toma los tests de la ontología original
            String testcode;
            model = ModelFactory.createOntologyModel();
            model.read(new File(fichero).toURI().toString());
            ExtendedIterator inds = model.listIndividuals();
            while (inds.hasNext()) {
                testcode = inds.next().toString();
                testcode = testcode.substring(testcode.indexOf("I"));
                codes.add(testcode);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        try {
            fichero = "C:/gandhi/kbmedglobal/disont.owl";   //Toma los disorders de la ontología original
            String testcode;
            model = ModelFactory.createOntologyModel();
            model.read(new File(fichero).toURI().toString());
            ExtendedIterator inds = model.listIndividuals();
            while (inds.hasNext()) {
                testcode = inds.next().toString();
                testcode = testcode.substring(testcode.indexOf("I"));
                codes.add(testcode);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        names = ClsSigns.getTestNames(codes);
        //Escribir en el fichero de texto

        Sfichero = "C:/gandhi/codesandnames.txt";
        //File out = new File(Sfichero);
        BufferedWriter bw = new BufferedWriter(new FileWriter(Sfichero));
        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(i) + "--" + names.get(i));
            //bw.write(codes.get(i) + "," + names.get(i) + "\n");
            bw.append(codes.get(i) + "," + names.get(i) + "\n");
        }
        bw.close();

    }

    public static void llenarlistdiseases() //Llena la lista de enfermedades con la ontología original
    {
        codes.clear();

        try {
            model1 = ModelFactory.createDefaultModel();
            Property has_sign = model1.createProperty(relationshipUri, "has_sign");

            fichero = "C:/gandhi/kbmedglobal/ddxont.owl";   //Toma las enfermedades de la ontología original
            try {
                FileInputStream fin = new FileInputStream(fichero);
                model1.read(fin, null);
            } catch (IOException e) {
                System.out.println("Exception caught" + e.getMessage());


            }
// List everyone in the model who has a child:
            ResIterator parents = model1.listSubjectsWithProperty(has_sign);

// Because subjects of statements are Resources, the method returned a ResIterator
            while (parents.hasNext()) {

                // ResIterator has a typed nextResource() method
                Resource person = parents.nextResource();
                codes.add(person.getLocalName());

            }
            model1.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static List<String> leerfichero(List<String> codes) throws FileNotFoundException, IOException {
        List<String> nombres = new ArrayList<String>();
        try {
            for (int i = 0; i < codes.size(); i++) {
                nombres.add(buscarnombre(codes.get(i).toString()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nombres;
    }

    public static String buscarnombre(String codigo) throws FileNotFoundException, IOException {
        String sCadena;
        String prefix1;
        String prefix2;
        String sufix = "";
        prefix1 = codigo;
        prefix2 = "";
        FileReader fr = new FileReader("C:/gandhi/codesandnames.txt");
        BufferedReader bf = new BufferedReader(fr);
        try{
        while ((sCadena = bf.readLine()) != null) {
        	prefix2 = sCadena.substring(0, sCadena.lastIndexOf(","));
         //   System.out.println(prefix);
            if (prefix1.equalsIgnoreCase(prefix2)) {
                sufix = sCadena.substring(sCadena.indexOf(",") + 1, sCadena.length());
                System.out.println(prefix1+"-"+sufix);
            }
        }
        }
        catch(Exception e)
        {
            
            System.out.println("error en la busqueda de nombres en el archivo "+e.toString());
        }
        return sufix;
    }
    
    public static List<String> leerfichero2(List<String> nombres) throws FileNotFoundException, IOException {
        List<String> codigos = new ArrayList<String>();
        try {
            for (int i = 0; i < nombres.size(); i++) {
                codigos.add(buscarcodigo(nombres.get(i).toString()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return codigos;
    }
    public static String buscarcodigo(String nombre) throws FileNotFoundException, IOException {
        String sCadena;
        String prefix = nombre.substring(0, nombre.indexOf("("));
        String sufix = ""; 
        
        FileReader fr = new FileReader("C:/gandhi/codesandnames.txt");
        BufferedReader bf = new BufferedReader(fr);
        try{
        while ((sCadena = bf.readLine()) != null) {
            if (sCadena.contains(prefix)) {
                sufix = sCadena.substring(0, sCadena.indexOf(","));
                System.out.println("sufijo = "+sufix);
            }
        }
        }
        catch(Exception e)
        {
            
            System.out.println("error en la busqueda de nombres en el archivo "+e.toString());
        }
        return sufix;
    }
}
