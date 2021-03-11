package deadlock;

public class Main2 {
	
	public static void main(String[] args){
		final PolitePerson p1 = new PolitePerson("Jane");
		final PolitePerson p2 = new PolitePerson("John");
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				p1.sayHello(p2);
				
			}}).start();
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				p2.sayHello(p1);
				
			}}).start();
		//p1.sayHello(p2);
		//p2.sayHello(p1);
		
	}
	
	static class PolitePerson{
		private final String name;
		
		public PolitePerson(String name){
			this.name = name;
		}
		
		public String getName(){ return this.name; }
		
		public synchronized void sayHello(PolitePerson person){
			System.out.format("%s: %s "+ "Has said hello to me!%n", this.name, person.getName());
			person.sayHelloBack(this);
		}
		
		public synchronized void sayHelloBack(PolitePerson person){
			System.out.format("%s: %s "+ "Has said hello back to me!%n", this.name, person.getName());
		}
	}

}
