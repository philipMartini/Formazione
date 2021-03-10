package concurrentPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
	
	public static final String EOF = "EOF";

	public static void main(String[] args) {
		//List<String> buffer = new ArrayList<>();
		//Usando classi ThreadSafe non serve usare lock
		ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);
		//ReentrantLock bufferLock = new ReentrantLock();
		
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		executorService.execute(new MyProducer(buffer));
		executorService.execute(new MyConsumer(buffer));
		executorService.execute(new MyConsumer(buffer));
		
		//Per Restituire un valore da un thread è necessario usare Callable e non Runnable
		Future<String> future = executorService.submit(new Callable<String>(){

			@Override
			public String call() throws Exception {
				return "This is callable results";
			}
			
		});
		
		try{
			System.out.println(future.get());
		}catch(ExecutionException e){
			
		}catch(InterruptedException e){
			
		}
		
		//Bisogna chiamare shutdow per terminare i threads del pool
		executorService.shutdown();
	}

}


class MyProducer implements Runnable{
	
	//private List<String> buffer;
	ArrayBlockingQueue<String> buffer;
	//private ReentrantLock lock;
	
	public MyProducer(ArrayBlockingQueue<String> buffer){
		this.buffer = buffer;
		//this.lock = lock;
	}

	@Override
	public void run() {
		Random random = new Random();
		String[] nums = {"1", "2", "3", "4", "5"};
		for(String num : nums){
			try{
				System.out.println("Adding... " + num);
				//Sezione critica
				//this.lock.lock();
					this.buffer.put(num);
					Thread.sleep(random.nextInt(3000));
			}catch(InterruptedException e){ e.printStackTrace();}
		}
		
		System.out.println("Producer Exiting...");
		//Sezione critica
		
		//this.lock.lock();
		try {
			this.buffer.put(Main.EOF);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}


class MyConsumer implements Runnable{
	
	private ArrayBlockingQueue<String> buffer;
	//private ReentrantLock lock;
	
	public MyConsumer(ArrayBlockingQueue<String> buffer){
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		
		while(true){
			synchronized(this.buffer){
				try{
					if(buffer.isEmpty()){
						continue;
						}
					//System.out.println("Counter = " + counter);
					if(this.buffer.peek().equals(Main.EOF)){
						System.out.println("Reader Exiting...");
						break;
						}
					else{
						System.out.println("Reader removed " + this.buffer.take());
					}
				}catch(InterruptedException e){
					
				}
			}
		}
		}
		
	}

	

	