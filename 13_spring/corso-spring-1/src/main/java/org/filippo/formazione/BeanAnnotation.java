package org.filippo.formazione;

import org.springframework.stereotype.Component;

@Component(value = "annot") //Qui specifico l'id altrimenti il default è il nome della classe senza maiuscola
public class BeanAnnotation {
	
	
	public void hello() {
		
		System.out.println("Hello From Annotation Bean!");
	}
}
