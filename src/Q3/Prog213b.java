package Q3;

import DataStructures.Set;
import Q1.Prog285b.Cl285b;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog213b {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog213b.txt"));
            var set = new Set<Integer>();
            while (file.hasNext()) {
                set.insert(file.nextInt());
            }

            Double price = 0.0;
            var quantity =0;
            if (quantity  > 0 && quantity <= 99) {
                price = 5.95;
            } else if (quantity >= 100 && quantity <= 199) {
                price = 5.75;
            } else if (quantity >= 200 && quantity <= 299) {
                price = 5.40;
            } else if (quantity >= 300) {
                price = 5.15;
            }

            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
