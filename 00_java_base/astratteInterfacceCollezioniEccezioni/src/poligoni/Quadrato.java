package poligoni;

public class Quadrato extends Rettangolo {
	
	public Quadrato(double lunghezzaLato){
		super(lunghezzaLato, lunghezzaLato);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rettangolo other = (Quadrato) obj;
		if(Math.abs(this.calcolaArea() - other.calcolaArea()) > 0.001)
			return false;
		return true;
	}

}
