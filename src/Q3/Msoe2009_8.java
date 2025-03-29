package Q3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Msoe2009_8 {

    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/image1.txt"));
            int count = file.nextInt();
            int length = file.nextInt();
            String line = "";
            for (int i = 0; i < count-1; i++) {
                line = file.nextLine();
                for (int j = 0; j < line.length(); j++) {

                }
            }
            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
