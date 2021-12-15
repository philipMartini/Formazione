package org.filippo.formazione;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaPersistenceContextDemo {
	
	
	public static void main(String[] args) {
		
		
		Employee e1 = new Employee(); 
	  e1.setName("Boo Far");
	  e1.setAge(33); 
	  e1.setSsn("7777"); 
	  e1.setDob(new Date());
	  e1.setType(EmployeeType.FULL_TIME);
		  
		  
		  
		 System.out.println("************************ Created Employee Instance");
		  
		  //Crea la factory dalla persistence unit myApp definita nel persistence.xml
		  EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp"); 
		  //Crea eManager dalla factory
		   EntityManager entityManager = entityManagerFactory.createEntityManager();
		  
		  EntityTransaction transaction = entityManager.getTransaction();
		  
		  //INSERT OPERATIONS
		  
		  //Apri la transazione 
		  transaction.begin();
		  
		  System.out.println("************************ Started Transaction");
		  
		  //Effettua linsert dell'entità e1 
		  entityManager.persist(e1);
		  //Di fatto la insert non è stata ancora effettuata.....
		  System.out.println("************************ After Persist Method Call");
		  
		  //....Quindi mi aspetterei di non trovarlo effettuando questa find....
		  Employee foundEmployee = entityManager.find(Employee.class, 1);
		  //In realtà viene trovato dato che JPA mantiene una sorta di Cache e effettua le insert nel punto ottimale
		  //Ossia alla commit della transazione
		  
		  //Oltretutto sono ESATTAMENTE lo stesso oggetto e infatti...
		  System.out.println(e1 == foundEmployee);//QUESTO RESTITUISCE TRUE
		  
		  //Committa la transazione...... ed è qui che avviene la insert
		  transaction.commit();
		  
		  System.out.println("************************ After transaction Commit");
		  //Chiudo il persistence context 
		  entityManager.close();
		  entityManagerFactory.close();
		 
		
		
		
	}

}
