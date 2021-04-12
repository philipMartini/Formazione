package org.advancia.filippo.data.valueObjects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//Con l'approccio del value object le colonne di Address vengono aggiunte a USerDetails
//Come se fossero dati membro della classe stessa. Questo perchè
//Non ha senso avere un'entità a parte per Address, questa non sarà una tabella del db
//Ma i suoi dati devono essere comunque salvati.
@Embeddable
public class Address {
	
	@Column(name = "STREET_NAME")
	private String street;
	@Column(name = "CITY_NAME")
	private String city;
	@Column(name = "STATE_NAME")
	private String state;
	@Column(name = "PINCODE")
	private String pincode;
	
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}
	
	
	

}
