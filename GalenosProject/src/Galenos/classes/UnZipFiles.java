package Galenos.classes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.swing.JOptionPane;
import Galeno.Forms.*;
public class UnZipFiles {
	List<String> fileList;
	  private static final String INPUT_ZIP_FILE = System.getProperty("user.dir") + "/src/src/gandhi.zip";
	  private static final String OUTPUT_FOLDER = "C:/";

	//  public static void main(String[] args)
	//  {
//	    File folder = new File("C:/gandhi");
//	    if (!folder.exists()) {
//	      unZipIt(INPUT_ZIP_FILE, "C:/");
//	    } else {
//	      System.out.println("La carpeta ya existe ");
//	      Principal obFrm = new Principal();
//	      obFrm.setVisible(true);
//	      obFrm.setSize(800, 600);
//	      obFrm.setLocationRelativeTo(null);
//	    }
	//  }
	  public void start(){
	      File folder = new File("C:/gandhi");
	    if (!folder.exists()) {
	      unZipIt(INPUT_ZIP_FILE, "C:/gandhi");
	    } else {
	      System.out.println("La carpeta ya existe ");
	      MainGUI obFrm = new MainGUI();
	      obFrm.open();
	     }
	  }

	  static void unZipIt(String zipFile, String outputFolder) {
	    byte[] buffer = new byte[1024];
	    try
	    {
	      File folder = new File("C:/");
	      if (!folder.exists()) {
	        folder.mkdir();
	      }

	      ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));

	      ZipEntry ze = zis.getNextEntry();

	      while (ze != null) {
	        String fileName = ze.getName();
	        File newFile = new File(outputFolder + File.separator + fileName);
	        System.out.println("file unzip : " + newFile.getAbsoluteFile());

	        if (ze.isDirectory()) {
	          new File(newFile.getParent()).mkdirs();
	        }
	        else {
	          FileOutputStream fos = null;
	          new File(newFile.getParent()).mkdirs();
	          fos = new FileOutputStream(newFile);
	          int len;
	          while ((len = zis.read(buffer)) > 0) {
	            fos.write(buffer, 0, len);
	          }
	          fos.close();
	        }
	        ze = zis.getNextEntry();
	      }
	      zis.closeEntry();
	      zis.close();

	      JOptionPane.showMessageDialog(null, "Ontologías descargadas en C:\\gandhi", "Descarga de ontologías", 1);

	      MainGUI obFrm = new MainGUI();
	      obFrm.open();
	    }
	    catch (IOException ex) {
	      JOptionPane.showMessageDialog(null, "ERROR durante la creación del directorio de ontologias en:\n C:\\galeno ontologies \n Elimine el directorio si es necesario...", "Descarga de ontologías", 0);

	      ex.printStackTrace();
	    }
	  }
	
}
