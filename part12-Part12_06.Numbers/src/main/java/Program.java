
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("How many random numbers should be printed?");
        int amountOfNumb = Integer.valueOf(scanner.nextLine());
        Random randomGen = new Random();
        for(int i = 0; i < amountOfNumb; i++){
            System.out.println(randomGen.nextInt(11));
        }
    }

}
