package voloMultiTratta;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RegistroVoli {
	
	private Map<String, Volo> voli;
	
	public RegistroVoli(){
		this.voli = new HashMap<>();
	}
	
	public void aggiungiVolo(String codice, Volo volo) throws CodiceVoloNonValidoException{
		if(!this.codiceValido(codice))
			throw new CodiceVoloNonValidoException("Codice volo Non valido!");
		this.voli.put(codice, volo);
	}
	
	public void aggiungiVolo(String codice, String aeroportoPartenza, String aeroportoDestinazione, int durata) throws CodiceVoloNonValidoException, VoloNonValidoException{
		this.aggiungiVolo(codice, new VoloDiretto(aeroportoPartenza, aeroportoDestinazione, durata));
	}

	private boolean codiceValido(String codice) {
		return codice.length() == 5;
	}
	
	public Volo getVolo(String codice){ return this.voli.get(codice); }
	
	public String[] getListaCodiciDeiVoli() { return this.voli.keySet().toArray(new String[0]); }
	
	public void dumpSuFile(String nomeFile) throws IOException {
		
		try(BufferedWriter fileLoc = new BufferedWriter(new FileWriter(nomeFile))){
			for(Entry<String, Volo> entry : this.voli.entrySet()){
				fileLoc.write(entry.getKey().toString() + " " + entry.getValue().toString() + "\n");
			}
			
		}
		
	}

}
