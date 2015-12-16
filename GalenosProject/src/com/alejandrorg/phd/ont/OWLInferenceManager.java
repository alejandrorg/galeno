package com.alejandrorg.phd.ont;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;

import com.alejandrorg.phd.exceptions.NoRulesFoundException;
import com.alejandrorg.phd.io.RulesReader;
import com.alejandrorg.phd.mdss.Consult;
import com.alejandrorg.phd.mdss.DiagnosisResult;
import com.alejandrorg.phd.others.ConfigManager;
import com.alejandrorg.phd.others.Constants;
//import com.alejandrorg.phd.others.MemoryTest;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntResource;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.reasoner.Derivation;
import com.hp.hpl.jena.reasoner.Reasoner;
import com.hp.hpl.jena.reasoner.rulesys.GenericRuleReasoner;
import com.hp.hpl.jena.reasoner.rulesys.Rule;

public class OWLInferenceManager {

	private InfModel inferenceModel;
	private Reasoner reasoner;
	private String ontologyURI;
	private OntModel model;
	private String mainOnt;

	private ObjectProperty has_sign;
	private ObjectProperty has_disorder;
	private ObjectProperty has_diagnostic_test;
	@SuppressWarnings("unused")
	private ObjectProperty can_occurr_with;
	private ObjectProperty possible_adverse_effect;

	private String idKB;
	private String ddxontURI;
	private String diseasesURI;
	private String signsURI;
	private String dtoURI;
	private String drugsURI;

	private String instanceIdentifier;

	private boolean explanation;

	private void loadConfig() throws Exception {
		mainOnt = ConfigManager.getConfig(Constants.ONT_FOLDER) + this.idKB
				+ "/" + ConfigManager.getConfig(Constants.MAIN_ONT_FILE);
		ddxontURI = ConfigManager.getConfig(Constants.URI_HOST) + this.idKB
				+ "/" + ConfigManager.getConfig(Constants.FILE_ONT_DDX)
				+ Constants.NUMBER_SIGN;
		diseasesURI = ConfigManager.getConfig(Constants.URI_HOST) + this.idKB
				+ "/" + ConfigManager.getConfig(Constants.FILE_ONT_DISEASES)
				+ Constants.NUMBER_SIGN;
		signsURI = ConfigManager.getConfig(Constants.URI_HOST) + this.idKB
				+ "/" + ConfigManager.getConfig(Constants.FILE_ONT_SIGNS)
				+ Constants.NUMBER_SIGN;
		dtoURI = ConfigManager.getConfig(Constants.URI_HOST) + this.idKB + "/"
				+ ConfigManager.getConfig(Constants.FILE_ONT_DTS)
				+ Constants.NUMBER_SIGN;
		drugsURI = ConfigManager.getConfig(Constants.URI_HOST) + this.idKB
				+ "/" + ConfigManager.getConfig(Constants.FILE_ONT_DRUGS)
				+ Constants.NUMBER_SIGN;
		instanceIdentifier = ConfigManager
				.getConfig(Constants.INSTANCE_IDENTIFIER);
	}

	public OWLInferenceManager(String id) throws Exception {
		this.idKB = id;
		init();
	}

