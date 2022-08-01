/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sebkula
 */
public class Container {
    private int amount;
    
    public Container(){
        this.amount = 0;
    }
    
    public void add(int amount){
        if(amount > 0){
            this.amount = this.amount + amount > 100 ? 100 : this.amount + amount;
        }
    }
    
    public void remove(int amount){
        if(amount > 0){
            this.amount = this.amount - amount > 0 ? this.amount - amount : 0;
        }
    }
    
    public int contains(){
        return amount;
    }
    
    @Override
    public String toString(){
        return amount + "/100";
    }
}
