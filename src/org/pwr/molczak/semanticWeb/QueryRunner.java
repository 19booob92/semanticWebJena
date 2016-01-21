package org.pwr.molczak.semanticWeb;

import org.pwr.molczak.semanticWeb.queries.SparkQuery;
import org.pwr.molczak.semanticWeb.queries.SparkRules;
import org.pwr.molczak.semanticWeb.sparkql.SparkProcessor;

public class QueryRunner {

	public static void main(String[] args) {
		SparkProcessor sparkProcessor = new SparkProcessor();

//		sparkProcessor.runQuery(SparkQuery.FIAT_POCHODZENIE_QUERY);
//		sparkProcessor.runQuery(SparkQuery.MITSHUBISHI_SPALANIE_QUERY);
//		sparkProcessor.runQuery(SparkQuery.CENA_WYPOSAZENIA);
//
//		sparkProcessor.runQuery(SparkQuery.SAMOCHODY_NIEOPLACALNE.query() + SparkRules.DEFNE_OPLACALNOSC.query()
//				+ SparkRules.DEFINE_CZY_SUPER_SAMPCHOD.query() + "}");
//
//		sparkProcessor.runQuery(SparkQuery.SAMOCHODY_NIEOPLACALNE_MOJA_ONTOLOGIA.query() + SparkRules.DEFNE_OPLACALNOSC_MOJA_ONTOLOGIA.query()
//				+ SparkRules.DEFINE_CZY_SUPER_SAMPCHOD_MOJA_ONTOLOGIA.query() + "}");
		sparkProcessor.runQuery(SparkQuery.QUERY_ALL_INSTANCES);
	}
}
