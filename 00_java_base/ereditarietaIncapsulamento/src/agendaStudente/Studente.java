package agendaStudente;

public class Studente {
	
	private String cognome;
	private int matricola;
	
	public Studente(String cognome, int matricola){
		this.setCognome(cognome);
		this.setMatricola(matricola);
	}
	

	private void setCognome(String cognome) {
		this.cognome = cognome;
	}



	private void setMatricola(int matricola) {
		this.matricola = matricola;
	}


	public String getCognome() {
		return cognome;
	}

	public int getMatricola() {
		return matricola;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + matricola;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		if (matricola != other.matricola)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Studente [cognome=" + cognome + ", matricola=" + matricola + "]";
	}
	
	
	

}
