package org.pwr.molczak.semanticWeb.queries;

public enum SparkRules {

	DEFNE_OPLACALNOSC_MOJA_ONTOLOGIA("bind( if( ?spalanieNa100Km > 25 && ?cena > 200000, "
			+ ":nieoplacalny, "
			+ ":oplacalny ) as ?czyOplacalny )"),
	
	DEFINE_CZY_SUPER_SAMPCHOD_MOJA_ONTOLOGIA("bind( if( ?czyOplacalny = :nieoplacalny, "
			+ ":superSamochod, "
			+ ":zlyklySamochod) as ?czySuperSamochod )"),

	DEFNE_OPLACALNOSC("bind( if( ?spalanie > 25 && ?cena > 200000, "
			+ ":nieoplacalny, "
			+ ":oplacalny ) as ?czyOplacalny )"),
	
	DEFINE_CZY_SUPER_SAMPCHOD("bind( if( ?czyOplacalny = :nieoplacalny, "
			+ ":superSamochod, "
			+ ":zlyklySamochod) as ?czySuperSamochod )");
	
	final private String query;

	SparkRules(String query) {
		this.query = query;
	}

	public String query() {
		return query;
	}
	
}
