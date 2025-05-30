package Q1;
import java.util.Scanner;

public class Prog52a {
    public static void main(String[] args) {
        var input = new Scanner(System.in);

        System.out.println("Enter length: ");
        int len = input.nextInt();

        System.out.println("Enter width: ");
        int wid = input.nextInt();

        int area = len * wid;
        int perim = 2 * len + 2 * wid;

        System.out.println("Area = " + area);
        System.out.println("Perimiter = " + perim);
    }
}
