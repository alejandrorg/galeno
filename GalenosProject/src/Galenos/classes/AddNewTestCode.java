package Galenos.classes;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author gandhi
 */

public class AddNewTestCode {

    int code = 0;
    String codigo = "";
ReviewCodes rc = new ReviewCodes();
AddNewItem ani = new AddNewItem();
   
    public int AddNewCode(String c_name) throws Exception {
        boolean band = true;

        System.out.println("datos recibidos " + c_name);
        //Buscar el número máximo en el fichero "C:/gandhi/maximum.txt"

        code = rc.getmaximo();
        System.out.println("El máximo es " + code);
        code = code + 1;
        //band = ani.serchcodename(String.valueOf(code), c_name); //busca el código en la lista de signos y test en las ontología
        band = ani.searchfinding(String.valueOf(code), c_name);
        if (band == false) {  // si band es false significa que el nuevo código no existe en ninguna de las ontologías signs.owl o dto.owl

            System.out.println("El nuevo código será " + code);
            codigo = String.valueOf(code);
        } else {
            code = 0;
        }
        return code;
    }
    public void actualizarficheronuevoscodigos(int code) {
        try {
            rc.updatefile(String.valueOf(code));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

