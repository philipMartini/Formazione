package org.filippo.formazione.functionalinterfaces;

import java.util.function.Predicate;

import org.filippo.formazione.data.Student;
import org.filippo.formazione.data.StudentDataBase;

public class PredicateStudentExample {

	static Predicate<Student> p1 = s -> s.getGradeLevel() >= 3;
	static Predicate<Student> p2 = s -> s.getGpa() >= 3.9;
	
	
	public static void filterStudentByGradeLevel() {
		
		StudentDataBase.getAllStudents()
			.forEach(s -> {
					if(p1.test(s))
						System.out.println(s);
				});
	}
	
	
	public static void filterStudentByGradeLevelAndGpa() {
			
			StudentDataBase.getAllStudents()
				.forEach(s -> {
						if(p1.and(p2).test(s))
							System.out.println(s);
					});
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
