package com.alejandrorg.phd.populator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.LinkedList;

import com.alejandrorg.phd.others.ConfigManager;
import com.alejandrorg.phd.others.Constants;
import com.alejandrorg.phd.others.StaticUtils;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

public class Populate {

	private OntModel model = ModelFactory.createOntologyModel();
	private File fileOnt;
	private String fileInsts;
	private String ontologyURI;
	private String classToExecute;

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
	public Populate(File fileOnt, String fileInsts, String ontologyURI,
			String cl) throws Exception {
		this.fileOnt = fileOnt;
		this.fileInsts = fileInsts;
		this.ontologyURI = ontologyURI;
		this.classToExecute = cl;
	}

	/**
	 * Constructor.
	 * 
	 * @param fileOnt
	 *            Recibe fichero ontología.
	 * @throws Exception
	 *             Puede lanzar excepción.
	 */
	public Populate(File fileOnt) throws Exception {
		this.fileOnt = fileOnt;
		model.read(fileOnt.toURI().toString());
	}

	/**
	 * Método para borrar todas las instancias.
	 */
	public void removeAllInstances() throws Exception {
		StaticUtils.log("Deleting relations..\n");
		LinkedList<Individual> inds = new LinkedList<Individual>();
		ExtendedIterator<?> insts = model.listIndividuals();
		while (insts.hasNext()) {
			Individual inst = (Individual) insts.next();
			inds.add(inst);
		}
		for (int i = 0; i < inds.size(); i++) {
			StaticUtils.log("Removing relation of instance " + inds.get(i));
			inds.get(i).removeProperties();
		}
		model.write(new FileOutputStream(fileOnt), "RDF/XML");
		StaticUtils.log("Relations deleted\n");
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

	public void execute() throws Exception {
		
		StaticUtils.log("Populating.. " + fileOnt + "\n");
		model.read(fileOnt.toURI().toString());
		LinkedList<String> instances = readInstances(fileInsts);
		OntClass oc = model.getOntClass(ontologyURI + Constants.NUMBER_SIGN
				+ classToExecute);
		for (int i = 0; i < instances.size(); i++) {
			StaticUtils.log("Creating instance: " + instances.get(i) + "\n");
			model.createIndividual(ontologyURI + Constants.NUMBER_SIGN
					+ instances.get(i), oc);
		}
		model.write(new FileOutputStream(fileOnt), "RDF/XML");
		StaticUtils.log("Population finished\n");
	}
}