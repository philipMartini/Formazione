package fileIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Locations implements Map<Integer, Location>{
	
	private static Map<Integer, Location> locations;
	
	//Uso static init block (Eseguito PRIMA del costruttore)
	static{
		try(DataInputStream locFile = new DataInputStream( new BufferedInputStream( 
				new FileInputStream("locations.dat")))){
			//Alla fine della lettura del file binario viene lanciata una EOFException
			boolean eof = false;
			while(!eof){
				try{
					Map<String, Integer> exits = new HashMap<>();
					int locId = locFile.readInt();
					String description = locFile.readUTF();
					int numExits = locFile.readInt();
					for(int i = 0; i < numExits; ++i){
						String direction = locFile.readUTF();
						int destination = locFile.readInt();
						exits.put(direction, destination);
					}
					locations.put(locId, new Location(locId, description, exits));
					
				}catch(EOFException e){
					System.out.println("EOF Finished readfile");
					eof  = true;
					//e.printStackTrace();
				}
			
			}
			
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	
	public static void main(String[] args)throws IOException {
		
		try(DataOutputStream locFile = new DataOutputStream( 
				new BufferedOutputStream( new FileOutputStream("locations.dat")));){
			for(Location location : locations.values()){
				locFile.writeInt(location.getLocationID());
				locFile.writeUTF(location.getDescription());
				locFile.writeInt(location.getExits().size());
				for(String direction : location.getExits().keySet()){
					if(!direction.equalsIgnoreCase("Q"))
						locFile.writeUTF(direction);
				}
			}
		}catch(IOException e){}
	}
	
	@Override
	public int size() {
		return Locations.locations.size();
	}

	@Override
	public boolean isEmpty() {
		return Locations.locations.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return locations.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return locations.containsValue(value);
	}

	@Override
	public Location get(Object key) {
		return Locations.locations.get(key);
	}

	@Override
	public Location put(Integer key, Location value) {
		// TODO Auto-generated method stub
		return Locations.locations.put(key, value);
	}

	@Override
	public Location remove(Object key) {
		return Locations.locations.remove(key);
	}

	@Override
	public void putAll(Map<? extends Integer, ? extends Location> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		Locations.locations.clear();
	}

	@Override
	public Set<Integer> keySet() {
		return Locations.locations.keySet();
	}

	@Override
	public Collection<Location> values() {
		return Locations.locations.values();
	}

	@Override
	public Set<java.util.Map.Entry<Integer, Location>> entrySet() {
		return Locations.locations.entrySet();
	}

}
