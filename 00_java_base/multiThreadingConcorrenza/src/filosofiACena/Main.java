package filosofiACena;

public class Main{
    public static void main(String args[]){
        Fork forks[] = new Fork[5];
        Philosopher phils[] = new Philosopher[5];
        //Table table = new Table();
        
        for(int c=0; c<5; forks[c] = new Fork(c), c++);
        //Il modo piu semplice di evitare il deadlock che in questa situazione
        //avviene è rompere una delle precondizioni di verifica del deadlock =>  attesa circolare
        //Basta fare in modo che lultimo filosofo prenda prima la forchetta Dx e non quella Sx
        for(int c=0; c<5; c++)
        	if(c == 4)
        		phils[c] = new Philosopher(c, forks[(c + 1) % 5], forks[c]);
        	else
        		phils[c] = new Philosopher(c, forks[c], forks[(c+1)%5]);
        
        for(int c=0; c<5; phils[c].start(), c++);
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {}
        for(int c=0; c<5; phils[c].stopRequested(),c++);
    }
}
