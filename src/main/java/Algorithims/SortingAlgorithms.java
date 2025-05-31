package Algorithims;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@SuppressWarnings({"unchecked", "unused", "ManualArrayCopy"})
public class SortingAlgorithms {
    public static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j].compareTo(arr[j+1]) > 0)
                    swap(arr, j, j+1);
            }
        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static <T extends Comparable<T>> void selectionSort(T[] arr) {
        int minIndex = 0;
        T temp = null;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static <T extends Comparable<T>> void shellSort(T[] arr) {
        int gap = arr.length/2;
        while (gap != 0) {
            for (int j = 0; j < arr.length-gap; j++) {
                if(arr[j].compareTo(arr[j+gap]) > 0)
                    swap(arr, j, j+gap);
            }
            gap--;
        }
    }

    /* ===== Merge Sort ===== */
    public static <T extends Comparable<T>> void mergeSort(T[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }

    public static <T extends Comparable<T>> void mergeSort(T[] arr, int l, int r) {
        if (r-l > 0) {
            mergeSort(arr, l, ((r + l) / 2));
            mergeSort(arr, ((r + l) / 2)+1, r);
            merge(arr, l, ((r + l) / 2), r);
        }
    }

    public static <T extends Comparable<T>> void merge(T[] arr, int l, int m, int r) {
        int lInc = 0;
        int rInc = 0;
        var constArr = new ArrayList<T>();
        for (int lcv = 0; lcv < arr.length; lcv++) {
            constArr.add(arr[lcv]);
        }
        boolean left = false;
        boolean right = false;
        System.out.println(r);
        for (int i = 0; i < r; i++) {
            left = false;
            right = false;
            if (l + lInc >= m) {
                left = true;
            }
            if (m + rInc >= r) {
                right = true;
            }
            if (!left && !right) {
                System.out.println("otherstatement");
                if ((constArr.get(l+lInc).compareTo(constArr.get(m+rInc)) <= 0)) {
                    arr[i] = constArr.get(l+lInc);
                    lInc++;
                } else {
                    arr[i] = constArr.get(m + rInc);
                    rInc++;
                }
            } else {
                System.out.println("extrastatement");
              if (left && !right) {
                  arr[i] = constArr.get(m + rInc);
                  rInc++;
              }
              else if (!left && right) {
                  arr[i] = constArr.get(l+lInc);
                  lInc++;
              }
            }
        }
    }



    public static <T extends Comparable<T>> void quickSort(T[] arr) {
quickSort(arr, 0, arr.length-1);
    }


    public static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }

    public static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return  i + 1;
    }

    /* ================ HeapSort ================ */
    public static <T extends Comparable<T>> void heapSort(T[] arr) {
        int n = arr.length;
        buildMaxHeap(arr);
        for (int i = n-1; i > 0; i--) {
            swap(arr, 0 ,i);
            n -= 1;
            maxHeapify(arr, 0, n);
        }
    }

    private static <T extends Comparable<T>> void buildMaxHeap(T[] arr) {
        int n = arr.length;
        for (int i = (n/2) - 1; i >= 0 ; i--) {
            maxHeapify(arr, i, n);
        }
    }

    private static <T extends Comparable<T>> void maxHeapify(T[] arr, int i, int n) {
        var largest = i;
        var left = 2 * i + 1;
        var right = 2 * i + 2;
        if (left < n && arr[left].compareTo(arr[largest]) > 0) {
            largest = left;
        }
        if (right < n && arr[right].compareTo(arr[largest]) > 0) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, largest, n);
        }
    }


}
