package voloMultiTratta;

public class VoloDiretto extends Volo {
	
	private int durataInMinuti;
	
	public VoloDiretto(String aeroportoPartenza, String aeroportoArrivo, int durataInMinuti) throws VoloNonValidoException{
		super(aeroportoPartenza, aeroportoArrivo);
		if(durataInMinuti <= 0)
			throw new VoloNonValidoException("La durata del volo deve essere un numero positivo!");
		this.durataInMinuti = durataInMinuti;
	}
	
	@Override
	public int getNumeroTratte() {
		return 1;
	}

	@Override
	public int getDurataInMinuti() {
		return this.durataInMinuti;
	}

}
