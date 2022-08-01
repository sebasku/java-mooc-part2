
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sebkula
 */
public class Box implements Packable{
    final private List<Packable> itemsInBox;
    private double maxWeight;

    public Box(double weight){
        this.itemsInBox = new ArrayList<>();
        this.maxWeight = weight;
    }
    
    @Override
    public double weight() {
        double weight = 0;
        for(Packable oneItem : itemsInBox){
            weight = weight + oneItem.weight();
        }
        
        return weight;
    }
    
    public void add(Packable item){
        if(this.weight() + item.weight() <= this.maxWeight){
            itemsInBox.add(item);
        }
    }
    
    @Override
    public String toString(){
        return "Box: " + itemsInBox.size() + " items, total weight " + this.weight() + " kg";
    }
}
