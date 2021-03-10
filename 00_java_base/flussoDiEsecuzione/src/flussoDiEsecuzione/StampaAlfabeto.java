package flussoDiEsecuzione;

/**
 * Scrivere un'applicazione 
 * che stampi i 26 caratteri dell’alfabeto (inglese-americano) con un ciclo.*/

public class StampaAlfabeto {

	public static void main(String[] args) {
		
		char letter = 'a';
		
		for(int i = 0; i < 26; ++i)
			//Il cast è necessario altrimenti vengono stampati i valori ascii
			System.out.println((char) letter + i);
			
	}

}
