package Q1;
import java.util.Scanner;
public class LP313 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        String[] array = {"Books", "Supplies", "Housing", "Tuition", "Personal expenses", "Meal Plan"};
        double expense = 0;
        double offset = 0;
        for (String item : array) {
            System.out.println("Input the cost of your " + item + ":");
            expense += scanner.nextDouble();
            System.out.println("Input the offset cost for " + item + " (Scholarships, etc.):");
            offset += scanner.nextDouble();
        }
        System.out.println("Your expenses after offset are: " + (expense-offset));
    }
}
