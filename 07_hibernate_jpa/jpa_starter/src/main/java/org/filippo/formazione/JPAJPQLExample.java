package org.filippo.formazione;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class JPAJPQLExample {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();	
		
		// Get all the employees whose age > 25
		//TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.age > 25 order by e.age desc", Employee.class);
		//TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.name like %Bar%", 
				//Employee.class);
		//TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.age between 22 and 32", 
				//Employee.class);
		//Non serve fare un join con la tabella access card....
		//TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.card.isActive = true", 
				//Employee.class);
		//Volendo è comunque è possibile fare join
		
		
		//E se volessi recuperare solo il nome degli impiegati?
		//TypedQuery<String> query = entityManager.createQuery("select e.name from Employee e", 
				//String.class);
		//Ovviamente anche il tipo generico del result list cambia
		//List<String> resultList = query.getResultList();
		
		//E se volessi nome e età degli impiegati? Devo usare il tipo object
		//TypedQuery<Object[]> query = entityManager.createQuery("select e.name, e.age from Employee e", Object[].class);
		
		//List<Employee> resultList = query.getResultList();
		//Ogni elemento di questa lista è un array che contiene nome e età
		//List<Object[]> resultList = query.getResultList();
		//resultList.forEach(System.out::println);
		
		//E se volessi aggiungere parametri variabili?
		int minAge = 25;
		//TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.age > :minAge order by e.age desc", Employee.class);
		//query.setParameter("minAge", minAge);
		
		//Qui posso usare la namedQuery
		TypedQuery<Employee> query = entityManager.createNamedQuery("employeeNameAscAge", Employee.class);
		query.setParameter("age", minAge);
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
