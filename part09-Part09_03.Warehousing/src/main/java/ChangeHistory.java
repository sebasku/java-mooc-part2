
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
public class ChangeHistory {
    private final ArrayList<Double> history;
    
    public ChangeHistory(){
        history = new ArrayList<>();
    }
    
    public void add(double status){
        history.add(status);
    }
    
    public void clear(){
        history.clear();
    }
    
    public String toString(){
        return history.toString();
    }
    
    public double maxValue(){
        double value = 0;
        for(Double valueInHistory : history){
            if(!(value > valueInHistory)){
              value = valueInHistory;
            }
        }
        return value;
    }
    
    public double minValue(){
        double value = history.get(0);
        for(Double valueInHistory : history){
            if(value > valueInHistory){
              value = valueInHistory;
            }
        }
        return value;
    }
    
    public double average(){
        double sum=0;
        for(Double valueInHistory : history){
            sum = sum + valueInHistory;
        }
        return sum/history.size();
    }
}
