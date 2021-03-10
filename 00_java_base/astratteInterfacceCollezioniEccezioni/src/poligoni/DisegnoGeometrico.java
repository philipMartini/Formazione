package poligoni;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DisegnoGeometrico {
	
	private List<Poligono> poligoni;
	
	
	public DisegnoGeometrico(){
		this.poligoni = new ArrayList<Poligono>();
	}
	
	public void aggiungiPoligono(Poligono poligono){
		this.poligoni.add(poligono);
	}
	
	public double calcolaAreaTotale() throws NoPoligoniException{
		if(this.poligoni.size() == 0)
			throw new NoPoligoniException("Nessun Poligono Presente nella Collezione!");
		Iterator<Poligono> iter = this.poligoni.iterator();
		double result = 0.0;
		while(iter.hasNext()){
			result += iter.next().calcolaArea();
		}
		
		return result;
	}

}
