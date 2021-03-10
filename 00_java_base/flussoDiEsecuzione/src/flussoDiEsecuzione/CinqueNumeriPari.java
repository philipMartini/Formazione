package flussoDiEsecuzione;

/**
 * Scrivere un semplice programma, costituito da un’unica classe, 
 * che sfruttando esclusivamente un ciclo infinito, l’operatore modulo, 
 * due costrutti if, 
 * un break ed un continue, stampi solo i primi cinque numeri pari.*/

public class CinqueNumeriPari {

	public static void main(String[] args) {
		int i = 1;
		while(true){
			if(i % 2 == 0)
				System.out.println(i);
			if(i > 10)
				break;
			++i;
		}

	}

}
