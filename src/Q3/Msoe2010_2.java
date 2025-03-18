package Q3;

import java.io.File;
import java.util.Scanner;

public class Msoe2010_2 {
    public static Boolean hasTriple(String str) {
        String triple = "";
        for (int i = 0; i < str.length(); i++) {
            triple = str.substring(i, i+1) + str.substring(i, i+1) + str.substring(i, i+1);
            if (str.contains(triple)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Input string: ");
        String myString = scanner.next();
        System.out.println("Contains triple character: " + hasTriple(myString));
    }
}
