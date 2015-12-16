package com.alejandrorg.phd.populator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
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

public class CreateRelations {
	private ObjectProperty has_sign;
	private ObjectProperty has_disorder;
	private ObjectProperty has_diagnostic_test;
	private ObjectProperty can_ocurr_with;
	private ObjectProperty possible_adverse_effect;

	private String ddxont;
	private String ddxontURI;
	private String diseasesURI;
	private String signsURI;
	private String dtoURI;
	private String drugsURI;

	private LinkedList<OntResource> diseases;
	private LinkedList<OntResource> signs;
	@SuppressWarnings("unused")
	private LinkedList<OntResource> dts;
	private LinkedList<OntResource> drugs;
	OntModel model = ModelFactory.createOntologyModel();

	/**
	 * Constructor.
	 * 
	 * @param ddxo
	 *            Fichero ontología ddx
	 * @param ddxU
	 *            DDx URI
	 * @param diU
	 *            Diseases URI
	 * @param siU
	 *            Signs URI
	 * @param dtoU
	 *            DTO URI
	 * @param druU
	 *            Drugs URI
	 * @throws Exception
	 *             Puede lanzar excepción.
	 */
	public CreateRelations(String ddxo, String ddxU, String diU, String siU,
			String dtoU, String druU) throws Exception {
		this.ddxont = ddxo;
		this.ddxontURI = ddxU;
		this.diseasesURI = diU;
		this.signsURI = siU;
		this.dtoURI = dtoU;
		this.drugsURI = druU;
		this.init();
	}

	/**
	 * Método init
	 */
	private void init() throws Exception {
		model.read(new File(ddxont).toURI().toString());
		this.has_sign = model.getOntResource(
				ddxontURI + Constants.NUMBER_SIGN
						+ ConfigManager.getConfig(Constants.HAS_SIGN_PROPERTY))
				.asObjectProperty();
		this.has_disorder = model.getOntResource(
				ddxontURI
						+ Constants.NUMBER_SIGN
						+ ConfigManager
								.getConfig(Constants.HAS_DISORDER_PROPERTY))
				.asObjectProperty();
		this.has_diagnostic_test = model
				.getOntResource(
						ddxontURI
								+ Constants.NUMBER_SIGN
								+ ConfigManager
										.getConfig(Constants.HAS_DIAGNOSTIC_TEST_PROPERTY))
				.asObjectProperty();
		this.can_ocurr_with = model.getOntResource(
				ddxontURI
						+ Constants.NUMBER_SIGN
						+ ConfigManager
								.getConfig(Constants.CAN_OCCURR_WITH_PROPERTY))
				.asObjectProperty();
		this.possible_adverse_effect = model
				.getOntResource(
						ddxontURI
								+ Constants.NUMBER_SIGN
								+ ConfigManager
										.getConfig(Constants.POSSIBLE_ADVERSE_EFFECT_PROPERTY))
				.asObjectProperty();
		this.diseases = getIndividualsFromClass(this.diseasesURI
				+ Constants.NUMBER_SIGN
				+ ConfigManager
						.getConfig(Constants.DISEASE_ONTOLOGY_MAIN_CLASS));
		this.signs = getIndividualsFromClass(this.signsURI
				+ Constants.NUMBER_SIGN
				+ ConfigManager.getConfig(Constants.SIGNS_ONTOLOGY_MAIN_CLASS));
		this.drugs = getIndividualsFromClass(this.drugsURI
				+ Constants.NUMBER_SIGN
				+ ConfigManager.getConfig(Constants.DRUGS_ONTOLOGY_MAIN_CLASS));
		this.dts = getIndividualsFromClass(this.dtoURI + Constants.NUMBER_SIGN
				+ ConfigManager.getConfig(Constants.DTS_ONTOLOGY_MAIN_CLASS));
	}

