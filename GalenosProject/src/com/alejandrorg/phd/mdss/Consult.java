package com.alejandrorg.phd.mdss;
import java.io.File;
import java.util.LinkedList;

public class Consult {
	private String name;
	private LinkedList<String> signs;
	private LinkedList<String> dts;
	private LinkedList<String> drugs;
	private File file;
	private String desc;
	private boolean isSubConsult;
	private String expSubConsult;
	private String superConsultName;

	/**
	 * Constructor.
	 * 
	 * @param name
	 *            Recibe el nombre de la consulta.
	 */
	public Consult(String name) {
		this.isSubConsult = false;
		this.signs = new LinkedList<String>();
		this.dts = new LinkedList<String>();
		this.drugs = new LinkedList<String>();
		this.name = name;
		this.expSubConsult = "";
		this.superConsultName = "";
	}

	public String getName() {
		return this.name;
	}

	public LinkedList<String> getSigns() {
		return this.signs;
	}

	public LinkedList<String> getDts() {
		return this.dts;
	}

	public void addSign(String s) {
		this.signs.add(s);
	}

	public void addDT(String d) {
		this.dts.add(d);
	}

	public void addDrug(String d) {
		this.drugs.add(d);
	}

	public String toString() {
		String ret = "";
		return ret;
	}

	public LinkedList<String> getDrugs() {
		return this.drugs;
	}

	public void setDrugs(LinkedList<String> d) {
		this.drugs = d;
	}

	public void setDts(LinkedList<String> d) {
		this.dts = d;
	}

	public void setSigns(LinkedList<String> s) {
		this.signs = s;
	}

	public void setFile(File f) {
		this.file = f;
	}

	public File getFile() {
		return this.file;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setIsSubConsult(boolean b) {
		this.isSubConsult = b;
	}

	public boolean isSubConsult() {
		return this.isSubConsult;
	}

	public void setExplanationSubConsult(String e) {
		this.expSubConsult = e;
	}

	public String getExplanationSubConsult() {
		return this.expSubConsult;
	}

	public void setSuperConsult(String s) {
		this.superConsultName = s;
	}

	public String getSuperConsult() {
		return this.superConsultName;
	}
}
