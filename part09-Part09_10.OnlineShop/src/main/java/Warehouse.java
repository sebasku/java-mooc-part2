
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
public class Warehouse {
    private final Map<String, Integer> productsPrices;
    private final Map<String, Integer> productsStock;
    
    public Warehouse(){
        productsPrices = new HashMap<>();
        productsStock = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock){
        productsPrices.put(product, price);
        productsStock.put(product, stock);
    }
    
    public int price(String product){
        if(productsPrices.containsKey(product)){
            return productsPrices.get(product);
        }
        
        return -99;
    }
    
    public int stock(String product){
        if(productsStock.containsKey(product)){
            return productsStock.get(product);
        } 
        
        return 0;
    }
    
    public boolean take(String product){
        int stock = 0;
        if(productsStock.containsKey(product)){
            stock = productsStock.get(product);
        } else {
            stock = -1;
        }
        
        if(stock > 0){
            stock--;
            productsStock.put(product, stock);
            return true;
        } 
        
        return false;
    }
    
    public Set<String> products(){
        Set<String> names = new HashSet<>();
        
        for(String name : productsPrices.keySet()){
            names.add(name);
        }
        
        return names;
    }
    
}
