package org.pwr.molczak.semanticWeb.utils;

public class StringUtils {

	public static String removeLastComma(StringBuilder input) {
		int lastCommaIndex = input.lastIndexOf(",");
		input.deleteCharAt(lastCommaIndex);
		
		return input.toString();
	}
}
