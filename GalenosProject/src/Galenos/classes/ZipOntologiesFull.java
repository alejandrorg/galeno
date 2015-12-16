/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Galenos.classes;

/**
 *
 * @author gandhi
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOntologiesFull
{
  private static final String INPUT_ZIP_FILE = "C:/gandhi/";
  private static final String OUPUT_FOLDER = "C:\\gandhi\\ontologies.zip";

  public boolean zipOntologies()
    throws IOException
  {
    try
    {
      File inFolder = new File("C:/gandhi/kbmedglobal");
      File outFolder = new File("C:\\gandhi\\ontologies.zip");

      ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outFolder)));

      out.setLevel(-1);
      out.setMethod(8);

      BufferedInputStream in = null;
      byte[] data = new byte[1024];
      String[] files = inFolder.list();

      for (int i = 0; i < files.length; i++) {
        in = new BufferedInputStream(new FileInputStream(inFolder.getPath() + "/" + files[i]), 1024);
        out.putNextEntry(new ZipEntry(files[i]));
        int count;
        while ((count = in.read(data, 0, 1024)) != -1) {
          out.write(data, 0, count);
        }
        out.closeEntry();
      }
      out.flush();
      out.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return true;
  }
}