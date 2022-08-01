/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sebkula
 */
public class Book {
    private String name;
    private int ageRecomm;
    
    public Book(String name, int ageRecomm){
        this.name = name;
        this.ageRecomm = ageRecomm;
    }
    
    public String getName(){
        return name;
    }
    
    public int getAgeRecomm(){
        return ageRecomm;
    }
    
    @Override
    public String toString(){
        return name + " (recommended for " + ageRecomm + " year-olds or older)";
    }
}
