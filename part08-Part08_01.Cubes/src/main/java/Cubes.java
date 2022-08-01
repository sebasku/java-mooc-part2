
import java.util.HashMap;
import java.util.Scanner;

public class Cubes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        
        while(true){
            userInput = scanner.nextLine();
            
            if(userInput.equals("end")){
                break;
            } else {
                int number = Integer.valueOf(userInput);
                System.out.println((int) Math.pow(number, 3));
            }
            
        }
    }
}
