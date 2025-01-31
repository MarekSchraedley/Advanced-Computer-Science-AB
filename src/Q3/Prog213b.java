package Q3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog213b {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Enter Quantity: ");
        int quantity = scanner.nextInt();
        Double price = 0.0;
        if (quantity  > 0 && quantity <= 99) {
            price = 5.95;
        } else if (quantity >= 100 && quantity <= 199) {
            price = 5.75;
        } else if (quantity >= 200 && quantity <= 299) {
            price = 5.40;
        } else if (quantity >= 300) {
            price = 5.15;
        }


    }
}
