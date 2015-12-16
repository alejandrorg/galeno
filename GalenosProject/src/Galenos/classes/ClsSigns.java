package Galenos.classes;

import java.io.*;
import java.util.*;
//import jenadiseases.LoadFiles;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import SnApi.Concepto;

public class ClsSigns {

    /**
     * ATRIBUTOS y CONSTANTES
     * 
     * DIR_BASE: Directorio base donde est�n las bases de conocimiento. Dentro
     * de este directorio hay varios directorios, donde cada uno representa a la
     * base de conocimiento de cada m�dico. Y dentro del propio directorio de la
     * base de conocimiento deber�an estar todos los ficheros de las ontolog�as.
     * 
     * ONT_BASE: Fichero de ontolog�a base.
     * 
     * ONT_DISEASES: Dado que necesitamos obtener las diseases a trav�s del URI
     * de la ontolog�a de diseases necesitamos su nombre de fichero.
     * 
     * ONT_SIGNS: Ontolog�a de Signos.
     * 
     * ONT_DIAGNOSTIC_TESTS: Ontolog�a pruebas diagn�sticas.
     * 
     * Los URIS se formar�n a partir de concatenar una serie de elementos.
     * 
     * FILE_PREFIX: Es el prefijo que se usa en la ontolog�a para indicar por
     * ejemplo que otra ontolog�a hace referencia a un URI que est� en un
     * fichero. Esto permite en teor�a a Jena poder acceder a todo el modelo
     * final de la ontolog�a cargando desde fichero en vez desde una web.
     * 
     * model: Objeto modelo de la ontolog�a. 
     * has_sign: Propiedad has_sign
     * DISEASES: Es un array que contiene un muestrario de enfermedades con las
     * que trabajar. En la versi�n final deber�amos obtener el listado completo
     * de otra forma, pero de momento sirve para trabajar con unas cuantas
     * enfermedades de muestra.
     */
    private static final String DIR_BASE = "C://gandhi/";
    private static final String ONT_BASE = "ddxont.owl";
    private static final String ONT_DISEASES = "disont.owl";
    private static final String FILE_PREFIX = "file:///";
    private static OntModel model;
    private static ObjectProperty has_sign;
    private static ObjectProperty has_diagnostic_test;
    private static List kbs = new ArrayList();
    private static String d;
    private static String dirkb;
    private static String kb;
    private static String dis;
    private static String rsc;
    private static Individual ind;
    private static NodeIterator ni;
    private static Individual indSign;
    private static Individual indTest;
    private static List sympthoms = new ArrayList(); //lista de síntomas de la ontología original
    static OutputStream out = null;
    private static List codes = new ArrayList();
    private static List Testcodes = new ArrayList();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String codigo;
    static Concepto p = new Concepto();
    

