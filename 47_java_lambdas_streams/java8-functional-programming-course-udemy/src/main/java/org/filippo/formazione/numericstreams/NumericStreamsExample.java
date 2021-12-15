package org.filippo.formazione.numericstreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class NumericStreamsExample {
	
	public static int sumOfNNumbers(List<Integer> numbers) {
		return numbers
				.stream()
				.reduce(0, (x,y) -> x+y); //Deve fare per ogni elemnto unboxing Integer -> int
	}
	
	public static int sumOfNNumbersIntStream() {
		return IntStream.rangeClosed(1, 6) // stream con 1,2,3,4,5,6
				.sum();
	}

	public static void main(String[] args) {
		List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7);

	}

}
