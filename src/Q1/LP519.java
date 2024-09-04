package Q1;
import java.util.Scanner;

public class LP519 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter a scentence: ");
        String scentence = scanner.next();
        System.out.print("Enter a word: " );
        String word = scanner.next();
        scentence = scentence.substring(0, scentence.indexOf(word)) + scentence.substring(scentence.indexOf(word)+word.length());
        System.out.println(scentence);
    }
}
