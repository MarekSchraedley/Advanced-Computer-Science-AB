package Q3;

import DataStructures.Set;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog505a {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog505a.txt"));
            var set = new Set<Integer>();
            while (file.hasNext()) {
                set.insert(file.nextInt());
            }
            System.out.println("Reading Contest\nName\t\tBooks\tPoints");
            var iter = set.iterator();
            while (iter.hasNext()) {
                int total = 0;
                var quantity = iter.next();
                System.out.println("Quantity: " + quantity);
                for (int i = 0; i < quantity; i++) {
                    if (i  > 0 && i <= 3) {
                        total += 10;
                    } else if (i >= 4 && i <= 6) {
                        total += 15;
                    } else if (i >= 7) {
                        total += 20;
                    }
                }
                //System.out.println("Price Per: " + price);
                //System.out.println("Price: " + (price * quantity));
                System.out.println();
            }


            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}