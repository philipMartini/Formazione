package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity (name="Corsi")
@Table(name = "corsi")
@NamedQuery(name="Corsi.findAll", query="SELECT c FROM Corsi c")
public class Corso implements Serializable{


	private static final long serialVersionUID = -94024634956615516L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_corso")
	private int idCorso;
	
	
	@Column(name="descrizione")
	private String descrizione;
	
	@ManyToMany(mappedBy="corsi")
	private Set<Persona> persone;
	
	public Set<Persona> getPersone() {
		return persone;
	}
	
	public void setPersone(Set<Persona> persone) {
		this.persone = persone;
	}
	
	public int getIdCorso() {
		return idCorso;
	}
	
	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
}
