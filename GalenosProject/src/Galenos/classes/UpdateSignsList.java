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

public class UpdateSignsList {

   public List<ClinicalElement> UpdateMDSignsList(List<ClinicalElement> listaNueva, String Id_Doctor, String Id_Disease) throws Exception {
        List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
        List<ClinicalElement> listaVieja = new ArrayList<ClinicalElement>();
        List<ClinicalElement> listaSintomasNuevos = new ArrayList<ClinicalElement>();
        List<ClinicalElement> listaSintomasBorrar = new ArrayList<ClinicalElement>();
        
        ClinicalElement ce = new ClinicalElement();
        ManageSigns mng = new ManageSigns();
        System.out.println("Se van a agregar los siguientes síntomas ");
        for (int i = 0; i < listaNueva.size(); i++) {
            System.out.println(listaNueva.get(i).getId());
        }
        try {
            listaVieja = ce.getSignsFromDiseasesFromDoc(Id_Doctor, Id_Disease);
//            if (listaVieja.get(0).getMensaje().equalsIgnoreCase("ERROR Id Doctor or Id Disease not valid")) {
//                System.out.println("la lista vieja está vacía");
//                listaVieja.clear();
//            }
            for(int i =0; i<listaVieja.size(); i++)
            {
             ce = new ClinicalElement();
             ce = listaVieja.get(i);
             System.out.println(ce.getId()+"$$"+ce.getNombre()+"$$"+ce.getTipo()+"$$"+ce.getMensaje());
             if(ce.getMensaje() != null)
             {if (ce.getMensaje().equalsIgnoreCase("ERROR Id Doctor or Id Disease not valid"))
             {
                System.out.println("la lista vieja está vacía");
                listaVieja.clear();
             }
             }
             
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + "Error al cargar la lista vieja");
            ce = new ClinicalElement();
            ce.setMensaje("ERROR al cargar la lista vieja " + e.getMessage());
            elements.add(ce);
            return elements;

        }
        try {
            listaSintomasNuevos = new ArrayList<ClinicalElement>(listaNueva);
            listaSintomasNuevos.removeAll(listaVieja);
            Iterator<ClinicalElement> itNuevos = listaSintomasNuevos.iterator();
            while (itNuevos.hasNext()) {
               // elements = mng.LogicAddRelation(Id_Doctor, Id_Disease, itNuevos.next().getId());
            }
        }
        catch (Exception e) {
            //response.sendError(404, "Doctor Id or Disease Id Not Valid");
            ce = new ClinicalElement();
            ce.setMensaje("ERROR en la llamada al método LogicAddRelation" + e.getMessage());
            elements.add(ce);
            return elements;
        }

try{
            listaSintomasBorrar = new ArrayList<ClinicalElement>(listaVieja);
            listaSintomasBorrar.removeAll(listaNueva);
            Iterator<ClinicalElement> itBorrar = listaSintomasBorrar.iterator();
            while (itBorrar.hasNext()) {
             //   elements = mng.LogicDeleteRelation(Id_Doctor, Id_Disease, itBorrar.next().getId());
            }
}
catch (Exception e) {
            //response.sendError(404, "Doctor Id or Disease Id Not Valid");
            ce = new ClinicalElement();
            ce.setMensaje("ERROR en la llamada al método LogicDeleteRelation" + e.getMessage());
            elements.add(ce);
            return elements;
        }
            ce = new ClinicalElement();
            ce.setMensaje("Signs list Updated");
            elements.add(ce);
         
        return elements;
    }
}