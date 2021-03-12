package voloMultiTratta;

import java.util.Iterator;
import java.util.List;

public class VoloMultiTratta extends Volo {
	
	private List<VoloDiretto> tratte;
	
	public VoloMultiTratta(List<VoloDiretto> tratte) throws VoloNonValidoException{
		super(estraiAeroportoPartenza(tratte), estraiAeroportoArrivo(tratte));
		if(! this.voloMuliTrattaValido(tratte))
			throw new VoloNonValidoException("Qualcosa Non Va nelle tratte!");
		this.tratte = tratte;
	}

	private static String estraiAeroportoArrivo(List<VoloDiretto> tratte) {
		return tratte.get(tratte.size() -1).getAeroportoArrivo();
	}

	private static String estraiAeroportoPartenza(List<VoloDiretto> tratte) {
		return tratte.get(0).getAeroportoPartenza();
	}

	private boolean voloMuliTrattaValido(List<VoloDiretto> tratte) {
		if(tratte.size() < 2)
			return false;
		for(int i = 0; i < tratte.size() - 1; ++i){
			if(!(tratte.get(i).getAeroportoArrivo().equals(tratte.get(i +1).getAeroportoPartenza())))
					return false;
		}
		return true;
	}

	@Override
	public int getNumeroTratte() {
		return this.tratte.size();
	}

	@Override
	public int getDurataInMinuti() {
		int durataTotale = 0;
		for(VoloDiretto volo : this.tratte)
			durataTotale += volo.getDurataInMinuti();
		return durataTotale;
	}

}
