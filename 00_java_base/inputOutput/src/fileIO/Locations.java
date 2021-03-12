package fileIO;

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
		Scanner scanner = null;
		try{
			scanner = new Scanner(new FileReader("locations.txt"));
			scanner.useDelimiter(",");
			while(scanner.hasNextLine()){
				int loc = scanner.nextInt();
				scanner.skip(scanner.delimiter());
				String description = scanner.nextLine();
				Map<String, Integer> tempExit = new HashMap<>();
				locations.put(loc, new Location(loc, description, tempExit));
			}
			
		}
		catch(IOException e){}
		finally{
			if(scanner != null)
				//Qui viene chiuso il Readeble stream
				scanner.close();
		}
		
		/*Map<String, Integer> tempExit = new HashMap<String, Integer>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java",null));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest",tempExit));*/
	}
	
	public static void main(String[] args)throws IOException {
		/*FileWriter locFile = null;
		try{
			locFile = new FileWriter("locations.txt");
			for(Location location: Locations.locations.values())
				locFile.write(location.getLocationID() + ", " + location.getDescription() + "\n");
			//locFile.close(); 
			}
		finally{
			
			if(locFile != null)
				locFile.close();
		}*/
		
		//Usando try-with-resource non è necessario usare finally perchè
		// questo costrutto si assicura che il file venga chiuso prima di uscire dallo scope
		try(FileWriter locFile = new FileWriter("locations.txt");
				FileWriter dirFile = new FileWriter("directions.txt")){
			for(Location location: Locations.locations.values()){
				locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
				for(String direction : location.getExits().keySet())
					dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
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
