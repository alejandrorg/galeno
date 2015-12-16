package com.alejandrorg.phd.populator;

import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedList;

import com.alejandrorg.phd.others.Constants;
import com.alejandrorg.phd.others.StaticUtils;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntResource;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;


public class Clean {

	private OntModel model = ModelFactory.createOntologyModel();
	private File fileOnt;
	private String ontologyURI;
	private String classToRemove;

	/**
	 * Constructor.
	 * @param fileOnt Fichero ontología.
	 * @param fileInsts Fichero instancias.
	 * @param ontologyURI URI ontología.
	 * @param cl Clase donde almacenar instancias.
	 * @throws Exception Puede lanzar excepción.
	 */
	public Clean(File fileOnt, String fileInsts, String ontologyURI,
			String cl) throws Exception {
		this.fileOnt = fileOnt;
		this.ontologyURI = ontologyURI;
		this.classToRemove = cl;
	}

	/**
	 * Método para borrar las instancias de una clase.
	 * 
	 * @param oc
	 *            Recibe la clase.
	 */
	private void removeInstances(OntClass oc) {
		ExtendedIterator<?> insts = oc.listInstances();
		LinkedList<OntResource> inds = new LinkedList<OntResource>();
		while (insts.hasNext()) {
			OntResource inst = (OntResource) insts.next();
			inds.add(inst);
		}
		for (int i = 0; i < inds.size(); i++) {
			inds.get(i).remove();
		}
	}
	
	/**
	 * Constructor.
	 * @param fileOnt Recibe fichero ontología.
	 * @throws Exception Puede lanzar excepción.
	 */
	public Clean(File fileOnt) throws Exception {
		model.read(fileOnt.toURI().toString());
	}

	public void execute() throws Exception {
		StaticUtils.log("Cleaning.. " + fileOnt + "\n");
		model.read(fileOnt.toURI().toString());
		OntClass oc = model.getOntClass(ontologyURI + Constants.NUMBER_SIGN + classToRemove);
		removeInstances(oc);
		model.write(new FileOutputStream(fileOnt), "RDF/XML");
		StaticUtils.log("Clean Finished\n");
	}
	
	
}
