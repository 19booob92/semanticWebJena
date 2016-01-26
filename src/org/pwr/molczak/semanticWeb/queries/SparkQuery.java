package org.pwr.molczak.semanticWeb.queries;

import static org.pwr.molczak.semanticWeb.sparkql.SparkProcessor.PREFIX_TOKEN;;

public enum SparkQuery {

	FIAT_POCHODZENIE_QUERY("PREFIX fiat:" + PREFIX_TOKEN
			+ "SELECT ?pochodziZ WHERE { ?samochod a fiat:Fiat. ?samochod fiat:pochodziZ ?pochodziZ. }"),

	MITSHUBISHI_SPALANIE_QUERY("PREFIX mitshubishi:" + PREFIX_TOKEN
			+ "SELECT * WHERE { ?samochod a mitshubishi:Mitshubishi. ?samochod mitshubishi:spalanieNa100Km ?spalanieNa100Km. }"),

	CENA_WYPOSAZENIA("PREFIX przedmiot: " + PREFIX_TOKEN
			+ "SELECT * WHERE { ?przedmiot a przedmiot:Wyposazenie. ?przedmiot przedmiot:cena ?cena. }"),
	
	SAMOCHODY_NIEOPLACALNE_MOJA_ONTOLOGIA("PREFIX : " + PREFIX_TOKEN
			+ "SELECT ?samochod ?czySuperSamochod "
			+ "WHERE {?samochod a :Mitshubishi. "
			+ "?samochod :przyspieszenieDo100KmNaH ?przyspieszenieDo100KmNaH. "
			+ "?samochod :spalanieNa100Km ?spalanieNa100km. "),
	
	SAMOCHODY_NIEOPLACALNE("PREFIX : " + PREFIX_TOKEN
			+ " SELECT ?samochod ?czySuperSamochod "
			+ "WHERE {  values (?samochod ?spalanie ?cena) {"
			+ "	(:FerrariF50 30 300000)"
			+ "	(:Porshe911 45 500000)"
			+ " (:LamborginiDiablo 50 1000000)"
			+ " (:FordTransit 50 50000) }"),

	DATA_MITSHUBISHI_CARS("PREFIX :" + PREFIX_TOKEN
			+ "SELECT * WHERE {?samochod a :Mitshubishi. "
			+ "?samochod :spalanieNa100Km ?spalanieNa100km. "
			+ "?samochod :przyspieszenieDo100KmNaH ?przyspieszenieDo100KmNaH.}"),

	QUERY_ALL_INSTANCES("PREFIX :" + PREFIX_TOKEN
			+ "SELECT ? WHERE {  ?entity :type ?type.  ?type :subClassOf* :SamochodOkreslonejMarki. }");
	
	final private String query;

	SparkQuery(String query) {
		this.query = query;
	}

	public String query() {
		return query;
	}

}
