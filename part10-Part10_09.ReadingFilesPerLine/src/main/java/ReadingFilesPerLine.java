
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReadingFilesPerLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test the method here
        List<String> linesTxt = read(scanner.nextLine());
    }

    public static List<String> read(String file){
        List<String> readedLines = new ArrayList<>();
        try{
            Files.lines(Paths.get(file)).forEach(row -> readedLines.add(row));
        } catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        return readedLines;
    }
}
