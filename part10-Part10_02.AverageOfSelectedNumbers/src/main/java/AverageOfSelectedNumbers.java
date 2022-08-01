
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne
        System.out.println("Input numbers, type \"end\" to stop.");
        String userInput;
        List<String> values = new ArrayList<>();
        
        while(true){
            userInput = scanner.nextLine();
            if(userInput.contains("end")){
                    System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
                    userInput = scanner.nextLine();
                break;
            }
            values.add(userInput);
        }

        double average;
        if(userInput.contains("n")){
            average = values.stream().mapToInt(val -> Integer.valueOf(val)).filter(val -> val < 0).average().getAsDouble();
            System.out.println("Average of the negative numbers: " + average);
        } else if(userInput.contains("p")){
            average = values.stream().mapToInt(val -> Integer.valueOf(val)).filter(val -> val > 0).average().getAsDouble();
            System.out.println("Average of the positive numbers: " + average);
        }
        
    }
}
