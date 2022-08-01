
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container container1 = new Container();
        Container container2 = new Container();
        
        while (true) {
            System.out.println("First: " + container1);
            System.out.println("Second: " + container2);

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            
            String[] split = input.split(" ");
            int number = Integer.valueOf(split[1]);
            switch(input){
                case "add":
            }
                    
            if (split[0].equals("add")){
                container1.add(number);
            }           
            if (split[0].equals("move")){
               if(number > container1.contains()){
                   number = container1.contains();
               }
               container1.remove(number);
               container2.add(number);
            }
            if (split[0].equals("remove")){
                if(number > container2.contains()){
                    number = container2.contains();
                }
                container2.remove(number);
            }
        }
    }
}
