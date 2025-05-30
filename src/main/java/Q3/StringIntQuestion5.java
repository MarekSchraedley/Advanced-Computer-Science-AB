package Q3;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringIntQuestion5 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("input a String: ");
        String str = scanner.next();
        var upper = Pattern.compile("[A-Z]");
        var lower = Pattern.compile("[a-z]");
        Matcher match1 = upper.matcher(str);
        Matcher match2 = lower.matcher(str);
        System.out.println("Contains only numbers: " + (!match1.find() && !match2.find()));
    }
}
