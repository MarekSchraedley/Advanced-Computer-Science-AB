package Q3;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Pelican54_7 {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/HeapData.txt"));
            ArrayList<String> array = new ArrayList<>();
            int index = 1;
            array.add(null);
            while (file.hasNext()) {
                array.add(file.next());
            }
            for (int i = 1; i < array.size(); i++) {
                System.out.print(array.get(i) + " ");
                if ((Math.log10(i+1)/Math.log10(2))%1.0 == 0) {
                    System.out.println();
                }
            }
            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
