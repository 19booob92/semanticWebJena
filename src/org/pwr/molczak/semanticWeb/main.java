package org.pwr.molczak.semanticWeb;

import static org.pwr.molczak.semanticWeb.sparkql.SprakProcessor.PREFIX_TOKEN;

import org.pwr.molczak.semanticWeb.jena.Ontology;
import org.pwr.molczak.semanticWeb.sparkql.SprakProcessor;

public class main {

	private final static String WIEDZMIN_POCHODZENIE_QUERY = "PREFIX gra: " + PREFIX_TOKEN
			+ "SELECT * WHERE { ?wiedzmin a gra:Wiedzmin. ?wiedzmin gra:jestZRegionu ?jestZRegionu. }";

	private final static String WIEDZMIN_NAGRODY = "PREFIX gra:" + PREFIX_TOKEN
			+ "SELECT ?wiedzmin ?posiadaNagrody WHERE { ?wiedzmin a gra:Wiedzmin. ?wiedzmin gra:posiadaNagrody ?posiadaNagrody. }";

	private final static String GRY_O_OKRESLONYM_TYTULE = "PREFIX gra: " + PREFIX_TOKEN
			+ "SELECT * WHERE { ?y gra:posiadaPodTytul ?g .FILTER regex(?g, \"d\", \"i\")}";

	public static void main(String[] args) {

		Ontology ontology = new Ontology();

//		ontology.printClasses();

//		ontology.printProperties();

//		ontology.printInstances();
//
//		ontology.printClassesWithIndividuals();
//
//		ontology.printClassesWithSubClasses();
//
		ontology.listPropertiesWithRangeAndDomain();
//
//		ontology.listClassHierarchy();

		// ## SPARK ##

		SprakProcessor spark = new SprakProcessor();

		// spark.runQuery(WIEDZMIN_POCHODZENIE_QUERY);
		// spark.runQuery(WIEDZMIN_NAGRODY);
//		spark.runQuery(GRY_O_OKRESLONYM_TYTULE);

	}
}
