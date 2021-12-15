package org.filippo.formazione.functionalinterfaces;

public class FunctionExample1 {
	//Usare le interfacce funzionali favorisce la code reusability!!!!!!!!
	public static String performConcat(String str) {
		return FunctionExample.addSomeString.apply(str);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
