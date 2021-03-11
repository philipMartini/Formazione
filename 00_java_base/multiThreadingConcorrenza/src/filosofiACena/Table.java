package filosofiACena;

public class Table {
	
	private static enum  States {THINKING, HUNGRY, EATING};
	private States[] state;
	private Philosopher[] philosophers;
	
	
	public Table(Philosopher[] philosophers){
		this.philosophers = philosophers;
		for(int i = 0; i < this.state.length; ++i)
			this.state[i] = Table.States.THINKING;
	}
	
	void pickup(int i){
		this.state[i] = Table.States.HUNGRY;
		this.test(i);
		if( this.state[i] != Table.States.EATING)
			try {
				this.philosophers[i].wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void putdown(int i){
		//Quando hai finito di mangiare rimettiti a pensare
		this.state[i] = Table.States.THINKING;
		//E notifica i tuoi vicini che le forchette sono disponibili
		this.test((i + 4) % 5);
		this.test((i + 1) % 5);
	}
	
	
	private void test(int i) {
		//Se i due vicini NON stanno mangiando notifica il thread i-esimo
		if(this.state[(i + 4) % 5] != Table.States.EATING && 
				this.state[i] == Table.States.HUNGRY && this.state[(i + 1) % 5] != Table.States.EATING){
			this.philosophers[i].notify();
		}
		
	}
	

}
