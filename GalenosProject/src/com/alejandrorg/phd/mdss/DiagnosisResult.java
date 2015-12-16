package com.alejandrorg.phd.mdss;

import java.util.LinkedList;
import com.alejandrorg.phd.others.DebugAndResult;

public class DiagnosisResult {
	private Consult consult;
	private LinkedList<String> diagnosisResults;
	private DebugAndResult dar;

	public DiagnosisResult(Consult c) {
		this.consult = c;
		this.diagnosisResults = new LinkedList<String>();
		this.dar = new DebugAndResult();
	}

	public void addDiagnosisResult(String rz) {
		this.diagnosisResults.add(rz);
	}

	public LinkedList<String> getDiagnosisResults() {
		return this.diagnosisResults;
	}

	public Consult getConsult() {
		return this.consult;
	}

	public DebugAndResult getDebugAndResult() {
		return this.dar;
	}

	public void appendDebug(String s) {
		this.dar.appendDebug("\r\n" + s);

	}
}
