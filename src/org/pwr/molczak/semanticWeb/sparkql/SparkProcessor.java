package org.pwr.molczak.semanticWeb.sparkql;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.pwr.molczak.semanticWeb.jena.RunJena;
import org.pwr.molczak.semanticWeb.queries.SparkQuery;

public class SparkProcessor {

	private static final String PREFIX = "<http://www.semanticweb.org/booob/ontologies/2015/11/TestCar.owl#> ";
	public static final String PREFIX_TOKEN = "_PREF_";

	public void runQuery(SparkQuery inputQuery) {
		runQuery(inputQuery.query());
	}

	public void runQuery(String inputQuery) {
		RunJena runJena = new RunJena();
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
