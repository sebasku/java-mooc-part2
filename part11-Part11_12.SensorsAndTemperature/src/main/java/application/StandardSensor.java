/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author Sebkula
 */
public class StandardSensor implements Sensor{
    private int value; 

    public StandardSensor(int value){
        this.value = value;
    }
    
    @Override
    public boolean isOn() {
        //always return true because its always On
        return true;
    }

    @Override
    public void setOn() {
        //always On, not needed
    }

    @Override
    public void setOff() {
        //always On, not needed
    }

    @Override
    public int read() {
        return value;
    }
    
}
