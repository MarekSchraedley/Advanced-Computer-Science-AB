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
        boolean changed = true;
        while (changed == true) {
            changed = false;
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i).getMyArea() < list.get(i+1).getMyArea()) {
                    gift temp = list.get(i);
                    list.set(i, list.get(i+1));
                    list.set(i+1, temp);
                    changed = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/MSOE2024_7.dat"));
            ArrayList<gift> giftList = new ArrayList<>();
            while (file.hasNext()) {
                String tempName = file.next();
                String temp = file.next();
                int lcv = 0;
                while (!temp.substring(lcv, lcv+1).equals("x")) {
                    lcv++;
                }
                double length = Double.parseDouble(temp.substring(0, lcv));
                int lcv2 = lcv+1;
                while (!temp.substring(lcv2, lcv2+1).equals("x")) {
                    lcv2++;
                }
                double width = Double.parseDouble(temp.substring(lcv+1, lcv2));
                double height = Double.parseDouble(temp.substring(lcv2+1));
                giftList.add(new gift(tempName, length, width, height));
            }
            file.close();
            for (gift mygift : giftList) {
                if (mygift.getMyArea() == 0) {
                    giftList.remove(mygift);
                }
            }
            sortBySize(giftList);

            ArrayList<ArrayList<gift>> lists = new ArrayList<ArrayList<gift>>();
            for (int lcv = 0; lcv < giftList.size(); lcv++) { //Head gift
                ArrayList<gift> list = new ArrayList<>();
                list.add(giftList.get(lcv));
                for (int lcv2 = lcv+1; lcv2 < giftList.size(); lcv2++) {
                    double ratio = list.get(list.size()-1).getMyArea() / giftList.get(lcv2).getMyArea();
                    if (ratio > 1.55 && ratio < 1.65) {
                        list.add(giftList.get(lcv2));
                    }
                }
                lists.add(list);
            }


            int largestLength = 0;
            for (int lcv = 0; lcv < lists.size(); lcv++) {
                if (lists.get(lcv).size() > largestLength) {
                    largestLength = lists.get(lcv).size();
                }
            }
            if (largestLength == 1) {
                System.out.println("No pairs");
            } else {

                Double largestArea = 0.0;
                int largestIndex = 0;
                for (int lcv = 0; lcv < lists.size(); lcv++) {
                    if (lists.get(lcv).size() == largestLength && lists.get(lcv).get(0).getMyArea() > largestArea) {
                        largestArea = lists.get(lcv).get(0).getMyArea();
                        largestIndex = lcv;
                    }
                }

                for (int lcv = 0; lcv < lists.get(largestIndex).size(); lcv++) {
                    gift printItem = lists.get(largestIndex).get(lcv);
                    System.out.println(printItem.myName + " " + printItem.myLength + "x" + printItem.myWidth + "x" + printItem.myHeight + " " + printItem.myArea);
                }

            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
ball_2 20.0x20.0x20.0 8000.0
soda 17.0x17.0x17.0 4913.0
glove 14.42x14.42x14.42 2998.442888
 */