	/**
	 * Método para crear relaciones entre fármacos y signos
	 */
	private String createRelationsBetweenDrugsAndSigns() throws Exception {
		String ret = "";
		LinkedList<String> rels = readFile(ConfigManager
				.getConfig(Constants.DATA_FOLDER)
				+ ConfigManager.getConfig(Constants.DRUGS_RELATIONS_DATA_FILE));
		/*
		 * Leemos las relaciones. Vienen en este formato:
		 * <Codigo_farmaco>=s1@s2@s3
		 * 
		 * Donde s1,s2,s3 pueden ser signos/síntomas o enfermedades (diseases)
		 * que provoca el fármaco.
		 */
		for (int i = 0; i < rels.size(); i++) {
			/*
			 * Recorremos las relaciones leidas.
			 */
			String r[] = null;
			if ((r = rels.get(i).split("=")).length == 2) {
				/*
				 * Si al hacer split por el "=" son dos partes, seguimos
				 * Asumimos que la primera [0] es el fármaco Y la segunda [1]
				 * el/los signo(s)
				 */
				String dr = r[0];
				String ss = r[1];
				String signs[] = ss.split("@");
				if (signs.length > 0) {
					/*
					 * Dividimos los signos por el caracter separador (@)
					 */
					OntResource drug = getDrug(dr);
					/*
					 * Obtenemos la instancia del fármaco
					 */
					if (drug != null) {
						ret += "\nPopulating drug: " + getNameOfDrug(drug)
								+ "\n\n\n";
						/*
						 * Si la encontramos
						 */
						LinkedList<OntResource> signsRelz = new LinkedList<OntResource>();
						for (int j = 0; j < signs.length; j++) {

							/*
							 * Creamos una lista donde guardar las instancias de
							 * los signos/enfermedades y las vamos guardando a
							 * medida que las vayamos encontrando (se busca en
							 * la lista de signos y de enfermedades)
							 */
							OntResource or = getResource(signs[j]);
							if (or != null) {
								signsRelz.add(or);
							}
						}
						/*
						 * Una vez tenemos todas debemos crear las relaciones
						 */
						for (int j = 0; j < signsRelz.size(); j++) {
							signsRelz.get(j).addProperty(this.can_ocurr_with,
									drug);
							drug.addProperty(this.possible_adverse_effect,
									signsRelz.get(j));
							ret += getNameOfSign(signsRelz.get(j))
									+ " -> can_ocurr_with -> "
									+ getNameOfDrug(drug) + "\n";
							ret += getNameOfDrug(drug)
									+ " -> possible_adverse_effect -> "
									+ getNameOfSign(signsRelz.get(j)) + "\n";
						}
					} else {
						ret += "Error. Drug not found: " + dr + "\n";
					}
				}
			}
		}
		return ret;
	}

	/**
	 * Método para encontrar un recurso buscando en la clase de signos y
	 * enfermedades.
	 * 
	 * @param r
	 *            Nombre del recurso
	 * @return Devuelve el objeto
	 */
	private OntResource getResource(String r) throws Exception {
		for (int i = 0; i < signs.size(); i++) {
			if (signs
					.get(i)
					.getLocalName()
					.equalsIgnoreCase(
							ConfigManager
									.getConfig(Constants.INSTANCE_IDENTIFIER)
									+ r)) {
				return signs.get(i);
			}
		}
		for (int i = 0; i < diseases.size(); i++) {
			if (diseases
					.get(i)
					.getLocalName()
					.equalsIgnoreCase(
							ConfigManager
									.getConfig(Constants.INSTANCE_IDENTIFIER)
									+ r)) {
				return diseases.get(i);
			}
		}
		return null;
	}

	/**
	 * Método para obtener la instancia de un fármaco.
	 * 
	 * @param dr
	 *            Recibe el nombre del fármaco.
	 * @return Devuelve la instancia.
	 */
	private OntResource getDrug(String dr) throws Exception {
		for (int i = 0; i < drugs.size(); i++) {
			if (drugs
					.get(i)
					.getLocalName()
					.equalsIgnoreCase(
							ConfigManager
									.getConfig(Constants.INSTANCE_IDENTIFIER)
									+ dr)) {
				return drugs.get(i);
			}
		}
		return null;
	}

	/**
	 * Método para leer un fichero.
	 * 
	 * @param f
	 *            Recibe el fichero
	 * @return Devuelve una lista con las cadenas leídas.
	 */
	private LinkedList<String> readFile(String f) throws Exception {
		BufferedReader bL = new BufferedReader(new FileReader(f));
		LinkedList<String> ret = new LinkedList<String>();
		while (bL.ready()) {
			ret.add(bL.readLine());
		}
		return ret;
	}

