package liveLock;

public class SharedResource {
	
	private Worker owner;
	
	

	public SharedResource(Worker owner) {
		super();
		this.owner = owner;
	}

	public void setOwner(Worker otherWorker) {
		this.owner = otherWorker;
		
	}

	public Worker getOwner() {
		return this.owner;
	}

}
