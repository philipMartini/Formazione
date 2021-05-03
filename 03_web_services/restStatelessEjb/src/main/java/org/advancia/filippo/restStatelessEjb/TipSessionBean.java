package org.advancia.filippo.restStatelessEjb;

import java.io.Serializable;

import javax.ejb.Remove;
import javax.ejb.Stateful;

//@SessionScoped
@Stateful
public class TipSessionBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int counter = 0;
	
    private final static String tips[] = {
        "I hear and I forget. I see and I remember. I do and I understand",
        "Study the past if you would define the future",
        "Attack life, it’s going to kill you anyway"};

    public String getTip() {
    	++this.counter;
        return tips[(int)(Math.random()*tips.length)];
    }
    
    public int getCounter() { return counter; }
    
    @Remove
    public void end() {
        System.out.println("TipOfTheDay Bean instance will be removed..");
    }

 
}