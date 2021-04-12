package org.advancia.filippo.data.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="USER_DETAILS") //Mappa questa classe alla tabella USER_DETAILS
//@Table(name = "USER_DETAILS") //Questo modifica il nome della tabella e non della entity
public class UserDetails {
	
	@Id //Questa è la PK (Surrogate key) e sarebbe ottimo se Hibernate pensasse
			//Alla generazione dei valori unici
	@GeneratedValue(strategy = GenerationType.AUTO) //Questo permette ad Hibernate di generare la surrogate Pk in automatico
	@Column(name="USER_ID")
	//Se la PK fosse un embedded Obj usa @EmbeddedId
	private int userId;
	
	@Column(name = "USER_NAME") //Questo dato membro è mappato alla colonna USER_NAME
	@Basic //Applica la conversione di tipo di default
	private String userName;
	
	//RELAZIONE ONE_TO_ONE => un user ha una sola macchina, ogni macchina ha un solo user
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "VEHICLE_ID")
	//private Vehicle vehicle;
	
	//RELAZIONE ONE_TO_MANY => un user ha 0 o piu macchine, 
	//@OneToMany(mappedBy = "user",cascade =  CascadeType.ALL) //Specificando mappedBy non viene creata
	//l'ulteriore tabella per l'associazione user <-> veicolo ma viene usato il dato membro
	//user di veicolo come FK
	//Viene creata la tabella che associa gli utenti alle macchine
	/*@JoinTable(name="USER_VEHICLE", joinColumns = @JoinColumn(name = "USER_ID"), 
			inverseJoinColumns = @JoinColumn(name="VEHICLE_ID"))*/
	
	
	//RELAZIONE MANY_TO_MANY
	//@ManyToMany(cascade = CascadeType.ALL)
	private Collection<Vehicle> vehicles = new ArrayList<>();
	
	/*@Temporal(TemporalType.DATE)//LA colonna  avrà solo la data non il timestamp
	private Date joinedDate;
	
	//@Transient Questo dice a Hib di non aggiungere questa colonna
	//Proviamo a rendere address una classe a parte....Non come entity ma come value object
	@Embedded
	@AttributeOverrides({
		//Nome attributo classe e override del nome della colonna per questo embedded obj
		@AttributeOverride(name = "street", column = @Column(name = "HOME_STREET_NAME")),
		@AttributeOverride(name = "city", column = @Column(name = "HOME_CITY_NAME")),
		@AttributeOverride(name = "state", column = @Column(name = "HOME_STATE_NAME")),
		@AttributeOverride(name = "pincode", column = @Column(name = "HOME_PINCODE"))
			
	}
	)
	private Address homeAddress;
	
	//E se volessi aggiungere un altro adress??
	@Embedded
	private Address officeAddress;*/
	
	/*@Lob //Dico a Hiber che questo è un LargeObject e non siamo limitati a varchar(2555)
	private String description;*/
	
	/*//Set è una delle collezioni supportate da Hibernate
	//Il fetch è lazy di default, EAGER recupera TUTTO l'oggetto nel proxy alla prima Get
	@ElementCollection(fetch = FetchType.EAGER) //Verrà generata una tabella a parte con gli indirizzi e userId che farà da FK
						//Il numero di record della nuova tabella è dato dagli elementi della collezione
	@JoinTable(name = "USER_ADDRESS", //Modifico il nome della tabella
				joinColumns = @JoinColumn(name="USER_ID"))//Modifico il nome della FKs
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")//Generator per la la PK
	@CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type = "long"))//Definisco una PK per la tabella
	private Collection<Address> listOfAddresses = new ArrayList<>();*/
	
	
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/*public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	*/
	
	
	
	
	
	
	
}
