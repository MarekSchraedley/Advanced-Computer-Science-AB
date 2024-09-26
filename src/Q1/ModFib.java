package Q1;
import java.io.*;
import java.util.*;

public class ModFib {
    static int modFibonacci(int n) {
        if (n == 0) {
            return 3;
        }
        if (n==1) {
            return 5;
        }
        if (n==2) {
            return 8;
        }
        return modFibonacci(n-1) + modFibonacci(n-2) + modFibonacci(n-3);
    }

    public static void main(String[] args) {
        Scanner kbReader = new Scanner(System.in);
        System.out.print("Generate which term number? ");
        int k = kbReader.nextInt();
        System.out.println("Term #" + k + " is " + modFibonacci(k));

    }
}
