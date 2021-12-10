package org.filippo.formazione.unit1;

public class Greeter {
	
	public void greet(Greeting greeting) {
		greeting.perform();
		
	}
	
	
	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		//HelloWorldGreeting helloWorldGreeting = new HelloWorldGreeting();
		//greeter.greet(helloWorldGreeting);
		
		//Se l'spressione ha una sola riga posso omettere le {} e la return keyword
		Greeting myLambdaGreeting = () -> System.out.println("Hello World From lambda!");
		//Posso anche chiamare il metodo dell'interfaccia implementata dalla lambda
		myLambdaGreeting.perform();
		//Ma allora quale è la differenza tra una classe che implementa l'interfaccia e la lambda?
		//La lambda è più simile ad una anonymous inner class  che implementa l'interaccia ossia:
		Greeting innerClassGreeting = new Greeting(){
			public void perform() {
				System.out.println("Hello From Inner class");
			}
		};
		
		greeter.greet(myLambdaGreeting);
		greeter.greet(innerClassGreeting);
		
		MyAdd addFunction = (int a, int b) -> a + b;
	}
}

//Per dichiarare un tipo lambda crea un interfaccia con un metodo con la stessa
//Firma della lambda => L'interfaccia deve avere un SOLO metodo => functional interface
interface MyLambda{
	
	void foo();
	
}

interface MyAdd {
	
	int add(int a, int b);
}