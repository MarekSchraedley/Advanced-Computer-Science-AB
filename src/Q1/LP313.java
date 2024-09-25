package Q1;

import java.io.File;
import java.util.Scanner;

public class LP313 {
    public static void main(String[] args) {
        try {
            var scanner = new Scanner(System.in);
            System.out.println("Enter the desired amount: ");
            double amount = scanner.nextDouble();
            System.out.println("Enter the number of years: ");
            double years = scanner.nextDouble();
            System.out.println("Enter the intrest rate: ");
            double interest = scanner.nextDouble();
            System.out.println("The principal that will need to be invested is: " + (amount / (1 + years * interest)));




        }catch (Exception e) {

        }
    }
}
