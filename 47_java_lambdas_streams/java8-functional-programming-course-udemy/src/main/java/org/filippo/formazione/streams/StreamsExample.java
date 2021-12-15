package org.filippo.formazione.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.filippo.formazione.data.Student;
import org.filippo.formazione.data.StudentDataBase;

public class StreamsExample {
	
	public static void main(String[] args) {
		
		//Take all students with grade level >= 3 and GPA >= 3.9 Objects from db and place them in a Map<String, List>
		//Where key = studentName, List = studentActivities
		
		Map<String, List<String>> studentMap = StudentDataBase.getAllStudents().stream() //Crea lo stream
			.peek(s -> { System.out.println(s);}) //Debugging stream operations
			.filter(s -> s.getGradeLevel() >= 3) //Filtra gli elementi sulla base di questo preditcato => Se lo studente passa il predicato va avanti al prossimo step della pipeline
			.peek(s -> { System.out.println("After 1st Filter: " + s);})
			.filter(s -> s.getGpa() >= 3.9) // Filtra gli elementi sulla base di questo preditcato
			.peek(s -> { System.out.println("After 2nd Filter: " + s);})
			.collect(Collectors.toMap(Student::getName, Student::getActivities)); //Converti lo stream nell'output che vogliamo avere QUESTO METODO FA PARTIRE LA PIPELINE ED È QUINDI FONDAMENTALE
		System.out.println(studentMap);
	}
}
