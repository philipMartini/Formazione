package org.filippo.formazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterUpdate {

	public static void main(String[] args) {
		//Crea la factory dalla persistence unit myApp definita nel persistence.xml
		 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp"); 
		  //Crea eManager dalla factory
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		 //Richiedi la transazione all'entity manager
		 EntityTransaction transaction = entityManager.getTransaction();
		 
		 //Aggiungiamo la subscribion di employee 2 al mailing group 8.....
		 Employee emp1 = entityManager.find(Employee.class, 2);
		 EmailGroup emailGroup = entityManager.find(EmailGroup.class, 8);
		 
		 emp1.addEmailGroup(emailGroup);
		 emailGroup.addEmployee(emp1);
		 
		 //Apri una nuova transazione
		 transaction.begin();
		 
		 //....Ora non resta che effettuare la persist delle due entity aggiornate
		 entityManager.persist(emp1);
		 entityManager.persist(emailGroup);
		
		 
		 
		 //Chiudi la transazione
		 transaction.commit();
		 

	}

}
