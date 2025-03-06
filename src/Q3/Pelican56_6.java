package Q3;

import java.io.File;
import java.util.Scanner;

public class Pelican56_6 {
    public static int hashCode(String key) {
        String tempKey = key.toUpperCase();
        return ((int) tempKey.charAt(0)) * 1000 + ((int) tempKey.charAt(1)) * 100 + ((int) tempKey.charAt(tempKey.length()-2)) * 10 + ((int) tempKey.charAt(tempKey.length()-1));
    }
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println(hashCode(scanner.next())%180);
    }
}
