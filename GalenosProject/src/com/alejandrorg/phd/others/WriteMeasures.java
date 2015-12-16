package com.alejandrorg.phd.others;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WriteMeasures {

	private final static String FILE = "measures.txt";

	public static void write(String s) throws Exception {
		BufferedWriter bW = new BufferedWriter(new FileWriter(new File(FILE),
				true));
		System.out.println("WM: " + s);
		bW.write(s);
		bW.newLine();
		bW.close();
	}
}
