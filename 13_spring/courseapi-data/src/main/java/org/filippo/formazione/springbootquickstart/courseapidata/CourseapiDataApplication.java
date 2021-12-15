package org.filippo.formazione.springbootquickstart.courseapidata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Aggiungendo la dipendeza di spring-actuator si aggiunge un endopoint di monitoring 
// ad esempio /health, /beans


@SpringBootApplication
public class CourseapiDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseapiDataApplication.class, args);
	}

}
