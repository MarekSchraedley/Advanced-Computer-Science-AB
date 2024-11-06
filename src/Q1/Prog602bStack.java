package Q1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog602bStack {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog602b.dat"));
            int account = 0;
            double hours = 0.0;
            int code = 0;
            double total = 0.0;
            System.out.println("Account number\tHours\tCode\tTotal");
            while (file.hasNext()) {
                total = 0;
                account = file.nextInt();
                hours = file.nextDouble();
                code = file.nextInt();
                if (hours >= 0 && hours <= 5) {
                    total = 200;
                }else if (hours <= 15) {
                    total = 200 + (((hours - 5))*50);
                } else {
                    total = 550 + (((hours - 15))*30);
                }
                if (code == 1) {
                    total += 50;
                }else if (code == 2) {
                    total += 150;
                }
                System.out.println(account + "\t" + hours + "\t" + code + "\t" + total);
            }
            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
