package org.filippo.formazione.optional;

import java.util.Optional;

import org.filippo.formazione.data.Bike;
import org.filippo.formazione.data.Student;
import org.filippo.formazione.data.StudentDataBase;

public class OptionalMapFlatMap {
	
	public static void optionalFilterExample() {
		Optional<Student> optional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
		
		//ANche gli optional hanno i filter
		optional.filter(s -> s.getGpa() >= 3.5)
				.ifPresent(s -> System.out.println(s));
	}
	
	public static void optionalMapExample() {
		Optional<Student> optional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
		
		//ANche gli optional hanno map
		if(optional.isPresent()) {
			System.out.println(optional.filter(s -> s.getGpa() >= 3.5) 
				.map(Student::getName));
			
		}
	}
	//Voglio avere la bike name
	public static void optionalFlatMapExample() {
		Optional<Student> optional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
		
		Optional<String> bikeName = optional
										.filter(s -> s.getGpa() >= 3.5) //Essendo bike un altro optional devo usare flatMAp
										.flatMap(Student::getBike)//Optional<Bike>
										.map(Bike::getName);//Optional<String>
		bikeName.ifPresent(name -> System.out.println(name));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
