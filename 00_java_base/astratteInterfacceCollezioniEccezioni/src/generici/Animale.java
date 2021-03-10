package generici;

public interface Animale<C extends Cibo> {
	
	public void mangia(C cibo);
}
