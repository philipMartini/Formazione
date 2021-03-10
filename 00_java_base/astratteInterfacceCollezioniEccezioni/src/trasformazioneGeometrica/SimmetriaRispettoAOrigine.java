package trasformazioneGeometrica;

public class SimmetriaRispettoAOrigine extends TrasformazioneGeometrica {

	@Override
	public Punto trasforma(Punto punto) {
		return new Punto(punto.getEtichetta() ,- punto.getX(), - punto.getY());
	}

}
