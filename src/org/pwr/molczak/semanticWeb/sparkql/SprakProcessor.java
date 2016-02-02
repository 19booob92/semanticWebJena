package org.pwr.molczak.semanticWeb.sparkql;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.pwr.molczak.semanticWeb.jena.ModelCreator;

public class SprakProcessor {

	private static final String PREFIX = "<http://www.semanticweb.org/fubar/ontologies/2015/10/untitled-ontology-14#>";
	public static final String PREFIX_TOKEN = "_PREF_";

	public void runQuery(String inputQuery) {
		ModelCreator runJena = new ModelCreator();
		Model model = runJena.getModel();

		String processedQuery = insertPrefix(inputQuery);

		Query query = QueryFactory.create(processedQuery);

		QueryExecution qe = QueryExecutionFactory.create(query, model);
		ResultSet results = qe.execSelect();

		ResultSetFormatter.out(System.out, results, query);

		qe.close();
	}

	private String insertPrefix(String inputQuery) {
		return inputQuery.replace(PREFIX_TOKEN, PREFIX);
	}
}
