
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        int userInput;
        
        while(true){
            userInput = Integer.valueOf(scanner.nextLine());
            if(userInput < 0){
                break;
            }
            numbers.add(userInput);
        }
        
        numbers.stream().filter(number -> number >= 1 && number <= 5).forEach(System.out::println);
    }
}
