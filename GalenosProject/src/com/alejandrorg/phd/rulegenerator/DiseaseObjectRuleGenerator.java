package com.alejandrorg.phd.rulegenerator;
import java.util.LinkedList;

import com.hp.hpl.jena.ontology.OntResource;

public class DiseaseObjectRuleGenerator {

	private OntResource or;
	private LinkedList<OntResource> signs;
	private LinkedList<OntResource> disorders;
	private LinkedList<OntResource> dts;
	private LinkedList<DiseaseObjectRuleGenerator> disordersWithSigns;

	/**
	 * Método para establecer el OntResource de la enfermedad.
	 * 
	 * @param ds
	 *            Recibe el objeto.
	 */
	public void setOntResource(OntResource ds) {
		this.or = ds;
	}

	/**
	 * Método para obtener el OntResource de la enfermedad.
	 * 
	 * @return Devuelve el objeto.
	 */
	public OntResource getOntResource() {
		return this.or;
	}

	/**
	 * Método para establecer los signos
	 * 
	 * @param s
	 *            Recibe los recursos de la enfermedad.
	 */
	public void setSigns(LinkedList<OntResource> s) {
		this.signs = s;
	}

	/**
	 * Método para obtener los signos.
	 * 
	 * @return Devuelve la lista.
	 */
	public LinkedList<OntResource> getSigns() {
		return this.signs;
	}

	/**
	 * Método para establecer los disorders. Aquí se pasan como parámetro
	 * aquellos disorders que no tienen signos asociados (y que en realidad
	 * actuarían como un mero signo), pero que necesitamos clasificar aquí
	 * debido a que es un "disorder" (has_disorder)
	 * 
	 * @param dodisorders
	 *            Recibe la lista.
	 */
	public void setDisorders(LinkedList<OntResource> dodisorders) {
		this.disorders = dodisorders;
	}

	/**
	 * Método para obtener los disorders.
	 * 
	 * @return Devuelve la lista
	 */
	public LinkedList<OntResource> getDisorders() {
		return this.disorders;
	}

	/**
	 * Método para establecer las pruebas diagnósticas.
	 * 
	 * @param d
	 *            Recibe la lista.
	 */
	public void setDts(LinkedList<OntResource> d) {
		this.dts = d;
	}

	/**
	 * Método para obtener las pruebas diagnósticas.
	 * 
	 * @return Devuelve la lista.
	 */
	public LinkedList<OntResource> getDts() {
		return this.dts;
	}

	/**
	 * Método para obtener el nombre.
	 * 
	 * @return Devuelve el nombre.
	 */
	public String getName() {
		return this.or.getLocalName();
	}

	/**
	 * Método para establecer los recursos de tipo disorder que tienen signos
	 * asociados.
	 * 
	 * @param dws
	 *            Recibe la lista.
	 */
	public void setDisordersWithSigns(LinkedList<DiseaseObjectRuleGenerator> dws) {
		this.disordersWithSigns = dws;
	}

	/**
	 * Método para obtener los disorders con signos.
	 * 
	 * @return Devuelve la lista.
	 */
	public LinkedList<DiseaseObjectRuleGenerator> getDisordersWithSigns() {
		return this.disordersWithSigns;
	}
}
