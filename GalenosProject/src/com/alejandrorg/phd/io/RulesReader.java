package com.alejandrorg.phd.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import com.alejandrorg.phd.others.ConfigManager;
import com.alejandrorg.phd.others.Constants;

/**
 * La clase RulesReader se encarga de cargar las reglas de inferencia de las que
 * disponga el sistema.
 * 
 * El funcionamiento es sencillo:
 * 
 * 1. Lista todos los ficheros de reglas que haya en el directorio donde se
 * guardan las reglas. 2. Uno a uno, va comprobando el hash md5 de cada fichero
 * y lo compara con su hash md5 anterior que est� en un fichero de configuraci�n
 * donde est�n todos los hashes. 3. En caso de que dicho hash no exista (posible
 * fichero nuevo), o sea distinto, se activa un flag que indicar� que ha habido
 * cambios en los ficheros de reglas. 4. Si ha habido cambios, generar� un nuevo
 * fichero de reglas "allRules.rules" que contendr� las reglas del resto de
 * ficheros del directorio (excepto allRules.rules logicamente), creando el
 * "fichero de reglas maestro".
 * 
 * Una vez finalizado este proceso, tanto si hubo cambios como si no, tendremos
 * en allRules.rules la versi�n con las reglas m�s recientes posible.
 * 
 */
public class RulesReader {

	public String RULES_DIRECTORY;
	public String RULES_FILE;
	public String HASHES_FILE;
	public String RULES_EXTENSION;

	private Properties properties;
	private String ontURI;
	private String signsURI;
	private String dtsURI;
	private String diseasesURI;
	private String idKB;

	/**
	 * Constructor de la clase.
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public RulesReader(String id) throws Exception {
		this.idKB = id;
		init();
		properties = new Properties();
		if (new File(HASHES_FILE).exists()) {
			properties.load(new FileInputStream(HASHES_FILE));
		}
		this.ontURI = ConfigManager.getConfig(Constants.URI_HOST) + this.idKB + "/"
				+ ConfigManager.getConfig(Constants.FILE_ONT_DDX);
		this.signsURI = ConfigManager.getConfig(Constants.URI_HOST) + this.idKB + "/"
				+ ConfigManager.getConfig(Constants.FILE_ONT_SIGNS);
		this.dtsURI = ConfigManager.getConfig(Constants.URI_HOST) + this.idKB + "/"
				+ ConfigManager.getConfig(Constants.FILE_ONT_DTS);
		this.diseasesURI = ConfigManager.getConfig(Constants.URI_HOST) + this.idKB + "/"
				+ ConfigManager.getConfig(Constants.FILE_ONT_DISEASES);
	}

	private void init() throws Exception {
		this.RULES_DIRECTORY = ConfigManager.getConfig(Constants.RULES_FOLDER) + this.idKB + "/";
		this.RULES_FILE = RULES_DIRECTORY
				+ ConfigManager.getConfig(Constants.ALL_RULES_FILE);
		this.HASHES_FILE = RULES_DIRECTORY
				+ ConfigManager.getConfig(Constants.HASH_RULES_FILE);
		this.RULES_EXTENSION = ConfigManager
				.getConfig(Constants.RULES_EXTENSION);
	}

	/**
	 * M�todo para obtener los ficheros de reglas que han cambiado.
	 * 
	 * @return Devuelve el array de ficheros.
	 * @throws Exception
	 */
	private ArrayList<File> getChangedRulesFiles() throws Exception {
		ArrayList<File> res = new ArrayList<File>();
		File directory = new File(RULES_DIRECTORY);
		if (directory.isDirectory()) {
			File files[] = directory.listFiles(new FileFilter() {
				public boolean accept(File arg0) {
					String file = arg0.getName();
					return file.substring(file.indexOf('.') + 1, file.length())
							.equalsIgnoreCase(RULES_EXTENSION);
				}
			});
			for (int i = 0; i < files.length; i++) {
				if ((!files[i].getName().equalsIgnoreCase(RULES_FILE))
						&& (!files[i].isDirectory())) {
					// Omitimos el RULES_FILE que es donde est�n todas las
					// reglas y posibles subdirectorios
					String md5File = MD5.getMD5Hash(files[i]);
					String md5ConfigFile = getSavedMD5OfFile(files[i]);
					if (!md5File.equalsIgnoreCase(md5ConfigFile)) {
						// Si no coinciden los hash hay que recargar
						res.add(files[i]);
					}
				}
			}
		}
		return res;
	}

