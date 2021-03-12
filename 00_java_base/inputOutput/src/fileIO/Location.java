package fileIO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Location implements Serializable{
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;
    
    private long serialVersionUID = 1L; //Fondamentale specificarlo esplicitamente 
    //per evitare InvalidClassException quando si de-serializza

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if(exits != null) {
            this.exits = new HashMap<String, Integer>(exits);
        } else {
            this.exits = new HashMap<String, Integer>();
        }
        this.exits.put("Q", 0);
    }

//    public void addExit(String direction, int location) {
//        exits.put(direction, location);
//    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }

	protected void addExit(String direction, int destination) {
		this.exits.put(direction, destination);
		
	}
}