	/**
	 * Método para escribir.
	 * 
	 * @throws Exception
	 *             Puede lanzar excepción.
	 */
	private String write() throws Exception {
		String ret = "";
		model.write(new FileOutputStream(ddxont), "RDF/XML");
		ret += "Finished\n";
		return ret;
	}

	/**
	 * Método para crear los objetos DiseasesObject
	 * 
	 * @throws Exception
	 *             Puede lanzar excepción
	 */
	private void createDiseasesObjects() throws Exception {
		for (int i = 0; i < diseases.size(); i++) {
			System.out.println("Disease: " + diseases.get(i));
			DiseaseObject dob = populateDisease(this.diseases.get(i));
			dob = getSignsOfDisorders(dob);
		}
	}

	/**
	 * En el caso de que tenga disorders (has_disorder "x") necesitamos sacar
	 * los síntomas asociados de ese/esos "x".
	 * 
	 * @param dob
	 *            Recibe el objeto de la enfermedad de donde sacar la
	 *            información.
	 * @return Devuelve el objeto tras haber extraido la información.
	 */
	private DiseaseObject getSignsOfDisorders(DiseaseObject dob) {
		/*
		 * Cada disorder será un diseaseObject
		 */
		LinkedList<DiseaseObject> dos = new LinkedList<DiseaseObject>();
		for (int i = 0; i < dob.getDisorders().size(); i++) {
			OntResource disorder = dob.getDisorders().get(i);
			DiseaseObject dot = new DiseaseObject();
			dot.setRepresentsDisorderSign(true);
			dot.setOntResource(disorder);
			LinkedList<OntResource> signs = getSignsOfDisease(disorder);
			dot.setSigns(signs);
			dos.add(dot);
		}
		dob.setSignsDiseases(dos);
		return dob;
	}

	/**
	 * Método para obtener los signos asociados a una enfermedad.
	 * 
	 * @param disorder
	 *            Recibe como parámetro la enfermedad
	 * @return Devuelve la lista de recursos (síntomas/signos).
	 */
	private LinkedList<OntResource> getSignsOfDisease(OntResource disorder) {
		StaticUtils.log("Disorder (" + disorder.getLocalName() + ")\n");
		LinkedList<OntResource> signs = new LinkedList<OntResource>();
		NodeIterator it = disorder.listPropertyValues(this.has_sign);
		while (it.hasNext()) {
			RDFNode rn = it.next();
			OntResource or = model.getOntResource(rn.asResource());
			signs.add(or);
			StaticUtils.log("\tSign associated: " + or.getLocalName() + "\n");
		}
		return signs;
	}

	/**
	 * Método para obtener las instancias de una determinada clase.
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

	/**
	 * Método para poblar una enfermedad.
	 * 
	 * @param ds
	 *            Recibe la enfermedad.
	 * @throws Exception
	 *             Puede lanzar excepción.
	 */
	private DiseaseObject populateDisease(OntResource ds)
			throws Exception {
		DiseaseObject dob = new DiseaseObject();
		dob.setOntResource(ds);
		StaticUtils.log("Instance of disease: " + ds.getLocalName() + "\n");
		String cd = ds.getLocalName().substring(1, ds.getLocalName().length());
		LinkedList<OntResource> _signs = readSigns(cd);
		LinkedList<OntResource> _dts = readDTS(cd);
		LinkedList<OntResource> dosigns = new LinkedList<OntResource>();
		LinkedList<OntResource> dodisorders = new LinkedList<OntResource>();
		if ((_signs != null) && (_signs.size() > 0)) {
			for (int i = 0; i < _signs.size(); i++) {
				OntResource s = _signs.get(i);
				if (isSign(s) && (!isDisorder(s))) {
					dosigns.add(s);
					ds.addProperty(this.has_sign, s);
					StaticUtils.log(getNameOfDisorder(ds) + " -> has_sign -> "
							+ getNameOfSign(s) + "\n");
					// System.out.println(getNameOfDisorder(ds) +
					// " -> has_sign -> "
					// + getNameOfSign(s) + "\n");
				}
				if ((isDisorder(s) && (isSign(s)))
						|| ((isDisorder(s) && (!isSign(s))))) {
					dodisorders.add(s);
					s = getDisorder(s);
					ds.addProperty(this.has_disorder, s);
					StaticUtils.log(getNameOfDisorder(ds) + " -> has_disorder -> "
							+ getNameOfDisorder(s) + "\n");
					// System.out.println(getNameOfDisorder(ds) +
					// " -> has_disorder -> "
					// + getNameOfDisorder(s) + "\n");
				}
				if (!isSign(s) && (!isDisorder(s))) {
					StaticUtils.log(" !!! ERROR !!!. What is " + s.getLocalName()
							+ " ?\n");
					// System.out.println(" !!! ERROR !!!. What is " +
					// s.getLocalName()
					// + " ?\n");
				}
			}
		}
		if ((_dts != null) && (_dts.size() > 0)) {
			for (int i = 0; i < _dts.size(); i++) {
				OntResource d = _dts.get(i);
				if (d != null) {
					ds.addProperty(this.has_diagnostic_test, d);
					StaticUtils.log(getNameOfDisorder(ds)
							+ " -> has_diagnostic_test -> " + getNameOfDT(d)
							+ "\n");
				} else {
					StaticUtils.log("[ERROR] Null DT: " + _dts.get(i) + "\n");
				}
			}
		}
		dob.setSigns(dosigns);
		dob.setDisorders(dodisorders);
		dob.setDts(_dts);
		return dob;
	}

