package org.filippo.formazione.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.filippo.formazione.data.Student;
import org.filippo.formazione.data.StudentDataBase;

public class StreamsComparatorExample {
	
	//Take all students put them in a list and sort them by name
	
	public static List<Student> sortStudentsByName(){
		return StudentDataBase.getAllStudents()
				.stream()
				.sorted(Comparator.comparing(Student::getName))
				.collect(Collectors.toList());
		
	}
	
	public static List<Student> sortStudentsByGPA(){
		return StudentDataBase.getAllStudents()
				.stream()
				.sorted(Comparator.comparing(Student::getGpa).reversed()) //In descending order
				.collect(Collectors.toList());
		
	}
	
	public static void main(String[] args) {
		System.out.println("************ Students sorted By NAme ********");
		sortStudentsByName().forEach(System.out::println);
		sortStudentsByGPA().forEach(System.out::println);

	}

}
