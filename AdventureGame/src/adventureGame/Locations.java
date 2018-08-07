package adventureGame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jtelepov
 */
public class Locations implements Map<Integer,Location>{
    private static Map<Integer,Location> locations= new LinkedHashMap<>();
    
    public static void main(String[] args) throws IOException{
        try(    BufferedWriter locFile = new BufferedWriter(new FileWriter("locations.txt"));
                BufferedWriter dirFile = new BufferedWriter(new FileWriter("directions.txt"))){
            for(Location location : locations.values()){
                locFile.write(location.getLocationId()+","+location.getDescription()+ "\n");
                for(String directions : location.getExits().keySet()){
                    dirFile.write(location.getLocationId()+","+directions+","+location.getExits().get(directions)+"\n");
                }
            }
           
    }
        
    }
   
    static{
//      Scanner scanner = null;
//        try(Scanner scanner = new Scanner(new FileReader("locations.txt"))){
          try(BufferedReader locFile = new BufferedReader(new FileReader("locations.txt"))){
//           scanner.useDelimiter(",");
              String input;
//            while(scanner.hasNextLine()){
              while((input = locFile.readLine())!=null){
                  String[] data = input.split(",");
                /*int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.println("Imported location:" + loc + ":" + description);*/
                Map<String,Integer> tempExit = new HashMap<>();
                int loc = Integer.parseInt(data[0]);
                String description = data[1];
                System.out.println("Imported location:" + loc + ":" + description);
                locations.put(loc, new Location(loc, description, tempExit));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }/*catch(IOException e){
            e.printStackTrace();
        }
        finally{
            if(scanner!=null){scanner.close();}
        }*/
        
        //Read the exits
        
        try(BufferedReader dirFile = new BufferedReader(new FileReader("directions.txt"));){
            String input;
            //scanner = new Scanner(new BufferedReader(new FileReader("directions.txt")));
           // scanner.useDelimiter(",");
           // while(scanner.hasNextLine()){
           while((input = dirFile.readLine()) !=null){
//                int loc= scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String direction = scanner.next();
//                scanner.skip(scanner.delimiter());
//                String dest = scanner.nextLine();
//                int destination = Integer.parseInt(dest);
//                String input = scanner.nextLine();
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                System.out.println(loc + ": "+direction + ": "+destination);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
                            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*finally{
            if(scanner!=null){scanner.close();}
        }*/
         /*  
        Map<String,Integer> tempExit = new HashMap<>();
        
        tempExit = new HashMap<>();
        tempExit.put("S", 2);
        locations.put(1, new Location(1, "Zobudil sisa doma vo svojom dome na strome",tempExit));
        
        
        tempExit = new HashMap<>();
        tempExit.put("W", 3);
        tempExit.put("N", 1);
        tempExit.put("E", 5);
        locations.put(2, new Location(2, "Zisiel si dole, okolo seba mas les",tempExit));
        
        tempExit = new HashMap<>();
        tempExit.put("E", 2);
        tempExit.put("W", 4);
        locations.put(3, new Location(3, "Narazil si na cestu cez potok",tempExit));
        
        tempExit = new HashMap<>();
        tempExit.put("E", 3);
        locations.put(4, new Location(4, "Prisiel si ku chramu",tempExit));
        
        tempExit = new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("S", 6);
        tempExit.put("E", 7);
        locations.put(5, new Location(5, "Lesna krizovatka",tempExit));
        
        tempExit = new HashMap<>();
        tempExit.put("N", 5);
        tempExit.put("E", 8);
        locations.put(6, new Location(6, "Prisiel si k jaskyni",tempExit));
        
        tempExit = new HashMap<>();
        tempExit.put("S", 8);
        tempExit.put("W", 5);
        locations.put(7, new Location(7, "V srdci lesa si nasiel oltar",tempExit));
        
        tempExit = new HashMap<>();
        tempExit.put("E", 6);
        tempExit.put("W", 7);
        locations.put(8, new Location(8, "Lesna cesta",tempExit));
        */
    }

    @Override
    public int size() {
      return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
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
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {
        locations.putAll(m);
    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
    

}
