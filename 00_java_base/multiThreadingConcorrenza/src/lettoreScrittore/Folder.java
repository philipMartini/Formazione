package lettoreScrittore;

import java.util.Random;

public class Folder {
	
	private MyFile[] files;
	private int numMaxFiles;
	private int capienzaMax;
	private int readPos;
	private int writePos;
	private int currentCapienza;
	private Object lock;
	
	
	public Folder(int numMaxFiles, int capienzaMax){
		this.numMaxFiles = numMaxFiles;
		this.capienzaMax = capienzaMax;
		this.files = new MyFile[this.numMaxFiles];
		this.writePos = 0;
		this.readPos = 0;
		this.currentCapienza = 0;
		//Uso un lock sull'oggetto piuttosto che la keyword synchronized
		this.lock = new Object();
	}
	
	public void write(MyFile file){
		//Finche non è possibile scrivere 
		Random random = new Random();
		synchronized(this.lock){
			while(this.exceedFilesNumb() || this.exceedCapienza(file)){ 
				System.out.println("Writer Waiting: "+ (this.currentCapienza + file.getDimensione()) + " " + Math.abs(this.writePos - this.readPos));
				try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} }
		//Effettua le operazioni di scrittura
			this.files[this.writePos] = file;
			System.out.println("Scritto Il file " + file + " : pos = " + this.writePos);
			this.writePos = (this.writePos + 1) % this.numMaxFiles;
			this.currentCapienza += file.getDimensione();
		//Notifica eventuali lettori in attesa
			lock.notify();
		}
		
	}
	
	
	public void read(){
		Random random = new Random();
		//Finche il buffer è vuoto non cè nulla da leggere
		synchronized(this.lock){
		while(this.currentCapienza == 0) { try {
			System.out.println("Reader Waiting " + this.currentCapienza);
			lock.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} }
		
		//Effettua la lettura
		this.currentCapienza -= this.files[this.readPos].getDimensione();
		System.out.println("Letto il file " + this.files[this.readPos] + ": pos = " + this.readPos);
		this.readPos = (this.readPos + 1) % this.numMaxFiles;
		lock.notify();
		}
	}
	
	private boolean exceedFilesNumb(){
		return (Math.abs(this.writePos - this.readPos) <= 0 && this.currentCapienza > 0);
	}
	
	private boolean exceedCapienza(MyFile file) {
		return this.currentCapienza + file.getDimensione() > this.capienzaMax;
	}

}
