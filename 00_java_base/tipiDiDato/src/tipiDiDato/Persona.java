package tipiDiDato;

public class Persona {
	
	public String nome;
	public String cognome;
	public int eta;
	
	//In questo caso non essendoci alcun costruttore dichiarato esplicitamente
	//Il compilatore fornirà quello di default
	
	public String dettagli(){
		return "nome: " + this.nome + " cognome: " + this.cognome + " eta: " + this.eta;
	}
}
