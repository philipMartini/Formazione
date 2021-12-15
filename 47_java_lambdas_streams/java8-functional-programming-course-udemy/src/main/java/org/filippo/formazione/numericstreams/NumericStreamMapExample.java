package org.filippo.formazione.numericstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamMapExample {
	
	public static List<Integer> mapToObj() {
		return IntStream.rangeClosed(1, 5)
				.mapToObj(i -> new Integer(i))
				.collect(Collectors.toList());
	}
	
	public static long mapToLong() {
		return IntStream.rangeClosed(1, 5)
				.mapToLong(i -> i)
				.sum();
	}
	
	public static double mapToDouble() {
		return IntStream.rangeClosed(1, 5)
				.mapToDouble(i -> i)
				.sum();
	}
	
	public static void main(String[] args) {
		
	}
}
