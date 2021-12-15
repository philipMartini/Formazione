package org.filippo.formazione.streams;

import org.filippo.formazione.data.Student;
import org.filippo.formazione.data.StudentDataBase;

public class StreamsMapReduceExample {
	
	//Get total number of notebooks of every female student
	public static int getTotalNumberOfNotebooks() {
		return StudentDataBase.getAllStudents()
				.stream()
				.filter(s -> s.getGender().equals("female"))
				.map(Student::getNoteBooks)
				.reduce(0, (a, b) -> a + b); //Oppure .reduce(0, Integer::sum)	
	}
	
	public static void main(String[] args) {
		System.out.println(getTotalNumberOfNotebooks());

	}

}
