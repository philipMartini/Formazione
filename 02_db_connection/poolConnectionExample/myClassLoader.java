package testDb;

import java.io.*;

public class myClassLoader extends ClassLoader {

	/** Creates new myClassLoader */
	public myClassLoader() {
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class findClass(String name) {
		byte[] b = loadClassData(name);
		System.out.println("Prima define....");
		Class classe = defineClass("anmco.prova", b, 0, b.length);
		resolveClass(classe);
		return classe;
	}

	private byte[] loadClassData(String name) {
		try {
			System.out.println("Prima lettura file....");
			FileInputStream inStream = new FileInputStream(name);
			System.out.println("Dopo lettura file....");
			int inBytes = inStream.available();
			byte[] inBuf = new byte[inBytes];
			int byteLetti = inStream.read(inBuf,0,inBytes);
			inStream.close();
			return(inBuf);

			//System.out.println("Cont File = " + byteDaLeggere);
			//System.out.println("Lettura = " +  new String(inBuf));

		} catch(IOException ex) 
		{} 
		return null;
	}

}

