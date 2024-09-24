package Q1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Prog705x {
    public static void main(String[] args) {
        try {
            var poem = new Scanner(new File("Langdat/prog512h.dat"));
            var code = new Scanner(new File("Langdat/prog705x.txt"));
            ArrayList<String> codes = new ArrayList<>();
            while (code.hasNext()) {
                codes.add(code.nextLine());
            }
            System.out.println(codes);
            for (String myCode : codes) {
                System.out.print(myCode);
                for (int lcv = 0; lcv < Integer.parseInt(myCode.substring(0,2)); lcv++) {
                    poem.nextLine();
                }
                for (int lcv = 0; lcv < Integer.parseInt(myCode.substring(2,3))-1; lcv++) {
                    poem.next();
                }

                System.out.println(poem.next().substring(3, 4));
            }
        }catch (Exception e) {
            System.out.println("Could not find data file.");
        }
    }
}
