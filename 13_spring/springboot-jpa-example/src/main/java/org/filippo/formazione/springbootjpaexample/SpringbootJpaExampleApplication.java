package org.filippo.formazione.springbootjpaexample;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

import org.filippo.formazione.springbootjpaexample.model.Employee;
import org.filippo.formazione.springbootjpaexample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement //Questo dice al container di gestire la transazioni
public class SpringbootJpaExampleApplication {
	
//	//Facciamo inj di EntityMangerFact dalla persistence unit definita
//	@PersistenceUnit
//	private EntityManagerFactory emf;
//	
//	//Posso fare inj dell entityManager direttamente
//	@PersistenceContext(type = PersistenceContextType.EXTENDED) //Se specifico questo tipo dico al container che mi occupo io di gestire a mano le transazioni
//	private EntityManager em; //ATTENZIONE QUESTA ISTANZA INIETTATA NON È THREAD SAFE PER LA GESTIONE DELLE TRANSAZIONI!!!!!!!
//								//Infatti lo spring container non lo permette => usalo per le read operations
//	
	
	//Usando la CrudRepo non devo gestire direttamnete EMF e EM mi basta fare injection della repository
	@Autowired
	private EmployeeRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaExampleApplication.class, args);
	}
	
	
	//Lancia questo metodo dopo la fase di inizializzazione del container
	@PostConstruct
	public void start() {
		
		//EntityManager writeEm = emf.createEntityManager();
		
		Employee e = new Employee();
		e.setAge(20);
		e.setName("Foo Bar");
		e.setSsn("1234");
		e.setDob(new Date());
//		
//		EntityTransaction transaction = writeEm.getTransaction();
//		transaction.begin();
//			writeEm.persist(e);
//		transaction.commit();
//		writeEm.close();
//		
//		System.out.println(this.em.find(Employee.class, 1));
		
		this.repository.save(e);
		System.out.println(this.repository.findById(1).get());
		
	}
	
	//Gestione delle transazioni in springboot jpa
	//In questo modo il metodo viene gestito in una transazione
	//Di default il container fa rollback se viene lanciata una qualsiasi ecc
	//Ma posso specificare il tipo di eccezione che triggera il rollback
	//QUesta annotazione permette di gestire la correattamente transaction propagation
	//Posso aprire anche una transazione per operazioni di read specificando readOnly = true => non blocca altre operazioni di write su altre entità
	@Transactional(value = Transactional.TxType.MANDATORY)
	private void updateEmployee(Employee employee, String updatedName) {
		employee.setName(updatedName);
		this.repository.save(employee);
	}
	
	//Transaction propagation
	//Supponiamo di avere questo metodo
	//In questo caso il metodo chiamante ha già aperto una transazione
	//Ma il chiamato aprendone a sua volta un'altra chiude la prima
	//Lasciandolo senza gestione appropriata. Questo avviene di defalt.
	//Noi vorremmo che SE il chiamante non ha aperto una nuova transazione allora il chiamato
	//Annotato con transactional la apre, altrimenti se anche il chiamante ne ha aperta una
	//Allora il chiamato NON deve aprire un'altra transazione
	@Transactional
	private void updateEmployeeAndAccessCard(Employee e, String name) {
		this.updateEmployee(e, name);
		accessCardRepository.save(acc)
	}
}
