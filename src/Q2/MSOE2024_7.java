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
        Double myArea;
        public gift(String name, double length, double width, double height) {
            myName = name;
            myLength = length;
            myWidth = width;
            myHeight = height;
            myArea = length * width * height;
        }
        public String getMyName(){return myName;}
        public Double getMyLength(){return myLength;}
        public Double getMyWidth(){return myWidth;}
        public Double getMyHeight(){return myHeight;}
        public Double getMyArea() {return myArea;}
    }



    public static void sortBySize(ArrayList<gift> list) {
        Boolean changed = true;
        while (changed == true) {
            changed = false;
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i).getMyArea() > list.get(i+1).getMyArea()) {
                    gift temp = list.get(i);
                    list.set(i, list.get(i+1));
                    list.set(i+1, temp);
                    changed = true;
                }
            }
        }
    }

    public static ArrayList<gift> largestRecursive(ArrayList<gift> list) {
        int[] sums = new int[list.size()];
        for (int lcv = 0; lcv < list.size(); lcv++) {
            ArrayList<gift> startTemp = new ArrayList<>();
            startTemp.add(list.get(lcv));
            sums[lcv] = myLargestRecursive(startTemp, list);
        }
    }


    // recursion call self as many times as there are possibilities, compare all possiblities and return largest, for very last possibility find largest starting box
    public static int  myLargestRecursive(ArrayList<gift> largest, ArrayList<gift> list) {

        for (int lcv = 0; lcv < list.size(); lcv++) {



        }

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
            sortBySize(giftList);

            for (int lcv = 0; lcv < giftList.size(); lcv++) { //Head gift
                Boolean endReached = false;
                while (endReached = false) {
                    for (int lcv2 = 0; lcv2 < 0; lcv2++) {

                    }
                }

            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
