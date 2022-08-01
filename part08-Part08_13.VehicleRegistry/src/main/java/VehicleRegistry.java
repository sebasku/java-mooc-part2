
import java.util.ArrayList;
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
public class VehicleRegistry {
    private HashMap<LicensePlate, String> hashmap;
    
    public VehicleRegistry(){
        this.hashmap = new HashMap<>();
    }
    
    public boolean add(LicensePlate licensePlate, String owner){
        for(LicensePlate plate : this.hashmap.keySet()){
            if(plate.equals(licensePlate)){
                return false;
            }
        }
        this.hashmap.put(licensePlate, owner);
        return true;
    }
    
    public String get(LicensePlate licensePlate){
        return this.hashmap.getOrDefault(licensePlate, null);
    }
    
    public boolean remove(LicensePlate licensePlate){
        if(!this.hashmap.containsKey(licensePlate)){
            return false;
        } else {
            this.hashmap.remove(licensePlate);
            return true;
        }
    }
    
    public void printLicensePlates(){
        for(LicensePlate plate : this.hashmap.keySet()){
            System.out.println(plate);
        }
    }
    
    public void printOwners(){
        ArrayList<String> owners = new ArrayList<>();
        for(String owner : this.hashmap.values()){
            if(!owners.contains(owner)){
                System.out.println(owner);
                owners.add(owner);
            }
        }
    }
}
