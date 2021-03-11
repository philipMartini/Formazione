package liveLock;

public class Worker {
	
	private String name;
	private boolean active;
	
	
	public Worker(String name, boolean active) {
		super();
		this.name = name;
		this.active = active;
	}


	public String getName() {
		return name;
	}


	public boolean isActive() {
		return active;
	}
	
	public synchronized void work(SharedResource sharedResource, Worker otherWorker){
		while(active){
			if(sharedResource.getOwner() != this){
				try{
					wait(10);
				}catch(InterruptedException e){}
				continue;
			}
		
		
		if(otherWorker.isActive()){
			System.out.println(this.getName() + " Gave the resource to " + otherWorker.getName());
			sharedResource.setOwner(otherWorker);
			continue;
		}
		
		System.out.println(this.getName() + " Working on the common resource");
		this.active = false;
		sharedResource.setOwner(otherWorker);
		}
	}
		

}
