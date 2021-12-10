package org.filippo.formazione.unit1;

//QUesta annotazione NON permette di aggiungere altri metodi a questa interfaccia
//Rendendola usabile con le lambdas
@FunctionalInterface
public interface Greeting {
	
	public void perform();

}
