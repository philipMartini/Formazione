package org.filippo.formazione.unit1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Unit1Exercise {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Foo", "Bar", 27),
				new Person("Baz", "Mu", 70),
				new Person("John", "Doe", 31),
				new Person("Prince", "Carl", 47)
				
				);
		//Step 1 => sort list by lastName
		//Comparator è una functional interface quindi posso passare una lambda che di fatto implementa
		//Il metodo compare
		people.sort((p1, p2) -> p1.getLastName().compareToIgnoreCase(p2.getLastName()));
		
		//Step 2 create method that prints all elements in the list
		System.out.println("*****All people In the list orderd By Last Name*********");
		printListWithFilter(people, p -> true);
		
		//Step 3 Create a method that prints alla people that have last name beginning With C
		System.out.println("******All the people in the list with last name starting with C************");
		printListWithFilter(people, p -> p.getLastName().startsWith("C"));
		
		
		//Step 2 create method that prints all elements in the list
		System.out.println("*****All people In the list orderd By Last Name*********");
		printListConditionally(people, p -> true);
		
		//Step 3 Create a method that prints alla people that have last name beginning With C
		System.out.println("******All the people in the list with last name starting with C ************");
		printListConditionally(people, p -> p.getLastName().startsWith("C"));
		
		//Using consumer functional interface to print only the first names
		System.out.println("******All the people in the list with first name starting with F ************");
		performOnListConditionally(people, p -> p.getFirstName().startsWith("F"), p -> System.out.println(p.getFirstName()));
		

	}
	
	
	public static void printListWithFilter(List<Person> persons, ListPrintFilter filter) {
		
		for(Person p : persons) {
			if(filter.filter(p))
				System.out.println(p);
		}
		
	}
	
	//Posso sostituire la mia interfaccia custom con l'interfaccia funzionale fornita da java.lang.Function.Predicate<T>
public static void printListConditionally(List<Person> persons, Predicate<Person> filter) {
		
		for(Person p : persons) {
			if(filter.test(p))
				System.out.println(p);
		}
		
	}


//Se volessi aggiungere anche l'azione che il metodo deve fare.....Potrei ad esempio voler stampare su std::err e non in console
public static void performOnListConditionally(List<Person> persons, Predicate<Person> filter, Consumer<Person> consumer) {
	
	for(Person p : persons) {
		if(filter.test(p))
			consumer.accept(p);
	}
	
}
	
	
	@FunctionalInterface
	public interface ListPrintFilter {
		
		boolean filter(Person p);
	}
	
	
}


