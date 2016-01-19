package org.pwr.molczak.semanticWeb.utils;

import java.io.InputStream;

import org.apache.jena.util.FileManager;

public class FileUtils {

	private static final String PATH = "/home/booob/ontologies/car/car.owl";

	public static InputStream readOwlFile() {
		InputStream inputStream = FileManager.get().open(PATH);
		return inputStream;
	}

}
