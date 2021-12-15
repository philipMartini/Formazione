package org.filippo.formazione.streams_terminal;

import java.util.stream.Collectors;

import org.filippo.formazione.data.StudentDataBase;

public class StreamsCountingExample {
	
	public static long count() {
		return StudentDataBase.getAllStudents()
				.stream()
				.filter(s -> s.getGpa() >= 3.9)
				.collect(Collectors.counting());
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(count());

	}

}
