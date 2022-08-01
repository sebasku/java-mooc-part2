import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Write your program here
        List<String> values = new ArrayList<>();
        String userInput;
        
        System.out.println("Input numbers, type \"end\" to stop.");
        while(true){
            userInput = scanner.nextLine();
            if(userInput.contains("end")){
                break;
            }
            
            values.add(userInput);
        }
        
        double average = values.stream().mapToInt(val -> Integer.valueOf(val)).average().getAsDouble();
        System.out.println("Average of the numbers: " + average);
    }
}
