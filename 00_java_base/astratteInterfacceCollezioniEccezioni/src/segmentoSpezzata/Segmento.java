package segmentoSpezzata;

public class Segmento extends Linea {
	
	public Segmento(Punto inizio, Punto fine) throws LineaNonValidaException{
		super(inizio, fine);
	}
	
	public Segmento(int ix, int iy, int fx, int fy) throws LineaNonValidaException{
		this(new Punto(ix, iy), new Punto(fx, fy));
	}

	@Override
	public double getLunghezza() {
		return Math.sqrt(Math.pow(this.getInizio().getX() - this.getFine().getX(), 2) + 
				Math.pow(this.getInizio().getY() - this.getFine().getY(), 2));
	}

	@Override
	public Linea[] getStruttura() {
		Linea[] result = new Linea[1];
		result[0] = this;
		return result;
	}

}
