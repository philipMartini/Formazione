package trasformazioneGeometrica;

public class Traslazione extends TrasformazioneGeometrica {
	
	private int deltaX;
	private int deltaY;
	
	
	public Traslazione(int deltaX, int deltaY){
		super();
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}

	@Override
	public Punto trasforma(Punto punto) {
		return new Punto(punto.getEtichetta(), punto.getX() + this.deltaX, punto.getY() + this.deltaY);
	}

}
