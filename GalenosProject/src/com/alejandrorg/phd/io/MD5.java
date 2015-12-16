package com.alejandrorg.phd.io;

/**
 * Título: Md5 Sum
 * Descripción: Clase que contiene métodos para calcular el md5 hash de un fichero.
 * Copyright: Copyright (c) 2005
 * Empresa: Ninguna
 * @author Alejandro Rodríguez González - 71652585H - i1652585
 * @version 1.0
 */

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public class MD5 {
  private static final char[] hexadecimal = {
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
      'a', 'b', 'c', 'd', 'e', 'f'
  };


  public static String getMD5Hash(File f) throws Exception {
	  return executeChecksum(f);
  }
  /**
   * Codifica los 128 bits (16 bytes) MD5 en un String de 32 caracteres.
   * @param binaryData byte[] Recibe el array.
   * @return String Devuelve el md5 codificado o null si falla.
   */
  private static String encode(byte[] binaryData) {
    if (binaryData.length != 16) {
      return null;
    }
    char[] buffer = new char[32];
    for (int i = 0; i < 16; i++) {
      int low = (binaryData[i] & 0x0f);
      int high = ( (binaryData[i] & 0xf0) >> 4);
      buffer[i * 2] = hexadecimal[high];
      buffer[i * 2 + 1] = hexadecimal[low];
    }
    return new String(buffer);
  }

  /**
   * Lo introduce en un contenedor estatico.
   * @param file File Recibe el fichero.
   * @throws Exception Puede lanzar excepción.
   * @return byte[] Devuelve un array de bytes.
   */
  private static byte[] getBytes(File file) throws Exception {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    InputStream stream = new FileInputStream(file);
    byte buf[] = new byte[1024];
    int len = 0;
    while ( (len = stream.read(buf, 0, 1024)) != -1) {
      baos.write(buf, 0, len);
    }
    return baos.toByteArray();
  }

  /**
   * Ejecuta el MD5-Sum.
   * @throws Exception Lanza excepción si ocurre un error mientras se calcula el hash.
   */
  private static String executeChecksum(File file) throws Exception {
    MessageDigest md5Helper = MessageDigest.getInstance("MD5");
    return encode(md5Helper.digest(getBytes(file)));
  }
}
