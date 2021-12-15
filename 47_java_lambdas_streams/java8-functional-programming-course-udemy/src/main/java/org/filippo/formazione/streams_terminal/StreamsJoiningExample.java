package org.filippo.formazione.streams_terminal;

import java.util.stream.Collectors;

import org.filippo.formazione.data.Student;
import org.filippo.formazione.data.StudentDataBase;

public class StreamsJoiningExample {
	
	public static String joining_1() {
		return StudentDataBase.getAllStudents()
				.stream()
				.map(Student::getName)
				.collect(Collectors.joining()); //Mergia tutte le stringhe presenti nello stream in un'unica stringa
	}
	
	
	public static String joining_2() {
		return StudentDataBase.getAllStudents()
				.stream()
				.map(Student::getName)
				.collect(Collectors.joining("-")); //Mergia tutte le stringhe presenti nello stream in un'unica stringa separati da -
	}
	
	public static String joining_3() {
		return StudentDataBase.getAllStudents()
				.stream()
				.map(Student::getName)
				.collect(Collectors.joining("-","(",")")); //Mergia tutte le stringhe presenti nello stream in un'unica stringa separati da -
	}														//Metti ( all'inizio e ) alla fine
	
	public static void main(String[] args) {
		System.out.println(joining_1());
		System.out.println(joining_2());
		System.out.println(joining_3());
	}

}
