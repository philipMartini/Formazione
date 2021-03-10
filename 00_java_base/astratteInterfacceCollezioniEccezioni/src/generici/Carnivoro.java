package generici;

public class Carnivoro<E extends Erbivoro> implements Animale<E> {

	@Override
	public void mangia(Erbivoro cibo) {
		System.out.println("Sto Mangiando " + cibo);

	}

}
