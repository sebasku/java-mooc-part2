
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sebkula
 */
public class StorageFacility {
    private final HashMap<String, ArrayList<String>> storage;
    
    public StorageFacility(){
        this.storage = new HashMap<>();
    }
    
    public void add(String unit, String item){
        final ArrayList<String> items;
        if(this.storage.containsKey(unit)){
            items = this.storage.get(unit);
        } else {
            items = new ArrayList<>();
        }
        items.add(item);
        this.storage.put(unit, items);
    }
    
    public ArrayList<String> contents(String storageUnit){
        final ArrayList<String> items;
        if(this.storage.containsKey(storageUnit)){
            items = this.storage.get(storageUnit);
        } else {
            items = new ArrayList<>();
        }
        
        return items;
    }
    
    public ArrayList<String> storageUnits(){
        final ArrayList<String> units = new ArrayList<>();
        for(String unit : this.storage.keySet()){
            if(!this.storage.get(unit).isEmpty()){
                units.add(unit);
            }
        }
        
        return units;
    }
    
    public void remove(String unit, String item){
        final ArrayList<String> items;
        if(this.storage.containsKey(unit)){
            items = this.storage.get(unit);
            items.remove(item);
        } 
    }
    
    
}
