package Algorithims;
import java.util.Arrays;
import java.util.Random;

@SuppressWarnings({"unchecked", "unused", "ManualArrayCopy"})
public class SortingAlgorithms {
    private static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        //Todo
    }

    private static <T extends Comparable<T>> void insertionSort(T[] arr) {
        //Todo
    }

    private static <T extends Comparable<T>> void selectionSort(T[] arr) {
        //Todo
    }

}
