package lettoreScrittore;

import java.util.Random;

public class FileReader implements Runnable{
	
	private Folder folder;
	
	public FileReader(Folder folder){
		this.folder = folder;
	}

	@Override
	public void run() {
		Random random = new Random();
		while(true){
			this.folder.read();
			try {
				Thread.sleep(random.nextInt(10000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	

}
