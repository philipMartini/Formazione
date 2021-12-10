package org.filippo.formazione.unit2;

public class ClosuresExample {

	public static void main(String[] args) {
		int a = 7;
		int b = 3;
		//In questo caso sto passando al body della lambda un valore dallo enclosing scope ma di fatto il comp assume che la
		//Variabile sia FINAL
		doProcess(a, i -> System.out.println(i + b));

	}
	
	public static void doProcess(int i, Process p) {
		p.process(i);
	}
}


interface Process {
	
	void process(int i);
}