package org.filippo.formazione.numericstreams;

import java.util.stream.IntStream;

public class NumericStreamAggregateExample {

	public static void main(String[] args) {
		//Somma tutti i valori nello stream
		System.out.println(IntStream.rangeClosed(1, 50).sum());
		//Max nello stream
		System.out.println(IntStream.rangeClosed(1, 50).max());
		//Min nello stream
		System.out.println(IntStream.rangeClosed(1, 50).min());
		//Avg dello stream
		System.out.println(IntStream.rangeClosed(1, 50).average());
	}

}
