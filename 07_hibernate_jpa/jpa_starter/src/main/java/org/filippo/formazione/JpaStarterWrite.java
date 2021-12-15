package org.filippo.formazione;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterWrite {

	public static void main(String[] args) {
		
		  Employee e1 = new Employee(); //e1.setId(1); 
		  e1.setName("Foo Bar");
		  e1.setAge(31); e1.setSsn("1234"); 
		  e1.setDob(new Date());
		  e1.setType(EmployeeType.FULL_TIME);
		  
		  Employee e2 = new Employee(); //e2.setId(2); 
		  e2.setName("John Doe");
		  e2.setAge(23); e2.setSsn("12356"); 
		  e2.setDob(new Date());
		  e2.setType(EmployeeType.CONTRACTOR);
		  
//		  Employee e3 = new Employee(); //e3.setId(3); 
//		  e3.setName("Hello World");
//		  e3.setAge(19); e3.setSsn("3456"); 
//		  e3.setDob(new Date());
//		  e3.setType(EmployeeType.CONTRACTOR);
		  
		  
		  AccessCard c1 = new AccessCard();
		  c1.setIssuedDate(new Date());
		  c1.setActive(true);
		  c1.setFirmwareVersion("1.0.1");
		  
		  AccessCard c2 = new AccessCard();
		  c2.setIssuedDate(new Date());
		  c2.setActive(false);
		  c2.setFirmwareVersion("1.2.0");
		  
		  PayStub p1 = new PayStub();
		  p1.setPayPeriodStart(new Date());
		  p1.setPayperiodEnd(new Date());
		  p1.setSalary(1000);
		  p1.setEmployee(e1);
		  
		  PayStub p2 = new PayStub();
		  p2.setPayPeriodStart(new Date());
		  p2.setPayperiodEnd(new Date());
		  p2.setSalary(2000);
		  p2.setEmployee(e1);
		  
		  
		  EmailGroup g1 = new EmailGroup();
		  g1.setName("Company watercooler discussions");
		  
		  EmailGroup g2 = new EmailGroup();
		  g2.setName("Engineering");
		  
		  //List<PayStub> paystubs = new ArrayList<>();
		  //paystubs.add(p1);
		  //paystubs.add(p2);
		  
		  
		  e1.setCard(c1);
		  e2.setCard(c2);
		  
		  //Dato che Paystub ha gia un reference ad employee, perchè devo aggiungere anche qui la lista di paystub????
		  //JPA non avrebbe bisogno di settare anche la lista dall'altro lato della relazione ma non garantisce che effettuando
		  //La find di e1 restituisca la collezione corretta di paystubs.
		  //Quindi per mantenere consistenza lato Java è CONSIGLIATO aggiungere gli oggetti nella collezione lato one-to-many
		  
		  e1.addPayStub(p1);
		  e1.addPayStub(p2);
		  
		  g1.addEmployee(e1);
		  g1.addEmployee(e2);
		  
		  
		  e1.addEmailGroup(g1);
		  e1.addEmailGroup(g2);
		  
		  e2.addEmailGroup(g1);
		  
		  g2.addEmployee(e1);
		  
		  //Crea la factory dalla persistence unit myApp definita nel persistence.xml
		  EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp"); 
		  //Crea eManager dalla factory
		   EntityManager entityManager = entityManagerFactory.createEntityManager();
		  
		  EntityTransaction transaction = entityManager.getTransaction();
		  
		  //INSERT OPERATIONS
		  
		  //Apri la transazione 
		  transaction.begin();
		  
		  //Effettua linsert dell'entità e1 
		  entityManager.persist(e1);
		  entityManager.persist(e2);
		  //entityManager.persist(e3);
		  entityManager.persist(c1);
		  entityManager.persist(c2);
		  
		  entityManager.persist(p1);
		  entityManager.persist(p2);
		  
		  entityManager.persist(g1);
		  entityManager.persist(g2);
		  
		  //Committa la transazione 
		  transaction.commit();
		  
		  //Chiudo il persistence context 
		  entityManager.close();
		  entityManagerFactory.close();
		 
		
		
		/*
		 * //READ OPERATIONS EntityManagerFactory entityManagerFactory =
		 * Persistence.createEntityManagerFactory("myApp"); //Crea eManager dalla
		 * factory EntityManager entityManager
		 * =entityManagerFactory.createEntityManager();
		 * 
		 * //Non serve aprire transazioni con operazioni di lettura!!!! //Restituiscimi
		 * Employee con id = 1 Employee employee = entityManager.find(Employee.class,
		 * 1); Employee employee1 = entityManager.find(Employee.class, 2);
		 * System.out.println(employee); System.out.println(employee1); //Questa
		 * restituisce null Employee employee2 = entityManager.find(Employee.class, 3);
		 * System.out.println(employee2);
		 * 
		 * //UPDATE Operations 
		 * //Aggiorno l'oggetto stesso 
		 * employee.setAge(41);
		 * employee.setSsn("7777"); 
		 * //Apro una transazione EntityTransaction transaction
		 * = entityManager.getTransaction();
		 * 
		 * 
		 * //Apri la transazione transaction.begin();
		 * 
		 * //Effettua lupdate dell'entità employee che esiste già dato che la sua PK è
		 * gia presente nella table 
		 * entityManager.persist(employee);
		 * 
		 * //DELETE Operations //Uso l'entity che ho recuprato tramite find e chiamo il
		 * metodo remove entityManager.remove(employee1);
		 * 
		 * //Committa la transazione t 
		 * transaction.commit();
		 * 
		 * 
		 * 
		 * 
		 * //Chiudo il persistence context entityManager.close();
		 * entityManagerFactory.close(); entityManagerFactory.close();
		 */
	}

}
