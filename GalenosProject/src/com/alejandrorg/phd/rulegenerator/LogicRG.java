package com.alejandrorg.phd.rulegenerator;

import java.io.File;
import java.util.LinkedList;

import com.alejandrorg.phd.others.ConfigManager;
import com.alejandrorg.phd.others.Constants;
import com.alejandrorg.phd.others.StaticUtils;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntResource;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

public class LogicRG {

	private OntModel model;

	private ObjectProperty has_sign;
	private ObjectProperty has_disorder;
	private ObjectProperty has_diagnostic_test;

	private String diseasesOntologyURI;

	private String ddxOntologyFile;
	private String ddxOntologyURI;

	private String diseasesClass;

	private String idKB;

	public LogicRG(String id) throws Exception {
		this.idKB = id;
		init();
	}

	private void init() throws Exception {
		diseasesOntologyURI = ConfigManager.getConfig(Constants.URI_HOST)
				+ this.idKB + "/"
				+ ConfigManager.getConfig(Constants.FILE_ONT_DISEASES);
		ddxOntologyURI = ConfigManager.getConfig(Constants.URI_HOST)
				+ this.idKB + "/"
				+ ConfigManager.getConfig(Constants.FILE_ONT_DDX);
		ddxOntologyFile = ConfigManager.getConfig(Constants.ONT_FOLDER)
				+ this.idKB + "/"
				+ ConfigManager.getConfig(Constants.FILE_ONT_DDX);
		diseasesClass = Constants.NUMBER_SIGN
				+ ConfigManager
						.getConfig(Constants.DISEASE_ONTOLOGY_MAIN_CLASS);
	}

	public void cleanRules() throws Exception {
		StaticUtils.log("Deleting rules..");
		File rulesFolder = new File(
				ConfigManager.getConfig(Constants.RULES_FOLDER) + this.idKB
						+ "/");
		File rules[] = rulesFolder.listFiles();
		for (int i = 0; i < rules.length; i++) {
			rules[i].delete();
		}
		StaticUtils.log(" Done\n");
	}

	/**
	 * M�todo para crear las reglas
	 */
	public void createRules() throws Exception {
		StaticUtils.log("Creating rules..\n");
		model = ModelFactory.createOntologyModel();
		model.read(new File(ddxOntologyFile).toURI().toString());
		this.has_sign = model.getOntResource(
				ddxOntologyURI + Constants.NUMBER_SIGN
						+ ConfigManager.getConfig(Constants.HAS_SIGN_PROPERTY))
				.asObjectProperty();
		this.has_disorder = model.getOntResource(
				ddxOntologyURI
						+ Constants.NUMBER_SIGN
						+ ConfigManager
								.getConfig(Constants.HAS_DISORDER_PROPERTY))
				.asObjectProperty();
		this.has_diagnostic_test = model
				.getOntResource(
						ddxOntologyURI
								+ Constants.NUMBER_SIGN
								+ ConfigManager
										.getConfig(Constants.HAS_DIAGNOSTIC_TEST_PROPERTY))
				.asObjectProperty();
		/*
		 * Obtenemos las enfermedades de la ontolog�a.
		 */
		LinkedList<OntResource> dss = getIndividualsFromClass(diseasesOntologyURI
				+ diseasesClass);
		LinkedList<DiseaseObjectRuleGenerator> diseases = new LinkedList<DiseaseObjectRuleGenerator>();
		/*
		 * Cogemos aquellas que tienen signos (o disorders asociados):
		 * addDiseaseIfHasSigns
		 */
		for (int i = 0; i < dss.size(); i++) {
			addDiseaseIfHasSigns(dss.get(i), diseases);
		}
		/*
		 * Creamos las reglas.
		 */
		for (int i = 0; i < diseases.size(); i++) {
			RuleWriter rw = new RuleWriter(diseases.get(i), idKB);
			rw.write();
		}
	}

