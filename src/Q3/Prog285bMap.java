package Q3;

import DataStructures.Dictionary;
import DataStructures.Set;
import Q1.Prog285b.Cl285b;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog285bMap {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog285b.txt"));
            var map = new Dictionary<Integer, Cl285b>();

            System.out.println("Id\tCode\tSales\tCommission");
            while (file.hasNext()) {
                int id = file.nextInt();
                int c = file.nextInt();
                double s = file.nextDouble();

                var fred = new Cl285b(id, c, s);
                map.insert(id, fred);
            }
            file.close();

            var iter = map.valueBag().iterator();
            while (iter.hasNext()) {
                System.out.println(iter.next());
            }
        } catch (
                IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
