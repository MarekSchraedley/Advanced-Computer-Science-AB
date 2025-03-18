package Q3;

import java.util.Scanner;

public class Msoe2007_7 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("What is the number of digits in the odometer? ");
        int digits = scanner.nextInt();
        System.out.println("What is the current reading? ");
        String reading = scanner.next();
        boolean isPalendrome = false;
        String closestPal = "";
        for (int i = 0; i < digits-reading.length(); i++) {closestPal += "0";}
        closestPal += reading;
        int count = -1;
        String revPal = "";
        while (!isPalendrome) {
            count++;
            revPal = "";
            for (int i = closestPal.length()-1; i >= 0; i--) {
                revPal += closestPal.substring(i, i+1);
            }
            if (closestPal.equals(revPal)) {
                isPalendrome = true;
            } else {
                String closestPalTemp = Integer.toString(Integer.parseInt(closestPal) + 1);
                closestPal = "";
                for (int i = 0; i < digits - closestPalTemp.length(); i++) {
                    closestPal += "0";
                }
                closestPal += closestPalTemp;
            }
        }
        System.out.println(Integer.parseInt(closestPal) - Integer.parseInt(reading));
    }
}
