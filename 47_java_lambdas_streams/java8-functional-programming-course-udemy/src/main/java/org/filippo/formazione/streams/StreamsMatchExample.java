package org.filippo.formazione.streams;

import org.filippo.formazione.data.StudentDataBase;

public class StreamsMatchExample {
	
	public static boolean allMatchExample() {
		return StudentDataBase.getAllStudents()
				.stream()
				.allMatch(s -> s.getGpa() >= 3.9);
	}
	
	public static boolean anyMatchExample() {
		return StudentDataBase.getAllStudents()
				.stream()
				.anyMatch(s -> s.getGpa() >= 4.0);
	}
	
	public static boolean noneMatchExample() {
		return StudentDataBase.getAllStudents()
				.stream()
				.noneMatch(s -> s.getGpa() >= 4.1);
	}
	
	public static void main(String[] args) {
		System.out.println(allMatchExample());
		System.out.println(anyMatchExample());
	}

}
