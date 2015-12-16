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
	 * M�todo para establecer el OntResource de la enfermedad.
	 * 
	 * @param ds
	 *            Recibe el objeto.
	 */
	public void setOntResource(OntResource ds) {
		this.or = ds;
	}

	/**
	 * M�todo para obtener el OntResource de la enfermedad.
	 * 
	 * @return Devuelve el objeto.
	 */
	public OntResource getOntResource() {
		return this.or;
	}

	/**
	 * M�todo para establecer los signos
	 * 
	 * @param s
	 *            Recibe los recursos de la enfermedad.
	 */
	public void setSigns(LinkedList<OntResource> s) {
		this.signs = s;
	}

	/**
	 * M�todo para obtener los signos.
	 * 
	 * @return Devuelve la lista.
	 */
	public LinkedList<OntResource> getSigns() {
		return this.signs;
	}

	/**
	 * M�todo para establecer los disorders. Aqu� se pasan como par�metro
	 * aquellos disorders que no tienen signos asociados (y que en realidad
	 * actuar�an como un mero signo), pero que necesitamos clasificar aqu�
	 * debido a que es un "disorder" (has_disorder)
	 * 
	 * @param dodisorders
	 *            Recibe la lista.
	 */
	public void setDisorders(LinkedList<OntResource> dodisorders) {
		this.disorders = dodisorders;
	}

	/**
	 * M�todo para obtener los disorders.
	 * 
	 * @return Devuelve la lista
	 */
	public LinkedList<OntResource> getDisorders() {
		return this.disorders;
	}

	/**
	 * M�todo para establecer las pruebas diagn�sticas.
	 * 
	 * @param d
	 *            Recibe la lista.
	 */
	public void setDts(LinkedList<OntResource> d) {
		this.dts = d;
	}

	/**
	 * M�todo para obtener las pruebas diagn�sticas.
	 * 
	 * @return Devuelve la lista.
	 */
	public LinkedList<OntResource> getDts() {
		return this.dts;
	}

	/**
	 * M�todo para obtener el nombre.
	 * 
	 * @return Devuelve el nombre.
	 */
	public String getName() {
		return this.or.getLocalName();
	}

	/**
	 * M�todo para establecer los recursos de tipo disorder que tienen signos
	 * asociados.
	 * 
	 * @param dws
	 *            Recibe la lista.
	 */
	public void setDisordersWithSigns(LinkedList<DiseaseObjectRuleGenerator> dws) {
		this.disordersWithSigns = dws;
	}

	/**
	 * M�todo para obtener los disorders con signos.
	 * 
	 * @return Devuelve la lista.
	 */
	public LinkedList<DiseaseObjectRuleGenerator> getDisordersWithSigns() {
		return this.disordersWithSigns;
	}
}
