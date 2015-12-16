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
public class ManageTest {

    private static OntModel model = null;
    private OntModel model2 = null;
    private String DISEASE = "";
    private String TEST_TO_ADD = "";
    private String TEST_TO_REMOVE = "";
    private String HAS_TEST = "";
    private OutputStream out = null;
    private String Id_Doctor = "";
    private String Id_Disease = "";
    private String Id_Test = "";

    public List<ClinicalElement> LogicAddRelation(String Id_Disease, String Id_Test) {
        List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
        ClinicalElement ce = new ClinicalElement();
        /*Se invoca al método borrar signo para hacer el borrado lógico*/
        elements = agregartest(Id_Disease, Id_Test);
        /*El nuevo estado del model con el signo borrado queda almacenado en model */
        /**/
        try {
            out = new FileOutputStream("c:/gandhi/kbmedglobal/ddxont.owl");
        } catch (Exception ioe) {
            ioe.printStackTrace();
            ce = new ClinicalElement();
            ce.setMensaje("ERROR " + ioe.getMessage());
            elements.clear();
            elements.add(ce);
            return elements;
        }
        model.write(out, "RDF/XML-ABBREV");
        return elements;

    }

    public List<ClinicalElement> agregartest(String Id_Disease, String Id_Test) {
        List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
        ClinicalElement ce = new ClinicalElement();
        DISEASE = "file:///C:/gandhi/kbmedglobal/disont.owl#" + Id_Disease;
        TEST_TO_ADD = "file:///C:/gandhi/kbmedglobal/dto.owl#" + Id_Test;
        HAS_TEST = "file:///C:/gandhi/kbmedglobal/ddxont.owl#has_diagnostic_test";
        InputStream in = null;
        try {
            in = new FileInputStream("C://gandhi//kbmedglobal//ddxont.owl");
        } catch (IOException ioe) {
            ioe.printStackTrace();
            ce = new ClinicalElement();
            ce.setMensaje("ERROR en el método agregar test" + ioe.getMessage());
            elements.clear();
            elements.add(ce);
            return elements;
        }
        /*
         * Creaci�n del modelo.
         */        try {
            model = null;
            model = ModelFactory.createOntologyModel();
            //model.read(in, null);
            String fichero = "C://gandhi//kbmedglobal//ddxont.owl";
            String fichero2 = "C://gandhi//kbmedglobal//dto.owl";
            model.read(new File(fichero).toURI().toString());
            /*
             * Estamos trabajando a nivel de instancia as� que tratamos de crear instancias (Individual).
             * 
             * Creamos una instancia para la enfermedad a editar (disease) y otra para el signo a borrar (sign)
             * Adem�s, queremos borrar un signo, con lo cual, afecta a la propiedad "has_sign", as� que creamos su objeto tambi�n.
             */
            model2 = ModelFactory.createOntologyModel();
            model2.read(new File(fichero2).toURI().toString());
            Individual disease = model.getIndividual(DISEASE);
            Individual test = model2.getIndividual(TEST_TO_ADD);
            ObjectProperty has_test = model.getObjectProperty(HAS_TEST);
            /*
             * Imprimimos por pantalla simplemente para comprobar que se han creado bien los objetos (no son null).
             */
            System.out.println("Disease: " + disease);
            System.out.println("Test: " + test);
            System.out.println("Has Diagnostic Test: " + has_test);
            /*
             * Ya estamos listos. Vamos a coger la enfermedad (disease) y listar todas las relaciones que tiene de tipo has_sign
             * e imprimirlas por pantalla. As� mismo, un contador nos dir� el total.
             */
            System.out.println("--------------------------------------");
            System.out.println("--------------- BEFORE ---------------");
            System.out.println("--------------------------------------");
            NodeIterator itInds = disease.listPropertyValues(has_test);
            int counter = 0;
            RDFNode actTest;
            while (itInds.hasNext()) {
                actTest = itInds.nextNode();//.next();
                System.out.println("has_diagnostic_test -> " + actTest);
                counter++;
            }
            System.out.println("Total Test: " + counter);
            /*
             * Ahora BORRAMOS. As� de simple, una sola l�nea de c�digo.
             * 
             * Borramos de la disease (disease), el signo que representa el objeto sign (sign). Como estamos eliminando
             * la propiedad has_sign pues usamos su objeto (has_sign).
             */
            disease.addProperty(has_test, test);
            //disease.addProperty(has_sign, sign);

            /*
             * E imprimimos para ver como queda el modelo. Como solo estamos borrando un signo, el contador deber� dar un 
             * elemento menos. Y si miramos los elementos, vemos que se ha cargado al que representa sign
             * (file:///C:/gandhi/kbmed7/signs.owl#I248568003)
             */
            System.out.println("--------------------------------------");
            System.out.println("---------------- AFTER ---------------");
            System.out.println("--------------------------------------");
            itInds = disease.listPropertyValues(has_test);
            counter = 0;
            while (itInds.hasNext()) {
                actTest = itInds.nextNode(); //.next();
                System.out.println("has_diagnostic_test -> " + actTest);
                counter++;
            }

            System.out.println("Total Signs: " + counter);
        } catch (Exception e) {
            ce = new ClinicalElement();
            ce.setMensaje("ERROR " + e.getMessage());
            elements.clear();
            elements.add(ce);
            return elements;
        }
        return elements;

    }
    //-------------------------------------------------------------------

