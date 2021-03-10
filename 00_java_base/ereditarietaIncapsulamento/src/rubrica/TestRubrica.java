package rubrica;

public class TestRubrica {

	public static void main(String[] args) {
		Contatto c1 = new Contatto("Pippo", "xxxx", "22222");
		Contatto c2 = new Contatto("Pluto", "yyyyy", "33333");
		Contatto c3 = new Contatto("Paperino", "zzzz", "55555");
		
		Rubrica r1 = new Rubrica(7);
		r1.addContatto(c1);
		r1.addContatto(c2);
		r1.addContatto(c3);
		
		assert(r1.getCapienza() == 7);
		assert(r1.getVociInserite() == 3);
		r1.addContatto(c1);
		assert(r1.getCapienza() == 7);
		assert(r1.getVociInserite() == 3);
		
		r1.removeContatto(c1);
		assert(r1.getCapienza() == 7);
		assert(r1.getVociInserite() == 2);
		
		assert(r1.removeContatto(c1)== null);
		
		assert(r1.searchContatto("Pippo", "yyyyy").equals(c2));
		assert(r1.searchContatto("Pippo", "xxxx") == null);
		
		System.out.println("Test terminato");

	}

}
