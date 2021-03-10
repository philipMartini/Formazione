package agendaStudente;

public class AgendaGiornaliera {
	
	private int giorno;
	private String docente;
	private Studente[] appuntamenti;
	
	
	public AgendaGiornaliera(String docente, int giorno, int numeroAppuntamenti){
		this.setDocente(docente);
		this.setGiorno(giorno);
		this.setInitAppuntamenti(numeroAppuntamenti);
	}
	
	public AgendaGiornaliera(String docente, int giorno){
		this(docente, giorno, 6);
	}
	
	public Studente getStudente(int slot){
		return this.appuntamenti[slot];
	}
	
	public boolean isLibero(int slot){
		if(slot >= 0 && slot < this.appuntamenti.length){
			return this.appuntamenti[slot] == null;
		}
		return false;
	}
	
	public boolean prenota(Studente studente){
		if(studente != null && this.esisteAppuntamento(studente)){
			for(int i = 0; i < this.appuntamenti.length; ++i){
				if(this.appuntamenti[i] == null){
					this.appuntamenti[i] = studente;
					return true;
				}
			}
			return false;
		}
		return false;
	}
	
	public boolean prenota(Studente studente, int orario){
		if(studente != null && this.appuntamenti[orario] == null && 
				this.esisteAppuntamento(studente)){
			this.appuntamenti[orario] = studente;
			return true;
		}
		return false;
	}
	
	public boolean annulla(Studente studente){
		if(studente != null && !this.esisteAppuntamento(studente)){
			for(int i = 0; i < this.appuntamenti.length; ++i){
				if(this.appuntamenti[i] != null && this.appuntamenti[i].equals(studente)){
					this.appuntamenti[i] = null;
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean esisteAppuntamento(Studente studente){
		/*Restituisce true se lo studente non ha prenotato un appuntamento*/
		for(int i = 0; i < this.appuntamenti.length; ++i){
			if(this.appuntamenti[i] != null && this.appuntamenti[i].equals(studente))
				return false;
		}
		return true;
	}
	private void setInitAppuntamenti(int numeroAppuntamenti) {
		this.appuntamenti = new Studente[numeroAppuntamenti];
		
	}

	private void setGiorno(int giorno) {
		this.giorno = giorno;
	}


	private void setDocente(String docente) {
		this.docente = docente;
	}


	public int getGiorno() {
		return giorno;
	}


	public String getDocente() {
		return docente;
	}


	public int getNumeroAppuntamentiGiornalieri(){
		return this.appuntamenti.length;
	}
	
	

}
