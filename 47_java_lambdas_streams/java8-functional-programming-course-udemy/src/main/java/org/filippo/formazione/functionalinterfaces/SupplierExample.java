package org.filippo.formazione.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import org.filippo.formazione.data.Student;
import org.filippo.formazione.data.StudentDataBase;

public class SupplierExample {
	
	
	
	
	public static void main(String[] args) {
		//Di fatto è l'opposto di Consumer, non prende in input nessun parametro e restituisce un out
		Supplier<Student> studentSupplier = () -> new Student("Adam",2,4.0,"male", Arrays.asList("swimming", "basketball","volleyball"));
		
		System.out.println(studentSupplier.get());
		
		Supplier<List<Student>> listSupplier = () -> StudentDataBase.getAllStudents();
		System.out.println(listSupplier.get());
	}

}
