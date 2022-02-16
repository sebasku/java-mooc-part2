/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sebkula
 */
public class ProductWarehouseWithHistory extends ProductWarehouse{
    private ChangeHistory history;
    
    public ProductWarehouseWithHistory(String productName, double capacity, double initalBalance){
        super(productName, capacity);
        super.addToWarehouse(initalBalance);
        history = new ChangeHistory();
        history.add(initalBalance);
    }
    
    public String history(){
        return history.toString();
    }
    
    public void addToWarehouse(double amount){
        double finalAmount = 0;
        finalAmount = super.getBalance() + amount;
        history.add(finalAmount);
        super.addToWarehouse(amount);
    }
    
    public double takeFromWarehouse(double amount){
        double finalAmount = 0;
        finalAmount = super.getBalance() - amount;
        history.add(finalAmount);
        return super.takeFromWarehouse(amount);
    }
    
    public void printAnalysis(){
        System.out.println("Product: " + super.getName());
        System.out.println("History: " + this.history());
        System.out.println("Largest amount of product: " + history.maxValue());
        System.out.println("Smallest amount of product: " + history.minValue());
        System.out.println("Average: " + history.average());
    }
}
