package org.filippo.formazione.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {
	
	
	
	public static void main(String[] args) {
		int[] someNumbers = { 1, 2, 3, 4};
		int key = 0;
		//COme faccio a fare catching dell'exception division by zero?????
		//E sopratutto come faccio ad essere sicuro che sia l'eccezione giusta da catchare dato che posso passare lexpr che voglio
		//La convezione migliore è wrappare la lamba che lancia l'eccezioen in un'altra lambda che la f!!!
		process(someNumbers, key, wrapperLambda((v, k) -> System.out.println(v / k)));
	}
	
	//This method will perform an action on every element of the array using the key
	public static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
		
		for(int i : someNumbers)
			consumer.accept(i, key);
	}
	
	//This is the wrapper lambda e prende in input la stessa interfaccia funzionale della lambda originale
	public static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
		return (v, k) -> {
			try {
				System.out.println("Executing from wrapper...");
				consumer.accept(v, k);
			}catch(ArithmeticException e) {
				System.out.println("Exception caught in wrapper lambda");
			}
		};
		}

}
