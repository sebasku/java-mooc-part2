
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sebkula
 */
public class Abbreviations {
    HashMap<String, String> mapAbbr;
    
    public Abbreviations(){
        mapAbbr = new HashMap<>();
    }
    
   public void addAbbreviation(String abbreviation, String explanation){
       if(mapAbbr.containsKey(abbreviation)){
           System.out.println("This abbrevation already exists");
       } else {
           mapAbbr.put(abbreviation, explanation);
       }
   } 
    
   public boolean hasAbbreviation(String abbreviation){
       return mapAbbr.containsKey(abbreviation);
   }
   
   public String findExplanationFor(String abbreviation){
       return mapAbbr.containsKey(abbreviation) ? mapAbbr.get(abbreviation) : null;
   }
   
   
}
