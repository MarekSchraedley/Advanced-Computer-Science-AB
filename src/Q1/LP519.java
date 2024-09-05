package Q1;
import java.util.Scanner;

public class LP519 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.print("Enter a scentence: ");
        String scentence = input.nextLine();
        System.out.print("Enter a word: " );
        String word = input.nextLine();
        scentence = scentence.substring(0, scentence.indexOf(word)) + scentence.substring(scentence.indexOf(word)+word.length());
        System.out.println(scentence);
    }
}
