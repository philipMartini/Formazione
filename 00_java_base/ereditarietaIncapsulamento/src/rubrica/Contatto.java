package rubrica;

public class Contatto {
	
	private String nome;
	private String cognome;
	private String numTel;
	
	public Contatto(){
		this.nome = "";
		this.cognome = "";
		this.numTel = "";
	}
	
	public Contatto(String nome, String cognome, String numTel){
		this.setNome(nome);
		this.setCognome(cognome);
		this.setNumTel(numTel);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numTel == null) ? 0 : numTel.hashCode());
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
		Contatto other = (Contatto) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numTel == null) {
			if (other.numTel != null)
				return false;
		} else if (!numTel.equals(other.numTel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contatto [nome=" + nome + ", cognome=" + cognome + ", numTel=" + numTel + "]";
	}
	
	

}
