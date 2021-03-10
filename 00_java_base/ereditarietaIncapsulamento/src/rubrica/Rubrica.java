package rubrica;

public class Rubrica {
	
	private Contatto[]  contatti;
	private int capienza;
	private int vociInserite;
	
	
	public Rubrica(){
		//Se non viene passata una capienza viene assegnata quella di default ossia 23 voci
		this.contatti = new Contatto[23];
		this.setCapienza(23);
		this.setVociInserite(0);
	}
	
	public Rubrica(int capienza){
		//Se la capienza è <= 0 allora viene impostata quella di default
		if(capienza <= 0){
			this.contatti = new Contatto[23];
			this.setCapienza(23);
		}
		else{
			this.contatti = new Contatto[capienza];
			this.setCapienza(capienza);
		}
		this.setVociInserite(0);	
	}
	
	
	public boolean addContatto(Contatto contatto){
		//Il contatto puo essere aggiunto 
		//sse la rubrica non è piena e il contatto non è gia presente
		if(this.getVociInserite() < this.getCapienza() - 1){
			int freeIndex = 0;
			for(int i = 0; i < this.getCapienza(); ++i){
				if(this.contatti[i] != null && this.contatti[i].equals(contatto))
					return false;
				else if(this.contatti[i] == null)
					freeIndex = i;
			}
			this.contatti[freeIndex] = contatto;
			++this.vociInserite;
			return true;
		}
		return false;
	}
	
	public Contatto removeContatto(Contatto contatto){
		//Elimina il contatto contatto se presente e lo restituisce, ritorna null
		//se il contatto non fosse presente in rubrica
		Contatto result = null;
		for(int i = 0; i < this.getCapienza(); ++i){
			if(contatto.equals(this.contatti[i])){
				result = contatto;
				this.contatti[i] = null;
				--this.vociInserite;
			}
		}
		
		return result;
	}
	
	public Contatto searchContatto(String nome, String cognome){
		Contatto result = null;
		for(int i = 0; i < this.getCapienza(); ++i){
			if(this.contatti[i].getNome().equals(nome) && this.contatti[i].getCognome().equals(cognome)){
				result = this.contatti[i];
			}
		}
		return result;
	}
	
	
	public int getCapienza() {
		return capienza;
	}

	private void setCapienza(int capienza) {
		this.capienza = capienza;
	}
	
	private void setVociInserite(int vociInserite){
		this.vociInserite = vociInserite;
	}

	public int getVociInserite() {
		return vociInserite;
	}


}
