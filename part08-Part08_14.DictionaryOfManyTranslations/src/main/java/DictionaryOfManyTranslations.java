
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
public class DictionaryOfManyTranslations {
    private final HashMap<String, ArrayList<String>> dict;
    
    public DictionaryOfManyTranslations(){
        this.dict = new HashMap<>();
    }
    
    public void add(String word, String translation){
        ArrayList<String> translations;
        if(this.dict.containsKey(word)){
            translations = this.dict.get(word);
            translations.add(translation);
        } else {
            translations = new ArrayList<>();
            translations.add(translation);
        }
        this.dict.put(word, translations);
    }
    
    public ArrayList<String> translate(String word){
        ArrayList<String> translations;
        if(this.dict.containsKey(word)){
            translations = this.dict.get(word);
        } else {
            translations = new ArrayList<>();
        }
        
        return translations;
    }
    
    public void remove(String word){
        if(this.dict.containsKey(word)){
            this.dict.remove(word);
        }
    }
    
}
