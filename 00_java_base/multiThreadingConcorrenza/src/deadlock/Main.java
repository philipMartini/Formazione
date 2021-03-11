package deadlock;

public class Main {
	
	public static Object lock1 = new Object();
	public static Object lock2 = new Object();

	public static void main(String[] args) {
			new Thread1().start();
			new Thread2().start();
	}
	
	/*Questa versione provoca Deadlock immediato, T1 acquisce il primo lock e va in sleep, 
	 * T2 acquisisce il secondo lock e va in sleep, in questo contesto T1 aspetta lock2 che possiede T2 e T2 aspetta
	 * lock1 che T1 possiede => Deadlock, Mettendo lo stesso ordine di acquisizione di lock il deadloc viene evitato*/
	
	private static class Thread1 extends Thread{
		
		@Override
		public void run(){
			synchronized(lock1){
				System.out.println("Thread 1 has Lock1");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Thread 1 waiting for lock2");
				synchronized(lock2){
					System.out.println("Thread 1 has Lock2");
				}
				
				System.out.println("Thread 1 released Lock2");
			}
			System.out.println("Thread 1 releasing lock1...Exiting...");
		}
	}
	
	private static class Thread2 extends Thread{
		
		@Override
		public void run(){
			synchronized(lock1){
				System.out.println("Thread 2 has Lock1");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Thread 2 waiting for lock2");
				synchronized(lock2){
					System.out.println("Thread 2 has Lock1 And Lock2");
				}
				
				System.out.println("Thread 2 released Lock2");
			}
			System.out.println("Thread 2 releasing lock1...Exiting...");
		}
		
	}

}

