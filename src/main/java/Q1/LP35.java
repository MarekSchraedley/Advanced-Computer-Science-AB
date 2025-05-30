package Q1;
import java.util.Scanner;
public class LP35 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.print("Enter the change in cents: ");
        int change = input.nextInt();
        System.out.println("The minimum number of coins is: ");
        int quarters = change / 25;
        change = change % 25;
        int dimes = change / 10;
        change = change % 10;
        int nickels = change / 5;
        change = change % 5;
        int pennies = change;
        System.out.println("quarters: " + quarters + "\ndimes: " + dimes + "\nnickels: " + nickels + "\npennies: " + pennies);
    }
}
