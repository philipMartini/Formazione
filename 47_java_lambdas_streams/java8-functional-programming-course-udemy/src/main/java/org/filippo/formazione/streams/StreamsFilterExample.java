package org.filippo.formazione.streams;

import java.util.List;
import java.util.stream.Collectors;

import org.filippo.formazione.data.Student;
import org.filippo.formazione.data.StudentDataBase;

public class StreamsFilterExample {
	
	public static List<Student> filterStudents(){
		return StudentDataBase.getAllStudents()
				.stream()
				.filter(s -> s.getGender().equals("female"))
				.filter(s -> s.getGpa() >= 3.9)
				.collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		System.out.println(filterStudents());

	}

}
