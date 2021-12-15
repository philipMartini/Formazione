package org.filippo.formazione.functionalinterfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import org.filippo.formazione.data.Student;
import org.filippo.formazione.data.StudentDataBase;

public class BiFunctionExample {
	
	//Uguale a function ma accetta due parametri e ne restituisce uno
	static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunctionStudents = 
			(students, predicate) -> {
				
				Map<String, Double> studentsGradeMap = new HashMap<>();
				students.forEach(s -> {
					if(predicate.test(s))
						studentsGradeMap.put(s.getName(), s.getGpa());
					
				});
				return studentsGradeMap;
			};
	
	
	public static void main(String[] args) {
		biFunctionStudents.apply(StudentDataBase.getAllStudents(), PredicateStudentExample.p1);

	}

}
