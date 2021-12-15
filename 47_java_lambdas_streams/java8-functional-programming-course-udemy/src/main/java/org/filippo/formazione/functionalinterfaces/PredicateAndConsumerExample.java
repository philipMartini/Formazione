package org.filippo.formazione.functionalinterfaces;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.filippo.formazione.data.Student;
import org.filippo.formazione.data.StudentDataBase;

public class PredicateAndConsumerExample {
	
	
	Predicate<Student> p1 = s -> s.getGradeLevel() >= 3;
	Predicate<Student> p2 = s -> s.getGpa() >= 3.9;
	BiConsumer<String, List<String>> biConsumer = (name, activities) -> System.out.println(name + " " + activities);
	
	//Unica differenza con Predicate è che BiPred prende due parametri in input
	BiPredicate<Integer, Double> biPredicate = (gradeLevel, gpa) -> gradeLevel >= 3 && gpa >= 3.9;
	
	Consumer<Student> studentConsumer = s -> {
		
		//if(p1.and(p2).test(s)) Oppure con il biPredicate
		if(biPredicate.test(s.getGradeLevel(), s.getGpa()))
			biConsumer.accept(s.getName(), s.getActivities());
	};
	
	
	
	
	public void printNameAndActivities(List<Student> students) {
		students.forEach(studentConsumer);
	}
	
	public static void main(String[] args) {
		PredicateAndConsumerExample example = new PredicateAndConsumerExample();
		example.printNameAndActivities(StudentDataBase.getAllStudents());
	}

}
