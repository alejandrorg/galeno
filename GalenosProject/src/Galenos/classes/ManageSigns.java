/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Galenos.classes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.RDFNode;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gandhi
 */
public class ManageSigns {

    private OntModel model=null;
    private OntModel model2=null;
    private OntModel model3=null;
    private String DISEASE="";
    private String SIGN_TO_ADD="";
    private String DISORDER_TO_ADD="";
    private String HAS_DISORDER="";
    private String SIGN_TO_REMOVE="";
    private String DISORDER_TO_REMOVE="";
    private String HAS_SIGN="";
    private OutputStream out = null;
    private String Id_Doctor="";
    private String Id_Disease="";
    private String Id_Sign="";
    private String Id_Disorder="";

    public List<ClinicalElement> LogicAddSignRelation(String Id_Disease, String Id_Sign) {
        List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
        ClinicalElement ce ;
        /*Se invoca al método borrar signo para hacer el borrado lógico*/
         elements = agregarsigno(Id_Disease, Id_Sign);
         
        /*El nuevo estado del model con el signo borrado queda almacenado en model */
        /**/
        try {
            out = new FileOutputStream("c:/gandhi/kbmedglobal/ddxont.owl");
        } catch (Exception ioe) {
            ioe.printStackTrace();
            ce = new ClinicalElement();
            ce.setMensaje("ERROR en logic add relation "+ioe.getMessage());
            elements.add(ce);
            return elements;
        }
        model.write(out, "RDF/XML-ABBREV");
      //  model.close();
        return elements;

    }
    public List<ClinicalElement> LogicAddDisorderRelation(String Id_Disease, String Id_Sign) {
        List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
        ClinicalElement ce ;
        /*Se invoca al método borrar signo para hacer el borrado lógico*/
          elements = agregardisorder(Id_Disease, Id_Sign);
        /*El nuevo estado del model con el signo borrado queda almacenado en model */
        /**/
        try {
            out = new FileOutputStream("c:/gandhi/kbmedglobal/ddxont.owl");
        } catch (Exception ioe) {
            ioe.printStackTrace();
            ce = new ClinicalElement();
            ce.setMensaje("ERROR en logic add relation "+ioe.getMessage());
            elements.add(ce);
            return elements;
        }
        model.write(out, "RDF/XML-ABBREV");
      //  model.close();
        return elements;

    }

