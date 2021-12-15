package org.filippo.formazione.streams_terminal;

import java.util.stream.Collectors;

import org.filippo.formazione.data.Student;
import org.filippo.formazione.data.StudentDataBase;

public class StreamsSummingAveregingExample {
	
	
	public static int sumAllNotebooksOfStudents() {
		return StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.summingInt(Student::getNoteBooks));
		
	}
	
	public static double avgAllNotebooksOfStudents() {
		return StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.averagingInt(Student::getNoteBooks));
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(sumAllNotebooksOfStudents());
		System.out.println(avgAllNotebooksOfStudents());
		

	}

}
