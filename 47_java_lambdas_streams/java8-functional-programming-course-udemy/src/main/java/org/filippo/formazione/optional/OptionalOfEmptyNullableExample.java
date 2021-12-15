package org.filippo.formazione.optional;

import java.util.Optional;

public class OptionalOfEmptyNullableExample {
	
	//Tutti questi metodi sono di fatto dei factory di Optional
	
	public static Optional<String> ofNullableExample(){
		return Optional.ofNullable(null); //Se il valore è nullo viene costruito un Optional vuoto
	}
	
	public static Optional<String> ofExample(){
		return Optional.of("Hello"); //Questo metodo si apsetta SEMPRE un oggetto NON NULLO in input, viene lanciata un'eccezione
	}
	
	public static Optional<String> emptyExample(){
		return Optional.empty(); //Questo metodo restituisce sempre un optional vuoto
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println(ofNullableExample());

	}

}
