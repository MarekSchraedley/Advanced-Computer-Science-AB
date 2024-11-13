package Q1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog1071hSFQ {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/bginvtry.dat"));

            while (file.hasNext()) {

            }

            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
