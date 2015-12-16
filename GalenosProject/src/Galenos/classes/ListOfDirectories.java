/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Galenos.classes;

import java.io.File;

/**
 *
 * @author gandhi
 */
public class ListOfDirectories {

    private final String DIR_BASE = "C://gandhi/";
    private String d = "";
    private int dirs=0;

//    public static void main(String[] args) {
//        dirs = listardirectorios();
//        System.out.println("Se han encontrado "+dirs+ " ontologías de médicos");
//    }

    public int countdirectories() {

        //Llena la lista kbs con las rutas de todos los directorios
        /**
         * En primer lugar creamos un objeto File que apunta al directorio base.
         */
        File dir = new File(DIR_BASE);
        /*
         * Mediante un for con listFiles le decimos que nos devuelva todos los
         * ficheros y subdirectorios.
         */
        int j = 0;
        for (int i = 0; i < dir.listFiles().length; i++) {
            /*
             * Si el objeto actual es un directorio, asumimos que es el
             * correspondiente a la base de conocimiento de un médico
             * determinado.
             */
            if (dir.listFiles()[i].isDirectory()) {
                /*
                 * Si lo es, simplemente añadimos el nombre del directorio a una
                 * lista y mostramos por pantalla.
                 */
                /*String*/ d = dir.listFiles()[i].toString();

                //if (d.contains("global")==false) {
                /*si no es el directorio global(el de la KB original) entonces debe tratarse del
                directorio de uno de los médicos(usuarios), por lo tanto se crea la ruta de ese directorio
                y se agrega a la lista de rutas de las kbs*/
//                if (usuarios.get(j).toString().equalsIgnoreCase("global") == false) {
//                    d = DIR_BASE + "kbmed" + usuarios.get(j).toString();
//                    this.kbs.add(d);
                j++;
                System.out.println(j + ".- Directorio (KB) cargado: " + d);

            }

        }
        return j;
    }
}