    public List<ClinicalElement> agregarsigno(String Id_Disease, String Id_Sign) {
        List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
        ClinicalElement ce ;
        System.out.println("Recibo en agregarsigno "+Id_Disease+" - "+Id_Sign);
       
        DISEASE = "file:///C:/gandhi/kbmedglobal/disont.owl#" + Id_Disease;
        SIGN_TO_ADD = "file:///C:/gandhi/kbmedglobal/signs.owl#" + Id_Sign;
        HAS_SIGN = "file:///C:/gandhi/kbmedglobal/ddxont.owl#has_sign";
        
        InputStream in = null;
        try {
            in = new FileInputStream("C://gandhi//kbmedglobal//ddxont.owl");
        } catch (Exception ioe) {
            ioe.printStackTrace();
            ce = new ClinicalElement();
            ce.setMensaje("ERROR en método agregar signo"+ioe.getMessage());
            elements.add(ce);
            return elements;
        }
        /*
         * Creaci�n del modelo.
         */
        try{
        model = null;
        model = ModelFactory.createOntologyModel();
        //model.read(in, null);
         
        String fichero = "C://gandhi//kbmedglobal//ddxont.owl";
        String fichero2 = "C://gandhi//kbmedglobal//signs.owl";
        model.read(new File(fichero).toURI().toString());
        /*
         * Estamos trabajando a nivel de instancia as� que tratamos de crear instancias (Individual).
         * 
         * Creamos una instancia para la enfermedad a editar (disease) y otra para el signo a borrar (sign)
         * Adem�s, queremos borrar un signo, con lo cual, afecta a la propiedad "has_sign", as� que creamos su objeto tambi�n.
         */
        model2 = ModelFactory.createOntologyModel();
        model2.read(new File(fichero2).toURI().toString());
        System.out.println("SING TO ADD "+SIGN_TO_ADD);
        Individual disease = model.getIndividual(DISEASE);
        Individual sign = model2.getIndividual(SIGN_TO_ADD);
        ObjectProperty has_sign = model.getObjectProperty(HAS_SIGN);
        /*
         * Imprimimos por pantalla simplemente para comprobar que se han creado bien los objetos (no son null).
         */
        System.out.println("Disease: " + disease);
        System.out.println("Sign: " + sign);
        System.out.println("Has Sign: " + has_sign);
        /*
         * Ya estamos listos. Vamos a coger la enfermedad (disease) y listar todas las relaciones que tiene de tipo has_sign
         * e imprimirlas por pantalla. As� mismo, un contador nos dir� el total.
         */
        System.out.println("--------------------------------------");
        System.out.println("--------------- BEFORE ---------------");
        System.out.println("--------------------------------------");
        NodeIterator itInds = disease.listPropertyValues(has_sign);
        int counter = 0;
        RDFNode actSign;
        while (itInds.hasNext()) {
            actSign = itInds.nextNode();//.next();
            System.out.println("has_sign -> " + actSign);
            counter++;
        }
        System.out.println("Total Signs: " + counter);
        /*
         * Ahora BORRAMOS. As� de simple, una sola l�nea de c�digo.
         * 
         * Borramos de la disease (disease), el signo que representa el objeto sign (sign). Como estamos eliminando
         * la propiedad has_sign pues usamos su objeto (has_sign).
         */
        disease.addProperty(has_sign, sign);
           /*
         * E imprimimos para ver como queda el modelo. Como solo estamos borrando un signo, el contador deber� dar un 
         * elemento menos. Y si miramos los elementos, vemos que se ha cargado al que representa sign
         * (file:///C:/gandhi/kbmed7/signs.owl#I248568003)
         */
        System.out.println("--------------------------------------");
        System.out.println("---------------- AFTER ---------------");
        System.out.println("--------------------------------------");
        itInds = disease.listPropertyValues(has_sign);
        counter = 0;
        while (itInds.hasNext()) {
            actSign = itInds.nextNode(); //.next();
            System.out.println("has_sign -> " + actSign);
            counter++;
        }
        System.out.println("Total Signs: " + counter);
        }
        catch(Exception e)
        {
         ce = new ClinicalElement();
         ce.setMensaje("ERROR de búsqueda de Individuals al agregar relaciones "+e.getMessage());
         elements.clear();
         elements.add(ce);
         return elements;
        }
        return elements;

    }
    public List<ClinicalElement> agregardisorder(String Id_Disease, String Id_Disorder) {
        List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
        ClinicalElement ce ;
        System.out.println("Recibo en agregardisorder "+Id_Disease+" - "+Id_Disorder);
       
        DISEASE = "file:///C:/gandhi/kbmedglobal/disont.owl#" + Id_Disease;
        DISORDER_TO_ADD = "file:///C:/gandhi/kbmedglobal/disont.owl#" + Id_Disorder;
        HAS_DISORDER = "file:///C:/gandhi/kbmedglobal/ddxont.owl#has_disorder";
        
        InputStream in = null;
        try {
            in = new FileInputStream("C://gandhi//kbmedglobal//ddxont.owl");
        } catch (Exception ioe) {
            ioe.printStackTrace();
            ce = new ClinicalElement();
            ce.setMensaje("ERROR en método agregar disorder"+ioe.getMessage());
            elements.add(ce);
            return elements;
        }
        /*
         * Creaci�n del modelo.
         */
        try{
        model = null;
        model = ModelFactory.createOntologyModel();
        //model.read(in, null);
         
        String fichero = "C://gandhi//kbmedglobal//ddxont.owl";
        String fichero3 = "C://gandhi//kbmedglobal//disont.owl";
        model.read(new File(fichero).toURI().toString());
        /*
         * Estamos trabajando a nivel de instancia as� que tratamos de crear instancias (Individual).
         * 
         * Creamos una instancia para la enfermedad a editar (disease) y otra para el signo a borrar (sign)
         * Adem�s, queremos borrar un signo, con lo cual, afecta a la propiedad "has_sign", as� que creamos su objeto tambi�n.
         */
        model3 = ModelFactory.createOntologyModel();
        model3.read(new File(fichero3).toURI().toString());
        System.out.println("DISORDER TO ADD "+DISORDER_TO_ADD);
        Individual disease = model.getIndividual(DISEASE);
        Individual disorder = model3.getIndividual(DISORDER_TO_ADD);
        ObjectProperty has_disorder = model.getObjectProperty(HAS_DISORDER);
        /*
         * Imprimimos por pantalla simplemente para comprobar que se han creado bien los objetos (no son null).
         */
        System.out.println("Disease: " + disease);
        System.out.println("Disorder: " + disorder);
        System.out.println("Has Disorder: " + has_disorder);
        /*
         * Ya estamos listos. Vamos a coger la enfermedad (disease) y listar todas las relaciones que tiene de tipo has_sign
         * e imprimirlas por pantalla. As� mismo, un contador nos dir� el total.
         */
        System.out.println("--------------------------------------");
        System.out.println("--------------- BEFORE ---------------");
        System.out.println("--------------------------------------");
        NodeIterator itInds = disease.listPropertyValues(has_disorder);
        int counter = 0;
        RDFNode actDisorder;
        while (itInds.hasNext()) {
            actDisorder = itInds.nextNode();//.next();
            System.out.println("has_sign -> " + actDisorder);
            counter++;
        }
        System.out.println("Total Disorders: " + counter);
        /*
         * Ahora BORRAMOS. As� de simple, una sola l�nea de c�digo.
         * 
         * Borramos de la disease (disease), el signo que representa el objeto sign (sign). Como estamos eliminando
         * la propiedad has_sign pues usamos su objeto (has_sign).
         */
        disease.addProperty(has_disorder, disorder);
           /*
         * E imprimimos para ver como queda el modelo. Como solo estamos borrando un signo, el contador deber� dar un 
         * elemento menos. Y si miramos los elementos, vemos que se ha cargado al que representa sign
         * (file:///C:/gandhi/kbmed7/signs.owl#I248568003)
         */
        System.out.println("--------------------------------------");
        System.out.println("---------------- AFTER ---------------");
        System.out.println("--------------------------------------");
        itInds = disease.listPropertyValues(has_disorder);
        counter = 0;
        while (itInds.hasNext()) {
            actDisorder = itInds.nextNode(); //.next();
            System.out.println("has_sign -> " + actDisorder);
            counter++;
        }
        System.out.println("Total Signs: " + counter);
        }
        catch(Exception e)
        {
         ce = new ClinicalElement();
         ce.setMensaje("ERROR de búsqueda de Individuals al agregar relaciones "+e.getMessage());
         elements.clear();
         elements.add(ce);
         return elements;
        }
        return elements;

    }

