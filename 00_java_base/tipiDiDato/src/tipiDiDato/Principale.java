package tipiDiDato;

public class Principale {

	public static void main(String[] args) {
		
		//Dichiarazione e istanza di due oggetti Persona
		Persona persona1 = new Persona();
		Persona persona2 = new Persona();
		
		//I dati membro di persona sono inizializzato ai valori di default
		//In questo caso 0 per int e null per String
		System.out.println("Persona1: " + persona1.dettagli());
		
		//Inizializzazione tramite operatore .
		persona1.nome = "Francesco";
		persona1.cognome = "Livati";
		persona1.eta = 22;
		
		System.out.println("Persona1: " + persona1.dettagli());
		
		persona2.nome = "Luca";
		persona2.cognome = "Tivali";
		persona2.eta = 23;
		
		System.out.println("Persona2: " + persona2.dettagli());
		
		//Il reference persona3 punta a persona2...
		Persona persona3 = persona2;
		
		//I dati membro saranno gli stessi.....
		System.out.println("Persona3: " + persona3.dettagli());
		//....E chiaramente puntano allo stesso oggetto
		System.out.println(persona3 == persona2);
		

	}

}
