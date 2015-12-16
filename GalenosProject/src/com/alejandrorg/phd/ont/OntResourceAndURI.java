package com.alejandrorg.phd.ont;

import com.hp.hpl.jena.ontology.OntResource;

public class OntResourceAndURI {

	private OntResource ontres;
	private String uri;

	public OntResourceAndURI(OntResource or, String u) {
		this.ontres = or;
		this.uri = u;
	}

	public OntResource getOntResource() {
		return this.ontres;
	}

	public String getURI() {
		return this.uri;
	}

}
