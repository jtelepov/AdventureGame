package adventureGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author jtelepov
 */
public class AdventureGame {
   
   private static Locations locations = new Locations();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);    
        
        
        
        int loc = 1;
        while(true){
            Map<String,String> vocabulary = new HashMap<>();
            vocabulary.put("SOUTH", "S");
            vocabulary.put("NORTH", "N");
            vocabulary.put("EAST", "E");
            vocabulary.put("WEST", "W");
            
            if(loc==0){
                break;
            }
            System.out.println(locations.get(loc).getDescription());     
            
            Map<String,Integer> exits = locations.get(loc).getExits();
            System.out.println(exits);
            System.out.print("Available exists are: ");
            for(String exit:exits.keySet()){
                System.out.print(exit +",");
            }
            System.out.println("");
            System.out.print("Enter the direction: ");
            String direction = scanner.nextLine().toUpperCase();
            if(direction.length()>1){
                String[] words = direction.split(" ");
                for(String word:words){
                   if(vocabulary.containsKey(word)){
                       try{loc = exits.get(vocabulary.get(word));}
                       catch(NullPointerException e){
                           System.out.println("Invalid direction.");
                        }
                   }
                }
            }
            
            else if(direction.length()==1){
            if(exits.containsKey(direction)){
                loc = exits.get(direction);
            }}
            
            else{
                System.out.println("You cannot go in that direction");
            }
            }
            
            
            
        }
    }

    
        
        
        
        
    
    

