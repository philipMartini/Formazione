package org.filippo.formazione.optional;

import java.util.Optional;

import org.filippo.formazione.data.Student;
import org.filippo.formazione.data.StudentDataBase;

public class OptionalOrElseExample {
	
	
	public static String optionalOrElse() {
		Optional<Student> optionalStudent = Optional.ofNullable(StudentDataBase.studentSupplier.get());
		
		//Se trova un valore valido da map lo restituisce altrimenti restiuisce la stringa Default
		return optionalStudent.map(Student::getName).orElse("Default");
	}
	
	public static String optionalOrElseGet() {
		Optional<Student> optionalStudent = Optional.ofNullable(StudentDataBase.studentSupplier.get());
		
		//Se trova un valore valido da map lo restituisce altrimenti restiuisce la stringa Default usando una lambda
		return optionalStudent.map(Student::getName).orElseGet(() -> "Default");
	}
	
	public static String optionalOrElseThrow() {
		Optional<Student> optionalStudent = Optional.ofNullable(StudentDataBase.studentSupplier.get());
		
		//Se trova un valore valido da map lo restituisce altrimenti lancia l'eccezione .....
		return optionalStudent.map(Student::getName).orElseThrow(() -> new RuntimeException("No Data Available"));
	}
	
	public static void main(String[] args) {
		System.out.println(optionalOrElse());

	}

}
