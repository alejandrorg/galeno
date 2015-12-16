package com.alejandrorg.phd.others;

public class DebugAndResult {
	private String debug;

	public DebugAndResult() {
		this.debug = "";
	}

	public DebugAndResult(String d) {
		this.debug = d;
	}

	public String getDebug() {
		return this.debug;
	}

	public void appendDebug(String s) {
		this.debug += s;
	}

	public String toString() {
		return this.getDebug();
	}
}
