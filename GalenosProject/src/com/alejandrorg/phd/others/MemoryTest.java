package com.alejandrorg.phd.others;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class MemoryTest {

	private static boolean printScreen = false;
	public static void printMemory(String m) {

		writeAndPrint("-- Memory consumption --");
		writeAndPrint("Moment: " + m);
		writeAndPrint(" - Max Memory: " + Runtime.getRuntime().maxMemory());
		writeAndPrint(" - Free Memory: " + Runtime.getRuntime().freeMemory());
		writeAndPrint(" - Usage Memory: " + Runtime.getRuntime().totalMemory());

	}

	private static void writeAndPrint(String m) {
		try {
			BufferedWriter bW = new BufferedWriter(new FileWriter(new File(
					"outmem.txt")));
			if (printScreen) System.out.println(m);
			bW.write(m);
			bW.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
