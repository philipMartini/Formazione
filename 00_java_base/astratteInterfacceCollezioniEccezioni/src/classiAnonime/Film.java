package classiAnonime;

public class Film {
	
	private String nome;
	private String genere;
	private int mediaRecensioni;
	
	
	public Film(String nome, String genere, int mediaRecensioni){
		this.nome = nome;
		this.genere = genere;
		this.mediaRecensioni = mediaRecensioni;
	}


	public int getMediaRecensioni() {
		return this.mediaRecensioni;
	}


	@Override
	public String toString() {
		return "Film [nome=" + nome + ", genere=" + genere + ", mediaRecensioni=" + mediaRecensioni + "]";
	}
	
	
}
