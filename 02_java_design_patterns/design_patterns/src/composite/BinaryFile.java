package composite;

//Leaf node in composite pattern
public class BinaryFile extends File{
	
	private long size;
	
	public BinaryFile(String name, long size) {
		super(name);
		this.size = size;
	}

	@Override
	public void ls() {
		System.out.println(this.getName() + "\t" + this.size);
		
	}

	@Override
	public void addFile(File file) {
		throw new UnsupportedOperationException("The leaf node does not support add operation");
		
	}

	@Override
	public File[] getFiles() {
		throw new UnsupportedOperationException("The leaf node does not support getFiles operation");
	}

	@Override
	public boolean removeFile(File file) {
		throw new UnsupportedOperationException("The leaf node does not support remove operation");
	}
	
	
}
