package org.filippo.formazione.streams;

import java.util.List;
import java.util.stream.Collectors;

import org.filippo.formazione.data.Student;
import org.filippo.formazione.data.StudentDataBase;

public class StreamsFlatMapExample {
	
	//FlatMap viene usato quando gli elementi dello stream sono a loro volta delle collezioni
	//In questo caso vogliamo mettere in una lista tutte le attività di tutti gli studenti
	public static List<String> getAllStudentsActivites(){
		List<String> studentsActivities = StudentDataBase.getAllStudents().stream() //Stream<Student>
				.map(Student::getActivities)//Stream<List<String>>
				.flatMap(List::stream) //Stream<String>
			.collect(Collectors.toList());
		return studentsActivities;
	}
	
	//Return all students activities with NO duplicates sorted
	public static List<String> getAllStudentsActivitesNoDuplicates(){
		List<String> studentsActivities = StudentDataBase.getAllStudents().stream() //Stream<Student>
				.map(Student::getActivities)//Stream<List<String>>
				.flatMap(List::stream) //Stream<String>
				.distinct()
			.collect(Collectors.toList());
		return studentsActivities;
	}
	
	//Return all students activities with NO duplicates sorted
		public static List<String> getAllStudentsActivitesNoDuplicatesSorted(){
			List<String> studentsActivities = StudentDataBase.getAllStudents().stream() //Stream<Student>
					.map(Student::getActivities)//Stream<List<String>>
					.flatMap(List::stream) //Stream<String>
					.distinct()
					.sorted()
				.collect(Collectors.toList());
			return studentsActivities;
		}
	
	//Return all the number students activities with NO duplicates 
		public static long getNumberOfStudentsActivitesNoDuplicates(){
			long count = StudentDataBase.getAllStudents().stream() //Stream<Student>
					.map(Student::getActivities)//Stream<List<String>>
					.flatMap(List::stream) //Stream<String>
					.distinct() 
					.count();// long
			return count;
		}
	
	
	public static void main(String[] args) {
		
		System.out.println(getAllStudentsActivites());
	}
}
