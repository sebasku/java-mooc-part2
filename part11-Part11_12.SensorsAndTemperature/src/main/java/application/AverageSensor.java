/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebkula
 */
public class AverageSensor implements Sensor{
    private List<Sensor> sensors;
    private List<Integer> averages;
    
    public AverageSensor(){
        this.sensors = new ArrayList<>();
        this.averages = new ArrayList<>();
    }
    
    public void addSensor(Sensor toAdd){
        sensors.add(toAdd);
    }
    
    @Override
    public boolean isOn() {
        for(Sensor sensor : sensors){
            if(sensor.isOn() == false){
                return false;
            }
        }
        return true;
    }
    
    public List<Integer> readings(){
        return averages;
    }

    @Override
    public void setOn() {
        sensors.stream().forEach(sensor -> sensor.setOn());
    }

    @Override
    public void setOff() {
        sensors.stream().forEach(sensor -> sensor.setOff());
    }

    @Override
    public int read() {
        if(sensors.isEmpty() || (this.isOn() == false)){
            throw new IllegalStateException("There are no sensors, or average sensor is off");
        }
        int average = sensors.stream().mapToInt(sensor -> sensor.read()).sum()/sensors.size(); 
        averages.add(average);
        return average;
    }
    
    
}