	private void init() throws Exception {
		// MemoryTest.printMemory("Load ontology (start)");
		// long t1 = System.currentTimeMillis();
		loadConfig();
		this.model = ModelFactory.createOntologyModel();
		/**
		 * AQUI CARGAMOS EL FICHERO CON LA BASE DE CONOCIMIENTO
		 */
		this.model.read(new File(mainOnt).toURI().toString());
		/**
		 * 
		 */
		this.ontologyURI = ddxontURI;
		this.has_sign = model.getOntResource(
				ddxontURI
						+ ConfigManager.getConfig(Constants.HAS_SIGN_PROPERTY))
				.asObjectProperty();
		this.has_disorder = model.getOntResource(
				ddxontURI
						+ ConfigManager
								.getConfig(Constants.HAS_DISORDER_PROPERTY))
				.asObjectProperty();
		this.has_diagnostic_test = model
				.getOntResource(
						ddxontURI
								+ ConfigManager
										.getConfig(Constants.HAS_DIAGNOSTIC_TEST_PROPERTY))
				.asObjectProperty();
		this.can_occurr_with = model.getOntResource(
				ddxontURI
						+ ConfigManager
								.getConfig(Constants.CAN_OCCURR_WITH_PROPERTY))
				.asObjectProperty();
		this.possible_adverse_effect = model
				.getOntResource(
						ddxontURI
								+ ConfigManager
										.getConfig(Constants.POSSIBLE_ADVERSE_EFFECT_PROPERTY))
				.asObjectProperty();
		this.loadRules();
		// MemoryTest.printMemory("Load ontology (finish)");
		// long t2 = System.currentTimeMillis();
		// System.out.println("Time (Load ontology): " + (t2 - t1));
	}

	/**
	 * M�todo para cargar las reglas.
	 * 
	 * @throws Exception
	 *             Puede lanzar excepci�n.
	 */
	public void loadRules() throws Exception {
            System.out.println("Loading rules..");
		// MemoryTest.printMemory("Load rules (start)");
		// long t1 = System.currentTimeMillis();
		RulesReader rr = new RulesReader(this.idKB);
		String fr = rr.getRulesFile();
                System.out.println("Rules file: " + fr);
		if (fr == null) {
			throw new NoRulesFoundException();
		} else {
			BufferedReader br = new BufferedReader(new FileReader(fr));
			this.reasoner = new GenericRuleReasoner(Rule.parseRules(Rule
					.rulesParserFromReader(br)));
			this.reasoner.setDerivationLogging(explanation);
			this.inferenceModel = ModelFactory.createInfModel(reasoner,
					this.model);
			this.inferenceModel.prepare();
			// MemoryTest.printMemory("Load rules (finish)");
			// long t2 = System.currentTimeMillis();
			// System.out.println("Time (Load rules): " + (t2 - t1));
		}
	}

	/**
	 * M�todo para crear la consulta.
	 * 
	 * @param c
	 *            Recibe el objeto Consult.
	 * @param dar
	 * @return Devuelve el recurso.
	 */
	public Resource createConsult(DiagnosisResult dr) throws Exception {

		Resource cons = null;
		cons = inferenceModel.createResource(this.ontologyURI
				+ Constants.NUMBER_SIGN + dr.getConsult().getName(),
				this.model.getOntResource(getConsultURI()));

		/**
		 * A�adimos los s�ntomas.
		 */
		for (int i = 0; i < dr.getConsult().getSigns().size(); i++) {
			OntResourceAndURI sign = getInstanceOfSign(dr.getConsult()
					.getSigns().get(i));
			if (sign != null) {
				if (sign.getURI().equalsIgnoreCase(this.signsURI)) {
					cons.addProperty(has_sign, sign.getOntResource());
					dr.appendDebug("has_sign -> "
							+ sign.getOntResource().getLocalName());
				}

				if (sign.getURI().equalsIgnoreCase(this.diseasesURI)) {
					cons.addProperty(has_disorder, sign.getOntResource());
					dr.appendDebug("has_disorder -> "
							+ sign.getOntResource().getLocalName());
				}
			} else {
				System.err.println("Error creating consult with symptom: "
						+ dr.getConsult().getSigns().get(i));
			}
		}

		/**
		 * A�adimos los diagnostic test.
		 */
		for (int i = 0; i < dr.getConsult().getDts().size(); i++) {
			cons.addProperty(has_diagnostic_test, getInstanceOfDT(dr
					.getConsult().getDts().get(i)));
		}

		this.model.add(this.inferenceModel);
		return cons;
	}