    /**
     * Constructor.
     * 
     * Inicializamos la base de conocimiento (para saber cuantas tenemos) y las
     * procesamos.
     */
    /*
    imprimimos la lista de diseases
     */
    /**
     * Cargamos las bases de conocimiento. Para ello:
     */
    public static void loadKBS() {  //Llena la lista kbs con las rutas de todos los directorios
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
                kbs.add(d.toString());
                //System.out.println(i+".- Directorio (KB) cargado: " + d);
            }
        }
    }

    /**
     * M�todo para procesar las bases de conocimiento.
     */
    public static List processKBSOriginal(String disease) {
        /*
         * Recorremos cada una de las bases de conocimiento (directorios)
         * disponibles.
         */
        List r = new ArrayList();
        System.out.println("Recibo " + disease + " en ProcessKBSOriginal");

        //  for (int i = 0; i < this.kbs.size(); i++) {
       try{
        /*String*/// dirkb = kbs.get(0).toString(); //se usa el índice 0 porque se está procesando el primer directorio unicamente
		dirkb = "C:\\gandhi\\kbmedglobal";	
                /*
         * Creamos la cadena 'kb' que contiene el directorio (por ej:
         * C:\gandhi\kbmed1). Le a�adimos la contrabarra para que se genere:
         * C:\gandhi\kbmed1\
         * 
         * Y finalmente el nombre de la ontolog�a base:
         * 
         * C:\gandhi\kbmed1\ddxont.owl
         */
        /*String*/ kb = dirkb + "\\" + ONT_BASE;
        System.out.println("Loading KB ( " + kb + " )");
        /*
         * Creamos el modelo de la ontolog�a.
         */
        model = ModelFactory.createOntologyModel();
        /*
         * Lo cargamos desde fichero.
         */
        model.read(new File(kb).toURI().toString());

        /*
         * Obtenemos la propiedad has_sign:
         * 
         * C:\gandhi\kbmed1\ddxont.owl#has_sign
         */
        has_sign = model.getObjectProperty(kb + "#has_sign");
        System.out.println("Listing diseases..\n");
        /*
         * Pasamos al proceso de listar enfermedades
         */

        r = listDiseases(dirkb, disease);
       }
       catch(Exception e)
       {
        return null;
       }
        return r;
        /*
         * NOTA: Se est� diciendo:
         * 
         * C:\gandhi\kbmed1\
         * 
         * Pero luego ser� kbmed2, kbmed3, o lo que sea, depende de los
         * subdirectorios de DIR_BASE (C:\gandhi\) actualmente.
         */
        // this.model.close();
        //}
    }

    /**
     * Estamos dentro de una base de conocimiento concreta.
     * 
     * Ahora toca listar las enfermedades de la misma, y los signos de estas
     * enfermedades.
     * 
     * @param dirkb
     *            Recibe el directorio de la base de conocimiento actual.
     */
    public static List listDiseases(String dirkb, String disea) {  //para la ontología original
		/*
         * Recorremos las enfermedades a procesar (en el futuro como se ha
         * comentado se deber�n obtener de otra forma)
         */
        sympthoms.clear();

        ///*String*/ d = listadiseases.get(disea).toString();
        d = disea;
        /*
         * Generamos el uri de cada enfermedad. Tendr� este formato:
         * file:///C:/gandhi/kbmed1/signs.owl#I25082004
         */
        /*String*/ dis = FILE_PREFIX + dirkb + "\\" + ONT_DISEASES + "#" + d;
        /*
         * Como por defecto tenemos la contrabarra (\) y necesitamos
         * exactamente usar la barra (/) hacemos un replace.
         */
        dis = dis.replace('\\', '/');
        System.out.println("Getting signs of disease [ " + d + " ]. URI: "
                + dis);

        /*
         * Obtenemos el objeto de tipo Individual
         * correspondiente a la enfermedad.
         */
        /*Individual*/ ind = model.getIndividual(dis);
        /*
         * Creamos un iterador para que nos devuelve aquellos
         * valores asociados a la propiedad/relaci�n has_sign
         */
        /*NodeIterator*/ ni = ind.listPropertyValues(has_sign);
        while (ni.hasNext()) {
            /*
             * En teor�a esto devuelve recursos de todo tipo
             * y nosotros solo necesitariamos los signos (DE MOMENTO).
             * 
             * No obstante es relativamente sencillo clasificar el tipo
             * de recurso seg�n la ontolog�a a la que pertenezca.
             */
            /*String*/ rsc = ni.next().toString();
            /*Individual*/ indSign = model.getIndividual(rsc);

            if (indSign != null) {
                if (rsc.indexOf("signs") != -1) {
                    codigo = rsc.substring(rsc.indexOf("#") + 1);
                    sympthoms.add(codigo);

                }
            }
            indSign = null;

        }


        ni = null;
        ind = null;

        System.gc();
        return sympthoms;

    }

    public static List processKBSMed(String Id_Doctor, String Id_Disease) {
           List r = new ArrayList();
        /*
         * Recorremos cada una de las bases de conocimiento (directorios)
         * disponibles.
         */
        //Se limpia la lista de sintomas porque previamente tenía los de la ontología original
        //ahora tendrá la lista de sintomas de la ontología del médico seleccionado (med)
        //  for (int i = 0; i < this.kbs.size(); i++) {
        try{
        dirkb = "C:\\gandhi\\kbmed"+Id_Doctor;
        ///*String*/ dirkb = kbs.get(med).toString(); //se usa el índice 0 porque se está procesando el primer directorio unicamente
			/*
         * Creamos la cadena 'kb' que contiene el directorio (por ej:
         * C:\gandhi\kbmed1). Le a�adimos la contrabarra para que se genere:
         * C:\gandhi\kbmed1\
         * 
         * Y finalmente el nombre de la ontolog�a base:
         * 
         * C:\gandhi\kbmed1\ddxont.owl
         */
        /*String*/ kb = dirkb + "\\" + ONT_BASE;
        System.out.println("Loading KB ( " + kb + " )");
        /*
         * Creamos el modelo de la ontolog�a.
         */
        model = ModelFactory.createOntologyModel();
        /*
         * Lo cargamos desde fichero.
         */
        model.read(new File(kb).toURI().toString());

        /*
         * Obtenemos la propiedad has_sign:
         * 
         * C:\gandhi\kbmed1\ddxont.owl#has_sign
         */
        has_sign = model.getObjectProperty(kb + "#has_sign");
        System.out.println("Listing diseases..\n");
        /*
         * Pasamos al proceso de listar enfermedades
         */

         r = listDiseases(dirkb, Id_Disease);
        }
        catch(Exception e)
        {
          return null;
        }
        return r;
        /*
         * NOTA: Se est� diciendo:
         * 
         * C:\gandhi\kbmed1\
         * 
         * Pero luego ser� kbmed2, kbmed3, o lo que sea, depende de los
         * subdirectorios de DIR_BASE (C:\gandhi\) actualmente.
         */
        // this.model.close();
        //}
    }

    public static List GetOriginalDiagTestCodes(String disease) {
        /*
         * Recorremos cada una de las bases de conocimiento (directorios)
         * disponibles.
         */
        codes.clear(); //Se limpia la lista de sintomas porque previamente tenía los de la ontología original
        //ahora tendrá la lista de sintomas de la ontología del médico seleccionado (med)
        try{
                       /*String*/ //dirkb = kbs.get(0).toString(); //se usa el índice 0 porque se está procesando el primer directorio unicamente
                       dirkb = "C:\\gandhi\\kbmedglobal";
        //dirkb = "C:\\gandhi\\kbmed"; 	
                    /*
         * Creamos la cadena 'kb' que contiene el directorio (por ej:
         * C:\gandhi\kbmed1). Le a�adimos la contrabarra para que se genere:
         * C:\gandhi\kbmed1\
         * 
         * Y finalmente el nombre de la ontolog�a base:
         * 
         * C:\gandhi\kbmed1\ddxont.owl
         */
        /*String*/ kb = dirkb + "\\" + ONT_BASE;
        System.out.println("Loading KB ( " + kb + " )");
        /*
         * Creamos el modelo de la ontolog�a.
         */
        model = ModelFactory.createOntologyModel();
        
        /*
         * Lo cargamos desde fichero.
         */
        model.read(new File(kb).toURI().toString());

        /*
         * Obtenemos la propiedad has_diagnostic_test:
         * 
         * C:\gandhi\kbmed1\ddxont.owl#has_diagnostic_test
         */
        has_diagnostic_test = model.getObjectProperty(kb + "#has_diagnostic_test");
        System.out.println("Listing diseases..\n");
        /*
         * Pasamos al proceso de listar enfermedades
         */

        codes = listTest(dirkb, disease);
        }
        catch(Exception e)
        {
          return null;
        }
        return codes;
        /*
         * NOTA: Se est� diciendo:
         * 
         * C:\gandhi\kbmed1\
         * 
         * Pero luego ser� kbmed2, kbmed3, o lo que sea, depende de los
         * subdirectorios de DIR_BASE (C:\gandhi\) actualmente.
         */
        // this.model.close();
        //}
    }

    public static List GetDoctorDiagnosticTestCodes(String Id_Doctor, String Id_Disease) throws Exception {
        /*
         * Recorremos cada una de las bases de conocimiento (directorios)
         * disponibles.
         */
        try{
        codes.clear(); //Se limpia la lista de sintomas porque previamente tenía los de la ontología original
        //ahora tendrá la lista de sintomas de la ontología del médico seleccionado (med)
        //       /*String*/ dirkb = kbs.get(0).toString(); //se usa el índice 0 porque se está procesando el primer directorio unicamente
        dirkb = "C:\\gandhi\\kbmed" + Id_Doctor;
        /*
         * Creamos la cadena 'kb' que contiene el directorio (por ej:
         * C:\gandhi\kbmed1). Le a�adimos la contrabarra para que se genere:
         * C:\gandhi\kbmed1\
         * 
         * Y finalmente el nombre de la ontolog�a base:
         * 
         * C:\gandhi\kbmed1\ddxont.owl
         */
        /*String*/ kb = dirkb + "\\" + ONT_BASE;
        System.out.println("Loading KB ( " + kb + " )");
        /*
         * Creamos el modelo de la ontolog�a.
         */
        model = ModelFactory.createOntologyModel();
        /*
         * Lo cargamos desde fichero.
         */
        model.read(new File(kb).toURI().toString());
        }
        catch(Exception e)
        {
          return null;
        }
        /*
         * Obtenemos la propiedad has_sign:
         * 
         * C:\gandhi\kbmed1\ddxont.owl#has_sign
         */
        has_diagnostic_test = model.getObjectProperty(kb + "#has_diagnostic_test");
        System.out.println("Listing diseases..\n");
        /*
         * Pasamos al proceso de listar enfermedades
         */

        codes = listTest(dirkb, Id_Disease);
        
        
        return codes;
        /*
         * NOTA: Se est� diciendo:
         * 
         * C:\gandhi\kbmed1\
         * 
         * Pero luego ser� kbmed2, kbmed3, o lo que sea, depende de los
         * subdirectorios de DIR_BASE (C:\gandhi\) actualmente.
         */
        // this.model.close();
        //}
    }

    public static List listTest(String dirkb, String disea) {  //para la ontología original
		/*
         * Recorremos las enfermedades a procesar (en el futuro como se ha
         * comentado se deber�n obtener de otra forma)
         */
        Testcodes.clear();

        ///*String*/ d = listadiseases.get(disea).toString();
        d = disea;
        /*
         * Generamos el uri de cada enfermedad. Tendr� este formato:
         * file:///C:/gandhi/kbmed1/signs.owl#I25082004
         */
        /*String*/ dis = FILE_PREFIX + dirkb + "\\" + ONT_DISEASES + "#" + d;
        /*
         * Como por defecto tenemos la contrabarra (\) y necesitamos
         * exactamente usar la barra (/) hacemos un replace.
         */
        dis = dis.replace('\\', '/');
        System.out.println("Getting test of disease [ " + d + " ]. URI: " + dis);

        /*
         * Obtenemos el objeto de tipo Individual
         * correspondiente a la enfermedad.
         */
        /*Individual*/ ind = model.getIndividual(dis);
        /*
         * Creamos un iterador para que nos devuelve aquellos
         * valores asociados a la propiedad/relaci�n has_sign
         */
        /*NodeIterator*/ ni = ind.listPropertyValues(has_diagnostic_test);
        while (ni.hasNext()) {
            /*
             * En teor�a esto devuelve recursos de todo tipo
             * y nosotros solo necesitariamos los signos (DE MOMENTO).
             * 
             * No obstante es relativamente sencillo clasificar el tipo
             * de recurso seg�n la ontolog�a a la que pertenezca.
             */
            /*String*/ rsc = ni.next().toString();
            /*Individual*/ indTest = model.getIndividual(rsc);

            if (indTest != null) {
                if (rsc.indexOf("dto") != -1) {
                    codigo = rsc.substring(rsc.indexOf("#") + 1);
                    Testcodes.add(codigo);

                }
            }
            indTest = null;

        }


        ni = null;
        ind = null;

        System.gc();
        return Testcodes;



    }

    public static List getSignsNames(List signs) {
        String termino = "";
        List names = new ArrayList();

        for (int i = 0; i < signs.size(); i++) {
            termino = signs.get(i).toString().substring(1);
            p.setTermino(termino);
            p.setDimension();
            names.add(p.getConcepto(0));
        }

        return names;
    }

    public static List<String> getTestNames(List test) {
        String termino = "";
        List<String> names = new ArrayList<String>();
        Concepto con = new Concepto();
        for (int i = 0; i < test.size(); i++) {
            try{
            termino = test.get(i).toString().substring(1);
            con.setTermino(termino);
            con.setDimension();
            names.add(con.getConcepto(0));
            }
            catch(Exception e)
            {
               System.out.println(e.toString());
               names.add("No Disponible");
            }
        }

        return names;
    }

   
