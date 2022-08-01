
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
public class TodoList {
    private final List<String> list;
    
    public TodoList(){
        list = new ArrayList<>();
    }
    
    public void add(String task){
        list.add(task);
    }
    
    public void print(){
        for(int i=0; i<list.size(); i++){
            System.out.println(i+1 + ": " + list.get(i));
        }
    }
    
    public void remove(int number){
        list.remove(number - 1);
    }
}
