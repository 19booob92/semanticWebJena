package org.pwr.molczak.semanticWeb;

import org.pwr.molczak.semanticWeb.queries.SparkQuery;
import org.pwr.molczak.semanticWeb.queries.SparkRules;
import org.pwr.molczak.semanticWeb.sparkql.SparkProcessor;

public class Gen {
	public static void main(String[] args) {
		SparkProcessor sparkProcessor = new SparkProcessor();
		
		sparkProcessor.runQuery(SparkQuery.SAMOCHODY_NIEOPLACALNE_MOJA_ONTOLOGIA.query() 
				+ SparkRules.DEFINE_OPLACALNOSC_MOJA_ONTOLOGIA.query()
		+ SparkRules.DEFINE_CZY_SUPER_SAMPCHOD.query() + "}");
		
	}
}
