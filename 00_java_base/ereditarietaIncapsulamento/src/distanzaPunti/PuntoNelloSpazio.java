package distanzaPunti;

public class PuntoNelloSpazio extends Punto {
	
	private double z;
	
	public PuntoNelloSpazio(){}
	
	public PuntoNelloSpazio(double x, double y, double z){
		super(x, y);
		this.z = z;
	}
	
	
	@Override
	public double calcolaDistanza(Punto p){
		if(p instanceof PuntoNelloSpazio){
			PuntoNelloSpazio p1 = (PuntoNelloSpazio) p;
		return Math.sqrt(Math.pow(this.getX() - p1.getX(), 2) + 
				Math.pow(this.getY() - p1.getY(), 2) + 
				Math.pow(this.getZ()- p1.getZ(), 2));
		}
		return -1;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PuntoNelloSpazio other = (PuntoNelloSpazio) obj;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PuntoNelloSpazio [z=" + z + "]";
	}
	
	

}
