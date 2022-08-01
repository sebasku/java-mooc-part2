
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
public class IOU {
    private HashMap<String, Double> WhoAndHowMuch;
    
    public IOU(){
        this.WhoAndHowMuch = new HashMap<>();
    }
    
    public void setSum(String toWhom, double amount){
        this.WhoAndHowMuch.put(toWhom, amount);
    }
    
    public double howMuchDoIOweTo(String toWhom){
        return this.WhoAndHowMuch.getOrDefault(toWhom, 0.0);
    }
}