	/**
	 * M�todo para obtener el MD5 de un determinado fichero que est� guardado en
	 * el fichero de hashes.
	 * 
	 * @param file
	 *            Recibe el fichero.
	 * @return Devuelve el hash.
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private String getSavedMD5OfFile(File file) throws FileNotFoundException,
			IOException {
		String ret = properties.getProperty(file.getName());
		if (ret == null)
			ret = "";
		return ret;
	}

	/**
	 * M�todo para obtener el fichero de reglas. Comprobar� si hay cambios en
	 * las reglas y crear� un nuevo fichero si es necesario.
	 * 
	 * @return Devuelve el fichero de reglas.
	 * @throws Exception
	 */
	public String getRulesFile() throws Exception {
		ArrayList<File> rulesFiles = getChangedRulesFiles();
		if (rulesFiles.size() > 0) {
			// ha habido cambios, regeneramos el fichero de reglas.
			generateRulesFile();
			writeNewHashes(rulesFiles);
			return RULES_FILE;
		} else {
			return RULES_FILE;
		}

	}

	/**
	 * M�todo para escribir los hashes de los archivos modificados.
	 * 
	 * @param rulesFiles
	 *            Recibe los archivos modificados (o nuevos).
	 * @throws Exception
	 */
	private void writeNewHashes(ArrayList<File> rulesFiles) throws Exception {
		for (int i = 0; i < rulesFiles.size(); i++) {
			File f = rulesFiles.get(i);
			String md5 = MD5.getMD5Hash(f);
			writeHash(f.getName(), md5);
		}
		properties.store(new FileOutputStream(HASHES_FILE), "");
	}

	/**
	 * M�todo para escribir el hash de un fichero al fichero de hashes.
	 * 
	 * @param name
	 *            Recibe el fichero.
	 * @param md5
	 *            Recibe el hash.
	 */
	private void writeHash(String name, String md5) {
		properties.setProperty(name, md5);

	}

	/**
	 * M�todo para generar el fichero de reglas. Recibe los ficheros de reglas
	 * que cambiaron (Reescribira su hash) aunque el fichero de reglas generado
	 * nuevo ser� entero, uno a uno, pues no podemos coger cada fichero
	 * independientemente.
	 * 
	 * @throws Exception
	 */
	private void generateRulesFile() throws Exception {
		BufferedWriter bW = new BufferedWriter(new FileWriter(RULES_FILE));
		writeHeaderRulesFile(bW);
		File directory = new File(RULES_DIRECTORY);
		if (directory.isDirectory()) {
			File files[] = directory.listFiles(new FileFilter() {
				public boolean accept(File arg0) {
					String file = arg0.getName();
					return file.substring(file.indexOf('.') + 1, file.length())
							.equalsIgnoreCase(RULES_EXTENSION);
				}
			});
			for (int i = 0; i < files.length; i++) {
				if ((!files[i].getName().equalsIgnoreCase(RULES_FILE))
						&& (!files[i].isDirectory())) {
					writeFile(files[i], bW);
				}
			}
		}
		bW.close();
	}

	/**
	 * M�todo para a�adir la cabecera de los ficheros de reglas al fichero.
	 * 
	 * @param finalFile
	 *            Recibe el buffer de escritura
	 * @throws Exception
	 */
	private void writeHeaderRulesFile(BufferedWriter bW) throws Exception {
		bW.write("@prefix ont: <" + this.ontURI + "#>.");
		bW.newLine();
		bW.write("@prefix signs: <" + this.signsURI + "#>.");
		bW.newLine();
		bW.write("@prefix dto: <" + this.dtsURI + "#>.");
		bW.newLine();
		bW.write("@prefix disont: <" + this.diseasesURI + "#>.");
		bW.newLine();
		bW.write("@include <RDFS>.");
		bW.newLine();
	}

	/**
	 * M�todo para leer un fichero y guardarlo en un StringBuffer.
	 * 
	 * @param file
	 *            Recibe el fichero.
	 * @return Devuelve el StringBuffer
	 * @throws Exception
	 */
	private void writeFile(File file, BufferedWriter bW) throws Exception {
		BufferedReader bL = new BufferedReader(new FileReader(file));
		while (bL.ready()) {
			String l = bL.readLine();
			bW.write(l);
			bW.newLine();
		}
		bW.newLine();
	}

}
