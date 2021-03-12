package fileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
		Locations.locations = new HashMap<>();
		try(BufferedReader r1 = new BufferedReader(new FileReader("locations_big.txt"))){
			//scanner = new Scanner(new FileReader("locations_big.txt"));
			//scanner.useDelimiter(",");
			String in;
			String[] data;
			while((in = r1.readLine()) != null){
				data = in.split(",");
				int loc = Integer.parseInt(data[0]);
				String description = data[1];
				Map<String, Integer> tempExit = new HashMap<>();
				locations.put(loc, new Location(loc, description, tempExit));
			}
			
		}
		catch(IOException e){}
		
		//Usando BufferedReader e try-with-resource
		
		
		
		try(BufferedReader dirFile = new BufferedReader( new FileReader( "directions_big.txt"))){
			String input;
			while((input = dirFile.readLine()) != null){
				
				String[] data = input.split(",");
				int loc = Integer.parseInt(data[0]);
				String direction = data[1];
				int destination = Integer.parseInt(data[2]);
				Location location = locations.get(loc);
				location.addExit(direction, destination);
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
		}
	
	
	public static void main(String[] args)throws IOException {
		
		//Usando try-with-resource non è necessario usare finally perchè
		// questo costrutto si assicura che il file venga chiuso prima di uscire dallo scope
		try(BufferedWriter  locFile = new BufferedWriter(new FileWriter("locations.txt"));
				BufferedWriter dirFile = new BufferedWriter(new FileWriter("directions.txt"))){
			for(Location location: Locations.locations.values()){
				locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
				for(String direction : location.getExits().keySet()){
					//Non scrivere le opzioni di quitting
					if(!direction.equalsIgnoreCase("Q"))
						dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
				}
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

}
