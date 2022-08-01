
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sebkula
 */
public class HashMap<K,V> {
    //implementing this way because in java-programming course on mooc.fi its been written to use arraylist. Probably more appropriate way
    //would be to create reference to next object in Pair class instead of using ArrayList 
    //This way values would be an array of Pairs where each Pair in array has inner referrecne to next Pair on that row
    //To be honest this excercise in this form is a bit pointless
    private ArrayList<Pair<K,V>>[] values;
    private int usedIndexes;

    public HashMap(){
        this.values = new ArrayList[4];
        this.usedIndexes = 0;
    }
    
    public V get(K key){
        int hashValue = Math.abs(key.hashCode() % values.length);
        ArrayList<Pair<K,V>> valuesAtIndex = values[hashValue];
        
        if(valuesAtIndex.isEmpty()){
            return null;
        }
        
        for(int i = 0; i < valuesAtIndex.size(); i++){
            if(valuesAtIndex.get(i).getKey().equals(key)){
                return valuesAtIndex.get(i).getValue();
            }
        }
        
        return null;
    }
    
    public void add(K key, V value){
        ArrayList<Pair<K,V>> rowList = getArrayListBasedOnKey(key);
        int index = getIndexOfKey(rowList, key);
        
        if(index < 0){
            rowList.add(new Pair<>(key, value));
            
        } else {
            rowList.get(index).setValue(value);
        }
        if(1.0 * usedIndexes/values.length >= 0.75){
            grow();
        }
    }
    
    public ArrayList<Pair<K,V>> getArrayListBasedOnKey(K key){
        int hashValue = Math.abs(key.hashCode() % values.length);
        if(values[hashValue] == null){
            values[hashValue]= new ArrayList<>();
            usedIndexes++;
        }

        return values[hashValue];
    }
    
    public int getIndexOfKey(ArrayList<Pair<K,V>> rowList, K key){
        for(int i = 0; i < rowList.size(); i++){
            if(rowList.get(i).getKey().equals(key)){
                return i;
            }
        }
                
        return -1;
    }
    
    private void grow(){
        ArrayList<Pair<K,V>>[] newValues= new ArrayList[values.length*2];
        for(int i = 0; i < values.length; i++){
            copy(newValues, i);
        }
        values = newValues;
    }
    
    private void copy(ArrayList<Pair<K,V>>[] newArray, int fromIndex){ 
        if(values[fromIndex] != null){
        for(int i = 0; i < values[fromIndex].size(); i++){
            Pair<K,V> value = values[fromIndex].get(i);
            int hashValue = Math.abs(value.getKey().hashCode() % newArray.length);
            if(newArray[hashValue] == null) {
                newArray[hashValue] = new ArrayList<>();
            }
            newArray[hashValue].add(value);
        }
        }
    }
        
    public V remove(K key){
        ArrayList<Pair<K,V>> rowList = getArrayListBasedOnKey(key);
        if(rowList == null){
            return null;
        }
        int index = getIndexOfKey(rowList, key);
        if(index < 0){
            return null;
        }
        
        Pair<K,V> pair = rowList.get(index);
        rowList.remove(index);
        return pair.getValue();
    }
    
    @Override
    public String toString() {
        return "HashMap{" + "values=" + Arrays.toString(values) + '}';
    }
    

}
