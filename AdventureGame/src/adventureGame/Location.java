package adventureGame;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author jtelepov
 */
public class Location {
    private final int locationId;
    private final String description;
    private final Map<String,Integer> exits;
    
    public Location(int locationId,String description, Map<String,Integer> exits){
        this.description=description;
        this.locationId=locationId;
        if(exits!=null){
            this.exits = new LinkedHashMap<>(exits);
        } else {
            this.exits = new LinkedHashMap<>();
        }
    }
    
    /*
    public void addExits(String direction,Integer location){
        exits.put(direction, location);
    }
    */
    
    public Map<String,Integer> getExits(){
        return new LinkedHashMap<>(exits);
    }

    public int getLocationId() {
        return locationId;
    }

    public String getDescription() {
        return description;
    }

    protected void addExit(String direction, int destination) {
        exits.put(direction, destination);
    }
    
   
    
    
    

}
