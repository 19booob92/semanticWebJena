package org.pwr.molczak.semanticWeb.queries;

import static org.pwr.molczak.semanticWeb.sparkql.SparkProcessor.PREFIX_TOKEN;;

public enum SparkQuery {

	FIAT_POCHODZENIE_QUERY("PREFIX fiat:" + PREFIX_TOKEN
			+ "SELECT ?pochodziZ WHERE { ?samochod a fiat:Fiat. ?samochod fiat:pochodziZ ?pochodziZ. }"),

	MITSHUBISHI_SPALANIE_QUERY("PREFIX mitshubishi:" + PREFIX_TOKEN
			+ "SELECT * WHERE { ?samochod a mitshubishi:Mitshubishi. ?samochod mitshubishi:spalanieNa100Km ?spalanieNa100Km. }"),

	CENA_WYPOSAZENIA("PREFIX przedmiot:" + PREFIX_TOKEN
			+ "SELECT * WHERE { ?przedmiot a przedmiot:Wyposazenie. ?przedmiot przedmiot:cena ?cena. }");

	final private String query;

	SparkQuery(String query) {
		this.query = query;
	}

	public String query() {
		return query;
	}

}
