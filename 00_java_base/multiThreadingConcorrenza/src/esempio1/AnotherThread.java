package esempio1;

public class AnotherThread extends Thread{
	
	@Override
	public void run(){
		System.out.println("Hello From " + this.getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return;
		}
		
		System.out.println("I am Awake!");
	}
}
