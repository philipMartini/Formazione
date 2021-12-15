package org.filippo.formazione.functionalinterfaces;

import java.util.List;
import java.util.function.BiConsumer;

import org.filippo.formazione.data.StudentDataBase;

public class BiConsumerExample {
	
	public static void printNameAndActivites() {
		
		BiConsumer<String, List<String>> biConsumer = (n, a) -> System.out.println(n + " : " + a);
		
		StudentDataBase.getAllStudents()
			.forEach(s -> biConsumer.accept(s.getName(), s.getActivities())); //Lambda che implementa COnsumer che chiama un BiConsumer
			
	}
	
	
	public static void main(String[] args) {
		//Stesso tipo di interfaccia di consumer ma accetta due Input al posto di uno
		BiConsumer<String, String> biConsumer = (a, b) -> System.out.println(a + " " + b);
		biConsumer.accept("Java 8", "Hello");
		
		BiConsumer<Integer, Integer> multiply = (x, y) -> System.out.println("Multiplication: " + x * y);
		
		
		BiConsumer<Integer, Integer> divide = (x, y) -> System.out.println("Division: " + x / y);
		
		//Anche qui posso usare andThen per fare chaining
		multiply.andThen(divide).accept(7, 7);
		
	}

}