	/**
	 * M�todo para ejecutar la inferencia.
	 * 
	 * @param re
	 *            Recibe como par�metro el recurso a ejecutar.
	 * @param c
	 *            Consulta
	 * @param dar
	 * @return Devuelve el resultado.
	 */
	public void executeInference(Resource re, DiagnosisResult dr)
			throws Exception {
		printConsultInfo(dr.getConsult(), dr);
		StmtIterator sti = this.inferenceModel.listStatements(re, null,
				(RDFNode) null);
		LinkedList<String> results = new LinkedList<String>();
		PrintWriter out = new PrintWriter(new FileWriter(
				ConfigManager.getConfig(Constants.EXPLANATIONS_DIR)
						+ dr.getConsult().getName()
						+ ConfigManager
								.getConfig(Constants.EXPLANATIONS_EXTENSION)));
		while (sti.hasNext()) {
			Statement st = (Statement) sti.next();
			if (explanation) {
				for (Iterator<?> id = this.inferenceModel.getDerivation(st); id
						.hasNext();) {
					Derivation deriv = (Derivation) id.next();
					deriv.printTrace(out, false);
				}
			}
			Resource r = st.getResource();
			String res = r.getLocalName();
			if (res != null) {
				if (res.startsWith(instanceIdentifier)
						&& (isNumber(res.charAt(res.length() - 1)))) {
					results.add(res);
				}
			}
		}
		if (explanation) {
			out.flush();
			out.close();
		}
		for (int i = 0; i < dr.getConsult().getSigns().size(); i++) {
			String s = dr.getConsult().getSigns().get(i);
			results.remove(instanceIdentifier + s);
		}
		for (int i = 0; i < dr.getConsult().getDts().size(); i++) {
			String s = dr.getConsult().getDts().get(i);
			results.remove(instanceIdentifier + s);
		}
		for (int i = 0; i < results.size(); i++) {
			String r = results.get(i).substring(1, results.get(i).length());
			OntClass or = this.model.getOntClass(this.diseasesURI + r);
			String rz = or.getLabel(null) + " (" + r + ")";
			dr.addDiagnosisResult(rz);
		}
	}

	/**
	 * M�todo para imprimir informaci�n de la consulta.
	 * 
	 * @param c
	 *            Recibe el objeto.
	 */
	private void printConsultInfo(Consult c, DiagnosisResult dr) {
		dr.appendDebug("\n\nConsult Input:");
		dr.appendDebug("-----------------");
		String ret = "\n";
		ret += "\t[!] Name: " + c.getName() + "\n";
		ret += "\t[!] Input signs [" + c.getSigns().size() + "]\n";
		for (int i = 0; i < c.getSigns().size(); i++) {
			ret += "\t\t[�] " + getInfoOfSign(c.getSigns().get(i)) + "\n";
		}
		ret += "\n";
		ret += "\t[!] Input dts [" + c.getDts().size() + "]\n";
		for (int i = 0; i < c.getDts().size(); i++) {
			ret += "\t\t[�] " + getInfoOfDts(c.getDts().get(i)) + "\n";
		}
		ret += "\n";
		ret += "\t[!] Input drugs [" + c.getDrugs().size() + "]\n";
		for (int i = 0; i < c.getDrugs().size(); i++) {
			ret += "\t\t[�] " + getInfoOfDrug(c.getDrugs().get(i)) + "\n";
		}
		dr.appendDebug(ret);
		dr.appendDebug("-----------------");
		dr.appendDebug("Inference output:\n");
	}

	/**
	 * M�todo para obtener informaci�n de una medicina.
	 * 
	 * @param d
	 *            Reciube la medicina.
	 * @return Devuelve el valor.
	 */
	private String getInfoOfDrug(String d) {
		OntClass or = this.model.getOntClass(this.drugsURI + d);
		String rz = or.getLabel(null) + " (" + d + ")";
		return rz;
	}

