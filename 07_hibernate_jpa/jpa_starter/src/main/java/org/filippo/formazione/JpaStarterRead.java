package org.filippo.formazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaStarterRead {

	public static void main(String[] args) {
		
		//Crea la factory dalla persistence unit myApp definita nel persistence.xml
		 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp"); 
		  //Crea eManager dalla factory
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		 //Di default viene effettuato il fetching di tutte le entità in relazione con Employee
		 //IN questo caso Access card => EAGER FETCHING
		 Employee e1 = entityManager.find(Employee.class, 1);
		 //Di default il fetching sulle relazioni OnetoMany ManyToOne è LAZY di default
		 System.out.println(e1.getPayStubs());
		 
		 
		 
		
	}

}
