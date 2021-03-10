package menuPiatto;

public class Menu {
	private String nomeRistorante;
	private Piatto[] piatti;
	
	public Menu(String ristorante, int numeroPiatti){
		this.nomeRistorante = ristorante;
		if(numeroPiatti < 1)
			this.piatti = new Piatto[30];
		else
			this.piatti = new Piatto[numeroPiatti];
	}
	
	public Menu(String ristorante){
		this.nomeRistorante = ristorante;
		this.piatti = new Piatto[30];
	}
	
	public boolean aggiungiPiatto(Piatto piatto){
		int freeIndex = -1;
		
		for(int i = 0; i < this.piatti.length; ++i){
			if(this.piatti[i] == null)
				freeIndex = i;
			else{
				if(this.piatti[i].equals(piatto))
					return false;
			}
		}
		if(freeIndex == -1)
			return false;
		else{
			this.piatti[freeIndex] = piatto;
			return true;
		}
	}
	
	public Piatto eliminaPiatto(Piatto piatto){
		Piatto piattoDaEliminare = null;
		
		for(int i = 0; i < this.piatti.length; ++i){
			if(this.piatti[i] != null && this.piatti[i].equals(piatto)){
				piattoDaEliminare = piatto;
				this.piatti[i] = null;
			}
		}
		
		return piattoDaEliminare;
	}
	
	
	public Piatto[] dammiTuttiIPiatti(String categoria){
		Piatto[] result = null;
		int numeroPiattiCategoria = 0;
		//Potendo utilizzare solo array devo iterare due volte
		for(int i = 0; i < this.piatti.length; ++i){
			if(this.piatti[i] != null && this.piatti[i].getCategoria().equals(categoria))
				++numeroPiattiCategoria;
		}
		if(numeroPiattiCategoria > 0){
			result = new Piatto[numeroPiattiCategoria];
			int j = 0;
			for(int i = 0; i < this.piatti.length; ++i){
				if(this.piatti[i] != null && this.piatti[i].getCategoria().equals(categoria)){
					result[j] = this.piatti[i];
					++j;
				}
				
			}
		}
		
		return result;
	}
	
	public Piatto[] dammiTuttiIPrimi(){
		return this.dammiTuttiIPiatti(Piatto.PRIMO);
	}
	
	public void setNomeRistorante(String nomeRistorante){
		this.nomeRistorante = nomeRistorante;
	}
	
	public String getNomeRistorante(){
		return this.nomeRistorante;
	}
	
	
}
