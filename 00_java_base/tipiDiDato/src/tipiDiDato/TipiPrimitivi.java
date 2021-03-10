package tipiDiDato;

public class TipiPrimitivi {

	public static void main(String[] args) {
		
		int a = 5, b = 3;
		
		//Utilizzo sempre la precisione dei double per le divisioni, il cast serve
		//a segnalare il fatto che NON voglio il risultato di una divisione intera
		double r1 = (double) a / b;
		System.out.println("r1: " + r1);
		char c = 'a';
		short s = 5000;
		//é sufficiente usare un int per contenere il risultato....
		int r2 =  c * s;
		System.out.println("r2 usando int: " + r2);
		//Infatti uno short non basterebbe
		short r22 = (short) (c * s);
		System.out.println("r2 usando short: " + r22);
		
		int i = 6;
		float f = 3.14F;
		//In questo caso il tipo di dato più ampio è float
		float r3 = i + f;
		System.out.println("r3: " + r3);
		
		//Il tipo di dato più ampio è double quindi il risultato 
		//sarà dello stesso tipo, il cast esplicito non è necessario
		double r4 = r1 - r2 - r3;
		System.out.println("r4: " + r4);
	}

}
