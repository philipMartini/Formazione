package trasformazioneGeometrica;

import java.util.HashSet;
import java.util.Set;

public class Grafico {
	
	private Set<Punto> punti;
	
	public Grafico(Punto punto){
		this.punti = new HashSet<>();
		if(punto != null)
			this.punti.add(punto);
	}
	
	public void aggiungiPunto(Punto punto) throws GraficoException{
		if(punto != null){
			if(!this.punti.add(punto))
				throw new GraficoException("Punto già aggiunto al Grafico!");
		}
	}
	
	public int getNumeroPunti(){ return this.punti.size(); }
	
	public void trasforma(TrasformazioneGeometrica trasformazione){
		if(trasformazione != null){
			this.punti = trasformazione.trasforma(this.punti);
		}
	}
	
	public void visualizza(){
		for(Punto p : this.punti)
			System.out.print(p + " ");
		System.out.println();
	}

}
