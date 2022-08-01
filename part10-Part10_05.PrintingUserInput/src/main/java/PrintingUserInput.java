
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        List<String> inputList = new ArrayList<>();
        
        while(true){
            userInput = scanner.nextLine();
            if(userInput.isEmpty()){
                break;
            }
            inputList.add(userInput);
        }
        
        inputList.stream().forEach(System.out::println);
    }
}
