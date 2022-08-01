/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sebkula
 */
public class Hideout<T> {
    private T object;
    
    public Hideout(){

    }
    
    public void putIntoHideout(T toHide){
        object = toHide;
    }
    
    public T takeFromHideout(){
        if(object != null){
            return object;
        } else {
            object = null;
            return null;
        }
    }
    
    public boolean isInHideout(){
        if(object != null){
            return true;
        } else {
            return false;
        }
    }
}
