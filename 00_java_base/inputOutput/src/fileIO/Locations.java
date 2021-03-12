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
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Locations implements Map<Integer, Location>{
	
	private static Map<Integer, Location> locations;
	private static Map<Integer, IndexRecord> index;
	private static RandomAccessFile ra;
	
	//Uso static init block (Eseguito PRIMA del costruttore)
	static{
		Locations.locations = new HashMap<>();
		Locations.index = new HashMap<>();
		try{
			Locations.ra = new RandomAccessFile("locations_rand.dat", "rwd");
			int numLocations = ra.readInt();
			long locationStartPoint = ra.readInt();
			
			while(ra.getFilePointer() < locationStartPoint){
				int locationId = ra.readInt();
				int locationStart = ra.readInt();
				int locationLength = ra.readInt();
				
				IndexRecord record = new IndexRecord(locationStart, locationLength);
				index.put(locationId, record);
			}
			
			}catch(IOException e){
				
			}
		
		
		}//END STATIC
	
	
	public Location getLocation(int locationID) throws IOException{
		IndexRecord record = Locations.index.get(locationID);
		ra.seek(record.getStartByte());
		int id = ra.readInt();
		String description = ra.readUTF();
		String exits = ra.readUTF();
		String[] exitPart = new String(exits).split(",");
		
		Location location = new Location(locationID, description, null);
		
		if(locationID != 0){
			for(int i = 0; i < exitPart.length; ++i){
				System.out.println("ExitPart = " + exitPart[i]);
				String direction = exitPart[i];
				int destination = Integer.parseInt(exitPart[++i]);
				location.addExit(direction, destination);
			}
		}
		
		return location;
	}
	
	
	public static void main(String[] args)throws IOException {
		
		//I primi 4 bytes conterranno il numero di locations
		//I successivi 4 bytes conterrano lo start offsett per la sezione delle locations
		//La successiva sezione conterrà lindex vero e proprio
		//Lultima sezione conterrà i records delle locations vere e proprie
		try(RandomAccessFile rao = new RandomAccessFile("locations_rand.dat", "rwd")){
			rao.writeInt(locations.size());
			int indexSize = locations.size() * 3 * Integer.BYTES;
			int locationStart = (int)(indexSize + rao.getFilePointer() + Integer.BYTES);
			rao.writeInt(locationStart);
			long indexStart = rao.getFilePointer();
			
			int startPointer = locationStart;
			rao.seek(startPointer);
			
			for(Location location : locations.values()){
				rao.writeInt(location.getLocationID());
				rao.writeUTF(location.getDescription());
				StringBuilder builder = new StringBuilder();
				for(String direction : location.getExits().keySet()){
					if(!direction.equalsIgnoreCase("Q")){
						builder.append(direction);
						builder.append(",");
						builder.append(location.getExits().get(direction));
						builder.append(",");
					}
				}
				rao.writeUTF(builder.toString());
				IndexRecord record = new IndexRecord(startPointer, (int) (rao.getFilePointer() - startPointer));
				index.put(location.getLocationID(), record);
				startPointer = (int) rao.getFilePointer();
			}

			rao.seek(indexStart);
			for(Integer locationID : index.keySet()){
				rao.writeInt(locationID);
				rao.writeInt(index.get(locationID).getStartByte());
				rao.writeInt(index.get(locationID).getLength());
			}
			
		}
		
		
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
	
	public void close() throws IOException {
		Locations.ra.close();
	}

}
