package Q3;

import Algorithims.SortingAlgorithms;
import DataStructures.Heap;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog485aHeapSort {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog485a.dat"));
            var heap = new Heap<Integer>();
            while (file.hasNext()) {
                int temp = Integer.parseInt(file.next());
                System.out.print(temp + " ");
                heap.insert(temp);
            }
            file.close();
            Integer[] newHeap = new Integer[heap.size()];
            int tempSize = heap.size();
            System.out.println();
            for (int i = 0; i < tempSize; i++) {
                System.out.print(heap.peek() + " ");
                newHeap[i] = heap.peek();
                heap.delete();
            }
            System.out.println();
            SortingAlgorithms.heapSort(newHeap);
            System.out.println("Frequency Number");
            int CurrentLargest = newHeap[0];
            int frequency = 1;
            for (int i = 1; i < newHeap.length; i++) {
                if (newHeap[i] > CurrentLargest) {
                    System.out.print(CurrentLargest + "\t\t");
                    System.out.println(frequency);
                    frequency = 1;
                    CurrentLargest = newHeap[i];
                } else {
                    frequency++;
                }
            }
            System.out.print(CurrentLargest + "\t\t");
            System.out.println(frequency);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
80 75 50 50 50 50 60 60 40 40 25 45 50 45 45 50 50 50 20 20 10 85 85 100 100 50 50 100 10 90 10 70 70 70 70 60 60 60 90 90 80 20 10 40 5 95 50 50 50
100 100 100 95 90 90 90 85 85 80 80 75 70 70 70 70 60 60 60 60 60 50 50 50 50 50 50 50 50 50 50 50 50 50 45 45 45 40 40 40 25 20 20 20 10 10 10 10 5
Frequency Number
5		1
10		4
20		3
25		1
40		3
45		3
50		13
60		5
70		4
75		1
80		2
85		2
90		3
95		1
100		3
 */