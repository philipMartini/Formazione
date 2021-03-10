package lettoreScrittore;

public class Main {
	
	public static void main(String[] args){
		
		Folder folder = new Folder(13, 7000);
		(new Thread(new FileSaver(folder))).start();
		(new Thread(new FileReader(folder))).start();
	}

}
