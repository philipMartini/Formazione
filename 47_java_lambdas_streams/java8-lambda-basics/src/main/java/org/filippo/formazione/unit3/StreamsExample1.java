package org.filippo.formazione.unit3;

import java.util.Arrays;
import java.util.List;

import org.filippo.formazione.unit1.Person;

public class StreamsExample1 {

	public static void main(String[] args) {
		

		List<Person> people = Arrays.asList(
				new Person("Foo", "Bar", 27),
				new Person("Baz", "Mu", 70),
				new Person("John", "Doe", 31),
				new Person("Prince", "Carl", 47)
				
				);
		
		//Supponiamo di voler ricavare una lista che contiene tutte le persone che hanno il cognome che inizia per C
		//Si potrebbe iterare sulla lista aggiungere le persone corrette al risultato e poi stampare.....
		//Le operazioni avvengono sequenzialmente, con gli stream questo non è valido e per ogni lemento della lista
		//Le operazioni richieste vengono effettuate subito per ogni elemento => Quindi aggiunta alla lista risultante e stampa elemento
		people.stream() //Questo restituisce uno stream di persone su cui le operation agiranno
			.filter(p -> p.getFirstName().startsWith("F")) //Con filter Predicate posso filtrare gli elementi della collezione
			.forEach(p -> System.out.println(p.getFirstName())); //Questa ops è necessara a chiudere lo stream
		
		//In pratica posso aggiungere operation a piacimento su ogni elemento della collezione non scrivendo un loop complesso o peggio ancora piu loop
		
		int count = (int) people.stream()
			.filter(p -> p.getLastName().startsWith("C"))
			.count(); //Altra operazione di chiusura dello stream
		System.out.println(count);
	
	}

}
