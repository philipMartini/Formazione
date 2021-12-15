package org.filippo.formazione.streams_terminal;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import org.filippo.formazione.data.Student;
import org.filippo.formazione.data.StudentDataBase;

public class StreamsMinByMaxBy {
	
	//Lo studente con il gpa piu basso
	public static Optional<Student> minByExample(){
		return StudentDataBase.getAllStudents()
					.stream()
					.collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));
	}
	
	//Lo studente con il gpa piu alto
		public static Optional<Student> maxByExample(){
			return StudentDataBase.getAllStudents()
						.stream()
						.collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));
		}
	
	
	
	public static void main(String[] args) {
		System.out.println(minByExample());
		System.out.println(maxByExample());

	}

}
