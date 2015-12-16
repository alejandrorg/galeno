package com.alejandrorg.phd.populator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.LinkedList;

import com.alejandrorg.phd.others.ConfigManager;
import com.alejandrorg.phd.others.Constants;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class PopulateSigns {

	private String diseasesOntologyFile;
	private String diseasesOntologyURI;
	private String diseasesOntologyMainClass;

	private String signsOntologyFile;
	private String signsOntologyURI;
	private String signsOntologyInstances;
	private String signsOntologyMainClass;

	private OntModel modelSigns = ModelFactory.createOntologyModel();
	private OntModel modelDiseases = ModelFactory.createOntologyModel();

	/**
	 * Constructor.
	 * 
	 * @param fileOnt
	 *            Fichero ontología.
	 * @param fileInsts
	 *            Fichero instancias.
	 * @param ontologyURI
	 *            URI ontología.
	 * @param cl
	 *            Clase donde almacenar instancias.
	 * @throws Exception
	 *             Puede lanzar excepción.
	 */
	public PopulateSigns() throws Exception {
		diseasesOntologyFile = ConfigManager.getConfig(Constants.ONT_FOLDER)
				+ ConfigManager.getConfig(Constants.FILE_ONT_DISEASES);
		diseasesOntologyURI = ConfigManager.getConfig(Constants.URI_HOST)
				+ ConfigManager.getConfig(Constants.FILE_ONT_DISEASES);
		diseasesOntologyMainClass = ConfigManager
				.getConfig(Constants.DISEASE_ONTOLOGY_MAIN_CLASS);

		signsOntologyFile = ConfigManager.getConfig(Constants.ONT_FOLDER)
				+ ConfigManager.getConfig(Constants.FILE_ONT_SIGNS);
		signsOntologyURI = ConfigManager.getConfig(Constants.URI_HOST)
				+ ConfigManager.getConfig(Constants.FILE_ONT_SIGNS);
		signsOntologyInstances = ConfigManager.getConfig(Constants.DATA_FOLDER)
				+ ConfigManager.getConfig(Constants.SIGNS_DATA_FILE);
		signsOntologyMainClass = ConfigManager
				.getConfig(Constants.SIGNS_ONTOLOGY_MAIN_CLASS);
	}

	/**
	 * Método para leer instancias.
	 * 
	 * @param s
	 *            Recibe el fichero.
	 * @return Devuelve una lista con las instancias.
	 * @throws Exception
	 *             Puede lanzar excepción.
	 */
	private LinkedList<String> readInstances(String s) throws Exception {
		LinkedList<String> ret = new LinkedList<String>();
		BufferedReader bL = new BufferedReader(new FileReader(s));
		while (bL.ready()) {
			String r = bL.readLine().trim();
			ret.add(ConfigManager.getConfig(Constants.INSTANCE_IDENTIFIER) + r);
		}
		bL.close();
		return ret;
	}

	public StringBuffer execute() throws Exception {
		StringBuffer ret = new StringBuffer();
		ret.append("Populating signs..\n");
		modelSigns.read(new File(signsOntologyFile).toURI().toString());
		modelDiseases.read(new File(diseasesOntologyFile).toURI().toString());
		LinkedList<String> instances = readInstances(signsOntologyInstances);
		OntClass signsClass = modelSigns.getOntClass(signsOntologyURI
				+ Constants.NUMBER_SIGN + signsOntologyMainClass);
		OntClass disClass = modelDiseases.getOntClass(diseasesOntologyURI
				+ Constants.NUMBER_SIGN + diseasesOntologyMainClass);
		for (int i = 0; i < instances.size(); i++) {
			String inst = instances.get(i);
			inst = inst.substring(1, inst.length());
			OntClass oc = modelSigns.getOntClass(signsOntologyURI
					+ Constants.NUMBER_SIGN + inst);
			if (oc != null) {
				ret.append("Creating instance (SO): " + instances.get(i) + "\n");
				modelSigns
						.createIndividual(
								signsOntologyURI
										+ Constants.NUMBER_SIGN
										+ ConfigManager
												.getConfig(Constants.INSTANCE_IDENTIFIER)
										+ inst, signsClass);
			} else {
				OntClass od = modelDiseases.getOntClass(diseasesOntologyURI
						+ Constants.NUMBER_SIGN + inst);
				if (od != null) {
					ret.append("Creating instance (DO): " + instances.get(i)
							+ "\n");
					modelDiseases
							.createIndividual(
									diseasesOntologyURI
											+ Constants.NUMBER_SIGN
											+ ConfigManager
													.getConfig(Constants.INSTANCE_IDENTIFIER)
											+ inst, disClass);
				} else {
					ret.append("[ERROR] Impossible to classify (not SO, not DO): "
							+ instances.get(i) + "\n");
				}
			}
		}

		modelSigns.write(new FileOutputStream(signsOntologyFile), "RDF/XML");
		modelDiseases.write(new FileOutputStream(diseasesOntologyFile),
				"RDF/XML");
		ret.append("Population finished\n");
		return ret;
	}
}