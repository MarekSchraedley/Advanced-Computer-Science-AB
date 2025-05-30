package Q3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog853a {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog853b.dat"));

            while (file.hasNext()) {

            }
            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
