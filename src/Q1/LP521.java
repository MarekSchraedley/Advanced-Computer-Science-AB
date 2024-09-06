package Q1;
import java.util.Scanner;
public class LP521 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String firstname = input.nextLine();
        System.out.print("Enter your last name: ");
        String lastname = input.nextLine();
        if (lastname.substring(0, 1).compareTo("I") <= 0) {
            System.out.println(firstname + " " + lastname + " Is assigned to Group 1");
        }
        else if (lastname.substring(0, 1).compareTo("S") <= 0) {
            System.out.println(firstname + " " + lastname + " Is assigned to Group 2");
        }
        else {
            System.out.println(firstname + " " + lastname + " Is assigned to Group 3");
        }
    }
}
