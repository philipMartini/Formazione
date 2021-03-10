package esempio1;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello From The Main Thread!");
		Thread anotherThread = new AnotherThread();
		anotherThread.setName("***Another Thread****");
		anotherThread.start();
		
		//Usando classe anonima
		new Thread(){
			@Override
			public void run(){
				System.out.println("Hello from the anonimous class Thread!");
			}
		}.start();
		
		//Usando Runnable
		Thread myRunnable = new Thread(new Runnable(){
			@Override
			public void run(){
				System.out.println("Hello from anonimous Runnable!");
				try{
					anotherThread.join();
					System.out.println("I waited another Thread to finish!");
				}
				catch(InterruptedException e){
					System.out.println("I was interrupted!");
				}
			}
		});
		myRunnable.start();
		//anotherThread.interrupt();
		
		System.out.println("Hello From The Main Thread Again!");
	}

}
