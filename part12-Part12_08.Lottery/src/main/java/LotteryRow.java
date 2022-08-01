
import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {

    private ArrayList<Integer> numbers;

    public LotteryRow() {
        // Draw the numbers when the LotteryRow is created
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void randomizeNumbers() {
        // Initialize the list for numbers
        this.numbers = new ArrayList<>(7);
        Random randomGen = new Random();
        int randomNumber = randomGen.nextInt(40) + 1;;
        
        for(int i = 0; i < 7; i++){
            while(this.containsNumber(randomNumber)){
                randomNumber = randomGen.nextInt(40 - 1) + 1;
            } 
            numbers.add(randomNumber);
        }
        // Implement the random number generation here
        // the method containsNumber is probably useful
        
    }

    public boolean containsNumber(int number) {
        // Check here whether the number is among the drawn numbers
        return numbers.stream().anyMatch(numberFromStream -> numberFromStream.equals(number));
    }
}

