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

public class AddNewTest {

    ClinicalElement ce = new ClinicalElement();
    AddNewItem ani = new AddNewItem();
    List<ClinicalElement> elements = new ArrayList<ClinicalElement>();

    public boolean AddTheNewTest(String c_code, String c_name) throws Exception {
        boolean band = true;
        System.out.println("Trying to add " + c_code + " - " + c_name );
        
        
       
        band = ani.serchcodename(c_code, c_name);
        if (band == false) { //cuando la bandera está en falso significa que no se encontró el código a agregar

            //entonces procede a agregarlo
            System.out.println("No se encontró el código del concepto");
            //agregar el código y nombre
            try {
                System.out.println("Adding " + c_code + " - " + c_name + "in global ontology");
                ani.newglobaltest(c_code, c_name);
                ce.setMensaje("New Tests Added");
                elements.add(ce);
                //return elements;
            } catch (Exception e) {
                ce = new ClinicalElement();
                elements.clear();
                ce.setMensaje("ERROR adding new Test " + e.getMessage());
                elements.add(ce);
                band = true;
                return band;

            }
            
        } 
return band;
    }

    public boolean agregacode_enfichero(String c_code, String c_name) {
        //se agrega al fichero de codesandnames.txt
        boolean band = false;
        try {
            band = ani.agregarsignenfichero(c_code, c_name);
        } catch (Exception e) {
            ce = new ClinicalElement();
            elements.clear();
            ce.setMensaje("ERROR adding new sign " + e.getMessage());
            elements.add(ce);
            return band;
        }
        return band;
    }
}
