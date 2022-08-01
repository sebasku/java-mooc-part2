
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>(); 
        int number;
        while(true){
            number = Integer.valueOf(scanner.nextLine());
            if(number > 0){
                numbers.add(number);
            }
            if(number == 0){
                break;
            }
        }
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        if(sum == 0){
            System.out.println("Cannot calculate the average");
        } else {
            System.out.println(1.0*sum/numbers.size());
        }
    }
}
