package org.filippo.formazione.unit2;

public class ThisReferenceExample {
	
	public void doProcess(int i, Process p) {
		p.process(i);
	}
	

	public void execute() {
		
		this.doProcess(7, i -> {
			System.out.println("Value of i: " + i);
			System.out.println(this); //Qui lo posso usare ed è riferito all'istanza di thisReferenceExample
		});
	}


	@Override
	public String toString() {
		return "ThisReferenceExample []";
	}
	
	
	
	public static void main(String[] args) {
		ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
		thisReferenceExample.doProcess(7, new Process() {

			@Override
			public void process(int i) {
				System.out.println("VAlue of i: " + i);
				System.out.println(this); //Stampa il ref di questa nuova anonymous inner class
			}
			
			
			
		});
		
		
		//Con la lambda non posso usare il reference this perchè le lambdas trattano il this come se si trovasse fuori dalla lambda
		//Quindi in questo caso essendo in un metodo statico non posso invocare il this e avrò un errore
		thisReferenceExample.doProcess(7, i -> {
			System.out.println("Value of i: " + i);
			//System.out.println(this); Questo va in errore, ma se il metodo chiamante fosse di istanza??????
		});
		
		thisReferenceExample.execute();
	}
	
	
	
}



