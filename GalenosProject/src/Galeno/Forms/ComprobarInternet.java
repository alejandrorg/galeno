package Galeno.Forms;

import javax.swing.*;
import java.net.*;

public class ComprobarInternet {

    public ComprobarInternet() {
    }

	public static void main(String args[]){
		ComprobarInternet obCon = new ComprobarInternet();
		if(obCon.ComprobarConexion()){
			JOptionPane.showMessageDialog(null, "Conexion a internet Ok");
		}else{
			JOptionPane.showMessageDialog(null, "Usted no tiene conexion a Internet");
		}
	}

    public boolean ComprobarConexion(){
    	boolean estado = false;
        try {

            URL ruta=new URL("http://snapi.dataline.co.uk/SnAPIService.svc?wsdl");
            URLConnection rutaC=ruta.openConnection();
            rutaC.connect();
            estado=true;
           }catch(Exception e){

            estado=false;
        }

return estado;
}
}

