/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Galenos.classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author gandhi
 */

public class UpdateTestList {

    public List<ClinicalElement> UpDateMDTestList(List<ClinicalElement> listaNueva, String Id_Doctor, String Id_Disease) throws Exception {
        List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
        ClinicalElement ce = new ClinicalElement();
        ManageTest mng = new ManageTest();
        //Grabar listaSintomas a enfermedad Id_Disease de la KB de Id_Doctor   
//        Id_Doctor = "miki";
//        Id_Disease = "I58718002";
        List<ClinicalElement> listaVieja=null;
       try{
        listaVieja = ce.getDiagnosticTestFromDiseasesFromDoc(Id_Doctor, Id_Disease);
        if(listaVieja.isEmpty())
        {
          listaVieja.clear();
        }
        List<ClinicalElement> listaTestNuevos = new ArrayList<ClinicalElement>(listaNueva);
        listaTestNuevos.removeAll(listaVieja);
        Iterator<ClinicalElement> itNuevos = listaTestNuevos.iterator();
        while (itNuevos.hasNext()) {
          // elements =  mng.LogicAddRelation(Id_Doctor, Id_Disease, itNuevos.next().getId());
        }
        
        List<ClinicalElement> listaTestBorrar = new ArrayList<ClinicalElement>(listaVieja);
        listaTestBorrar.removeAll(listaNueva);
        Iterator<ClinicalElement> itBorrar = listaTestBorrar.iterator();
        while (itBorrar.hasNext()) {
         //   elements = mng.LogicDeleteRelation(Id_Doctor, Id_Disease, itBorrar.next().getId());
        }
        ce = new ClinicalElement();
        ce.setMensaje("Tests list Updated");
        elements.add(ce);
        
        }
        catch(Exception e)
        {
          //response.sendError(404, "Doctor Id or Disease Id Not Valid");
          ce = new ClinicalElement();
          ce.setMensaje("ERROR Doctor Id or Disease Id Not Valid "+e.getMessage());
          elements.clear();
          elements.add(ce);
          return elements;
          
        }
        return elements;
    }
}
