package org.filippo.formazione.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.filippo.formazione.data.Student;
import org.filippo.formazione.data.StudentDataBase;

public class StreamsReduceExample {
	
	
	//VOglio la moltiplicazione dei valori nella lista
	
	public static int performMultiplication(List<Integer> integerList) {
		return integerList
			.stream()
			//Initial value/Accumulator and operation to perform between accumulator and stream elements
			//a=1, b=1 (from stream) => result 1 is returned
			//a=1 b=3 (from stream) => result 3 is returned
			//a=3 b= 5 (from stream) >= result 15 is returned
			//a=15 b=7 (from stream) >= result 105 i returned
			.reduce(1, (a, b) ->  a*b);
	}
	
	public static Optional<Integer> performMultiplicationNoInitSpecify(List<Integer> integerList) {
		return integerList
			.stream()
			.reduce((a, b) ->  a*b);
	}
	
	public static Optional<Student> getHighestGPAStudent(){
		return StudentDataBase.getAllStudents()
			.stream()
			.reduce((s1, s2) -> s1.getGpa() > s2.getGpa() ? s1 : s2); //Di fatto viene accumulato lo studente con il GPA piu alto	
																		//E confrontato con i nuovi valori dello stream
	}
	
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,3,5,7);
		System.out.println(performMultiplication(numbers));
		System.out.println(performMultiplicationNoInitSpecify(numbers).get());
		System.out.println(performMultiplicationNoInitSpecify(new ArrayList<Integer>()).isPresent());
		
		Optional<Student> studentOpt = getHighestGPAStudent();
		if(studentOpt.isPresent())
			System.out.println(studentOpt.get());
	}

}
