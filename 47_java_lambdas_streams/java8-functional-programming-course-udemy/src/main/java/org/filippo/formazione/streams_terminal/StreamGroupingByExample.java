package org.filippo.formazione.streams_terminal;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.filippo.formazione.data.Student;
import org.filippo.formazione.data.StudentDataBase;

public class StreamGroupingByExample {
	
	//Group the studends based on genders => molto simile alla sql GROUP BY
	public static Map<String, List<Student>> groupStudentsByGender() {
		return StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.groupingBy(Student::getGender));
	}
	
	
	//Group the studends based on GPA and custom keys => molto simile alla sql GROUP BY 
		public static Map<String, List<Student>> groupStudentsByCustomizedKeys() {
			return StudentDataBase.getAllStudents()
					.stream()
					.collect(Collectors.groupingBy(s -> s.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE"));
		}
		
	//Gruppa gli studenti per grade level e all'interno del gruppo gruppali per secondo la lambda
	public static Map<Integer, Map<String, List<Student>>> twoLevelGrouping_1() {
		return StudentDataBase.getAllStudents()
			.stream()
			.collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.groupingBy(s -> s.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE")));
	}
	
	
	//Il numero di noteboos degli studenti gruppati per gradelevel
	public static Map<Integer, Integer> twoLevelGrouping_2() {
		return StudentDataBase.getAllStudents()
			.stream()
			.collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.summingInt(Student::getNoteBooks)));
	}
	
	
	public static LinkedHashMap<String, Set<Student>> threeArgumentGrouping() {
		return StudentDataBase.getAllStudents()
			.stream()						//Semplicmente faccio override del comportamento di defualt di gruopBy mettendo i collectors che voglio usare
			.collect(Collectors.groupingBy(Student::getName, LinkedHashMap::new, Collectors.toSet()));
	}
	
	//Calculate top/least gpa student in each grade
	public static Map<Integer, Optional<Student>> calculateTopGpaPerGradeOptional() {
		return StudentDataBase.getAllStudents()
			.stream()
			.collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.maxBy(Comparator.comparing(Student::getGpa))));
	}
	
	public static Map<Integer, Student> calculateTopGpaPerGrade() {
		return StudentDataBase.getAllStudents()
			.stream()
			.collect(Collectors.groupingBy(Student::getGradeLevel, 
					Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getGpa)), 
							Optional::get)));
	}
	
	public static void main(String[] args) {
		System.out.println(groupStudentsByGender());
		System.out.println(groupStudentsByCustomizedKeys());
		System.out.println(twoLevelGrouping_1());

	}

}
