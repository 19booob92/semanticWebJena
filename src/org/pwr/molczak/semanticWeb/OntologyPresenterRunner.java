package org.pwr.molczak.semanticWeb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.pwr.molczak.semanticWeb.jena.OntologyProcessor;
import org.pwr.molczak.semanticWeb.utils.Tuple;

public class OntologyPresenterRunner {
	private static final int UNDEFINED_VALUE = -1;

	public static void main(String[] args) {

		OntologyProcessor processor = new OntologyProcessor();

		int choice = UNDEFINED_VALUE;

		while ((choice = printMenu()) != 10) {
			switch (choice) {
			case 1: {
				Tuple<String, Long> classes = processor.listAllClasses();
				System.err.println(processor.printResult(classes, " klas") + "\n\n");
			}
				break;
			case 2: {
				Tuple<String, Long> properties = processor.listAllProperties();
				System.err.println(processor.printResult(properties, " własności") + "\n\n");
			}
				break;
			case 3: {
				Tuple<String, Long> individuals = processor.listAllInstances();
				System.err.println(processor.printResult(individuals, " indywidua") + "\n\n");
			}
				break;
			case 4: {
				String classesWithIndividuals = processor.listClassesWithIndividuals();
				System.err.println(classesWithIndividuals + "\n\n");
			}
				break;
			case 5: {
				String classesWithSubClasses = processor.listClassesWithSubClasses();
				System.err.println(classesWithSubClasses + "\n\n");
			}
				break;
			case 6: {
				processor.listClassHierarchy();
			}
				break;
			case 7: {
				String propertiesWithDomainAndRange = processor.listPropertiesWithRangeAndDomain();
				System.err.println(propertiesWithDomainAndRange + "\n\n");
			}
				break;
			default:
			}
		}

	}

	private static int printMenu() {

		System.out.println("1 - Lista klas");
		System.out.println("2 - Lista własności klas");
		System.out.println("3 - Lista instancji");
		System.out.println("4 - Klasy wraz z instancjami");
		System.out.println("5 - Klasy z podklasami");
		System.out.println("6 - Hierarchia klas");
		System.out.println("7 - Własności wraz z domeną i zakresem");
		System.out.println("10 - Wyjdź");
		System.out.println("Proszę wybrać dane do wypisania: \n");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int choice = Integer.parseInt(in.readLine());
			return choice;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return UNDEFINED_VALUE;
	}
}
