package trasformazioneGeometrica;

public class Punto {
	
	private String etichetta;
	private int x;
	private int y;
	
	
	public Punto(String etichetta, int x, int y){
		this.setEtichetta(etichetta);
		this.x = x;
		this.y = y;
	}


	public String getEtichetta() {
		return etichetta;
	}


	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}


	public void setEtichetta(String etichetta) {
		if(etichetta == null || "".equals(etichetta))
			this.etichetta = "UNDEF";
		else
			this.etichetta = etichetta;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "("+ this.etichetta + ": " + this.x + ", " + this.y + ")";
	}
	
	
	

}
