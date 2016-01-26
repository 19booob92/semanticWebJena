package org.pwr.molczak.semanticWeb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.pwr.molczak.semanticWeb.queries.SparkQuery;
import org.pwr.molczak.semanticWeb.queries.SparkRules;
import org.pwr.molczak.semanticWeb.sparkql.SparkProcessor;

public class QueryRunner {
	
	private static final int UNDEFINED_VALUE = -1;

	public static void main(String[] args) {

		SparkProcessor sparkProcessor = new SparkProcessor();
		
		int choice = UNDEFINED_VALUE;

		while ((choice = printMenu()) != 10) {
			switch (choice) {
			case 1: {
				sparkProcessor.runQuery(SparkQuery.FIAT_POCHODZENIE_QUERY);
			}
				break;
			case 2: {
				sparkProcessor.runQuery(SparkQuery.MITSHUBISHI_SPALANIE_QUERY);
			}
				break;
			case 3: {
				sparkProcessor.runQuery(SparkQuery.CENA_WYPOSAZENIA);
			}
				break;
			case 4: {
				sparkProcessor.runQuery(SparkQuery.SAMOCHODY_NIEOPLACALNE.query() + SparkRules.DEFINE_OPLACALNOSC.query()
				+ SparkRules.DEFINE_CZY_SUPER_SAMPCHOD.query() + "}");
			}
				break;
			case 5: {
				sparkProcessor.runQuery(SparkQuery.QUERY_ALL_INSTANCES);
			}
				break;
			case 6: {
				sparkProcessor.runQuery(SparkQuery.DATA_MITSHUBISHI_CARS);
			}
			break;
			default:
			}
		}

	}

	private static int printMenu() {

		System.out.println("1 - Określ pochodzenie Fiata");
		System.out.println("2 - Określ spalanie aut firmy Mitshubishi");
		System.out.println("3 - Określ ceny elementów wyposażenia");
		System.out.println("4 - Znajdź wszystkie samochody nieopłacalne");
		System.out.println("5 - Znajdź wszystkie instancje");
		System.out.println("6 - Informacje o samochodach marki Mitshubishi");
		System.out.println("10 - Wyjdź");
		System.out.println("Proszę wybrać dane do wypisania: \n");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int choice = Integer.parseInt(in.readLine());
			return choice;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return UNDEFINED_VALUE;
	}
}
