package Q1;

import Algorithims.SortingAlgorithms;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog482j {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/numsort.dat"));
            int count = 0;
            while (file.hasNext()) {
                file.nextInt();
                count++;
            }
            file = new Scanner(new File("Langdat/numsort.dat"));
            Integer[] array = new Integer[count];
            for (int lcv = 0; lcv < array.length; lcv++) {
                array[lcv] = file.nextInt();
            }
            for (int lcv = 0; lcv < array.length; lcv++) {
                System.out.print(array[lcv] + " ");
            }
            System.out.println("\n");
            SortingAlgorithms.insertionSort(array);
            for (int lcv = 0; lcv < array.length; lcv++) {
                System.out.print(array[lcv] + " ");
            }
            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
