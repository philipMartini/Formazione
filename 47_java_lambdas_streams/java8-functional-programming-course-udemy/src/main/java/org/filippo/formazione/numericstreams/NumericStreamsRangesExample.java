package org.filippo.formazione.numericstreams;

import java.util.stream.IntStream;

public class NumericStreamsRangesExample {

	public static void main(String[] args) {
		IntStream intStream = IntStream.range(1, 50);
		System.out.println(intStream.count());
		
		IntStream intStreamClosed = IntStream.rangeClosed(1, 50);
		System.out.println(intStreamClosed.count());
		
		//Da uno stream di int genera uno stream di double
		IntStream.range(1, 50).asDoubleStream().forEach(System.out::println);
		

	}

}
