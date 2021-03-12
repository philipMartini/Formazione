package voloMultiTratta;

public abstract class Volo {
	
	private String aeroportoPartenza;
	private String aeroportoArrivo;
	
	public Volo(String aeroportoPartenza, String aeroportoArrivo) throws VoloNonValidoException{
		if(!(Aeroporti.aeroportoValido(aeroportoPartenza)&& Aeroporti.aeroportoValido(aeroportoArrivo)))
			throw new VoloNonValidoException("Aeroporto Non Valido!");
		this.aeroportoPartenza = aeroportoPartenza;
		this.aeroportoArrivo = aeroportoArrivo;
	}

	public String getAeroportoPartenza() {
		return aeroportoPartenza;
	}

	public String getAeroportoArrivo() {
		return aeroportoArrivo;
	}

	public abstract int getNumeroTratte();
	
	public abstract int getDurataInMinuti();

	@Override
	public String toString() {
		return "Volo [aeroportoPartenza=" + aeroportoPartenza + ", aeroportoArrivo=" + aeroportoArrivo
				+ ", getNumeroTratte()=" + getNumeroTratte() + ", getDurataInMinuti()=" + getDurataInMinuti() + "]";
	}
	
	

}
