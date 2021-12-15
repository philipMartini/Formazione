package org.filippo.formazione.streams_terminal;

import java.util.List;
import java.util.stream.Collectors;

import org.filippo.formazione.data.Student;
import org.filippo.formazione.data.StudentDataBase;

public class StreamsMappingExample {
	
	
	
	
	public static void main(String[] args) {
		List<String> collect = StudentDataBase.getAllStudents()
			.stream()
			.collect(Collectors.mapping(Student::getName, Collectors.toList())); //mappa i nomi degli studenti in una lista
		System.out.println(collect);
		
		//O equivalentement
		StudentDataBase.getAllStudents()
			.stream()
			.map(Student::getName)
			.collect(Collectors.toList());

	}

}
