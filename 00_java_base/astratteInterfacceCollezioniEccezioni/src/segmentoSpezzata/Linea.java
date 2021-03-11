package segmentoSpezzata;

public abstract class Linea {
	
	private Punto inizio;
	private Punto fine;
	
	public Linea(Punto inizio, Punto fine) throws LineaNonValidaException{
		if(inizio == null || fine == null || inizio.equals(fine))
			throw new LineaNonValidaException();
		
		this.inizio = inizio;
		this.fine = fine;
	}

	public Punto getInizio() {
		return inizio;
	}

	public Punto getFine() {
		return fine;
	}
	
	public abstract double getLunghezza();
	
	public abstract Linea[] getStruttura();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fine == null) ? 0 : fine.hashCode());
		result = prime * result + ((inizio == null) ? 0 : inizio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		//if (getClass() != obj.getClass())
			//return false;
		Linea other = (Linea) obj;
		if (fine == null) {
			if (other.fine != null)
				return false;
		} else if (!fine.equals(other.fine))
			return false;
		if (inizio == null) {
			if (other.inizio != null)
				return false;
		} else if (!inizio.equals(other.inizio))
			return false;
		return true;
	}
	
	

}
