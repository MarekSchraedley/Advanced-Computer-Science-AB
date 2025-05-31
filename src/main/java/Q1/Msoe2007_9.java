package Q1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Msoe2007_9 {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/problem9.dat"));
            ArrayList<Integer> myList = new ArrayList<Integer>();
            while (file.hasNext()) {
                myList.add(file.nextInt());

            }
            Boolean noVal = false;
            int start = 0;
            int count = 0;
            while (!noVal) {
                count = 0;
                for (int item : myList) {
                    if (item == start || item == start+1) {
                        count++;
                    }
                }
                if (count == 0) {
                    noVal = true;
                } else {
                    System.out.print(start + " - " + (start+1) + " ");
                    for (int lcv = 0; lcv < count; lcv++) {
                        System.out.print("*");
                    }
                    System.out.println();
                    start += 2;
                }
            }
            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
