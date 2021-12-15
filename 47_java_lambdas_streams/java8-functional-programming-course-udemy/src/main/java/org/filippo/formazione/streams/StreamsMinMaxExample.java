package org.filippo.formazione.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsMinMaxExample {
	
	public static int findMaxValue(List<Integer> numbers) {
		return numbers
				.stream()
				.reduce(numbers.get(0),(n1, n2) -> n1 > n2 ? n1 : n2);
	}
	
	public static Optional<Integer> findMaxValueOptional(List<Integer> numbers) {
		return numbers
				.stream()
				.reduce((n1, n2) -> n1 > n2 ? n1 : n2);
	}
	
	public static Optional<Integer> findMinValueOptional(List<Integer> numbers) {
		return numbers
				.stream()
				.reduce((n1, n2) -> n1 < n2 ? n1 : n2);
	}
	
	
	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(6,7,8,9,10);
		System.out.println(findMaxValue(integers));
		Optional<Integer> valueOptional = findMaxValueOptional(integers);
		if(valueOptional.isPresent())
			System.out.println(valueOptional.get());
		valueOptional = findMinValueOptional(integers);
		if(valueOptional.isPresent())
			System.out.println(valueOptional.get());
	}
}
