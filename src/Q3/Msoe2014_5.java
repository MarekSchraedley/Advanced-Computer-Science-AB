package Q3;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Msoe2014_5 {
    public static void main(String[] args) {
        var file = new Scanner(System.in);
        double input = file.nextInt();
        ArrayList<Double> relevantPrime = new ArrayList<>();
        for (double i = 2; i < input; i++) {
            Boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i%j == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                relevantPrime.add(i);
            }
        }
        double tempInput = input;
        boolean finished = false;
        ArrayList<Double> primeList = new ArrayList<>();
        while (!finished) {
            for (int i = 0; i < relevantPrime.size(); i++) {
                finished = true;
                if (tempInput % relevantPrime.get(i) == 0) {
                    tempInput /= relevantPrime.get(i);
                    primeList.add(relevantPrime.get(i));
                    finished = false;
                    break;
                }
            }
        }
        for (int i = 0; i < relevantPrime.size(); i++) {
            primeList.remove(relevantPrime.get(i));
        }
        double total = primeList.get(0);
        for (int i = 1; i < primeList.size(); i++) {
            total *= primeList.get(i);
        }
        System.out.println(total);
    }
}
