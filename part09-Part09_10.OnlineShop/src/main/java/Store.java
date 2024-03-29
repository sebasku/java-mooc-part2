
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sebkula
 */
public class Store {
    private Warehouse warehouse;
    private Scanner scanner;
    
    public Store(Warehouse warehouse, Scanner scanner){
        this.warehouse = warehouse;
        this.scanner = scanner;
    }
    
    public void shop(String customer){
        ShoppingCart cart = new ShoppingCart();
        
        System.out.println("Welcome to the store " + customer);
        System.out.println("our selection:");
        
        for(String product : this.warehouse.products()){
            System.out.println(product);
        }
        
        while(true){
            System.out.print("What to put in the cart (press enter to go to the register)");
            String product = scanner.nextLine();
            if(product.isEmpty()){
                break;
            }
            
            if(warehouse.take(product)){
                cart.add(product, warehouse.price(product));
            }
        }
        
        System.out.println("Your shopping cart: ");
        cart.print();
        System.out.println("Total: " + cart.price());
    }
}
