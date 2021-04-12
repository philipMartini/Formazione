package model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the persone database table.
 * 
 */
@Entity (name="Persone")
@Table(name = "persone")
@NamedQuery(name="Persone.findAll", query="SELECT p FROM Persone p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_persona")
	private int idPersona;

	@Column(name="Cognome")
	private String cognome;

	@Column(name="Data_nascita")
	private Timestamp dataNascita;

	@Column(name="nome")
	private String nome;
	
	
	 @ManyToMany
	 @JoinTable(
	      name="persone_corsi",
	      joinColumns={@JoinColumn(name="id_persona", referencedColumnName="id_persona")},
	      inverseJoinColumns={@JoinColumn(name="id_corso", referencedColumnName="id_corso")})
	private Set<Corso> corsi;

	public Set<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(Set<Corso> corsi) {
		this.corsi = corsi;
	}

	//@OneToMany
	@OneToMany(mappedBy="persona")
	//@JoinTable(name = "persone_macchine", joinColumns = { @JoinColumn(name = "id_persona") }, inverseJoinColumns = { @JoinColumn(name = "id_macchina") })
	private Set<Macchina> macchine; 
	
	public Persona() {
		macchine = new HashSet<Macchina>();
	}

	public Set<Macchina> getMacchine() {
		return macchine;
	}

	public void setMacchine(Set<Macchina> macchine) {
		this.macchine = macchine;
	}

	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Timestamp getDataNascita() {
		return this.dataNascita;
	}

	public void setDataNascita(Timestamp dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}