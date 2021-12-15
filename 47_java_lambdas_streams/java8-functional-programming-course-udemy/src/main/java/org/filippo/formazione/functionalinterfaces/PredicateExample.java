package org.filippo.formazione.functionalinterfaces;

import java.util.function.Predicate;

public class PredicateExample {
	//Predicate accetta un argomento e restituisce un boolean
	static Predicate<Integer> p1 = n -> n % 2 == 0;
	
	static Predicate<Integer> p2 = n -> n % 5 == 0;
	
	public static void predicateAndExample() {
		System.out.println(p1.and(p2).test(8)); //Posso fare chaining dei predicate il risultato è l'and dei predicati
		
	}
	
	public static void predicateOrExample() {
		System.out.println(p1.or(p2).test(8)); //Posso fare chaining dei predicate il risultato è l'or dei predicati
		
	}
	
	public static void predicateNegateExample() {
		System.out.println(p1.or(p2).negate().test(8)); //Posso fare chaining dei predicate il risultato è il negato dell'or dei predicati
		
	}
	
	public static void main(String[] args) {
		
		
		System.out.println(p1.test(8));
		predicateAndExample();
		predicateOrExample();

	}

}
