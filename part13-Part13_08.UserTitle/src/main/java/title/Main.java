package title;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserTitle.launch(UserTitle.class,"--usersTitle=" + scanner);
    }

}
