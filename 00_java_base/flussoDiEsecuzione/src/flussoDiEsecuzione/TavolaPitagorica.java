package flussoDiEsecuzione;

/**
 * Scrivere una semplice classe che stampi a video la tavola pitagorica.*/

public class TavolaPitagorica {
	
	public static void main(String[] args){
		// la tavola viene stampata per i primi 10 numeri naturali
		// come una matrice 10x10
		for(int i = 1; i < 11; ++i){
			for(int j = 1; j < 11; ++j){
				System.out.print(i * j + " ");
			}
			System.out.print('\n');
		}
		
		
	}

}
