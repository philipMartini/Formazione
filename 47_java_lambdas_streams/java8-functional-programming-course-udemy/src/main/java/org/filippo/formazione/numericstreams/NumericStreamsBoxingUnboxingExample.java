package org.filippo.formazione.numericstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamsBoxingUnboxingExample {
	
	//From int to Integer
	public static List<Integer> boxing() {
		return IntStream.rangeClosed(1, 10) 
				.boxed()
				.collect(Collectors.toList());
	}
	
	//From Integer to int
	public static IntStream unboxing(List<Integer> integerList) {
		//wrapper to primite
		return integerList
				.stream()
				.mapToInt(Integer::intValue);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
