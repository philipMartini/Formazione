package liveLock;

public class Main {

	public static void main(String[] args) {
		final Worker w1 = new Worker("W1", true);
		final Worker w2 = new Worker("W2", true);
		
		final SharedResource s1 = new SharedResource(w1);
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				w1.work(s1, w2);
				
			}
			
		}).start();
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				w2.work(s1, w1);
				
			}
			
		}).start();

	}

}
