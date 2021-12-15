package org.filippo.formazione.functionalinterfaces;

import java.util.function.Function;

public class FunctionExample {
	
	//Questa interfaccia prende un input e restituisce un output vanno definiti i tipi sia per in che out
	
	static Function<String, String> function = (name) -> name.toUpperCase();
	
	static Function<String, String> addSomeString = s -> s.toUpperCase().concat(" Default");
	
	public static void main(String[] args) {
		System.out.println("Result is : " + function.apply("hello world!"));
		// QUi le funzioni vengono eseguite da sx verso dx
		System.out.println("Result of andThen is: " + function.andThen(addSomeString).apply("hello world")); 
		//Compose esegue prima la più interna (quindi il suo argoemnto) e poi quella esterna
		System.out.println("Result of compose is: " + function.compose(addSomeString).apply("hello world"));
	}

}
