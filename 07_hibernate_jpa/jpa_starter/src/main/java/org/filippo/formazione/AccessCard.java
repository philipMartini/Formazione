package org.filippo.formazione;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity	
public class AccessCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date issuedDate;	
	private boolean isActive;
	private String firmwareVersion;
	
	@OneToOne(mappedBy = "card") //Effettuo il mappaggio della relationship anche lato card, e in questo caso è neccessario dire a JPA
	//Che questo è semplicmente l'altro lato del mappaggio della relazione presente in Employee
	//Quindi si usa mappedBy proprio per dire di non effettuare il fetching di card in employee perchè card è la entity stessa.
	private Employee owner;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getFirmwareVersion() {
		return firmwareVersion;
	}
	public void setFirmwareVersion(String firmwareVersion) {
		this.firmwareVersion = firmwareVersion;
	}
	@Override
	public String toString() {
		return "AccessCard [id=" + id + ", issuedDate=" + issuedDate + ", isActive=" + isActive + ", firmwareVersion="
				+ firmwareVersion + "]";
	}
	
	
	

}
