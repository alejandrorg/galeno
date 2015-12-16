package com.alejandrorg.phd.rulegenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;

import com.alejandrorg.phd.others.ConfigManager;
import com.alejandrorg.phd.others.Constants;
import com.hp.hpl.jena.ontology.OntResource;

public class RuleWriter {

	private String finalRule;
	private DiseaseObjectRuleGenerator dob;
	private String idKB;

	/**
	 * Constructor.
	 * 
	 * @param dob
	 *            Recibe el objeto que representa la enfermedad.
	 */
	public RuleWriter(DiseaseObjectRuleGenerator dob, String id) {
		this.idKB = id;
		System.out.println("Creating rule of: " + dob.getName());
		this.finalRule = "";
		this.dob = dob;
		LinkedList<String> totalSigns = new LinkedList<String>();
		finalRule += createRuleNotRestSigns(totalSigns) + "\n\n";
		finalRule += createRuleNotRestDisorders(totalSigns) + "\n\n";
		finalRule += createRuleNotRestDiagnosticTests() + "\n\n";
		/*
		 * Reglas para signos aislados
		 */
		for (int i = 0; i < this.dob.getSigns().size(); i++) {
			finalRule += createRuleForSign(this.dob.getSigns().get(i)) + "\n\n";
		}
		/*
		 * Reglas para pruebas de diagnóstico aisladas
		 */
		if (this.dob.getDts() != null) {
			for (int i = 0; i < this.dob.getDts().size(); i++) {
				if (this.dob.getDts().get(i) != null) {
					finalRule += createRuleForDT(this.dob.getDts().get(i))
							+ "\n\n";
				}
			}
		}
		/*
		 * Reglas para disorders (sin signos asociados)
		 */
		if ((dob.getDisorders() != null) && (dob.getDisorders().size() > 0)) {
			for (int i = 0; i < dob.getDisorders().size(); i++) {
				finalRule += createRuleForDisorder(dob.getDisorders().get(i));
			}
		}
		/*
		 * Reglas para disorders (con signos asociados)
		 */
		if ((dob.getDisordersWithSigns() != null)
				&& (dob.getDisordersWithSigns().size() > 0)) {
			for (int i = 0; i < dob.getDisordersWithSigns().size(); i++) {
				finalRule += createRuleForDisorderWithSigns(dob
						.getDisordersWithSigns().get(i));
			}
		}

	}

	/**
	 * Método para crear una regla para un disorder
	 * 
	 * @param dio
	 *            Recibe el objeto que encapsula al disorder
	 * @return Devuelve la cadena con la regla.
	 */
	private String createRuleForDisorder(OntResource dio) {
		String rule = "";
		rule += "[rule_" + dob.getName() + "_" + dio.getLocalName()
				+ "DISORDER_SIGN:\n";
		rule += "(?i ont:diagnosis disont:" + dob.getName() + ") <- ";
		rule += "(?i ont:has_disorder disont:" + dio.getLocalName() + ") ";
		rule += "noValue(?i, ont:hasNegSign ont:"
				+ dob.getOntResource().getLocalName() + "_NOT_SIGNS) ";
		rule += "noValue(?i, ont:hasNegDT ont:"
				+ dob.getOntResource().getLocalName() + "_NOT_DT) ";
		rule += "noValue(?i, ont:hasNegDisorder ont:"
				+ dob.getOntResource().getLocalName()
				+ "_NOT_DISORDERS) ]\n\n\n";
		return rule;
	}

	/**
	 * Método para crear una regla para un disorder (con signos)
	 * 
	 * @param dio
	 *            Recibe el objeto que encapsula al disorder
	 * @return Devuelve la cadena con la regla.
	 */
	private String createRuleForDisorderWithSigns(DiseaseObjectRuleGenerator dio) {
		String rule = "";
		for (int i = 0; i < dio.getSigns().size(); i++) {
			OntResource sign = dio.getSigns().get(i);
			rule += "[rule_" + dob.getName() + "_"
					+ dio.getOntResource().getLocalName()
					+ "DISORDER_WITH_SIGN:" + sign.getLocalName() + ":\n";
			rule += "(?i ont:has_sign ont:"
					+ dio.getOntResource().getLocalName() + "DISORDER) <- ";
			rule += "(?i ont:has_sign signs:" + sign.getLocalName() + ") ";
			rule += "noValue(?i, ont:hasNegSign ont:"
					+ dob.getOntResource().getLocalName() + "_NOT_SIGNS) ";
			rule += "noValue(?i, ont:hasNegDT ont:"
					+ dob.getOntResource().getLocalName() + "_NOT_DT) ";
			rule += "noValue(?i, ont:hasNegDisorder ont:"
					+ dob.getOntResource().getLocalName()
					+ "_NOT_DISORDERS) ]\n\n\n";
		}
		for (int i = 0; i < dio.getDisorders().size(); i++) {
			OntResource disor = dio.getDisorders().get(i);
			rule += "[rule_" + dob.getName() + "_"
					+ dio.getOntResource().getLocalName()
					+ "DISORDER_WITH_DISORDER:" + disor.getLocalName() + ":\n";
			rule += "(?i ont:has_sign ont:"
					+ dio.getOntResource().getLocalName() + "DISORDER) <- ";
			rule += "(?i ont:has_sign signs:" + disor.getLocalName() + ") ";
			rule += "noValue(?i, ont:hasNegSign ont:"
					+ dob.getOntResource().getLocalName() + "_NOT_SIGNS) ";
			rule += "noValue(?i, ont:hasNegDT ont:"
					+ dob.getOntResource().getLocalName() + "_NOT_DT) ";
			rule += "noValue(?i, ont:hasNegDisorder ont:"
					+ dob.getOntResource().getLocalName()
					+ "_NOT_DISORDERS) ]\n\n\n";
		}
		rule += "[rule_" + dob.getName() + "_SIGN:"
				+ dio.getOntResource().getLocalName() + ":\n";
		rule += "(?i ont:diagnosis disont:" + dob.getName() + ") <- ";
		rule += "(?i ont:has_sign ont:" + dio.getOntResource().getLocalName()
				+ "DISORDER) ";
		rule += "noValue(?i, ont:hasNegSign ont:"
				+ dob.getOntResource().getLocalName() + "_NOT_SIGNS) ";
		rule += "noValue(?i, ont:hasNegDT ont:"
				+ dob.getOntResource().getLocalName() + "_NOT_DT) ";
		rule += "noValue(?i, ont:hasNegDisorder ont:"
				+ dob.getOntResource().getLocalName()
				+ "_NOT_DISORDERS) ]\n\n\n";
		return rule;
	}

