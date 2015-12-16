package com.alejandrorg.phd.populator;
import java.util.LinkedList;

import com.hp.hpl.jena.ontology.OntResource;

public class DiseaseObject {

	private OntResource or;
	private LinkedList<OntResource> signs;
	private LinkedList<OntResource> disorders;
	private LinkedList<OntResource> dts;
	private boolean representsDisorderSign = false;
	private LinkedList<DiseaseObject> signsDiseases;

	public boolean isRepresentingDisorder() {
		return this.representsDisorderSign;
	}

	public void setRepresentsDisorderSign(boolean b) {
		this.representsDisorderSign = b;
	}

	public void setOntResource(OntResource ds) {
		this.or = ds;
	}

	public OntResource getOntResource() {
		return this.or;
	}

	public void setSigns(LinkedList<OntResource> dosigns) {
		this.signs = dosigns;
	}

	public LinkedList<OntResource> getSigns() {
		return this.signs;
	}

	public void setDisorders(LinkedList<OntResource> dodisorders) {
		this.disorders = dodisorders;
	}

	public LinkedList<OntResource> getDisorders() {
		return this.disorders;
	}

	public void setDts(LinkedList<OntResource> dts2) {
		this.dts = dts2;
	}

	public LinkedList<OntResource> getDts() {
		return this.dts;
	}

	public String getName() {
		return this.or.getLocalName();
	}

	public void setSignsDiseases(LinkedList<DiseaseObject> dos) {
		this.signsDiseases = dos;
	}

	public LinkedList<DiseaseObject> getSignsDiseases() {
		return this.signsDiseases;
	}

}
