package Q1;

import Algorithims.SortingAlgorithms;

public class Pelican401 {
    public static void main(String args[]) {
        Integer base[] = {4,2,5,1,3,18,0,9,6};
        Integer theArray[] = {4,2,5,1,3,18,0,9,6};
        SortingAlgorithms.bubbleSort(theArray);
        for(int j = 0; j < theArray.length; j++)
        {
            System.out.print(theArray[j] + " ");
        }
        System.out.println(" ");

        theArray = base;
        SortingAlgorithms.selectionSort(theArray);
        for(int j = 0; j < theArray.length; j++)
        {
            System.out.print(theArray[j] + " ");
        }
        System.out.println(" ");

        theArray = base;
        SortingAlgorithms.insertionSort(theArray);
        for(int j = 0; j < theArray.length; j++)
        {
            System.out.print(theArray[j] + " ");
        }
        System.out.println(" ");
    }
}

