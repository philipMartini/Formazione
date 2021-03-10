package lettoreScrittore;

import java.util.Random;

public class FileSaver implements Runnable{
	//Questa classe crea oggetti MyFile di dimensione random e li scrive nel buffer
	private Folder folder;
	
	public FileSaver(Folder folder){
		this.folder = folder;
	}
	
	
	@Override
	public void run() {
		int fileIndex = 0;
		Random random = new Random();
		while(true){
			MyFile file = new MyFile("File" + fileIndex, random.nextInt(1500));
			this.folder.write(file);
			++fileIndex;
			try {
				Thread.sleep(random.nextInt(7000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
