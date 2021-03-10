package menuPiatto;

public class Piatto {
	
	public static final String PRIMO = "primo";
	public static final String SECONDO = "secondo";
	public static final String DOLCE = "dolce";
	private String categoria;
	private String nome;
	
	
	public Piatto(){
		this.categoria = "";
		this.nome = "";
	}
	
	public Piatto(String categoria, String nome){
		//La categoria può appartenere ad uno dei tre valori permessi
		if(categoria.equals(PRIMO) || categoria.equals(SECONDO) || categoria.equals(DOLCE))
			this.categoria = categoria;
		else
			this.categoria = "";
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Piatto other = (Piatto) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Piatto [categoria=" + categoria + ", nome=" + nome + "]";
	}
	
	
	
}