    //------------------------------------------------------------------

    public void LogicAddNewSign(String Id_Sign) {
        /*Se invoca al método borrar signo para hacer el borrado lógico*/
        agregarnuevosigno(Id_Sign);
        /*El nuevo estado del model con el signo borrado queda almacenado en model */
        /**/
        try {
            out = new FileOutputStream("c:/gandhi/kbmedglobal/signs.owl");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        model.write(out, "RDF/XML-ABBREV");

    }
    //------------------------------------------------------------------

    public void agregarnuevosigno(String Id_Sign) {
        DISEASE = "file:///C:/gandhi/kbmedglobal/disont.owl#" + Id_Disease;
        SIGN_TO_ADD = "file:///C:/gandhi/kbmedglobal/signs.owl#" + Id_Sign;
        HAS_SIGN = "file:///C:/gandhi/kbmedglobal/ddxont.owl#has_sign";
        InputStream in = null;
        try {
            in = new FileInputStream("C://gandhi//kbmedglobal//signs.owl");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        /*
         * Creaci�n del modelo.
         */
        model = ModelFactory.createOntologyModel();
        model.read(in, null);
        /*
         * Estamos trabajando a nivel de instancia as� que tratamos de crear instancias (Individual).
         * 
         * Creamos una instancia para la enfermedad a editar (disease) y otra para el signo a borrar (sign)
         * Adem�s, queremos borrar un signo, con lo cual, afecta a la propiedad "has_sign", as� que creamos su objeto tambi�n.
         */
//		Individual disease = model.getIndividual(DISEASE);
        Individual sign = model.getIndividual(SIGN_TO_ADD);
//		ObjectProperty has_sign = model.getObjectProperty(HAS_SIGN);
		/*
         * Imprimimos por pantalla simplemente para comprobar que se han creado bien los objetos (no son null).
         */
//		System.out.println("Disease: " + disease);
//		System.out.println("Sign: " + sign);
//		System.out.println("Has Sign: " + has_sign);
		/*
         * Ya estamos listos. Vamos a coger la enfermedad (disease) y listar todas las relaciones que tiene de tipo has_sign
         * e imprimirlas por pantalla. As� mismo, un contador nos dir� el total.
         */
        System.out.println("--------------------------------------");
        System.out.println("--------------- BEFORE ---------------");
        System.out.println("--------------------------------------");
//		NodeIterator itInds = disease.listPropertyValues(has_sign);
//		int counter = 0;
//                RDFNode actSign;
//		while (itInds.hasNext()) {
//			actSign = itInds.nextNode();//.next();
//			System.out.println("has_sign -> " + actSign);
//			counter++;
//		}
//		System.out.println("Total Signs: " + counter);
		/*
         * Ahora BORRAMOS. As� de simple, una sola l�nea de c�digo.
         * 
         * Borramos de la disease (disease), el signo que representa el objeto sign (sign). Como estamos eliminando
         * la propiedad has_sign pues usamos su objeto (has_sign).
         */
        model.createIndividual(sign);
        //disease.addProperty(has_sign, sign);
        //disease.addProperty(has_sign, sign);

        /*
         * E imprimimos para ver como queda el modelo. Como solo estamos borrando un signo, el contador deber� dar un 
         * elemento menos. Y si miramos los elementos, vemos que se ha cargado al que representa sign
         * (file:///C:/gandhi/kbmed7/signs.owl#I248568003)
         */
        System.out.println("--------------------------------------");
        System.out.println("---------------- AFTER ---------------");
        System.out.println("--------------------------------------");
//		itInds = disease.listPropertyValues(has_sign);
//		counter = 0;
//		while (itInds.hasNext()) {
//			actSign = itInds.nextNode(); //.next();
//			System.out.println("has_sign -> " + actSign);
//			counter++;
//		}
//		System.out.println("Total Signs: " + counter);
//  
    }
    //-------------------------------------------------------------------

    public List<ClinicalElement> LogicDeleteSignRelation(String Id_Disease, String Id_Sign) {

        List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
        ClinicalElement ce = new ClinicalElement();
         /*Se invoca al método borrar signo para hacer el borrado lógico*/
        elements = borrarsigno(Id_Disease, Id_Sign);
        /*El nuevo estado del model con el signo borrado queda almacenado en model */
        /**/
        try {
            out = new FileOutputStream("c:/gandhi/kbmedglobal/ddxont.owl");
        } catch (Exception ioe) {
            ioe.printStackTrace();
            ce = new ClinicalElement();
            ce.setMensaje("ERROR en el método logic delete relation "+ioe.getMessage());
            elements.clear();
            elements.add(ce);
            return elements;
        }
        model.write(out, "RDF/XML-ABBREV");
        return elements;

    }
    public List<ClinicalElement> LogicDeleteDisorderRelation(String Id_Disease, String Id_Sign) {

        List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
        ClinicalElement ce = new ClinicalElement();
         /*Se invoca al método borrar signo para hacer el borrado lógico*/
        elements = borrardisorder(Id_Disease, Id_Sign);
        /*El nuevo estado del model con el signo borrado queda almacenado en model */
        /**/
        try {
            out = new FileOutputStream("c:/gandhi/kbmedglobal/ddxont.owl");
        } catch (Exception ioe) {
            ioe.printStackTrace();
            ce = new ClinicalElement();
            ce.setMensaje("ERROR en el método logic delete relation "+ioe.getMessage());
            elements.clear();
            elements.add(ce);
            return elements;
        }
        model.write(out, "RDF/XML-ABBREV");
        return elements;

    }

    public List<ClinicalElement> borrarsigno(String Id_Disease, String Id_Sign) {
        List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
        ClinicalElement ce = new ClinicalElement();
        DISEASE = "file:///C:/gandhi/kbmedglobal/disont.owl#" + Id_Disease;
        SIGN_TO_REMOVE = "file:///C:/gandhi/kbmedglobal/signs.owl#" + Id_Sign;
        HAS_SIGN = "file:///C:/gandhi/kbmedglobal/ddxont.owl#has_sign";
        int counter = 0;
        InputStream in = null;
        
        try {
            in = new FileInputStream("C://gandhi//kbmedglobal//ddxont.owl");
        } catch (IOException ioe) {
            ioe.printStackTrace();
            ce = new ClinicalElement();
            ce.setMensaje("ERROR en el método borrar signo "+ioe.getMessage());
            elements.clear();
            elements.add(ce);
            return elements;
        }
        /*
         * Creaci�n del modelo.
         */
        try{
        model = ModelFactory.createOntologyModel();
        model.read(in, null);
        /*
         * Estamos trabajando a nivel de instancia as� que tratamos de crear instancias (Individual).
         * 
         * Creamos una instancia para la enfermedad a editar (disease) y otra para el signo a borrar (sign)
         * Adem�s, queremos borrar un signo, con lo cual, afecta a la propiedad "has_sign", as� que creamos su objeto tambi�n.
         */
        Individual disease = model.getIndividual(DISEASE);
        Individual sign = model.getIndividual(SIGN_TO_REMOVE);
        ObjectProperty has_sign = model.getObjectProperty(HAS_SIGN);
        /*
         * Imprimimos por pantalla simplemente para comprobar que se han creado bien los objetos (no son null).
         */
        System.out.println("Disease: " + disease);
        System.out.println("Sign: " + sign);
        System.out.println("Has Sign: " + has_sign);
        /*
         * Ya estamos listos. Vamos a coger la enfermedad (disease) y listar todas las relaciones que tiene de tipo has_sign
         * e imprimirlas por pantalla. As� mismo, un contador nos dir� el total.
         */
        System.out.println("--------------------------------------");
        System.out.println("--------------- BEFORE ---------------");
        System.out.println("--------------------------------------");
        NodeIterator itInds = disease.listPropertyValues(has_sign);
        
        RDFNode actSign;
        while (itInds.hasNext()) {
            actSign = itInds.nextNode();//.next();
            System.out.println("has_sign -> " + actSign);
            counter++;
        }
        System.out.println("Total Signs: " + counter);
        /*
         * Ahora BORRAMOS. As� de simple, una sola l�nea de c�digo.
         * 
         * Borramos de la disease (disease), el signo que representa el objeto sign (sign). Como estamos eliminando
         * la propiedad has_sign pues usamos su objeto (has_sign).
         */
        disease.removeProperty(has_sign, sign);
        //disease.addProperty(has_sign, sign);

        /*
         * E imprimimos para ver como queda el modelo. Como solo estamos borrando un signo, el contador deber� dar un 
         * elemento menos. Y si miramos los elementos, vemos que se ha cargado al que representa sign
         * (file:///C:/gandhi/kbmed7/signs.owl#I248568003)
         */
        System.out.println("--------------------------------------");
        System.out.println("---------------- AFTER ---------------");
        System.out.println("--------------------------------------");
        itInds = disease.listPropertyValues(has_sign);
        counter = 0;
        while (itInds.hasNext()) {
            actSign = itInds.nextNode(); //.next();
            System.out.println("has_sign -> " + actSign);
            counter++;
        }
        }
        catch(Exception e)
        {
          ce = new ClinicalElement();
          ce.setMensaje("ERROR al buscar Individuals al borrar relaciones "+e.getMessage());
          elements.clear();
          elements.add(ce);
          return elements;
          
        }
        System.out.println("Total Signs: " + counter);
        return elements;

    }

    public List<ClinicalElement> borrardisorder(String Id_Disease, String Id_Disorder){
    	List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
        ClinicalElement ce = new ClinicalElement();
        DISEASE = "file:///C:/gandhi/kbmedglobal/disont.owl#" + Id_Disease;
        DISORDER_TO_REMOVE = "file:///C:/gandhi/kbmedglobal/disont.owl#" + Id_Disorder;
        HAS_DISORDER = "file:///C:/gandhi/kbmedglobal/ddxont.owl#has_disorder";
        int counter = 0;
        InputStream in = null;
        
        try {
            in = new FileInputStream("C://gandhi//kbmedglobal//ddxont.owl");
        } catch (IOException ioe) {
            ioe.printStackTrace();
            ce = new ClinicalElement();
            ce.setMensaje("ERROR en el método borrar signo "+ioe.getMessage());
            elements.clear();
            elements.add(ce);
            return elements;
        }
        /*
         * Creaci�n del modelo.
         */
        try{
        model = ModelFactory.createOntologyModel();
        model.read(in, null);
        /*
         * Estamos trabajando a nivel de instancia as� que tratamos de crear instancias (Individual).
         * 
         * Creamos una instancia para la enfermedad a editar (disease) y otra para el signo a borrar (sign)
         * Adem�s, queremos borrar un signo, con lo cual, afecta a la propiedad "has_sign", as� que creamos su objeto tambi�n.
         */
        Individual disease = model.getIndividual(DISEASE);
        Individual disorder = model.getIndividual(DISORDER_TO_REMOVE);
        ObjectProperty has_disorder = model.getObjectProperty(HAS_DISORDER);
        /*
         * Imprimimos por pantalla simplemente para comprobar que se han creado bien los objetos (no son null).
         */
        System.out.println("Disease: " + disease);
        System.out.println("Disorder: " + disorder);
        System.out.println("Has Disorder: " + has_disorder);
        /*
         * Ya estamos listos. Vamos a coger la enfermedad (disease) y listar todas las relaciones que tiene de tipo has_sign
         * e imprimirlas por pantalla. As� mismo, un contador nos dir� el total.
         */
        System.out.println("--------------------------------------");
        System.out.println("--------------- BEFORE ---------------");
        System.out.println("--------------------------------------");
        NodeIterator itInds = disease.listPropertyValues(has_disorder);
        
        RDFNode actDisorder;
        while (itInds.hasNext()) {
            actDisorder = itInds.nextNode();//.next();
            System.out.println("has_sign -> " + actDisorder);
            counter++;
        }
        System.out.println("Total Disorders: " + counter);
        /*
         * Ahora BORRAMOS. As� de simple, una sola l�nea de c�digo.
         * 
         * Borramos de la disease (disease), el signo que representa el objeto sign (sign). Como estamos eliminando
         * la propiedad has_sign pues usamos su objeto (has_sign).
         */
        disease.removeProperty(has_disorder, disorder);
        //disease.addProperty(has_sign, sign);

        /*
         * E imprimimos para ver como queda el modelo. Como solo estamos borrando un signo, el contador deber� dar un 
         * elemento menos. Y si miramos los elementos, vemos que se ha cargado al que representa sign
         * (file:///C:/gandhi/kbmed7/signs.owl#I248568003)
         */
        System.out.println("--------------------------------------");
        System.out.println("---------------- AFTER ---------------");
        System.out.println("--------------------------------------");
        itInds = disease.listPropertyValues(has_disorder);
        counter = 0;
        while (itInds.hasNext()) {
            actDisorder = itInds.nextNode(); //.next();
            System.out.println("has_disorder -> " + actDisorder);
            counter++;
        }
        }
        catch(Exception e)
        {
          ce = new ClinicalElement();
          ce.setMensaje("ERROR al buscar Individuals al borrar relaciones "+e.getMessage());
          elements.clear();
          elements.add(ce);
          return elements;
          
        }
        System.out.println("Total Disorders: " + counter);
        return elements;

    }
//    public static void main(String[] args) {
//        Id_Doctor = "miki";
//        Id_Disease = "I49049000";
//        Id_Sign = "I162397003";
//        LogicAddRelation(Id_Doctor, Id_Disease, Id_Sign);
//    }
}
