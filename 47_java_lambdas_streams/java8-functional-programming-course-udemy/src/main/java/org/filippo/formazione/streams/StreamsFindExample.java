package org.filippo.formazione.streams;

import java.util.Optional;

import org.filippo.formazione.data.Student;
import org.filippo.formazione.data.StudentDataBase;

public class StreamsFindExample {
	
	//La vera differenza fra findAny e findFirst si vede con i parallel streams
	
	
	public static Optional<Student> findAnyStudentWithGPAGreaterThan(){
		return StudentDataBase.getAllStudents()
				.stream()
				.filter(s -> s.getGpa() >= 3.9)
				.findAny();
	}
	
	public static Optional<Student> findFirstStudentWithGPAGreaterThan(){
		return StudentDataBase.getAllStudents()
				.stream()
				.filter(s -> s.getGpa() >= 3.9)
				.findFirst();
	}
	
	
	public static void main(String[] args) {
		System.out.println(findAnyStudentWithGPAGreaterThan());
		System.out.println(findFirstStudentWithGPAGreaterThan());

	}

}