	/**
	 * Método para crear la regla para un determinado diagnostic test
	 * 
	 * @param dt
	 *            Recibe el diagnostic test.
	 * @return Devuelve la cadena.
	 */
	private String createRuleForDT(OntResource dt) {
		String rule = "";
		rule += "[rule_" + dob.getName() + "_DT:" + dt.getLocalName() + ":\n";
		rule += "(?i ont:diagnosis disont:" + dob.getName() + ") <- ";
		rule += "(?i ont:has_diagnostic_test dto:" + dt.getLocalName() + ") ";
		rule += "noValue(?i, ont:hasNegSign ont:" + dob.getName()
				+ "_NOT_SIGNS) ";
		rule += "noValue(?i, ont:hasNegDT ont:" + dob.getName() + "_NOT_DT) ";
		rule += "noValue(?i, ont:hasNegDisorder ont:"
				+ dob.getOntResource().getLocalName() + "_NOT_DISORDERS) ]";
		return rule;
	}

	/**
	 * Método para crear la regla para un determinado signo.
	 * 
	 * @param s
	 *            Recibe el signo.
	 * @return Devuelve la regla.
	 */
	private String createRuleForSign(OntResource s) {
		String rule = "";
		rule += "[rule_" + dob.getName() + "_SIGN:" + s.getLocalName() + ":\n";
		rule += "(?i ont:diagnosis disont:" + dob.getName() + ") <- ";
		rule += "(?i ont:has_sign signs:" + s.getLocalName() + ") ";
		rule += "noValue(?i, ont:hasNegSign ont:" + dob.getName()
				+ "_NOT_SIGNS) ";
		rule += "noValue(?i, ont:hasNegDT ont:" + dob.getName() + "_NOT_DT) ";
		rule += "noValue(?i, ont:hasNegDisorder ont:"
				+ dob.getOntResource().getLocalName() + "_NOT_DISORDERS) ]";

		return rule;
	}

	/**
	 * Método para crear la regla de exclusión de diagnostic tests.
	 * 
	 * @return Devuelve la cadena.
	 */
	private String createRuleNotRestDiagnosticTests() {
		String rule = "";
		rule += "[rule_" + dob.getName() + "_NOT_REST_DTS:\n";
		rule += "(?i ont:has_diagnostic_test ?x)";
		int written = 0;
		if (dob.getDts() != null) {
			for (int i = 0; i < dob.getDts().size(); i++) {
				if (dob.getDts().get(i) != null) {
					rule += " notEqual(?x, dto:"
							+ dob.getDts().get(i).getLocalName() + ")";
					written++;
				}
			}
		}

		rule += " -> (?i ont:hasNegDT ont:" + dob.getName() + "_NOT_DT) ]\n";
		return rule;
	}

