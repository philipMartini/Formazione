package lettoreScrittore;

public class MyFile {
	
	private String nome;
	private int dimensione;
	
	public MyFile(String nome, int dimensione){
		this.nome = nome;
		this.dimensione = dimensione;
	}

	public String getNome() {
		return nome;
	}

	public int getDimensione() {
		return dimensione;
	}

	@Override
	public String toString() {
		return "MyFile [getNome()=" + getNome() + ", getDimensione()=" + getDimensione() + "]";
	}
	
	

}
