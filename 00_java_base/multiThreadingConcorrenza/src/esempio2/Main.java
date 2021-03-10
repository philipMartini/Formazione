package esempio2;


public class Main {

	public static void main(String[] args) {
		Countdown c1 = new Countdown();
		CountdownThread t1 = new CountdownThread(c1);
		t1.setName("Thread 1");
		CountdownThread t2 = new CountdownThread(c1);
		t2.setName("Thread 2");
		t1.start();
		t2.start();

	}

}


class Countdown{
	
	private int i;
	
	public void doCountdown(){
		String color;
		
		switch(Thread.currentThread().getName()){
			case "Thread 1":
				color = "Thread 1";
				break;
			case "Thread 2":
				color = "Thread 2";
				break;
			default:
				color  = "Default Color";
		}
		//Uso intrinsic lock sull'oggetto condiviso fra i due trheads
		synchronized(this){
			for(i=10; i > 0; --i)
				System.out.println(color + " : " + i);
		}
	}
}


class CountdownThread extends Thread{
	private Countdown threadCountdown;
	
	public CountdownThread(Countdown countdown){
		this.threadCountdown = countdown;
	}
	
	@Override
	public void run(){
		this.threadCountdown.doCountdown();
	}
}
