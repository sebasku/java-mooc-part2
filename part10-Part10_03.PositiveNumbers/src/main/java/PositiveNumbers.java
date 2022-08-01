
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here
        
        List<Integer> numbers = Arrays.asList(5,10,-5,-12,7,3,-8);
        List<Integer> altNumbers = positive(numbers);
    }
    
    public static List<Integer> positive(List<Integer> numbers){
        return numbers.stream().filter(num -> num > 0).collect(Collectors.toList());
    }

}
