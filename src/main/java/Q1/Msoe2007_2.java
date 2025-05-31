package Q1;

import java.util.Scanner;

public class Msoe2007_2 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        String[] vowels = {"a", "e", "i", "o", "u", "A", "E", "I", "O", "U"};
        System.out.println("Input a string: ");
        String myString = input.next();
        int count = 0;
        for (int lcv = 0; lcv < myString.length(); lcv++) {
            for (int lcv2 = 0; lcv2 < vowels.length; lcv2++) {
                if (myString.substring(lcv, lcv+1).equals(vowels[lcv2])) {
                    count++;
                }
            }
        }
        System.out.println("There are " + count + " vowels in your string");
    }
}
