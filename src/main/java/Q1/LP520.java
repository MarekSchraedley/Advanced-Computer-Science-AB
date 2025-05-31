package Q1;
import java.util.Scanner;
public class LP520 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        String[] vowels = {"a", "e", "i", "o", "u", "A", "E", "I", "O", "u"};
        System.out.println("Enter Text: ");
        String text = input.nextLine();
        int count = 0;
        for (int lcv = 0; lcv < text.length(); lcv++) {
            for (int lcv2 = 0; lcv2 < vowels.length; lcv2++) {
                if (text.substring(lcv, lcv+1).equals(vowels[lcv2])) {
                    count++;
                }
            }
        }
        System.out.println("The number of vowels in " + text + " is " + count + ".");
    }
}
