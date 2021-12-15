package org.filippo.formazione.streams_terminal;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.filippo.formazione.data.Student;
import org.filippo.formazione.data.StudentDataBase;

public class StreamsPartioningByExample {
	
	//Simile alla group by ma accetta un predicato come input e partiziona l'insieme in true e false come keys della mappa
	public static Map<Boolean, List<Student>> partitioningBy_1() {
		return StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.partitioningBy( s -> s.getGpa() >= 3.8));
	}
	
	//Posso usare un Set come collector
	public static Map<Boolean, Set<Student>> partitioningBy_2() {
		return StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.partitioningBy( s -> s.getGpa() >= 3.8, Collectors.toSet()));
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