	/**
	 * Método para crear la regla de exclusión de signos
	 * 
	 * @param totalSigns
	 *            Recibe los signos que se llevan procesando en las reglas NOT
	 *            REST
	 * @return Devuelve la cadena con la regla.
	 */
	private String createRuleNotRestSigns(LinkedList<String> totalSigns) {
		String rule = "";
		rule += "[rule_" + dob.getName() + "_NOT_REST_SIGNS:\n";
		rule += "(?i ont:has_sign ?x)";
		/*
		 * Signos normales. Ej: Estamos con laringitis, cogemos sus signos. Por
		 * ej: Hoarse, Loss of voice, ..
		 */
		for (int i = 0; i < dob.getSigns().size(); i++) {
			String sign = dob.getSigns().get(i).getLocalName();
			if (!totalSigns.contains(sign)) {
				rule += " notEqual(?x, signs:" + sign + ")";
				totalSigns.add(sign);
			}
		}
		/*
		 * Aquí cogemos los signos de los disorders de la enfermedad.
		 * 
		 * Ej: Estamos con Laringitis. Sabemos que laringitis tiene asociado
		 * "Faringitis" que tiene asociados varios signos (que no disorders,
		 * como por ej: Headache, Pain in throat, ...). Aquí cogemos esos signos
		 * de Faringitis.
		 */
		if ((dob.getDisordersWithSigns() != null)
				&& (dob.getDisordersWithSigns().size() > 0)) {
			for (int i = 0; i < dob.getDisordersWithSigns().size(); i++) {
				DiseaseObjectRuleGenerator dio = dob.getDisordersWithSigns()
						.get(i);
				if (dio.getDisorders().size() > 0) {
					/*
					 * Esta es una parte de la regla donde definimos como
					 * "posible" la propia patología que corresponda. Por ej,
					 * aquí pondríamos algo para si nos meten directamente
					 * "Faringitis" por eso el prefijo es "disont"
					 */
					rule += " notEqual(?x, disont:"
							+ dio.getOntResource().getLocalName() + ")";
					/*
					 * Ahora, cogemos los signos de la faringitis
					 */
					LinkedList<OntResource> signs = dio.getSigns();
					for (int j = 0; j < signs.size(); j++) {
						/*
						 * Y creamos las primitivas asociadas
						 */
						String sign = signs.get(j).getLocalName();
						if (!totalSigns.contains(sign)) {
							rule += " notEqual(?x, signs:"
									+ signs.get(j).getLocalName() + ")";
							totalSigns.add(sign);
						}
					}
				}
			}
		}
		rule += " -> (?i ont:hasNegSign ont:" + dob.getName()
				+ "_NOT_SIGNS) ]\n";
		return rule;
	}

	/**
	 * Método para generar la regla para los disorders que no pertenezcan a la
	 * enfermedad.
	 * 
	 * @param totalSigns
	 *            Recibe los signos que se llevan procesando en las reglas NOT
	 *            REST
	 * @return Devuelve una cadena
	 */
	private String createRuleNotRestDisorders(LinkedList<String> totalSigns) {
		String rule = "";
		rule += "[rule_" + dob.getName() + "_NOT_REST_DISORDERS:\n";
		rule += "(?i ont:has_disorder ?x)";
		/*
		 * Primero, los disorders "solos" (sin signos asociados). Ejemplo:
		 * Estamos en la enfermedad "Laringitis", que sabemos que tiene una
		 * serie de "disorders" que no tienen signos asociados, como por ejemplo
		 * "Aphonia", "Nasal Discharge", .. Aquí estamos poniendo esos
		 * disorders.
		 */
		if ((dob.getDisorders() != null) && (dob.getDisorders().size() > 0)) {
			for (int i = 0; i < dob.getDisorders().size(); i++) {
				OntResource dio = dob.getDisorders().get(i);
				String sign = dio.getLocalName();
				if (!totalSigns.contains(sign)) {
					rule += " notEqual(?x, disont:" + dio.getLocalName() + ")";
					totalSigns.add(sign);
				}

			}
		}
		/*
		 * A continuación, los que tienen signos asociados. En el mismo caso,
		 * sabemos que la Laringitis tiene un disorder asociado que tiene sus
		 * propios signos (La Faringitis), pero algunos de esos signos aparecen
		 * en realidad como disorders (por ejemplo: Linfadenopatía). Aquí ahora
		 * ponemos esos.
		 */
		if ((dob.getDisordersWithSigns() != null)
				&& (dob.getDisordersWithSigns().size() > 0)) {
			for (int i = 0; i < dob.getDisordersWithSigns().size(); i++) {
				DiseaseObjectRuleGenerator dio = dob.getDisordersWithSigns()
						.get(i);
				if (dio.getDisorders().size() > 0) {
					/*
					 * Aquí no ponemos primitiva para excluir al disorder que
					 * tiene signos (es decir, faringitis) porque ya la hemos
					 * puesto antes.
					 */
					LinkedList<OntResource> disorders = dio.getDisorders();
					for (int j = 0; j < disorders.size(); j++) {
						String sign = disorders.get(j).getLocalName();
						if (!totalSigns.contains(sign)) {
							rule += " notEqual(?x, disont:"
									+ disorders.get(j).getLocalName() + ")";
							totalSigns.add(sign);
						}
					}
				}
			}
		}
		rule += " -> (?i ont:hasNegDisorder ont:" + dob.getName()
				+ "_NOT_DISORDERS) ]\n";
		return rule;
	}

	/**
	 * Método para escribir.
	 */
	public void write() {
		try {
			File f = new File(ConfigManager.getConfig(Constants.RULES_FOLDER) + this.idKB + "/" + dob.getName() + ".rules");
			BufferedWriter bW = new BufferedWriter(new FileWriter(f));
			bW.write(this.finalRule);
			bW.newLine();
			bW.close();
			System.out.println("File written: " + f.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
