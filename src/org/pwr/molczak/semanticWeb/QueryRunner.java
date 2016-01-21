package org.pwr.molczak.semanticWeb;

import org.pwr.molczak.semanticWeb.queries.SparkQuery;
import org.pwr.molczak.semanticWeb.sparkql.SparkProcessor;

public class QueryRunner {

	public static void main(String[] args) {
		SparkProcessor sparkProcessor = new SparkProcessor();

		sparkProcessor.runQuery(SparkQuery.FIAT_POCHODZENIE_QUERY);
		sparkProcessor.runQuery(SparkQuery.MITSHUBISHI_SPALANIE_QUERY);
		sparkProcessor.runQuery(SparkQuery.CENA_WYPOSAZENIA);
	}
}