	/**
	 * Método para obtener el nombre de un dt.
	 * 
	 * @param s
	 *            Recibe como parámetro el recurso OntResource
	 * @return Devuelve el valor.
	 */
	private String getNameOfDrug(OntResource s) {
		String rz = s.getLocalName() + " (no value)";
		OntClass or = this.model.getOntClass(this.drugsURI
				+ Constants.NUMBER_SIGN
				+ s.getLocalName().substring(1, s.getLocalName().length()));
		if (or != null) {
			rz = or.getLabel(null) + " (" + s.getLocalName() + ")";
		}
		return rz;
	}

	/**
	 * Método para obtener el nombre de un dt.
	 * 
	 * @param s
	 *            Recibe como parámetro el recurso OntResource
	 * @return Devuelve el valor.
	 */
	private String getNameOfSign(OntResource s) {
		String rz = s.getLocalName() + " (no value)";
		OntClass or = this.model.getOntClass(this.signsURI
				+ Constants.NUMBER_SIGN
				+ s.getLocalName().substring(1, s.getLocalName().length()));
		if (or != null) {
			rz = or.getLabel(null) + " (" + s.getLocalName() + ")";
		} else {
			or = this.model.getOntClass(this.diseasesURI
					+ Constants.NUMBER_SIGN
					+ s.getLocalName().substring(1, s.getLocalName().length()));
			if (or != null) {
				rz = or.getLabel(null) + " (" + s.getLocalName() + ")";
			}
		}
		return rz;
	}

	/**
	 * Método para obtener el nombre de un dt.
	 * 
	 * @param s
	 *            Recibe como parámetro el recurso OntResource
	 * @return Devuelve el valor.
	 */
	private String getNameOfDT(OntResource s) {
		String rz = s.getLocalName() + " (no value)";
		OntClass or = this.model.getOntClass(this.dtoURI
				+ Constants.NUMBER_SIGN
				+ s.getLocalName().substring(1, s.getLocalName().length()));
		if (or != null) {
			rz = or.getLabel(null) + " (" + s.getLocalName() + ")";
		}
		return rz;
	}

	/**
	 * Método para obtener el nombre de un disorder.
	 * 
	 * @param s
	 *            Recibe como parámetro el recurso OntResource
	 * @return Devuelve el valor.
	 */
	private String getNameOfDisorder(OntResource s) {
		String rz = s.getLocalName() + " (no value)";
		OntClass or = this.model.getOntClass(this.diseasesURI
				+ Constants.NUMBER_SIGN
				+ s.getLocalName().substring(1, s.getLocalName().length()));
		if (or != null) {
			rz = or.getLabel(null) + " (" + s.getLocalName() + ")";
		}
		return rz;
	}

	/**
	 * Método para obtener el recurso proporcionado en la ontología disont.
	 * 
	 * @param s
	 *            Recibe el recurso de la ontología signs.
	 * @return Devuelve el recurso de la ontología disont.
	 */
	private OntResource getDisorder(OntResource s) {
		String n = s.getLocalName();
		OntResource r = model.getOntResource(this.diseasesURI
				+ Constants.NUMBER_SIGN + n);
		return r;
	}

