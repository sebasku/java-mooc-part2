
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>(); 
        String userInput1, userInput2;
        
        while(true){
            System.out.print("Input the name of the book, empty stops:");
            userInput1 = scanner.nextLine();
            if(userInput1.isEmpty()){
                break;
            }
            System.out.print("Input the age recommendation:");
            userInput2 = scanner.nextLine();
            if(userInput2.isEmpty()){
                break;
            }   
            books.add(new Book(userInput1, Integer.valueOf(userInput2)));
        }
        
        System.out.println("\n" + books.size() + " books in total." + "\n");
        System.out.println("Books:");
        Comparator<Book> comparatorBooks = Comparator.comparing(Book::getAgeRecomm)
                .thenComparing(Book::getName);
        Collections.sort(books, comparatorBooks);
        books.stream().forEach(book -> System.out.println(book));
    }

}
