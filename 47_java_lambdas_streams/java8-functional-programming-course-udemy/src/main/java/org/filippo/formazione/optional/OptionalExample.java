package org.filippo.formazione.optional;

import java.util.Optional;

import org.filippo.formazione.data.Student;
import org.filippo.formazione.data.StudentDataBase;

//Di fatto Optional sostituisce null e il vantaggio è che su un oggetto Optional vuoto si puo SEMPRE chiamare isPresent.
//Inoltre un optional ha un tipo e null puo essere qualsiasi cosa
public class OptionalExample {
	
	public static Optional<String> getStudentName() {
		Optional<Student> optionalStudent = Optional.ofNullable(StudentDataBase.studentSupplier.get()); //Optional wrappa l'oggetto
		if(optionalStudent.isPresent())
			return optionalStudent.map(Student::getName); //Optional<String>
		return Optional.empty(); //Optional Object with no value
	}
	
	public static void main(String[] args) {
		Optional<String> stringOptional = getStudentName();
		
		if(stringOptional.isPresent())
			System.out.println(stringOptional.get());
		else
			System.out.println("Name not Found");

	}

}
