package Q1;
import java.util.Scanner;

public class LP510 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);

        System.out.println("Enter num1 and num seperated by a space");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int temp = 0;

        while (num2 > 0) {
            temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }

        System.out.println("GCD = " + num1);
    }
}
