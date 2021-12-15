package org.filippo.formazione.streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamsOfGenerateIterateExample {
	
	public static void main(String[] args) {
		//Crea uno stream
		Stream<String> streamString = Stream.of("adam", "julie", "john");
		
		//Genera uno stream infinito (se non limito) usando 1 come valore iniziale
		Stream.iterate(1, x -> x*2)
			.limit(7)
			.forEach(System.out::println);
		
		Supplier<Integer> integerSupplier = new Random()::nextInt;
		//Infinite stream of random numbers
		Stream.generate(integerSupplier)
				.limit(7)
				.forEach(System.out::println);;
	}

}
