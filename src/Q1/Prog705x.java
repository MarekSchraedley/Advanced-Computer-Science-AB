package Q1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Prog705x {
    public static void main(String[] args) {
        try {
            var code = new Scanner(new File("Langdat/prog705x.txt"));
            ArrayList<String> codes = new ArrayList<>();
            while (code.hasNext()) {
                codes.add(code.nextLine());
            }
            System.out.println(codes);
            for (String myCode : codes) {
                var poem = new Scanner(new File("Langdat/prog512h.dat"));
                System.out.print(myCode);
                for (int lcv = 0; lcv < Integer.parseInt(myCode.substring(0,2))-1; lcv++) {
                    poem.nextLine();
                }
                for (int lcv = 0; lcv < Integer.parseInt(myCode.substring(2,3))-1; lcv++) {
                    poem.next();
                }

                System.out.println(poem.next().substring(Integer.parseInt(myCode.substring(3, 4))-1, Integer.parseInt(myCode.substring(3, 4))));
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