	/**
	 * M�todo para a�adir una enfermedad a la lista si es una enfermedad de la
	 * que se vaya a generar regla (tiene s�ntomas o signos asociados).
	 * 
	 * @param ds
	 *            Recibe la enfermedad.
	 * @param diseases
	 *            Recibe la lista.
	 * @param ret
	 */
	private void addDiseaseIfHasSigns(OntResource ds,
			LinkedList<DiseaseObjectRuleGenerator> diseases) {

		/*
		 * Signos, disorders y pruebas
		 */
		LinkedList<OntResource> signs = new LinkedList<OntResource>();
		LinkedList<OntResource> disorders = new LinkedList<OntResource>();
		LinkedList<OntResource> dts = new LinkedList<OntResource>();

		String str_signs = "";
		String str_disorders = "";
		/*
		 * Cogemos los signos asociados a la enfermedad actual
		 */
		NodeIterator it = ds.listPropertyValues(this.has_sign);
		while (it.hasNext()) {
			RDFNode rn = it.next();
			OntResource or = model.getOntResource(rn.asResource());
			signs.add(or);
			str_signs += "\t- " + or.getLocalName() + "\n";
		}
		/*
		 * Cogemos los disorders asociados a la enfermedad (todos)
		 */
		it = ds.listPropertyValues(this.has_disorder);
		while (it.hasNext()) {
			RDFNode rn = it.next();
			OntResource or = model.getOntResource(rn.asResource());
			disorders.add(or);
			str_disorders += "\t- " + or.getLocalName() + "\n";
		}
		/*
		 * Cogemos las pruebas de diagn�stico asociadas a la enfermedad
		 */
		it = ds.listPropertyValues(this.has_diagnostic_test);
		while (it.hasNext()) {
			RDFNode rn = it.next();
			OntResource or = model.getOntResource(rn.asResource());
			dts.add(or);
		}

		if (signs.size() > 0 || disorders.size() > 0) {
			/*
			 * Si la enfermedad tiene signos o disorders..
			 */
			/*
			 * Creamos el objeto que representa la enfermedad
			 */
			DiseaseObjectRuleGenerator d = new DiseaseObjectRuleGenerator();
			/*
			 * Establecemos los signos
			 */
			d.setSigns(signs);
			/*
			 * Creamos la lista de objetos disorder que tienen signos asociados.
			 * 
			 * Ha de ser de tipo "DiseaseObject" para poder establecer sus
			 * respectivos signos y disorders asociados.
			 */
			LinkedList<DiseaseObjectRuleGenerator> disordersWithSigns = new LinkedList<DiseaseObjectRuleGenerator>();
			/*
			 * Recorremos la lista de disorders existentes para la enfermedad
			 */
			LinkedList<OntResource> finalDisorders = new LinkedList<OntResource>();
			for (int i = 0; i < disorders.size(); i++) {
				/*
				 * Comprobamos si ese disorder tiene signos
				 */
				if (disorderHasSigns(disorders.get(i))) {
					/*
					 * Si tiene signos, creamos un "Disease object" a partir del
					 * disorder (porque un disorder se compone de signos y
					 * disorders) De aqu�, nos interesar� el
					 * "getSigns() y el getDisorders()"
					 */
					DiseaseObjectRuleGenerator doz = createDiseaseObjectFromDisorder(disorders
							.get(i));
					StaticUtils.log("\t\t Signs?: " + doz.getSigns() + "\n");
					StaticUtils.log("\t\t Disorders?: " + doz.getDisorders()
							+ "\n");
					disordersWithSigns.add(doz);
				} else {
					/*
					 * Si no tiene signos asociados es uno de los "normales".
					 */
					finalDisorders.add(disorders.get(i));
				}
			}
			/*
			 * Al final establecemos los disorders, dts y signos, as� como el
			 * "ont resource" asociado e imprimimos la informaci�n
			 */
			d.setDisordersWithSigns(disordersWithSigns);
			d.setDisorders(finalDisorders);
			d.setDts(dts);
			d.setOntResource(ds);
			diseases.add(d);
			StaticUtils.log(ds.getLocalName() + "\n");
			StaticUtils.log("Signs:\n\n" + str_signs + "\n");
			StaticUtils.log("Disorders:\n\n" + str_disorders + "\n");
		}
	}

	/**
	 * M�todo para generar el DiseaseObject a partir del disorder
	 * 
	 * @param d
	 *            Recibe el disorder.
	 * @return Devuelve el valor.
	 */
	private DiseaseObjectRuleGenerator createDiseaseObjectFromDisorder(
			OntResource d) {
		/*
		 * Creamos el objeto
		 */
		DiseaseObjectRuleGenerator dob = new DiseaseObjectRuleGenerator();
		/*
		 * Creamos los signos y los disorders (tipo OntResource)
		 */
		LinkedList<OntResource> signs = new LinkedList<OntResource>();
		LinkedList<OntResource> disorders = new LinkedList<OntResource>();
		/*
		 * Obtenemos los signos y los introducimos
		 */
		NodeIterator it = d.listPropertyValues(this.has_sign);
		while (it.hasNext()) {
			RDFNode rn = it.next();
			OntResource or = model.getOntResource(rn.asResource());
			signs.add(or);
		}
		/*
		 * Obtenemos los disorders y los introducimos
		 */
		it = d.listPropertyValues(this.has_disorder);
		while (it.hasNext()) {
			RDFNode rn = it.next();
			OntResource or = model.getOntResource(rn.asResource());
			disorders.add(or);
		}
		/*
		 * Lo establecemos todo
		 */
		dob.setOntResource(d);
		dob.setSigns(signs);
		dob.setDisorders(disorders);
		return dob;
	}

	/**
	 * M�todo para saber si un disorder tiene signos asociados.
	 * 
	 * @param d
	 *            Recibe el disorder.
	 * @return Devuelve un booleano.
	 */
	private boolean disorderHasSigns(OntResource d) {
		int signs = 0;
		NodeIterator it = d.listPropertyValues(this.has_sign);
		while (it.hasNext()) {
			it.next();
			signs++;
		}
		int disorders = 0;
		it = d.listPropertyValues(this.has_disorder);
		while (it.hasNext()) {
			it.next();
			disorders++;
		}
		return ((signs > 0) || (disorders > 0));
	}

	/**
	 * M�todo para obtener las instancias de una determinada clase.
	 * 
	 * @param cl
	 *            Recibe la clase.
	 * @return Devuelve las instancias.
	 */
	private LinkedList<OntResource> getIndividualsFromClass(String cl) {
		LinkedList<OntResource> ret = new LinkedList<OntResource>();
		OntClass cls = model.getOntClass(cl);
		ExtendedIterator<?> dss = cls.listInstances();
		while (dss.hasNext()) {
			OntResource ds = (OntResource) dss.next();
			ret.add(ds);
		}
		return ret;
	}
}
