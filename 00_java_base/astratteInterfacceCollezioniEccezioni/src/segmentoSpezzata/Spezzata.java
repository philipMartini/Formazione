package segmentoSpezzata;

import java.util.ArrayList;
import java.util.List;

public class Spezzata extends Linea {
	
	private List<Linea> linee;
	
	public Spezzata(Linea[] linee) throws LineaNonValidaException{
		super(linee[0].getInizio(), linee[linee.length - 1].getFine());
		if(!this.spezzataValida(linee))
			throw new LineaNonValidaException();
		this.linee = new ArrayList<>();
		for(Linea l : linee)
			this.linee.add(l);
	}

	private boolean spezzataValida(Linea[] linee) {
		//Una spezzata è composta da almeno due linee
		if(linee.length < 2)
			return false;
		//E ci deve essere corrispondenza fra i punti di inizio e fine della spezzata
		for(int i = 0; i < linee.length - 1; ++i){
			if(!linee[i].getFine().equals(linee[i + 1].getInizio()))
				return false;
		}
		return true;
	}

	@Override
	public double getLunghezza() {
		double result = 0.0;
		for(Linea l : this.linee)
			result += l.getLunghezza();
		return result;
	}

	@Override
	public Linea[] getStruttura() {
		return this.linee.toArray(new Linea[0]);
	}
	
	public boolean sostituisci(int posizioneLinea, Linea nuovaLinea) throws LineaNonValidaException{
		System.out.println(posizioneLinea);
		if(!this.linee.get(posizioneLinea).equals(nuovaLinea))
			throw new LineaNonValidaException("Sostituzione non effettuabile!");
		this.linee.remove(posizioneLinea);
		this.linee.add(posizioneLinea, nuovaLinea);
		return true;
	}
	
	public boolean sostituisci(Linea lineaDaSostituire, Linea nuovaLinea) throws LineaNonValidaException{
		return this.sostituisci(this.linee.indexOf(lineaDaSostituire), nuovaLinea);
	}

}
