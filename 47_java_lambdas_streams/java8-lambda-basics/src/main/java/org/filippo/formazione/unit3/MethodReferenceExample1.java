package org.filippo.formazione.unit3;

public class MethodReferenceExample1 {
	
	
	
	public static void main(String[] args) {
		
		//Thread t = new Thread(() -> printMessage()); Questo equiviale a .....
		
		//QUando usi una lambda senza args che chiama un metodo noargs => posso usare un method reference
		Thread t = new Thread(MethodReferenceExample1::printMessage);//....A questo
		t.start();
	}
	
	
	public static void printMessage() {
		System.out.println("Hello");
	}
}
