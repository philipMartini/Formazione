package org.filippo.formazione.functionalinterfaces;

import java.util.function.Consumer;

import org.filippo.formazione.data.Student;
import org.filippo.formazione.data.StudentDataBase;

public class CunsumerExample {
	
	static Consumer<Student> c1 = st -> System.out.print("Name: "+st.getName());
	static Consumer<Student> c2 = st -> System.out.println("Activities: "+st.getActivities());
	
	//For each prende in input un Consumer<T>
	public static void printStudentsName() {
		StudentDataBase.getAllStudents()
			.forEach(st -> System.out.println(st.getName()));
	}
	
	//Stampa il nome è le attività di ogni studente usando consumer chaining
	public static void printStudentsNameAndActivities() {		
		
		StudentDataBase.getAllStudents()
			.forEach(c1.andThen(c2));
	}
	
	//Stampa il nome è le attività di ogni studente usando consumer chaining
		public static void printStudentsNameAndActivitiesCondition() {
			
			StudentDataBase.getAllStudents()
				.forEach(st -> {if(st.getGradeLevel() >= 3) 
										c1.andThen(c2).accept(st); });
		}
	
	//Consumer è un'interfaccia funzionale che si aspetta una lambda con un solo parametro che non restituisce nulla
	public static void main(String[] args) {
		Consumer<String> c1 = s -> System.out.println(s.toUpperCase());
		
		c1.accept("hello world!");
		
		printStudentsName();
		//printStudentsNameAndActivities();
		printStudentsNameAndActivitiesCondition();
	}

}
