/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Sebkula
 */
public class Dictionary {
    private List<String> words;
    private Map<String, String> dictionary;

    public Dictionary(){
        this.dictionary = new HashMap<>();
        this.words = new ArrayList<>();
        
        add("sana", "word");
    }
    
    public void add(String word, String translation){
        if(!dictionary.containsKey(word)){
            words.add(word);
        }
        dictionary.put(word, translation);
    }
    
    public String get(String word){
        return dictionary.get(word);
    }
    
    public String getRandomWord(){
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }
}
