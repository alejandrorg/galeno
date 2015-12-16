package com.alejandrorg.phd.others;

//import com.hp.hpl.jena.util.FileUtils;
import java.io.File;

import org.apache.commons.io.FileUtils;

public class FileCopier {

	public String copyOntologyToWebServer() throws Exception {
		String ret = "";
		ret += "Copying " + ConfigManager.getConfig(Constants.ONT_FOLDER)
				+ ConfigManager.getConfig(Constants.FILE_ONT_DDX)
				+ " to Web Server directory ("
				+ ConfigManager.getConfig(Constants.WEB_SERVER_DIRECTORY)
				+ ")...";
		FileUtils.copyFileToDirectory(
				new File(ConfigManager.getConfig(Constants.ONT_FOLDER)
						+ ConfigManager.getConfig(Constants.FILE_ONT_DDX)),
				new File(ConfigManager
						.getConfig(Constants.WEB_SERVER_DIRECTORY)));
		ret += "Done.\n";

		ret += "Copying " + ConfigManager.getConfig(Constants.ONT_FOLDER)
				+ ConfigManager.getConfig(Constants.FILE_ONT_DISEASES)
				+ " to Web Server directory ("
				+ ConfigManager.getConfig(Constants.WEB_SERVER_DIRECTORY)
				+ ")...";
		FileUtils
				.copyFileToDirectory(
						new File(ConfigManager.getConfig(Constants.ONT_FOLDER)
								+ ConfigManager
										.getConfig(Constants.FILE_ONT_DISEASES)),
						new File(ConfigManager
								.getConfig(Constants.WEB_SERVER_DIRECTORY)));
		ret += "Done.\n";

		ret += "Copying " + ConfigManager.getConfig(Constants.ONT_FOLDER)
				+ ConfigManager.getConfig(Constants.FILE_ONT_DRUGS)
				+ " to Web Server directory ("
				+ ConfigManager.getConfig(Constants.WEB_SERVER_DIRECTORY)
				+ ")...";
		FileUtils.copyFileToDirectory(
				new File(ConfigManager.getConfig(Constants.ONT_FOLDER)
						+ ConfigManager.getConfig(Constants.FILE_ONT_DRUGS)),
				new File(ConfigManager
						.getConfig(Constants.WEB_SERVER_DIRECTORY)));
		ret += "Done.\n";

		ret += "Copying " + ConfigManager.getConfig(Constants.ONT_FOLDER)
				+ ConfigManager.getConfig(Constants.FILE_ONT_DTS)
				+ " to Web Server directory ("
				+ ConfigManager.getConfig(Constants.WEB_SERVER_DIRECTORY)
				+ ")...";
		FileUtils.copyFileToDirectory(
				new File(ConfigManager.getConfig(Constants.ONT_FOLDER)
						+ ConfigManager.getConfig(Constants.FILE_ONT_DTS)),
				new File(ConfigManager
						.getConfig(Constants.WEB_SERVER_DIRECTORY)));
		ret += "Done.\n";

		ret += "Copying " + ConfigManager.getConfig(Constants.ONT_FOLDER)
				+ ConfigManager.getConfig(Constants.FILE_ONT_SIGNS)
				+ " to Web Server directory ("
				+ ConfigManager.getConfig(Constants.WEB_SERVER_DIRECTORY)
				+ ")...";
		FileUtils.copyFileToDirectory(
				new File(ConfigManager.getConfig(Constants.ONT_FOLDER)
						+ ConfigManager.getConfig(Constants.FILE_ONT_SIGNS)),
				new File(ConfigManager
						.getConfig(Constants.WEB_SERVER_DIRECTORY)));
		ret += "Done.\n";
		return ret;
	}
}
