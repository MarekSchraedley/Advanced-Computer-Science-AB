package Q1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Prog505b {
    public static void main(String[] args) {
        try {
            String ltGrades[] = {"A", "B", "C", "D", "E"};
            int grades[] = new int[5];
            double rowAvg[] = new double[5];
            var file = new Scanner(new File("Langdat/prog505b.dat"));
            var nums = new ArrayList<Integer>();
            double sums = 0;
            double temp = 0;
            double average = 0;
            while (file.hasNext()) {
                sums = 0;
                System.out.print(file.nextLine() + " " + file.nextLine());
                for (int lcv = 0; lcv < 5; lcv++) {
                    temp = Integer.parseInt(file.nextLine());
                    System.out.print(" " + temp);
                    sums += temp;
                    rowAvg[lcv] += temp;

                }
                average = (sums / 5);
                System.out.print(" " + average);
                if (average >= 90) {
                    System.out.print(" A");
                    grades[0] += 1;
                } else if (average >= 80) {
                    System.out.print(" B");
                    grades[1] += 1;
                }else if (average >= 70) {
                    System.out.print(" C");
                    grades[2] += 1;
                }else if (average >= 60) {
                    System.out.print(" D");
                    grades[3] += 1;
                } else {
                    System.out.print(" F");
                    grades[4] += 1;
                }
                System.out.println();
            }

            file.close();
            for (int lcv = 0; lcv < 5; lcv++) {
                System.out.println("Test " + lcv + "\t" + (rowAvg[lcv] / 3) + "\t" + ltGrades[lcv] + " " + grades[lcv]);
            }
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }
}
