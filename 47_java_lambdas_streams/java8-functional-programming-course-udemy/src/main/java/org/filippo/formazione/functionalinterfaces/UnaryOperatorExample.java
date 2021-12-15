package org.filippo.formazione.functionalinterfaces;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
	
	//Questa interfaccia estende Function e viene usata quando in/out sono dello STESSO tipo quindi basta specificare un tipo generico solo
	static UnaryOperator<String> unary = s -> s.concat("default");
	
	//Binary operator estende BiFunction quindi prende due input e restituisce un out ma nel caso di BInaryOperator out e in sono dello STESSO tipo
	static BinaryOperator<Integer> binary = (a, b) -> a * b;
	
	
	public static void main(String[] args) {
		System.out.println(unary.apply("hello world!"));

	}

}
