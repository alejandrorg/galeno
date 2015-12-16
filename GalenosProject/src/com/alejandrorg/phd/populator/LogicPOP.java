package com.alejandrorg.phd.populator;

import com.alejandrorg.phd.others.ConfigManager;
import com.alejandrorg.phd.others.Constants;

/**
 * La llamada a la clase:
 * 
 * Populate: Genera las instancias. PopulateONT: Genera las relaciones y las
 * reglas.
 * 
 * @author Alejandro Rodríguez González
 * 
 */

public class LogicPOP {

	private String diseasesOntologyFile;
	private String diseasesOntologyURI;
	private String diseasesOntologyInstances;
	private String diseasesOntologyMainClass;

	private String signsOntologyFile;
	private String signsOntologyURI;
	private String signsOntologyInstances;
	private String signsOntologyMainClass;

	private String dtOntologyFile;
	private String dtOntologyURI;
	private String dtOntologyInstances;
	private String dtOntologyMainClass;

	private String drugsOntologyFile;
	private String drugsOntologyURI;
	private String drugsOntologyInstances;
	private String drugsOntologyMainClass;

	private String ddxOntologyFile;
	private String ddxOntologyURI;

	public LogicPOP() throws Exception {
		loadConfig();
	}

	public void execute() throws Exception {
		/**
		 * Para poblar la ontología:
		 * 
		 * Ejecutar clean y createInstances primero.
		 * 
		 * Copiar las ontologías a la web donde apunte el URI.
		 * 
		 * Ejecutar create relations.
		 * 
		 * Copiar ontologías de nuevo a la web.
		 */

		boolean cleanAndCreateInstances = false;
		if (cleanAndCreateInstances) {
			clean();
			createInstances();
		} else {
			createRelations();
		}
	}

	private void loadConfig() throws Exception {
		diseasesOntologyFile = ConfigManager.getConfig(Constants.ONT_FOLDER)
				+ ConfigManager.getConfig(Constants.FILE_ONT_DISEASES);
		diseasesOntologyURI = ConfigManager.getConfig(Constants.URI_HOST)
				+ ConfigManager.getConfig(Constants.FILE_ONT_DISEASES);
		diseasesOntologyInstances = ConfigManager
				.getConfig(Constants.DATA_FOLDER)
				+ ConfigManager.getConfig(Constants.DISEASES_DATA_FILE);
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

		dtOntologyFile = ConfigManager.getConfig(Constants.ONT_FOLDER)
				+ ConfigManager.getConfig(Constants.FILE_ONT_DTS);
		dtOntologyURI = ConfigManager.getConfig(Constants.URI_HOST)
				+ ConfigManager.getConfig(Constants.FILE_ONT_DTS);
		dtOntologyInstances = ConfigManager.getConfig(Constants.DATA_FOLDER)
				+ ConfigManager.getConfig(Constants.DTS_DATA_FILE);
		dtOntologyMainClass = ConfigManager
				.getConfig(Constants.DTS_ONTOLOGY_MAIN_CLASS);

		drugsOntologyFile = ConfigManager.getConfig(Constants.ONT_FOLDER)
				+ ConfigManager.getConfig(Constants.FILE_ONT_DRUGS);
		drugsOntologyURI = ConfigManager.getConfig(Constants.URI_HOST)
				+ ConfigManager.getConfig(Constants.FILE_ONT_DRUGS);
		drugsOntologyInstances = ConfigManager.getConfig(Constants.DATA_FOLDER)
				+ ConfigManager.getConfig(Constants.DRUGS_DATA_FILE);
		drugsOntologyMainClass = ConfigManager
				.getConfig(Constants.DRUGS_ONTOLOGY_MAIN_CLASS);

		ddxOntologyFile = ConfigManager.getConfig(Constants.ONT_FOLDER)
				+ ConfigManager.getConfig(Constants.FILE_ONT_DDX);
		ddxOntologyURI = ConfigManager.getConfig(Constants.URI_HOST)
				+ ConfigManager.getConfig(Constants.FILE_ONT_DDX);
	}

	public void createRelations() throws Exception {
		new CreateRelations(ddxOntologyFile, ddxOntologyURI,
				diseasesOntologyURI, signsOntologyURI, dtOntologyURI,
				drugsOntologyURI).execute();
	}

	public void createInstances() throws Exception {
		new Populate(new java.io.File(diseasesOntologyFile),
				diseasesOntologyInstances, diseasesOntologyURI,
				diseasesOntologyMainClass).execute();
		new PopulateSigns().execute();
		new Populate(new java.io.File(dtOntologyFile), dtOntologyInstances,
				dtOntologyURI, dtOntologyMainClass).execute();
		new Populate(new java.io.File(drugsOntologyFile),
				drugsOntologyInstances, drugsOntologyURI,
				drugsOntologyMainClass).execute();
	}

	public void clean() throws Exception {
		new Clean(new java.io.File(diseasesOntologyFile),
				diseasesOntologyInstances, diseasesOntologyURI,
				diseasesOntologyMainClass).execute();
		new Clean(new java.io.File(signsOntologyFile), signsOntologyInstances,
				signsOntologyURI, signsOntologyMainClass).execute();
		new Clean(new java.io.File(dtOntologyFile), dtOntologyInstances,
				dtOntologyURI, dtOntologyMainClass).execute();
		new Clean(new java.io.File(drugsOntologyFile), drugsOntologyInstances,
				drugsOntologyURI, drugsOntologyMainClass).execute();
		new Populate(new java.io.File(ddxOntologyFile)).removeAllInstances();
	}

}
