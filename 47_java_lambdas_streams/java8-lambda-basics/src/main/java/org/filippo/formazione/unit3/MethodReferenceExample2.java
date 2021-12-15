package org.filippo.formazione.unit3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.filippo.formazione.unit1.Person;


public class MethodReferenceExample2 {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Foo", "Bar", 27),
				new Person("Baz", "Mu", 70),
				new Person("John", "Doe", 31),
				new Person("Prince", "Carl", 47)
				
				);
		
		
		
		//Using consumer functional interface to print only the first names
		System.out.println("******All the people in the list with first name starting with F ************");
		//performOnListConditionally(people, p -> p.getFirstName().startsWith("F"), p -> System.out.println(p.getFirstName()));
		
		//Se volessi usare un method reference in questo caso?????
		performOnListConditionally(people, p -> true, System.out::println);// quando hai questa struttura p -> method(p) puoi sostituire con method reference
	}
	
	
	


	//Se volessi aggiungere anche l'azione che il metodo deve fare.....Potrei ad esempio voler stampare su std::err e non in console
	public static void performOnListConditionally(List<Person> persons, Predicate<Person> filter, Consumer<Person> consumer) {
		
		for(Person p : persons) {
			if(filter.test(p))
				consumer.accept(p);
		}
	
}
	
	
	
}
