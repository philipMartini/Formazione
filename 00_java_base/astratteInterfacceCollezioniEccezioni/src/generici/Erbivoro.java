package generici;

public class Erbivoro<E extends Erba> implements Animale<E>, Cibo {

	@Override
	public String getColore() {
		return new String("Il colore dell'erbivoro");
	}

	@Override
	public void mangia(Erba cibo) {
		System.out.println("Sto mangiando: " + cibo);

	}

	@Override
	public String toString() {
		return "Erbivoro []";
	}
	
	

}
