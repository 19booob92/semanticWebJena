package org.pwr.molczak.semanticWeb.utils;

public class Tuple<T, K> {

	public T getValues() {
		return values;
	}

	public void setValues(T values) {
		this.values = values;
	}

	private T values;
	private K amount;

	public Tuple(T values, K amount) {
		this.values = values;
		this.amount = amount;
	}

	public K getAmount() {
		return amount;
	}

	public void setAmount(K amount) {
		this.amount = amount;
	}

}
