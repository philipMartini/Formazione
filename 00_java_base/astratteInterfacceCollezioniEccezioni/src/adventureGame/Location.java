package adventureGame;

import java.util.HashMap;
import java.util.Map;

public class Location {
	
	private final int locationID;
	private final String description;
	private final Map<String, Integer> exits;
	
	public Location(int locationID, String description, Map<String, Integer> exits){
		this.locationID = locationID;
		this.description = description;
		if(exits != null)
			this.exits = new HashMap<String, Integer>(exits);
		else
			this.exits = new HashMap<String, Integer>();
		this.exits.put("Q", 0); // Per ogni Location è possibile uscire dal gioco
	}
	
	/*public void addExit(String direction, int locationID){
		exits.put(direction, locationID);
	}
*/
	public int getLocationID() {
		return locationID;
	}

	public String getDescription() {
		return description;
	}

	public Map<String, Integer> getExits() {
		return new HashMap<String, Integer>(this.exits);
	}
	
	

}
