
import java.util.Scanner;

public class LiquidContainers {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int container1 = 0;
        int container2 = 0;


        while (true) {
            System.out.println("First: " + container1 + "/100");
            System.out.println("Second: " + container2 + "/100");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            
            String[] split = input.split(" ");
            int number = Integer.valueOf(split[1]);
            
            if (split[0].equals("add")){
                if(container1 + number <= 100){
                    if(number > 0){
                    container1 = container1 + number; 
                    }
                } else {
                    container1 = 100;
                }
            }           
            if (split[0].equals("move")){
                if(container1 < number){
                    container2 = container2 + container1;
                    container1 = 0;
                } else {
                    container2 = container2 + number;
                    container1 = container1 - number;
                }
                
                if(container2 > 100){
                    container2 = 100;
                }
            }
            if (split[0].equals("remove")){
                container2 = container2 - number < 0 ? 0 : container2 - number;
                }
            }
        }
    }

