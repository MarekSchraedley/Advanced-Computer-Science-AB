package Q2;

import Algorithims.SortingAlgorithms;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Prog575aMergeSort {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog575a.dat"));
            var arrList = new ArrayList<String>();
            String temp = "";
            while (file.hasNext()) {
                temp = file.next();
                System.out.println(temp);
                arrList.add(temp);
            }
            String[] list = new String[arrList.size()];
            for (int lcv = 0; lcv < arrList.size(); lcv++) {
                list[lcv] = arrList.get(lcv);
            }
            SortingAlgorithms.mergeSort(list);
            for (int lcv = 0; lcv < list.length; lcv++) {
                System.out.println(list[lcv]);
            }
            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
