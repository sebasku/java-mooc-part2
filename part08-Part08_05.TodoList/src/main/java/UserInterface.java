
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
public class UserInterface {
    private final TodoList todolist;
    private Scanner scanner;
    
    public UserInterface(TodoList todolist, Scanner scanner){
        this.todolist = todolist;
        this.scanner = scanner;
    }
    
    public void start(){
        Boolean isInterfaceRunning = true;
        while(isInterfaceRunning){
            System.out.print("Command:");
            String userInput = scanner.nextLine();
            
            if(userInput.contains("stop")){
                isInterfaceRunning = false;
            }
            if(userInput.contains("add")){
                System.out.print("To add:");
                userInput = scanner.nextLine();
                todolist.add(userInput);
            }
            if(userInput.contains("list")){
                todolist.print();
            }
            if(userInput.contains("remove")){
                System.out.print("Which one is removed?:");
                int numberToRemove = Integer.valueOf(scanner.nextLine());
                todolist.remove(numberToRemove);
            }
        }
    }
    
}
