package org.filippo.formazione;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PayStub {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date payPeriodStart;
	private Date payperiodEnd;
	private float salary;
	
	//Nel caso della ManyToOne è ONE che possiede la relation
	
	@ManyToOne
	//Con questa annotazione posso manipolare la colonna della foreign key di impiegato in Paystub
	@JoinColumn(name = "EMPLOYEE")
	private Employee employee;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getPayPeriodStart() {
		return payPeriodStart;
	}
	public void setPayPeriodStart(Date payPeriodStart) {
		this.payPeriodStart = payPeriodStart;
	}
	public Date getPayperiodEnd() {
		return payperiodEnd;
	}
	public void setPayperiodEnd(Date payperiodEnd) {
		this.payperiodEnd = payperiodEnd;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "PayStub [id=" + id + ", payPeriodStart=" + payPeriodStart + ", payperiodEnd=" + payperiodEnd
				+ ", salary=" + salary + "]";
	}
	
	
	

}
