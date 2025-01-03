package Q2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MSOE2024_7 {
    public static class gift {
        String myName;
        Double myLength;
        Double myWidth;
        Double myHeight;
        public gift(String name, double length, double width, double height) {
            myName = name;
            myLength = length;
            myWidth = width;
            myHeight = height;
        }
        public String getMyName(){return myName;}
        public Double getMyLength(){return myLength;}
        public Double getMyWidth(){return myWidth;}
        public Double getMyHeight(){return myHeight;}
    }
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/REPLACE.dat"));
            ArrayList<gift> giftList = new ArrayList<>();
            while (file.hasNext()) {
                String tempName = file.next();
                String temp = file.next();
                int lcv = 0;
                while (temp.substring(lcv, lcv+1) != "x") {
                    lcv++;
                }
                int length = Integer.parseInt(temp.substring(0, lcv));
                int lcv2 = lcv;
                while (temp.substring(lcv2, lcv2+1) != "x") {
                    lcv2++;
                }
                int width = Integer.parseInt(temp.substring(lcv+1, lcv2));
                int height = Integer.parseInt(temp.substring(lcv2+1));
                giftList.add(new gift(tempName, length, width, height));
            }
            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
