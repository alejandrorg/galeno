/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Galenos.classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gandhi
 */

public class AddNewSign {

    AddNewItem ani = new AddNewItem();
    ClinicalElement ce = new ClinicalElement();
    List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
    public boolean AddTheNewSign(String c_code, String c_name) throws Exception {

        boolean band = true;
        System.out.println("Trying to add " + c_code + " - " + c_name );
        band = ani.serchcodename(c_code, c_name);
        if (band == false) { //cuando la bandera está en falso significa que no se encontró el código a agregar

            //entonces procede a agregarlo
            System.out.println("No se encontró el código del concepto");
            //agregar el código y nombre
            try {
                System.out.println("Adding " + c_code + " - " + c_name + "in global ontology");
                ani.newglobalsign(c_code, c_name);

                System.out.println("New Sign added "+c_code+"---"+c_name);
             
            } catch (Exception e) {

            	e.printStackTrace();
                band = true;
                return band;

            }
            
        } 
return band;
    }
    
    public boolean agregacode_enfichero(String c_code, String c_name){
        //se agrega al fichero de codesandnames.txt
        boolean band = false;
            try {
              band =  ani.agregarsignenfichero(c_code, c_name);
            } catch (Exception e) {
//                ce = new ClinicalElement();
//                elements.clear();
//                ce.setMensaje("ERROR adding new sign " + e.getMessage());
//                elements.add(ce);
            	System.out.println("ERROR adding new sign "+e.getMessage());
              return band;
            }
            return band;
    }
}
