package trasformazioneGeometrica;

import java.util.HashSet;
import java.util.Set;

public abstract class TrasformazioneGeometrica {
	
	public abstract Punto trasforma(Punto punto);
	
	public Set<Punto> trasforma(Set<Punto> punti){
		Set<Punto> result = new HashSet<>();
		for(Punto p : punti)
			result.add(this.trasforma(p));
		return result;
	}

}
