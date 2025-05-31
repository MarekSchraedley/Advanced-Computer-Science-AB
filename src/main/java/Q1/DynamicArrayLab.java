package Q1;

import Algorithims.SortingAlgorithms;
import DataStructures.DynamicArray;

import java.util.ArrayList;

public class DynamicArrayLab {
    public static void main(String[] args) {
        System.out.println("========= Dynamic array =========");
        var dArray = new DynamicArray<Integer>();
        long start = System.nanoTime();
        for (int i = 0; i < 100_000; i++)
            dArray.add(i);
        long end = System.nanoTime();
        System.out.println("Dynamic Array add: " + (end-start)/1e6 + " ms" );

        start = System.nanoTime();
        for (int i = 0; i < 100_000; i++)
            dArray.remove(0);
        end = System.nanoTime();
        System.out.println("Dynamic Array add: " + (end-start)/1e6 + " ms" );

        start = System.nanoTime();
        dArray.sort();
        end = System.nanoTime();
        System.out.println("Dynamic Array add: " + (end-start)/1e6 + " ms" );

        System.out.println("========= arrayList =========");
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        start = System.nanoTime();
        for (int i = 0; i < 100_000; i++)
            arrayList.add(i);
        end = System.nanoTime();
        System.out.println("Dynamic Array add: " + (end-start)/1e6 + " ms" );

        start = System.nanoTime();
        for (int i = 0; i < 100_000; i++)
            arrayList.remove(0);
        end = System.nanoTime();
        System.out.println("Dynamic Array add: " + (end-start)/1e6 + " ms" );

        start = System.nanoTime();
        for (int i = 1; i < arrayList.size(); i++) {
            int key = arrayList.get(i);
            int j = i - 1;
            while (j >= 0 && arrayList.get(j).compareTo(key) > 0) {
                arrayList.set(j+1, arrayList.get(j));
                j--;
            }
            arrayList.set(j+1, key);
        }
        end = System.nanoTime();
        System.out.println("Dynamic Array add: " + (end-start)/1e6 + " ms" );

    }
}
/*
========= Dynamic array =========
Dynamic Array add: 6.5439 ms
Dynamic Array add: 32475.7787 ms
Dynamic Array add: 0.9927 ms
========= arrayList =========
Dynamic Array add: 7.3924 ms
Dynamic Array add: 278.1646 ms
Dynamic Array add: 0.0037 ms

 */