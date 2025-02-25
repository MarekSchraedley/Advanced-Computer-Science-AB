package Q3.prog505a;

import DataStructures.Set;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog505a {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog505a.dat"));
            var set = new Set<Integer>();
            var nameSet = new Set<String>();
            while (file.hasNext()) {
                nameSet.insert(file.next() + " " + file.next());
                set.insert(file.nextInt());
            }
            System.out.println("Reading Contest\nName\t\tBooks\tPoints");
            var intIter = set.iterator();
            var strIter = nameSet.iterator();
            int winner = 0;
            while (intIter.hasNext()) {
                System.out.println(intIter.next());
            }
//            while (intIter.hasNext()) {
//                System.out.print(strIter.next());
//                int total = 0;
//                var quantity = intIter.next();
//                System.out.print("\t" + quantity);
//                for (int i = 1; i <= quantity; i++) {
//                    if (i  > 0 && i <= 3) {
//                        total += 10;
//                    } else if (i >= 4 && i <= 6) {
//                        total += 15;
//                    } else if (i >= 7) {
//                        total += 20;
//                    }
//                }
//                System.out.println("\t" + total);
//                System.out.println();
//            }


            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}