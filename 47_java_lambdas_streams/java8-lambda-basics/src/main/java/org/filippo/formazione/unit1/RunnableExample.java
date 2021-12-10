package org.filippo.formazione.unit1;

public class RunnableExample {

	public static void main(String[] args) {
		//In questo esempio thread ha bisogno che venga passato al costruttore
		//Una classe che implementa l'interfaccia funzionale Runnable => 
		//Quindi in questo caso posso usare una lambda
		
		//Con la anonynous class
//		Thread t = new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				System.out.println("Hello From Anonymous inner Runnable");
//				
//			}
//			
//		});
		
		//Basta creare una lambda con la stessa firma di run() e che di conseguenza implementa l'interfaccia Runnable
		
		Thread t = new Thread(() -> System.out.println("Hello from lambda Runnable"));
		
		t.run();
	}

}
