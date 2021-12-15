package org.filippo.formazione.functionalinterfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.filippo.formazione.data.Student;
import org.filippo.formazione.data.StudentDataBase;

public class FunctionStudentsExample {
	
	static Function<List<Student>, Map<String, Double>> studentFunction = 
			students -> {
				Map<String, Double> studentGradeMap = new HashMap<>();
				
				students.forEach(s -> {
					if(PredicateStudentExample.p1.test(s))
						studentGradeMap.put(s.getName(), s.getGpa());
						});
				
				return studentGradeMap;
			};
	
	
	public static void main(String[] args) {
		System.out.println(studentFunction.apply(StudentDataBase.getAllStudents()));

	}

}
