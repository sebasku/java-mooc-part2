
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sebkula
 */
public class BoxWithMaxWeight extends Box{
    private ArrayList<Item> items;
    private int capacity;
    
    public BoxWithMaxWeight(int capacity){
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public int currentAmount(){
        int sum = 0;
        for(Item item : items){
            sum = sum + item.getWeight();
        }
        return sum;
    }
    
    @Override
    public void add(Item item) {
        if(currentAmount() + item.getWeight() <= capacity){
            items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return items.contains(item);
    }
}
