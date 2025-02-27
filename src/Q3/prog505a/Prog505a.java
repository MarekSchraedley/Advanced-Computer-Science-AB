package Q3.prog505a;

import DataStructures.Set;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog505a  {

    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog505a.dat"));
            var set = new Set<Cl505a>();
            while (file.hasNext()) {
                set.insert(new Cl505a(file.next() + " " + file.next(), file.nextInt()));
            }
            System.out.println("Reading Contest\nName\t\tBooks\tPoints");
            var Iter = set.iterator();
            while (Iter.hasNext()) {
                var temp = Iter.next();
                System.out.print(temp.getName());
                int total = 0;
                var quantity = temp.getBooks();
                System.out.print("\t" + quantity);
                for (int i = 1; i <= quantity; i++) {
                    if (i  > 0 && i <= 3) {
                        total += 10;
                    } else if (i >= 4 && i <= 6) {
                        total += 15;
                    } else if (i >= 7) {
                        total += 20;
                    }
                }
                System.out.println("\t" + total);
            }


            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}