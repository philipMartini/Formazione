package org.filippo.formazione.unit1;

public class TypeInferenceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Posso eliminare il tipo del parametro perchè l'interfaccia
		//Che implmenta ha già informazioni sul tipo di parametro in input
		StringLengthLambda myLambda = (s) -> s.length();
		System.out.println(myLambda.getLength("Hello Lambda"));
		//Di fatto il compilatore esaminando la lambd è in grado
		//di fare typeInference e capire che quell'espressione implementa linterfaccia che il metodo accetta come parametro
		printLambda(s -> s.length());
	}
	
	
	public static void printLambda(StringLengthLambda l) {
		System.out.println(l.getLength("Hello Lambda"));
	}
	
	interface StringLengthLambda {
		
		int getLength(String s);
	}

}
