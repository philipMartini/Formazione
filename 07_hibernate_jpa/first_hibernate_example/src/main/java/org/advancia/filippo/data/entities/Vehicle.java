package org.advancia.filippo.data.entities;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity

@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region="VehicleCache")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //Crea tabelle separate ripetendo tutti i campi ereditati
//@Inheritance(strategy = InheritanceType.JOINED) //Qui vengono tenuti record di tutti gli oggetti e nelle tabelle che ereditano
//Sono presenti la PK e la proprietà specifiche della classe fliglia => Per avere tutto basta fare un join
//Se non specifico questa annotazione viene adottata la single table strategy
//@DiscriminatorColumn(
		//name="VEHICLE_TYPE", discriminatorType = DiscriminatorType.STRING
		//)//Questa è la personalizzazione della colonna dtype (single col strategy)
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)//Questa proprietà è auto esplicativa
//Questa annotazione permette di creare le query che verranno effettuate su questa entità
//E richiamarle in tutta l'applicazione
@NamedQuery(name = "Vehicle.byId", query = "from Vehicle where vehicleId = ?") //IN HQL
//@NamedNativeQuery(name=Vehicle.byName, query="SELECT * FROM VEHICLES WHERE VEHICLE_NAME = ?", resultClass=Vehicle.class) In SQL

public class Vehicle {
	@Id
	//@GeneratedValue(strategy = GenerationType.TABLE)//Se usi table per class
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vehicleId;
	private String vehicleName;
	
	//MANY TO ONE RELATIONSHIP => la macchina DEVE essere associata ad almeno un utente
	//@ManyToOne
	//@JoinColumn(name = "USER_ID")
	//private UserDetails user;
	
	//RELAZIONE MANY_TO_MANY
	//@ManyToMany(mappedBy = "vehicles") //In questo modo non crea un'ulteriore tabella di mapping
	//private Collection<UserDetails> users = new ArrayList<>();
	
	
	
	/*public Collection<UserDetails> getUsers() {
		return users;
	}
	public void setUsers(Collection<UserDetails> users) {
		this.users = users;
	}*/
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleName=" + vehicleName + "]";
	}
	
	

}
