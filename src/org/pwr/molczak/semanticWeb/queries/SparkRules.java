package org.pwr.molczak.semanticWeb.queries;

public enum SparkRules {

	DEFINE_OPLACALNOSC_MOJA_ONTOLOGIA("bind( if( (?przyspieszenieDo100KmNaH < 10) && (?spalanieNa100Km > 20), "
			+ ":nieoplacalny, "
			+ ":oplacalny ) as ?czyOplacalny )"),

	DEFINE_OPLACALNOSC("bind( if( ?spalanie > 25 && ?cena > 200000, "
			+ ":nieoplacalny, "
			+ ":oplacalny ) as ?czyOplacalny )"),
	
	DEFINE_CZY_SUPER_SAMPCHOD("bind( if( ?czyOplacalny = :oplacalny, "
			+ ":zwyklySamochod, "
			+ ":superSamochod) as ?czySuperSamochod )");
	
	final private String query;

	SparkRules(String query) {
		this.query = query;
	}

	public String query() {
		return query;
	}
	
}
