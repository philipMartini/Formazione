package poligoni;

public class Rettangolo implements Poligono {
	
	private double base;
	private double altezza;
	
	
	public Rettangolo(double base, double altezza){
		this.setBase(base);
		this.setAltezza(altezza);
	}
	
	@Override
	public double calcolaArea() {
		return this.getBase() * this.getAltezza();
	}

	private void setAltezza(double altezza) {
		if(altezza > 0)
			this.altezza = altezza;
		
	}

	private void setBase(double base) {
		if(base > 0)
			this.base = base;	
	}
	
	

	public double getBase() {
		return base;
	}



	public double getAltezza() {
		return altezza;
	}

	
	@Override
	public boolean equals(Object obj) {
		//Due poligoni della stessa classe sono uguali sse 
		//la loro area differisce per meno di 0.001
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rettangolo other = (Rettangolo) obj;
		if(Math.abs(this.calcolaArea() - other.calcolaArea()) > 0.001)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rettangolo [getBase()=" + getBase() + ", getAltezza()=" + getAltezza() + "]";
	}

	
	
}