    public List<ClinicalElement> LogicDeleteRelation(String Id_Disease, String Id_Test) {
        List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
        ClinicalElement ce = new ClinicalElement();
        /*Se invoca al método borrar signo para hacer el borrado lógico*/
        elements = borrartest(Id_Disease, Id_Test);
        /*El nuevo estado del model con el signo borrado queda almacenado en model */
        /**/
        try {
            out = new FileOutputStream("c:/gandhi/kbmedglobal/ddxont.owl");
        } catch (IOException ioe) {
            ioe.printStackTrace();
            ce = new ClinicalElement();
            ce.setMensaje("ERROR " + ioe.getMessage());
            elements.clear();
            elements.add(ce);
            return elements;
        }

        model.write(out, "RDF/XML-ABBREV");
        return elements;

    }

    public List<ClinicalElement> borrartest(String Id_Disease, String Id_Test) {
        List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
        ClinicalElement ce = new ClinicalElement();
        DISEASE = "file:///C:/gandhi/kbmedglobal/disont.owl#" + Id_Disease;
        TEST_TO_REMOVE = "file:///C:/gandhi/kbmedglobal/dto.owl#" + Id_Test;
        HAS_TEST = "file:///C:/gandhi/kbmedglobal/ddxont.owl#has_diagnostic_test";
        InputStream in = null;
        try {
            in = new FileInputStream("C://gandhi//kbmedglobal//ddxont.owl");
        } catch (IOException ioe) {
            ioe.printStackTrace();
            ce.setMensaje("ERROR " + ioe.getMessage());
            elements.clear();
            elements.add(ce);
            return elements;
        }
        /*
         * Creaci�n del modelo.
         */
        try {
            model = ModelFactory.createOntologyModel();
            model.read(in, null);
            /*
             * Estamos trabajando a nivel de instancia as� que tratamos de crear instancias (Individual).
             * 
             * Creamos una instancia para la enfermedad a editar (disease) y otra para el signo a borrar (sign)
             * Adem�s, queremos borrar un signo, con lo cual, afecta a la propiedad "has_sign", as� que creamos su objeto tambi�n.
             */
            Individual disease = model.getIndividual(DISEASE);
            Individual test = model.getIndividual(TEST_TO_REMOVE);
            ObjectProperty has_test = model.getObjectProperty(HAS_TEST);
            /*
             * Imprimimos por pantalla simplemente para comprobar que se han creado bien los objetos (no son null).
             */
            System.out.println("Disease: " + disease);
            System.out.println("Test: " + test);
            System.out.println("Has Sign: " + has_test);
            /*
             * Ya estamos listos. Vamos a coger la enfermedad (disease) y listar todas las relaciones que tiene de tipo has_sign
             * e imprimirlas por pantalla. As� mismo, un contador nos dir� el total.
             */
            System.out.println("--------------------------------------");
            System.out.println("--------------- BEFORE ---------------");
            System.out.println("--------------------------------------");
            NodeIterator itInds = disease.listPropertyValues(has_test);
            int counter = 0;
            RDFNode actTest;
            while (itInds.hasNext()) {
                actTest = itInds.nextNode();//.next();
                System.out.println("has_diagnostic_test -> " + actTest);
                counter++;
            }
            System.out.println("Total Tests: " + counter);
            /*
             * Ahora BORRAMOS. As� de simple, una sola l�nea de c�digo.
             * 
             * Borramos de la disease (disease), el signo que representa el objeto sign (sign). Como estamos eliminando
             * la propiedad has_sign pues usamos su objeto (has_sign).
             */
            disease.removeProperty(has_test, test);
            //disease.addProperty(has_sign, sign);

            /*
             * E imprimimos para ver como queda el modelo. Como solo estamos borrando un signo, el contador deber� dar un 
             * elemento menos. Y si miramos los elementos, vemos que se ha cargado al que representa sign
             * (file:///C:/gandhi/kbmed7/signs.owl#I248568003)
             */
            System.out.println("--------------------------------------");
            System.out.println("---------------- AFTER ---------------");
            System.out.println("--------------------------------------");
            itInds = disease.listPropertyValues(has_test);
            counter = 0;
            while (itInds.hasNext()) {
                actTest = itInds.nextNode(); //.next();
                System.out.println("has_diagnostic_test -> " + actTest);
                counter++;
            }
            System.out.println("Total Test: " + counter);
        } catch (Exception e) {
            ce = new ClinicalElement();
            ce.setMensaje("ERROR " + e.getMessage());
            elements.clear();
            elements.add(ce);
            return elements;
        }
        return elements;

    }
//        public static void main(String[] args) {
//                Id_Doctor = "miki";
//                Id_Disease = "I49049000";
//                Id_Test = "I111583006";
//		LogicAddRelation(Id_Doctor, Id_Disease, Id_Test);
//	}    
}
