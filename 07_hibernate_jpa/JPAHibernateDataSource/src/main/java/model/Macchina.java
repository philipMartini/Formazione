package model;

import java.io.Serializable;

import javax.persistence.*;

@Entity (name="Macchine")
@Table(name = "macchine")
@NamedQuery(name="Macchine.findAll", query="SELECT m FROM Macchine m")
public class Macchina implements Serializable{


	private static final long serialVersionUID = 3886159453893541560L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_macchina")
	private int idMacchina;
	
	@Column(name="modello")
	private String modello;
	
	//@ManyToOne
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_persona")
	private Persona persona;
	
	public int getIdMacchina() {
		return idMacchina;
	}

	public void setIdMacchina(int idMacchina) {
		this.idMacchina = idMacchina;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public String getModello() {
		return modello;
	}
	
	public void setModello(String modello) {
		this.modello = modello;
	}
	
	
}
