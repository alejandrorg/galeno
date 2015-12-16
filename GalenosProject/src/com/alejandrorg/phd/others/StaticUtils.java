package com.alejandrorg.phd.others;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Clase que representa ciertas utilidades de forma estática.
 * 
 * @author Alejandor Rodríguez González - Universidad Carlos III de Madrid -
 *         Proyecto SONAR2
 * 
 */
public class StaticUtils {

	private static boolean debug = true;
	@SuppressWarnings("unused")
	private static Logger logger;
	@SuppressWarnings("unused")
	private static FileHandler fhlogger;
	@SuppressWarnings("unused")
	private static SimpleFormatter logformatter;
	private static final int FILE_NUMERIC_VALUE = 5;

	/**
	 * Método para comprobar si una cadena esta vacia ("" o null)
	 * 
	 * @param str
	 *            Recibe la cadena
	 * @return Devuelve booleano.
	 */
	public static boolean isEmpty(String str) {
		return ((str == null) || (str.trim().equals("")));
	}

	/**
	 * Método para obtener un float a partir de un String.
	 * 
	 * @param str
	 *            Recibe el String.
	 * @return Devuelve el float.
	 */
	public static float getFloatFromString(String str) {
		if (str == null)
			return 0;
		float res = 0;
		try {
			res = Float.parseFloat(str);
		} catch (Exception e) {
			res = 0;
		}
		return res;
	}

	/**
	 * Método para saber si se está ejecutando desde un JAR
	 * 
	 * @return Devuelve un booleano.
	 */
	public static boolean isExecutingFromJAR() {
		String className = StaticUtils.class.getName().replace('.', '/');
		String classJar = StaticUtils.class.getResource(
				"/" + className + ".class").toString();
		if (classJar.startsWith("jar:")) {
			return true;
		}
		return false;
	}

	/**
	 * Método para obtener el nombre del fichero JAR
	 * 
	 * @return Devuelve la cadena.
	 */
	public static String getJARFileName() {
		String className = StaticUtils.class.getName().replace('.', '/');
		String classJar = StaticUtils.class.getResource(
				"/" + className + ".class").getFile();
		classJar = classJar
				.substring(FILE_NUMERIC_VALUE, classJar.indexOf('!'));
		return classJar;
	}

	/**
	 * Método para obtener un long a partir de un String.
	 * 
	 * @param str
	 *            Recibe el String.
	 * @return Devuelve el long.
	 */
	public static double getDoubleFromString(String str) {
		if (str == null)
			return 0;
		double res = 0;
		try {
			res = Double.parseDouble(str);
		} catch (Exception e) {
			res = 0;
		}
		return res;
	}

	/**
	 * Método para borrar una extensión en una cadena que contenga un fichero y
	 * su extensión.
	 * 
	 * @param name
	 *            Recibe la cadena.
	 * @return Devuelve otra cadena.
	 */
	public static String removeExtension(String name) {
		String ret = "";
		for (int i = 0; i < name.lastIndexOf('.'); i++) {
			ret += name.charAt(i);
		}
		return ret;
	}

	/**
	 * Método de debug.
	 * 
	 * @param string
	 *            Recibe la cadena a guardar.
	 */
	public static void debug(String string) {
		if (debug) {
			try {
				BufferedWriter bW = new BufferedWriter(new FileWriter(
						"debug_signal.txt", true));
				// bW.newLine();
				bW.write(string);
				bW.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.print("Debug: " + string);
		}

	}

	/**
	 * Método para obtener un int de una cadena.
	 * 
	 * @param str
	 *            Recibe la cadena.
	 * @return Devuelve el entero.
	 */
	public static int getIntFromString(String str) {
		if (str == null)
			return 0;
		int res = 0;
		try {
			res = Integer.parseInt(str);
		} catch (Exception e) {
			res = 0;
		}
		return res;
	}

	/**
	 * Método para loguear.
	 * 
	 * @param m
	 *            Recibe el mensaje.
	 */
	public static void log(String m) {
		System.out.println(m);
		// if (logger == null) {
		// logger = Logger.getLogger("MDSS_Log");
		// }
		// if (fhlogger == null) {
		// try {
		// fhlogger = new FileHandler("MDSS.log", true);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// logger.addHandler(fhlogger);
		// logger.setLevel(Level.ALL);
		// if (logformatter == null) {
		// logformatter = new SimpleFormatter();
		// }
		// fhlogger.setFormatter(logformatter);
		// logger.log(Level.WARNING, m);
		// }
	}

	/**
	 * Método para saber si una cadena es un entero.
	 * 
	 * @param cat
	 *            Recibe la cadena.
	 * @return Devuelve un booleano.
	 */
	public static boolean isInteger(String cat) {
		try {
			Integer.parseInt(cat);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Método para saber si una cadena es un float.
	 * 
	 * @param cat
	 *            Recibe la cadena.
	 * @return Devuelve un booleano.
	 */
	public static boolean isFloat(String cat) {
		try {
			Float.parseFloat(cat);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Método para saber si una cadena es un double.
	 * 
	 * @param cat
	 *            Recibe la cadena.
	 * @return Devuelve un booleano.
	 */
	public static boolean isDouble(String cat) {
		try {
			Double.parseDouble(cat);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Método para saber si una cadena es un booleano.
	 * 
	 * @param c
	 *            Recibe la cadena.
	 * @return Devuelve un booleano.
	 */
	public static boolean isBoolean(String c) {
		try {
			Boolean.parseBoolean(c);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static String removeChars(String str, char[] exclude) {
		String ret = str;
		for (int i = 0; i < exclude.length; i++) {
			ret = removeCharacter(ret, exclude[i]);
		}
		return ret;
	}

	public static String removeCharacter(String ret, char c) {
		String retu = "";
		for (int i = 0; i < ret.length(); i++) {
			if (ret.charAt(i) != c) {
				retu += ret.charAt(i);
			}
		}
		return retu;
	}

	public static String reverse(String s) {
		String ret = "";
		for (int i = s.length()-1; i > 0; i--) {
			ret += s.charAt(i);
		}
		return ret;
	}
}