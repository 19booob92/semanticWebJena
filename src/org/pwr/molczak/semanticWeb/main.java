package org.pwr.molczak.semanticWeb;

import org.apache.jena.base.Sys;
import org.pwr.molczak.semanticWeb.jena.OntologyProcessor;
import org.pwr.molczak.semanticWeb.utils.Tuple;

public class main {
	public static void main(String[] args) {

		OntologyProcessor processor = new OntologyProcessor();

		Tuple<String, Long> classes = processor.listAllClasses();
		Tuple<String, Long> properties = processor.listAllProperties();
		Tuple<String, Long> individuals = processor.listAllInstances();
		String classesWithIndividuals = processor.listClassesWithIndividuals();
		String classesWithSubClasses = processor.listClassesWithSubClasses();
		String propertiesWithDomainAndRange = processor.listPropertiesWithRangeAndDomain();

		System.err.println(processor.printResult(classes, " klas"));
		System.err.println("\n\n");
		System.err.println(processor.printResult(properties, " własności"));
		System.err.println("\n\n");
		System.err.println(processor.printResult(individuals, " indywidua"));
		System.err.println("\n\n");
		System.err.println(classesWithIndividuals);
		System.err.println("\n\n");
		System.err.println(classesWithSubClasses);
		System.err.println("\n\n");
		System.err.println(propertiesWithDomainAndRange);
		
		processor.listClassHierarchy();

	}
}
