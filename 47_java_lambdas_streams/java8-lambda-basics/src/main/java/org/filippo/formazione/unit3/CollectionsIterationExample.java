package org.filippo.formazione.unit3;

import java.util.Arrays;
import java.util.List;

import org.filippo.formazione.unit1.Person;

public class CollectionsIterationExample {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Foo", "Bar", 27),
				new Person("Baz", "Mu", 70),
				new Person("John", "Doe", 31),
				new Person("Prince", "Carl", 47)
				
				);
		
		
		//Ovviamente posso iterare sulla collezione con un for normale, un ciclo for in...Il punto è che il codice che scrivi controlla
		//Direttamente l'iterazione => external iteration.
		//Con Java 8 è possibile dire al jre di voler iterare sulla collezione, come avviene l'iterazione non mi interessa, itera in ogni caso su tutti gli elementi
		//QUesto permette al jdk varie ottimizzazioni tra cui il parallelismo
		//INTERNAL ITERATION e si esprime con....
		people.forEach(p -> System.out.println(p)); //Questo prende in input un Consumer => posso quindi passare una lambda!!!!
		System.out.println("******* Using Method Reference *************");
		//Posso anche esprimere la precedente lambda come un method reference
		people.forEach(System.out::println);
	}

}
