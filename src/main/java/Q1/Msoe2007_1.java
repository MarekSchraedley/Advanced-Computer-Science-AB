package Q1;

import java.util.Scanner;

public class Msoe2007_1 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Input the known height: ");
        double h1 = input.nextDouble();
        System.out.println("Input the shadow length of the known height: ");
        double l1 = input.nextDouble();
        System.out.println("Input the second length" );
        double l2 = input.nextDouble();
        if (h1 <= 0 || l1 <= 0 || l2 <= 0) {
            System.out.println("ERROR: values cannot be negative or zero");
        }else {
            System.out.println("The unknown height is: " + (h1 * l2) / l1);
        }
    }
}