	/**
	 * Método para saber si un recurso es considerado signo.
	 * 
	 * @param s
	 *            Recibe el recurso.
	 * @return Devuelve un booleano.
	 */
	private boolean isSign(OntResource s) {
		for (int i = 0; i < signs.size(); i++) {
			if (signs.get(i).getLocalName().equalsIgnoreCase(s.getLocalName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Método para saber si un recurso es considerado disorder.
	 * 
	 * @param s
	 *            Recibe el recurso.
	 * @return Devuelve un booleano.
	 */
	private boolean isDisorder(OntResource s) {
		for (int i = 0; i < diseases.size(); i++) {
			if (diseases.get(i).getLocalName()
					.equalsIgnoreCase(s.getLocalName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Método para leer las pruebas complementarias de diagnóstico.
	 * 
	 * @param rds
	 *            Recibe el código de la enfermedad.
	 * @return Devuelve una lista de recursos.
	 * @throws Exception
	 *             Puede lanzar una excepción.
	 */
	private LinkedList<OntResource> readDTS(String rds)
			throws Exception {
		File f = new File(ConfigManager.getConfig(Constants.DATA_FOLDER)
				+ ConfigManager.getConfig(Constants.DISEASES_DATA_FOLDER) + rds
				+ ConfigManager.getConfig(Constants.DATA_DTS_FILE_SUFFIX));
		if (f.exists()) {
			LinkedList<OntResource> ret = new LinkedList<OntResource>();
			BufferedReader bL = new BufferedReader(new FileReader(f));
			while (bL.ready()) {
				String r = bL.readLine();
				String p[] = r.split("-");
				if (p.length == 2) {
					String inst = p[0].trim();
					OntResource or = model.getOntResource(this.dtoURI
							+ Constants.NUMBER_SIGN
							+ ConfigManager
									.getConfig(Constants.INSTANCE_IDENTIFIER)
							+ inst);
					ret.add(or);
					// System.out.println("Read DTS: " + or.getLocalName());
				}
			}
			return ret;
		} else {
			StaticUtils.log("Skipping file " + f.toString() + "\n");
			return null;
		}
	}

	/**
	 * Método para leer los signos.
	 * 
	 * @param rds
	 *            Recibe el código de la enfermedad.
	 * @return Devuelve una lista de recursos.
	 * @throws Exception
	 *             Puede lanzar una excepción.
	 */
	private LinkedList<OntResource> readSigns(String rds)
			throws Exception {
		File f = new File(ConfigManager.getConfig(Constants.DATA_FOLDER)
				+ ConfigManager.getConfig(Constants.DISEASES_DATA_FOLDER) + rds
				+ ConfigManager.getConfig(Constants.DATA_SIGNS_FILE_SUFFIX));

		if (f.exists()) {
			LinkedList<OntResource> ret = new LinkedList<OntResource>();
			BufferedReader bL = new BufferedReader(new FileReader(f));
			while (bL.ready()) {
				String r = bL.readLine();
				String inst = "";
				for (int i = 0; i < r.length(); i++) {
					if (r.charAt(i) == ' ') {
						break;
					} else {
						inst += r.charAt(i);
					}
				}
				OntResource or = model.getOntResource(this.signsURI
						+ Constants.NUMBER_SIGN
						+ ConfigManager
								.getConfig(Constants.INSTANCE_IDENTIFIER)
						+ inst);

				if (or != null) {
					ret.add(or);
				} else {
					OntResource od = model.getOntResource(this.diseasesURI
							+ Constants.NUMBER_SIGN
							+ ConfigManager
									.getConfig(Constants.INSTANCE_IDENTIFIER)
							+ inst);
					if (od != null) {
						ret.add(od);
					} else {
						StaticUtils.log("[ERROR] Unknown instance (not SO/DO)?: "
								+ inst + "\n");
					}
				}
			}
			return ret;
		} else {
			StaticUtils.log("Skipping file " + f.toString() + "\n");
			return null;
		}
	}

	public void execute() throws Exception {
		createDiseasesObjects();
		createRelationsBetweenDrugsAndSigns();
		write();
	}
}
