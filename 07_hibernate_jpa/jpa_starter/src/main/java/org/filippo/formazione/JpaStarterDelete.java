package org.filippo.formazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterDelete {

	public static void main(String[] args) {
		//Crea la factory dalla persistence unit myApp definita nel persistence.xml
		 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp"); 
		  //Crea eManager dalla factory
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		 //Richiedi la transazione all'entity manager
		 EntityTransaction transaction = entityManager.getTransaction();
		 
		 //Cancelliamo employee con id = 1
		 Employee emp1 = entityManager.find(Employee.class, 1);
		 
		 
		 //Apri una nuova transazione
		 transaction.begin();
		 
		//Di default il comportamento sulle delete è quello di rimuovere in cascata tutte le righe che contengono employee
		 //Ad esempio in una joinTable(ManyToMany). VIene però lanciata un'eccezione se esiste una relazione oneToMany
		 //Dato che JPA non sa se e come rimuovere le righe lato One della relationship che contentogono la FK dell'entità
		 //Che si vuole eliminare, per ottenere questo è necessario aggiungere il cascading 
		 entityManager.remove(emp1);
		
		 
		 
		 //Chiudi la transazione
		 transaction.commit();

	}

}
