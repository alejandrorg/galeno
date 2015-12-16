package Galenos.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

public class Logic {
	private String ficherosigns = "";
	private String ficherodiseases = "";
	private String ficherotests="";
	private String ficherodisorders="";
    private static OntModel signsmodel = ModelFactory.createOntologyModel();
    private static OntModel testmodel = ModelFactory.createOntologyModel();
    private OntModel disordermodel = ModelFactory.createOntologyModel();
    private Model diseasesmodel = ModelFactory.createDefaultModel(); 
    static String propNs = "file:///C:/gandhi/kbmedglobal/ddxont.owl#";
    private String relationshipUri = propNs;
    List<String> codes = new ArrayList<String>();
    List<String> names = new ArrayList<String>();
    List<String> diseases = new ArrayList<String>();
    public  List<ClinicalElement> clinicalsigns = new ArrayList<ClinicalElement>();
    public List<ClinicalElement> clinicaldisorders = new ArrayList<ClinicalElement>();
    public List<ClinicalElement> clinicaldiseases = new ArrayList<ClinicalElement>();
    public List<ClinicalElement> clinicaltests = new ArrayList<ClinicalElement>();
    private int cont = 0;
    private static String dirkb;
    private static String kb;
    private static final String ONT_BASE = "ddxont.owl";
    private static OntModel modeloparasigns;
    private static OntModel modeloparatest;
    private static OntModel modeloparadisorders;
    private static ObjectProperty has_sign;
    private static ObjectProperty has_diagnostic_test;
    private static ObjectProperty has_disorder;
    private static List<String> sympthoms = new ArrayList<String>();
    private static List<String> tests = new ArrayList<String>();
    private static String d;
    private static final String FILE_PREFIX = "file:///";
    private static String dis;
    private static final String ONT_DISEASES = "disont.owl";
    private static Individual ind;
    private static NodeIterator ni;
    private static String rsc;
    private static Individual indSign;
    private static Individual indTest;
    private static Individual indDisorder;
    private static String codigo;
    private static String name;
    
    
    public void cargarmodelos(){
    	try{
    	llenarlistdiseases();
        llenarlistsigns();
        llenarlisttests();
        llenarlistdisorders();
        llenarmodelosigns();
        llenarmodelodisorders();
        llenarmodelotest();
        System.out.println("Listas cargadas");
        System.out.println("diseases = "+clinicaldiseases.size());
        System.out.println("signs = "+clinicalsigns.size());
        System.out.println("disorders = "+clinicaldisorders.size());
        System.out.println("tests = "+clinicaltests.size());
    	}
    	catch(Exception e){
    		System.out.println("Error al cargar listas "+e.getMessage());
    	}
     }
    public void vacialistsigns(){
    	clinicalsigns.removeAll(clinicalsigns);
    }
    public void vaciarlisttests(){
    	clinicaltests.removeAll(clinicaltests);
    }
    public void vaciarlistdisorders(){
    	clinicaldisorders.removeAll(clinicaldisorders);
    }
    public void vaciarlistdiseases(){
    	clinicaldiseases.removeAll(clinicaldiseases);
    }
    public void llenarlistsigns(){
    	try {
    		codes.clear();
    		names.clear();
            ficherosigns = "C:/gandhi/kbmedglobal/signs.owl";   //Toma los signos de la ontología original
            String signcode;
            signsmodel = ModelFactory.createOntologyModel();
            signsmodel.read(new File(ficherosigns).toURI().toString());
            ExtendedIterator inds = signsmodel.listIndividuals();
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
         
        System.out.println("dentro del m�todo llenarclinicalsigns signs = "+clinicalsigns.size());
    }
    public void llenarlistdisorders(){
    	try {
    		codes.clear();
    		names.clear();
            ficherodisorders = "C:/gandhi/kbmedglobal/disont.owl";   //Toma los signos de la ontología original
            String signcode;
            disordermodel = ModelFactory.createOntologyModel();
            disordermodel.read(new File(ficherodisorders).toURI().toString());
            ExtendedIterator inds = disordermodel.listIndividuals();
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
                clinicaldisorders.add(ce);
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    public void llenarlisttests(){
	try {
		codes.clear();
		names.clear();
        ficherotests = "C:/gandhi/kbmedglobal/dto.owl";   //Toma los signos de la ontología original
        String signcode;
        testmodel = ModelFactory.createOntologyModel();
        testmodel.read(new File(ficherotests).toURI().toString());
        ExtendedIterator inds = testmodel.listIndividuals();
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
            clinicaltests.add(ce);
        }
    } catch (Exception e) {
       e.printStackTrace();
    }
      
    }
    public void llenarlistdiseases(){
    	try{
    	codes.clear();
	   names.clear();
	   
        Property has_sign = diseasesmodel.createProperty(relationshipUri, "has_sign");
        ficherodiseases = "C:/gandhi/kbmedglobal/ddxont.owl";   //Toma las enfermedades de la ontología original
        try {
            FileInputStream fin = new FileInputStream(ficherodiseases);
            diseasesmodel.read(fin, null);
        } catch (IOException e) {
            System.out.println("Exception caught" + e.getMessage());
                    }
// List everyone in the model who has a child:
        ResIterator parents = diseasesmodel.listSubjectsWithProperty(has_sign);

// Because subjects of statements are Resources, the method returned a ResIterator
        while (parents.hasNext()) {

            // ResIterator has a typed nextResource() method
            Resource person = parents.nextResource();
            codes.add(person.getLocalName());
            cont++;
        }
        
        diseasesmodel.close();
        }
        catch(Exception e)
        {
        e.printStackTrace();  
        }
        try {
			names = CreateCodeNamesFile.leerfichero(codes);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ClinicalElement ce;
        for (int i = 0; i < codes.size(); i++) {
            ce = new ClinicalElement();
            ce.setId(codes.get(i).toString());
            ce.setNombre(names.get(i).toString());
            ce.setTipo(names.get(i).toString());
            clinicaldiseases.add(ce);
        }
        for(int i =0; i<clinicaldiseases.size(); i++){
        	System.out.println(clinicaldiseases.get(i).getId()+"-"+clinicaldiseases.get(i).getNombre());
        }
	}
    public void llenarmodelosigns(){
    	try{
    		dirkb = "C:\\gandhi\\kbmedglobal";	
            kb = dirkb + "\\" + ONT_BASE;
             System.out.println("Loading KB ( " + kb + " )");
             /*
              * Creamos el modelo de la ontolog�a.
              */
             modeloparasigns = ModelFactory.createOntologyModel();
             /*
              * Lo cargamos desde fichero.
              */
             modeloparasigns.read(new File(kb).toURI().toString());

             /*
              * Obtenemos la propiedad has_sign:
              * 
              * C:\gandhi\kbmed1\ddxont.owl#has_sign
              */
             has_sign = modeloparasigns.getObjectProperty(kb + "#has_sign");
             System.out.println("Listing diseases..\n");
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }
    public void llenarmodelodisorders(){
    	try{
    		dirkb = "C:\\gandhi\\kbmedglobal";	
            kb = dirkb + "\\" + ONT_BASE;
             System.out.println("Loading KB ( " + kb + " )");
             /*
              * Creamos el modelo de la ontolog�a.
              */
             modeloparadisorders = ModelFactory.createOntologyModel();
             /*
              * Lo cargamos desde fichero.
              */
             modeloparadisorders.read(new File(kb).toURI().toString());

             /*
              * Obtenemos la propiedad has_sign:
              * 
              * C:\gandhi\kbmed1\ddxont.owl#has_sign
              */
             has_disorder = modeloparadisorders.getObjectProperty(kb + "#has_disorder");
             System.out.println("Listing diseases..\n");
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }
   public void llenarmodelotest(){
	   try{
   		dirkb = "C:\\gandhi\\kbmedglobal";	
           kb = dirkb + "\\" + ONT_BASE;
            System.out.println("Loading KB ( " + kb + " )");
            /*
             * Creamos el modelo de la ontolog�a.
             */
            modeloparatest = ModelFactory.createOntologyModel();
            /*
             * Lo cargamos desde fichero.
             */
            modeloparatest.read(new File(kb).toURI().toString());

            /*
             * Obtenemos la propiedad has_sign:
             * 
             * C:\gandhi\kbmed1\ddxont.owl#has_sign
             */
            has_diagnostic_test = modeloparatest.getObjectProperty(kb + "#has_diagnostic_test");
            System.out.println("Listing diseases..\n");
   	}
   	catch(Exception e){
   		e.printStackTrace();
   	}
   }
    public List<ClinicalElement> ordenalista(List<ClinicalElement> elements, String listname)
	  {
	    int size = elements.size();
       System.out.println("El tama�o en ordenalista es "+size);
       
	    String[] claves = new String[size];
	    String[] nombres = new String[size];
	    String aux = "";
	    try{
	    for (int i = 0; i < elements.size(); i++) {
	      ClinicalElement el = elements.get(i);
	      claves[i] = el.getId().toString();
	      nombres[i] = el.getNombre().toString();
	    }
	    System.out.println("los nombres recibidos son");
	    for(int i =0; i<size; i++){
	    	System.out.println(claves[i]+"-"+nombres[i]);   
	       }
	    for (int i = 0; i < nombres.length; i++) {
	      for (int j = 0; j < nombres.length - 1; j++) {
	        if (nombres[j].compareTo(nombres[(j + 1)]) > 0) {
	          aux = nombres[j];
	          nombres[j] = nombres[(j + 1)];
	          nombres[(j + 1)] = aux;
	          aux = claves[j];
	          claves[j] = claves[(j + 1)];
	          claves[(j + 1)] = aux;
	        }
	      }
	    }
	 
	    elements.clear();
	    System.out.println("los datos ordenados son--------");
	    for (int i = 0; i < nombres.length; i++) {
	      ClinicalElement el = new ClinicalElement();
	      el.setNombre(nombres[i]);
	      el.setId(claves[i]);
	      elements.add(el);
	      System.out.println(claves[i]+"-"+nombres[i]);
	    }
	    }
	    catch(Exception e){
	       e.printStackTrace();
	    }
	    return elements;
	  }
	
	 public List<ClinicalElement> getAllSigns() throws Exception {
	     System.out.println("M�todo getAllSigns en Logic signs = "+clinicalsigns.size());  
		 return clinicalsigns;
	    }
	 public List<ClinicalElement> getAllDisorders() throws Exception{
		   return clinicaldisorders;
	 }
	 public List<ClinicalElement> getOriginalDiseases() throws Exception {
	     return clinicaldiseases;
}
	 public List<ClinicalElement> getAllTest() throws Exception {
	        return clinicaltests;
	    }
     
	 public List<ClinicalElement> getsignsfromdisease(String disease) throws FileNotFoundException, IOException{
    	 List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
    	 ClinicalElement el; 
         List<String> r = new ArrayList<String>();
         System.out.println("Recibo " + disease + " en ProcessKBSOriginal");
         r = listSigns(dirkb, disease);
         
         for(int i=0; i<r.size(); i++){
        	name = CreateCodeNamesFile.buscarnombre(r.get(i).toString());
        	el = new ClinicalElement();
        	el.setId(r.get(i).toString());
        	el.setNombre(name);
        	if(!el.getId().equalsIgnoreCase("SO"))
        	elements.add(el);
         }
         
        return elements;
     }
	public static List<String> listSigns(String dirkb, String disea) {  //para la ontología original
 		 sympthoms.clear();
         d = disea;
         dis = FILE_PREFIX + dirkb + "\\" + ONT_DISEASES + "#" + d;
         dis = dis.replace('\\', '/');
         System.out.println("Getting signs of disease [ " + d + " ]. URI: " + dis);

         /*Individual*/ ind = modeloparasigns.getIndividual(dis);
         /*NodeIterator*/ ni = ind.listPropertyValues(has_sign);
         while (ni.hasNext()) {
              rsc = ni.next().toString();
             /*Individual*/ indSign = modeloparasigns.getIndividual(rsc);

             if (indSign != null) {
                 if (rsc.indexOf("signs") != -1) {
                     codigo = rsc.substring(rsc.indexOf("#") + 1);
                     sympthoms.add(codigo);

                 }
             }
             //indSign = null;

         }
         //ni = null;
         //ind = null;

         //System.gc();
         return sympthoms;

     }
	
	public List<ClinicalElement> gettestfromdisease(String disease) throws FileNotFoundException, IOException{
   	 List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
   	 ClinicalElement el; 
        List<String> r = new ArrayList<String>();
        System.out.println("Recibo " + disease + " en ProcessKBSOriginal");
        r = listTests(dirkb, disease);
        
        for(int i=0; i<r.size(); i++){
       	name = CreateCodeNamesFile.buscarnombre(r.get(i).toString());
       	el = new ClinicalElement();
       	el.setId(r.get(i).toString());
       	el.setNombre(name);
       	elements.add(el);
        }
        
       return elements;
    }
	public static List<String> listTests(String dirkb, String disea) {  //para la ontología original
 		
        tests.clear();
        d = disea;
        dis = FILE_PREFIX + dirkb + "\\" + ONT_DISEASES + "#" + d;
        dis = dis.replace('\\', '/');
        System.out.println("Getting test of disease [ " + d + " ]. URI: " + dis);

        /*Individual*/ ind = modeloparatest.getIndividual(dis);
        /*NodeIterator*/ ni = ind.listPropertyValues(has_diagnostic_test);
        while (ni.hasNext()) {
             rsc = ni.next().toString();
            /*Individual*/ indTest = modeloparatest.getIndividual(rsc);

            if (indTest != null) {
                if (rsc.indexOf("dto") != -1) {
                    codigo = rsc.substring(rsc.indexOf("#") + 1);
                    tests.add(codigo);

                }
            }
            indTest = null;

        }
        ni = null;
        ind = null;

        System.gc();
        return tests;

    }

	    
	 public List<ClinicalElement> getdisordersfromdisease(String disease) throws FileNotFoundException, IOException{
    	 List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
    	 ClinicalElement el; 
         List<String> r = new ArrayList<String>();
         System.out.println("Recibo " + disease + " en ProcessKBSOriginal");
         r = listDisorders(dirkb, disease);
         
         for(int i=0; i<r.size(); i++){
        	name = CreateCodeNamesFile.buscarnombre(r.get(i).toString());
        	el = new ClinicalElement();
        	el.setId(r.get(i).toString());
        	el.setNombre(name);
        	if(!el.getId().equalsIgnoreCase("DO"))
        	elements.add(el);
         }
         
        return elements;
     }
	 public static List<String> listDisorders(String dirkb, String disea) {  //para la ontología original
		 sympthoms.clear();
        d = disea;
        dis = FILE_PREFIX + dirkb + "\\" + ONT_DISEASES + "#" + d;
        dis = dis.replace('\\', '/');
        System.out.println("Getting disorders of disease [ " + d + " ]. URI: " + dis);

        /*Individual*/ ind = modeloparadisorders.getIndividual(dis);
        /*NodeIterator*/ ni = ind.listPropertyValues(has_disorder);
        while (ni.hasNext()) {
             rsc = ni.next().toString();
            /*Individual*/ indDisorder = modeloparadisorders.getIndividual(rsc);

            if (indDisorder != null) {
                if (rsc.indexOf("disont") != -1) {
                    codigo = rsc.substring(rsc.indexOf("#") + 1);
                    sympthoms.add(codigo);

                }
            }
            //indSign = null;

        }
        //ni = null;
        //ind = null;

        //System.gc();
        return sympthoms;

    }
	 
	
     public boolean updatesignlist(List<ClinicalElement> listaNueva, String disease){
		 boolean resp = true;
		 List<ClinicalElement> listaVieja = new ArrayList<ClinicalElement>();
	        List<ClinicalElement> listaSintomasNuevos = new ArrayList<ClinicalElement>();
	        List<ClinicalElement> listaSintomasBorrar = new ArrayList<ClinicalElement>();
	        List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
	        ManageSigns mng = new ManageSigns();
	        try {
				listaVieja = getsignsfromdisease(disease);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resp = false;
			    return resp;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resp = false;
			    return resp;
			}
			try{
			listaSintomasNuevos = new ArrayList<ClinicalElement>(listaNueva);
            listaSintomasNuevos.removeAll(listaVieja);
            Iterator<ClinicalElement> itNuevos = listaSintomasNuevos.iterator();
            while (itNuevos.hasNext()) {
                elements = mng.LogicAddSignRelation(disease, itNuevos.next().getId());
            }
			}
			catch(Exception e){
				e.printStackTrace();
				resp = false;
			    return resp;
			}
			try{
	            listaSintomasBorrar = new ArrayList<ClinicalElement>(listaVieja);
	            listaSintomasBorrar.removeAll(listaNueva);
	            Iterator<ClinicalElement> itBorrar = listaSintomasBorrar.iterator();
	            while (itBorrar.hasNext()) {
	                elements = mng.LogicDeleteSignRelation(disease, itBorrar.next().getId());
	            }
			}
	            catch(Exception e){
	            	e.printStackTrace();
	            	resp = false;
				    return resp;
	            }
		 return resp;
	 }
     public boolean updatedisorderlist(List<ClinicalElement> listaNueva, String disease){
		 boolean resp = true;
		 List<ClinicalElement> listaVieja = new ArrayList<ClinicalElement>();
	        List<ClinicalElement> listaDisordersNuevos = new ArrayList<ClinicalElement>();
	        List<ClinicalElement> listaDisordersBorrar = new ArrayList<ClinicalElement>();
	        List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
	        ManageSigns mng = new ManageSigns();
	        try {
				listaVieja = getdisordersfromdisease(disease);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resp = false;
			    return resp;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resp = false;
			    return resp;
			}
			try{
			listaDisordersNuevos = new ArrayList<ClinicalElement>(listaNueva);
            listaDisordersNuevos.removeAll(listaVieja);
            Iterator<ClinicalElement> itNuevos = listaDisordersNuevos.iterator();
            while (itNuevos.hasNext()) {
                elements = mng.LogicAddDisorderRelation(disease, itNuevos.next().getId());
            }
			}
			catch(Exception e){
				e.printStackTrace();
				resp = false;
			    return resp;
			}
			try{
	            listaDisordersBorrar = new ArrayList<ClinicalElement>(listaVieja);
	            listaDisordersBorrar.removeAll(listaNueva);
	            Iterator<ClinicalElement> itBorrar = listaDisordersBorrar.iterator();
	            while (itBorrar.hasNext()) {
	                elements = mng.LogicDeleteDisorderRelation(disease, itBorrar.next().getId());
	            }
			}
	            catch(Exception e){
	            	e.printStackTrace();
	            	resp = false;
				    return resp;
	            }
		 return resp;
	 }
public boolean updatetestlist(List<ClinicalElement> listaNueva, String disease){
	boolean resp = true;
	 List<ClinicalElement> listaVieja = new ArrayList<ClinicalElement>();
       List<ClinicalElement> listaTestNuevos = new ArrayList<ClinicalElement>();
       List<ClinicalElement> listaTestBorrar = new ArrayList<ClinicalElement>();
       List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
       ManageTest mng = new ManageTest();
       try {
			listaVieja = gettestfromdisease(disease);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp = false;
		    return resp;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp = false;
		    return resp;
		}
		try{
		listaTestNuevos = new ArrayList<ClinicalElement>(listaNueva);
       listaTestNuevos.removeAll(listaVieja);
       Iterator<ClinicalElement> itNuevos = listaTestNuevos.iterator();
       while (itNuevos.hasNext()) {
           elements = mng.LogicAddRelation(disease, itNuevos.next().getId());
       }
		}
		catch(Exception e){
			e.printStackTrace();
			resp = false;
		    return resp;
		}
		try{
           listaTestBorrar = new ArrayList<ClinicalElement>(listaVieja);
           listaTestBorrar.removeAll(listaNueva);
           Iterator<ClinicalElement> itBorrar = listaTestBorrar.iterator();
           while (itBorrar.hasNext()) {
               elements = mng.LogicDeleteRelation(disease, itBorrar.next().getId());
           }
		}
           catch(Exception e){
           	e.printStackTrace();
           	resp = false;
			    return resp;
           }
	 return resp;
}
}