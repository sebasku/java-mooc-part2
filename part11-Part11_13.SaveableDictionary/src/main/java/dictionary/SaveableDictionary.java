/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Sebkula
 */
public class SaveableDictionary {
    private Map<String, String> dictionary;
    private Map<String, String> dictionary_two;
    private String fileName;
    
    
    public SaveableDictionary(){
        this.dictionary = new HashMap<>();
        this.dictionary_two = new HashMap<>();
    }
    
    public SaveableDictionary(String file){
        this();
        fileName = file;
    }
    
    public void add(String words, String translation){
        /*if(!dictionary.containsKey(words)){
            dictionary.put(words, translation);
            dictionary.put(translation, words);
        }
        */
        dictionary.putIfAbsent(words, translation);
        dictionary_two.putIfAbsent(translation, words);
    }
    
    public String translate(String word){
        String translation;
        if(dictionary.containsKey(word)){
            translation = dictionary.get(word);
        } else if(dictionary_two.containsKey(word)){
            translation = dictionary_two.get(word);
        } else {
            translation = null;
        }
        return translation;
    }
    
    public void delete(String word){
        String translation;
        if(dictionary.containsKey(word)){
            translation = dictionary.get(word);
            dictionary.remove(word);
            dictionary_two.remove(translation);
        } else if(dictionary_two.containsKey(word)){
            translation = dictionary_two.get(word);
            dictionary_two.remove(word);
            dictionary.remove(translation);
        }
    }
    
    public boolean load(){
        List<String> rows = new ArrayList<>();
        try{
            Files.lines(Paths.get(fileName)).forEach(row -> rows.add(row));
            for(String line : rows){
                String[] parts = line.split(":");
                this.add(parts[0], parts[1]);
            }
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
    
    public boolean save() {
        
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            for(Entry<String, String> entry : dictionary.entrySet()){
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}
 