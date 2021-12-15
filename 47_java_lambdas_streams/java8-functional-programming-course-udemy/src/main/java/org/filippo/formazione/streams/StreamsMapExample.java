package org.filippo.formazione.streams;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.filippo.formazione.data.Student;
import org.filippo.formazione.data.StudentDataBase;

public class StreamsMapExample {
	
	
	public static Set<String> namesSet(){
		Set<String> studentList = StudentDataBase.getAllStudents().stream() //Stream<Student>
			//Getting a student as input -> Student name, Quindi stiamo trasformando Student in una stringa
			.map(Student::getName) //Stream<String>
			.map(String::toUpperCase) //Stream<String> qui non stiamo cambiando il tipo dello stream ma semplicemente effettua un'operazione
			.collect(Collectors.toSet()); //Sbatti gli elementi in questa collezione
		return studentList;
	}
	
	public static void main(String[] args) {
		//Collect all the students names and place them in a list
		System.out.println(namesSet());
	}

}
