package org.filippo.formazione;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class EmailGroup {
	
	@Id
	@GeneratedValue()
	private int id;
	private String name;
	
	//Ora bisogna dire a JPA la bidirezionalità della relazione per Employee e per EmailGroup.....
	//Altrimenti JPA crea 2 Join tables
	//Il fetching per le many-to-many è LAZY di default quindi la lista viene acceduta SOLO quando viene effettuata
	//La chiamata al metodo getter
	//Attenzione a settare EAGER come fetch type per le many to many, ad esempio in questo caso se anche il fetching su Paystub
	//Fosse EAGER si genererebbe un cascading di fetching di dati probabilmente non necessari
	@ManyToMany(mappedBy = "emailGroups")
	private List<Employee> employees = new ArrayList<>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public void addEmployee(Employee employee) {
		this.employees.add(employee);
	}
	
	
	

}
