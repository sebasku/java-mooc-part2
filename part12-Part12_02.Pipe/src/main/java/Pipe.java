
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
public class Pipe <T> {
    private List<T> pipe;
    
    public Pipe(){
        this.pipe = new ArrayList<>();
    }
    
    public void putIntoPipe(T value){
        pipe.add(0, value);
    }
    
    public T takeFromPipe(){
        if(!pipe.isEmpty()){
            T value = pipe.get(pipe.size());
            pipe.remove(pipe.size());
            return value;
        } else {
            return null;
        }
    }
    
    public boolean isInPipe(){
        return !pipe.isEmpty();
    }
}
