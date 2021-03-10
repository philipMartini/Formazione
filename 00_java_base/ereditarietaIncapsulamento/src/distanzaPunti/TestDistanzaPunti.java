package distanzaPunti;

public class TestDistanzaPunti {

	public static void main(String[] args) {
		Punto p1 = new Punto(2, 4);
		Punto p2 = new Punto(2, 4);
		Punto p3 = new PuntoNelloSpazio(2,4,6);
		Punto p4 = new PuntoNelloSpazio(2,4,6);
		Punto [] punti = {p1, p2, p3, p4};
		
		for(int i = 0; i < punti.length; ++i){
			System.out.println(p1.calcolaDistanza(punti[i]));
		}
		
		for(int i = 0; i < punti.length; ++i){
			System.out.println(p3.calcolaDistanza(punti[i]));
		}

	}

}
