package dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        // You can test your dictionary here
        try(BufferedReader reader = new BufferedReader(new FileReader("words.txt"))) {
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }
}
