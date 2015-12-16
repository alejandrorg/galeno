/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Galenos.classes;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author gandhi
 */
public class ReviewCodes {

    long newcode;
    boolean band = false;
    List<ClinicalElement> elements = new ArrayList<ClinicalElement>();
    List<String> codigos = new ArrayList<String>();
    ClinicalElement ce = new ClinicalElement();
    Logic lg = new Logic();
    int maximo = 0;
    String maxi="";
    String file;

    public boolean Review(Long code) throws Exception {

        elements.clear();
        Logic lg = new Logic();
        elements = lg.getAllSigns();
        for (int i = 0; i < elements.size(); i++) {
            codigos.add(elements.get(i).getId().substring(1));
        }
        elements.clear();
        elements = lg.getAllDisorders();
        for (int i = 0; i < elements.size(); i++) {
            codigos.add(elements.get(i).getId().substring(1));
        }
        elements.clear();
        elements = lg.getAllTest();
        for (int i = 0; i < elements.size(); i++) {
            codigos.add(elements.get(i).getId().substring(1));
        }

        for (int i = 0; i < codigos.size(); i++) {
            if (Long.parseLong(codigos.get(i)) == code) {
                band = true;
                return band;
            }

        }
        return band;
    }

    public void buscamaximo() throws Exception {
        elements.clear();
        Logic lg = new Logic();
        elements = lg.getAllSigns();
        for (int i = 0; i < elements.size(); i++) {
            codigos.add(elements.get(i).getId().substring(1));
        }
        elements.clear();
        elements = lg.getAllDisorders();
        for (int i = 0; i < elements.size(); i++) {
            codigos.add(elements.get(i).getId().substring(1));
        }
        elements.clear();
        elements = lg.getAllTest();
        for (int i = 0; i < elements.size(); i++) {
            codigos.add(elements.get(i).getId().substring(1));
        }
        for (int i = 0; i < codigos.size(); i++) {
            if (Long.parseLong(codigos.get(i)) > maximo) {
                maximo = Integer.parseInt(codigos.get(i));
            }
        }
        System.out.println("El máximo es " + maximo);
    }

    public int getmaximo() throws Exception {
        try {
            maximo = 0;
            // Abrimos el archivo
            FileInputStream fstream = new FileInputStream("C:/gandhi/maximum.txt");
            // Creamos el objeto de entrada
            DataInputStream entrada = new DataInputStream(fstream);
            // Creamos el Buffer de Lectura
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            String strLinea;
            // Leer el archivo linea por linea
            while ((strLinea = buffer.readLine()) != null) {
                // Imprimimos la línea por pantalla
                System.out.println(strLinea);
                maximo = Integer.parseInt(strLinea);
            }
            // Cerramos el archivo
            buffer.close();
            fstream.close();
            entrada.close();
        } catch (Exception e) {
            System.err.println("Ocurrio un error: " + e.getMessage());
        }

        return maximo;
    }
    public void updatefile(String max) throws IOException
    {
      //actualizar el fichero maximum con el siguiente código
        try{
        file = "C:/gandhi/maximum.txt";    
        FileWriter bw = new FileWriter(file, true);
        bw.write("\n"+max);
        bw.close();
        }
        catch(Exception e)
        {
          System.out.println("Error en el método updatefile "+e.getMessage());
        }
    }

//    public static void main(String args[]) throws Exception {
//        ReviewCodes r = new ReviewCodes();
//        //maximo = r.getmaximo();
//       AddNewSignCodeResource res = new AddNewSignCodeResource();
//      // elements = res.AddNewSignCode("me duele la panza (finding)", "gandhi");
//       
//       
//    }
}
