package org.filippo.formazione;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "EMPLOYEE_DATA")
//Se avessi delle query che vengono chiamate ripetutamente su una certa entità è molto meglio usare le namedQueries
@NamedQuery(query="SELECT e FROM Employee e where e.age > :age ORDER BY e.name", name="employeeNameAscAge")
@NamedQuery(query="SELECT e FROM Employee e ORDER BY e.name", name="employeeNameAsc")
public class Employee {
	
	@Id
	//Se non voglio settare io a mano la PK, lascio al db il compito di farlo
	@GeneratedValue(strategy = GenerationType.AUTO)//Con AUTO lascio la politica di creazione in mano al db
										//Se uso SEQUENCE chiedo al db di creare una nuova sequenza legata alla tabella
	private int id;
	
	
	//Esplicitare il mapping dei dati primitivi e usa lo stesso nome del dato membro
	//@Basic
	//Usando questa annotazione posso specificare il nome della colonna e altre proprietà
	@Column(name="employee_name", unique = false)
	private String name;
	
	//insertable = false non permette di inserire il valore dell'età nella colonna age
	//updatable permette linserimento ma non lupdate
	//@Column(insertable = false)
	private int age;
	
	//Se due record avessero lo stesso ssn non sarebbero salvati nel db => viene lanciata un'eccezione
	@Column(unique = true, length = 10, nullable = false) //Length => varchar(10)
	private String ssn;
	
	//Con questa annotazione posso specificare il formato di data che desidero
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	//Di default le Enum vengono salvate con tipo intero, ma è possibile specificare l'uso della stringa con...
	//Da preferire è il mappaggio a stringa perchè disaccoppia l'ordinamento della ENUM dai valori inseriti in precedenza
	@Enumerated(EnumType.STRING)
	private EmployeeType type;
	
	//Esistono dati membro che non vogliamo salvare nel db, usa questa annotazione
	@Transient
	private String debugString;
	
	//Aggiungo qui la notazione per il tipo di relazione che voglio usare
	//In questo caso è una ONE-TO-ONE => ogni impiegato ha una acc card e ogni access card appartiene ad un solo impiegato
	@OneToOne(fetch = FetchType.LAZY) //Aspetta ad effettuare il fetching finche non avviene una chiamata al getter
	private AccessCard card;		//Sostanzialmente non viene effettuato alcun join finche non viene chiamato il getter
	
	
	//In questo caso vogliamo poter navigare la relazione anche lato Employee quindi aggiungiamo qui la collezione di Paystub
	@OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE) //Quando rimuovo employee vengono rimossi anche i Paystub associati con l'impiegato
	private List<PayStub> payStubs = new ArrayList<>();
	
	@ManyToMany
	//Come per Joincolumn posso editare le proprietà della jointable per le many to many
	//L'annotazione va usata dal lato in cui NON è presente la mapped by annotation
	//Posso anche settare il nome della colonna della prima foreign-key accedendo alla proprietà joinColumns
	//E settare il nome della seconda foreign key accedendo alla proprietà inverseJoinColumns
	@JoinTable(name = "emailGroupsSubscription", 
	joinColumns = @JoinColumn(name = "employee_id"),
	inverseJoinColumns = @JoinColumn(name = "email_group_id"))
	private List<EmailGroup> emailGroups = new ArrayList<>();
	
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public EmployeeType getType() {
		return type;
	}
	public void setType(EmployeeType type) {
		this.type = type;
	}
	public String getDebugString() {
		return debugString;
	}
	public void setDebugString(String debugString) {
		this.debugString = debugString;
	}
	
	
	public AccessCard getCard() {
		return card;
	}
	public void setCard(AccessCard card) {
		this.card = card;
	}
	
	
	
	public List<PayStub> getPayStubs() {
		return payStubs;
	}
	public void setPayStubs(List<PayStub> payStubs) {
		this.payStubs = payStubs;
	}
	
	public void addPayStub(PayStub payStub) {
		this.payStubs.add(payStub);
	}
	
	
	
	public List<EmailGroup> getEmailGroups() {
		return emailGroups;
	}
	public void setEmailGroups(List<EmailGroup> emailGroups) {
		this.emailGroups = emailGroups;
	}
	
	public void addEmailGroup(EmailGroup emailGroup) {
		this.emailGroups.add(emailGroup);
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", ssn=" + ssn + ", dob=" + dob + ", type="
				+ type + ", debugString=" + debugString + ", card=" + card + ", payStubs=" + payStubs + "]";
	}
	
	
	
	
	
	
	
	
	

}
