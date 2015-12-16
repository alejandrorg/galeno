package com.alejandrorg.phd.others;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class ConfigManager {

	private static Properties config;
	private final static String CFG_FILE = "C:/gandhi/config/config.cfg";

	/**
	 * M�todo para crear la instancia.
	 * 
	 * @throws Exception
	 *             Puede lanzar excepci�n.
	 */
	private static void createInstace() throws Exception {
		config = new Properties();
		config.load(new FileInputStream(CFG_FILE));
	}

	/**
	 * M�todo para obtener un valor de configuraci�n.
	 * 
	 * @param key
	 *            Recibe la clave.
	 * @return Devuelve el valor.
	 * @throws Exception
	 *             Puede lanzar excepci�n.
	 */
	public static String getConfig(String key) throws Exception {
		if (config == null) {
			createInstace();
		}
		String ret = config.getProperty(key);
		if (ret == null) {
			ret = "";
		}
		return ret;
	}

	/**
	 * M�todo para obtener una configuraci�n de un fichero concreto.
	 * 
	 * @param key
	 *            Recibe la configuraci�n.
	 * @param file
	 *            Recibe el fichero.
	 * @return Devuelve el resultado.
	 * @throws Exception
	 *             Puede lanzar excepci�n.
	 */
	public static String getConfig(String key, File file) throws Exception {
		Properties tmpProp = new Properties();
		tmpProp.load(new FileInputStream(file));
		String ret = tmpProp.getProperty(key);
		if (ret == null) {
			ret = "";
		}
		return ret;
	}

	/**
	 * M�todo para establecer un valor de configuraci�n.
	 * 
	 * @param key
	 *            Recibe la clave.
	 * @param value
	 *            Recibe el valor.
	 * @throws Exception
	 *             Puede lanzar excepci�n.
	 */
	public static void setConfig(String key, String value) throws Exception {
		if (config == null) {
			createInstace();
		}
		config.setProperty(key, value);
		config.store(new FileOutputStream(CFG_FILE), "");
	}

	/**
	 * M�todo para establecer una configuraci�n.
	 * 
	 * @param key
	 *            Clave
	 * @param value
	 *            Valor
	 * @param file
	 *            Fichero
	 * @throws Exception
	 *             Puede lanzar excepci�n.
	 */
	public static void setConfig(String key, String value, File file)
			throws Exception {
		Properties tmpProp = new Properties();
		tmpProp.load(new FileInputStream(file));
		tmpProp.setProperty(key, value);
		tmpProp.store(new FileOutputStream(file), "");
	}
}
