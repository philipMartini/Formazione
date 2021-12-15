package org.filippo.formazione.optional;

import java.util.Optional;

public class OptionalPresentExample {
	
	public static void main(String[] args) {
		Optional<String> optional = Optional.ofNullable("Hello Optional");
		System.out.println(optional.isPresent()); //True sse l'otional wrappa un oggetto non nullo
		
		//Ifpresent permette di passare un Consumer quindi di effettuare un operazione sull oggetto wrappato
		optional.ifPresent(s -> System.out.println(s));

	}

}