public static void getTestName(String test) {
        String termino = "";
        Concepto con = new Concepto();
        try{ 
        termino = test.toString().substring(1);
         con.setTermino(termino);
         con.setDimension();
         termino = con.getConcepto(0);
            }
            catch(Exception e)
            {
               System.out.println(e.toString());
               termino = "No disponible";
            }
        System.out.println(termino);
        }

        
    
    public static void main(String args[]) throws FileNotFoundException, IOException {
        String Id_Doctor = "miki";
        String Id_Disease = "I49049000";
        ClinicalElement ce = new ClinicalElement();
        List<ClinicalElement> listaNueva = new ArrayList<ClinicalElement>();
        ClinicalElement c1 = new ClinicalElement();
        c1.setId("I82272006");
        listaNueva.add(c1);
        ClinicalElement c2 = new ClinicalElement();
        c2.setId("I56717001");
        listaNueva.add(c2);
        ClinicalElement c3 = new ClinicalElement();
        c3.setId("I26823002");
        listaNueva.add(c3);
        for(int i =0; i<listaNueva.size(); i++)
        {
          System.out.println(listaNueva.get(i).getId());
        }
        //se genera la lista de síntomas vieja (actualmente en la ontología)
        List<ClinicalElement> listaVieja = ce.getSignsFromDiseasesFromDoc(Id_Doctor, Id_Disease);
        //Imprimo
        System.out.println("la lista de síntomas vieja es ");
        for(int i =0; i<listaVieja.size(); i++)
        {
            System.out.println(listaVieja.get(i).getId());
        }
        //eliminar los síntomas que se encuentran el la lista vieja
         Iterator<ClinicalElement> itVieja = listaVieja.iterator();
        //recorremos la lista vieja para quitar relaciones
        while(itVieja.hasNext())
        {
           //ClsSigns.LogicDeleteRelation(Id_Doctor, Id_Disease, itVieja.next().getId());
        }
       listaVieja = ce.getSignsFromDiseasesFromDoc(Id_Doctor, Id_Disease);
       System.out.println("la lista de síntomas vieja ahora está vacía ");
        for(int i =0; i<listaVieja.size(); i++)
        {
            System.out.println(listaVieja.get(i).getId());
        }
    //Escribimos los síntomas nuevos en la ontología
      List<ClinicalElement> listaSintomasNuevos = new ArrayList<ClinicalElement>(listaNueva);
        //creo un iterador de la lista nueva
        Iterator<ClinicalElement> itNuevos = listaSintomasNuevos.iterator();
       //recorremos el iterador de la lista nueva para agregar relaciones
        while (itNuevos.hasNext()) {
           //ClsSigns.LogicAddRelation(Id_Doctor, Id_Disease, itNuevos.next().getId());
        }
       System.out.println("Lista de síntomas nuevos ");        
       listaSintomasNuevos = ce.getSignsFromDiseasesFromDoc(Id_Doctor, Id_Disease);
       for(int i =0; i<listaSintomasNuevos.size(); i++)
       {
         System.out.println(listaSintomasNuevos.get(i).getId());
       }
      
        
    }
}