	/**
	 * M�todo para obtener informaci�n de un dt.
	 * 
	 * @param s
	 *            Recibe el dt.
	 * @return Devuelve la informaci�n.
	 */
	private String getInfoOfDts(String d) {
		OntClass or = this.model.getOntClass(this.dtoURI + d);
		String rz = or.getLabel(null) + " (" + d + ")";
		return rz;
	}

	/**
	 * M�todo para obtener informaci�n de un signo.
	 * 
	 * @param s
	 *            Recibe el signo.
	 * @return Devuelve la informaci�n.
	 */
	private String getInfoOfSign(String s) {
		String rz = "Not info avalaible about: " + s;
		OntClass or = this.model.getOntClass(this.signsURI + s);
		if (or != null) {
			rz = or.getLabel(null) + " (" + s + ")";
		} else {
			OntClass ord = this.model.getOntClass(this.diseasesURI + s);
			if (ord != null) {
				rz = ord.getLabel(null) + " (" + s + ")";
			}
		}
		return rz;
	}

	/**
	 * M�todo para saber si un car�cter es un n�mero.
	 * 
	 * @param c
	 *            Recibe el car�cter.
	 * @return Devuelve un booleano.
	 */
	private boolean isNumber(char c) {
		try {
			Integer.parseInt(Character.toString(c));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * M�todo para obtener la instancia de un dt determinado.
	 * 
	 * @param d
	 *            DT.
	 * @return Devuelve la instancia
	 */
	private OntResource getInstanceOfDT(String d) {
		OntResource oc = model.getOntResource(this.dtoURI + "I" + d);
		if (oc == null) {
			System.out.println("Error getting ontresource (dt): " + d);
		}
		return oc;
	}

	/**
	 * M�todo para obtener la instancia de un signo determinado.
	 * 
	 * @param s
	 *            Signo.
	 * @return Devuelve la instancia
	 */
	private OntResourceAndURI getInstanceOfSign(String s) {
		OntResourceAndURI orau = null;
		OntResource oc = model.getOntResource(this.signsURI + "I" + s);
		if (oc == null) {
			oc = model.getOntResource(this.diseasesURI + "I" + s);
			if (oc == null) {
				System.err.println("Error getting ontresource (sign): " + s);
			} else {
				orau = new OntResourceAndURI(oc, this.diseasesURI);
			}
		} else {
			orau = new OntResourceAndURI(oc, this.signsURI);
		}
		return orau;
	}

	/**
	 * M�todo para obtener el URI de la clase Consulta.
	 * 
	 * @return Devuelve el valor.
	 */
	private String getConsultURI() throws Exception {
		return this.ddxontURI + ConfigManager.getConfig(Constants.QUERY_CLASS);
	}

	/**
	 * M�todo para obtener el modelo de la ontolog�a.
	 * 
	 * @return Devuelve el modelo.
	 */
	public OntModel getOntModel() {
		return this.model;
	}

	/**
	 * M�todo para obtener una propiedad determinada.
	 * 
	 * @return Devuelve el objeto.
	 */
	public ObjectProperty getPossibleAdverseEffectProperty() {
		return this.possible_adverse_effect;
	}

	/**
	 * M�todo para obtener la URI de los f�rmacos.
	 * 
	 * @return Devuelve el valor.
	 */
	public String getDrugsURI() {
		return this.drugsURI;
	}

	/**
	 * M�todo para obtener la URI de los DTs.
	 * 
	 * @return Devuelve el valor.
	 */
	public String getDTsURI() {
		return this.dtoURI;
	}

	/**
	 * M�todo para obtener la URI de los signos.
	 * 
	 * @return Devuelve el valor.
	 */
	public String getSignsURI() {
		return this.signsURI;
	}

	/**
	 * M�todo para obtener la URI de las enfermedades.
	 * 
	 * @return Devuelve el valor.
	 */
	public String getDiseasesURI() {
		return this.diseasesURI;
	}

	public void setExplanations(boolean s) {
		this.explanation = s;
	}
}
