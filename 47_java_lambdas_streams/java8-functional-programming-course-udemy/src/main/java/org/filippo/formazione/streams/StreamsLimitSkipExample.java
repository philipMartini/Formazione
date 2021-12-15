package org.filippo.formazione.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsLimitSkipExample {
	
	public static Optional<Integer> limitSumToKElements(List<Integer> numbers, int limit){
		return numbers
				.stream()
				.limit(limit) //esamina solo i primi limit elementi dello stream
				.reduce(Integer::sum);
	}
	
	public static Optional<Integer> sumSkippingTheFirstKElements(List<Integer> numbers, int step){
		return numbers
				.stream()
				.skip(step) //considera gli elementi nello stream saltando i primi step elementi
				.reduce(Integer::sum);
	}
	
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(6,7,8,9,10);
		System.out.println(limitSumToKElements(numbers, 2));
		System.out.println(sumSkippingTheFirstKElements(numbers, 2));

	}

}
