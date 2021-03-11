package starvation;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
	
	//Usiamo un Rlock passando true al costruttore la politica di servizio sui waiting threads è FIFO
	private static ReentrantLock lock = new ReentrantLock(true);

	public static void main(String[] args) {
		Thread t1 = new Thread(new Worker("Priority 10"));
		Thread t2 = new Thread(new Worker("Priority 8"));
		Thread t3 = new Thread(new Worker("Priority 6"));
		Thread t4 = new Thread(new Worker("Priority 4"));
		Thread t5 = new Thread(new Worker("Priority 2"));
		
		//Questa è solo una suggestione allo scheduler, ma non si puo forzare l'ordine di esecuzione dei threads
		//Priorità piu alta => proabilità di esecuzione maggiore
		t1.setPriority(10);
		t1.setPriority(8);
		t1.setPriority(6);
		t1.setPriority(4);
		t1.setPriority(2);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

	}
	
	//Il qualificatore static permette di accedere con una sintassi piu semplice alla inner class
	private static class Worker implements Runnable{
		private int runCount = 1;
		private String name;
		
		public Worker(String name){
			this.name = name;
		}
		
		@Override
		public void run() {
			for(int i = 0; i < 100; ++i){
				
				lock.lock();
				try{
					System.out.format("%s: RunCount= %d\n", this.name, this.runCount++);
				}
				finally{
					lock.unlock();
				}
			}
		}
	}

}
