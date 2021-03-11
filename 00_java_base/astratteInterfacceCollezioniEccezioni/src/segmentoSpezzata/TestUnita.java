package segmentoSpezzata;

import junit.framework.TestCase;


public class TestUnita extends TestCase {

	/*******************    Classe Segmento    *******************/

	/** Verifica la gestione degli errori in fase di costruzione di un segmento */
	public void testGestioneErroriSegmento() {
		Linea v;
		//inizio e fine uguali
		try {
			v = new Segmento(new Punto(1, 2), new Punto(1, 2));
			fail();
		} catch (LineaNonValidaException e) { /*OK*/}
		//inizio o fine a null
		try {
			v = new Segmento(new Punto(1,2), null);
			fail();
		} catch (LineaNonValidaException e) { /*OK*/}
		//inizio e fine uguali
		try {
			v = new Segmento(new Punto(1,2), new Punto(1,2));
			fail();
		} catch (LineaNonValidaException e) { /*OK*/}
	}


	/** Verifica dei metodi di get **/
	public void testMetodiSegmento(){
		try {
			Segmento s = new Segmento(new Punto(1, 2), new Punto(3, 2));
			assertEquals(2, s.getLunghezza(), 0.5);
			assertEquals(new Punto(1, 2), s.getInizio());
			assertEquals(new Punto(3, 2), s.getFine());
		} catch (LineaNonValidaException e) { /*OK*/}
	}

	/*******************    Classe Spezzata    *******************/	

	/** Verifica la gestione degli errori in fase di costruzione di una spezzata */
	public void testGestioneErroriSpezzata() {
		Linea v;
		//inizio e fine uguali
		try {
			v = new Spezzata(new Linea[]{new Segmento(new Punto(1, 1), new Punto(2, 1)), new Segmento(new Punto(2, 1), new Punto(2, 3)),
					new Spezzata(new Linea[]{new Segmento(new Punto(2, 3), new Punto(4, 3)), new Segmento(new Punto(4, 3), new Punto(1, 1))})});
			fail();
		} catch (LineaNonValidaException e) { /*OK*/}
		//punti di inizio e fine diversi delle linee che realizzano la spezzata
		try {
			v = new Spezzata(new Linea[]{new Segmento(new Punto(1, 1), new Punto(2, 1)), new Segmento(new Punto(3, 1), new Punto(2, 3)),
					new Spezzata(new Linea[]{new Segmento(new Punto(2, 3), new Punto(4, 3)), new Segmento(new Punto(4, 3), new Punto(1, 3))})});
			fail();
		} catch (LineaNonValidaException e) { /*OK*/}
		//numero di linee minore di 2
		try {			
			v = new Spezzata(new Linea[]{new Segmento(new Punto(1, 1), new Punto(2, 1))});
			fail();
		} catch (LineaNonValidaException e) { /*OK*/}
	}


	/** Verifica dei metodi di get **/
	public void testMetodiSpezzata(){
		try {			
			Linea s = new Spezzata(new Linea[]{new Segmento(new Punto(1, 1), new Punto(2, 1)), new Segmento(new Punto(2, 1), new Punto(2, 3)),
					new Spezzata(new Linea[]{new Segmento(new Punto(2, 3), new Punto(4, 3)), new Segmento(new Punto(4, 3), new Punto(7, 3))})});
			assertEquals(8, s.getLunghezza(), 0.5);
			assertEquals(new Punto(1, 1), s.getInizio());
			assertEquals(new Punto(7, 3), s.getFine());
		} catch (LineaNonValidaException e) {}
	}

	
	/** verifica dei metodi sostituisci **/
	public void testSostituisci() {
		//public boolean sostituisci(int posizioneLinea, Linea nuovaLinea)
		try {
			Spezzata s1 = new Spezzata(new Linea[]{new Segmento(new Punto(1, 1), new Punto(2, 1)), new Segmento(new Punto(2, 1), new Punto(2, 3)),
					new Spezzata(new Linea[]{new Segmento(new Punto(2, 3), new Punto(4, 3)), new Segmento(new Punto(4, 3), new Punto(7, 3))})});
			
			assertTrue(s1.sostituisci(new Segmento(new Punto(2, 3), new Punto(7, 3)), new Spezzata(new Linea[]{new Segmento(new Punto(2, 3), new Punto(6, 3)), new Segmento(new Punto(6, 3), new Punto(7, 3))})));
			
		} catch (LineaNonValidaException e) {}

	}


}
