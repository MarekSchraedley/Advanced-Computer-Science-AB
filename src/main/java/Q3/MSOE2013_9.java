package Q3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MSOE2013_9 {
    public static class location {
        private String myName;
        private Double myXCoord;
        private Double myYCoord;
        public location(String name, Double xCoord, Double yCoord) {
            myName = name;
            myXCoord = xCoord;
            myYCoord = yCoord;
        }
        public String getMyName() {return myName;}
        public Double getMyXCoord() {return myXCoord;}
        public Double getMyYCoord() {return myYCoord;}
    }
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/Cabs.txt"));
            ArrayList<location> cabs = new ArrayList<>();
            int temp = file.nextInt();
            for (int i = 0; i < temp; i++) {
                cabs.add(new location(Integer.toString(i), file.nextDouble(), file.nextDouble()));
            }
            file = new Scanner(new File("Langdat/Passengers.txt"));
            ArrayList<location> passengers = new ArrayList<>();
            String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
            temp = file.nextInt();
            for (int i = 0; i < temp; i++) {
                passengers.add(new location(letters[i], file.nextDouble(), file.nextDouble()));
            }
            file.close();
            double minDistance = 0;
            int minIndex = 0;
            for (int i = 0; i < passengers.size(); i++) {
                minDistance = Math.abs(cabs.get(0).getMyXCoord()-passengers.get(i).getMyXCoord()) + Math.abs(cabs.get(0).getMyYCoord()-passengers.get(i).getMyYCoord());
                minIndex = 0;
                for (int j = 1; j < cabs.size(); j++) {
                    double tempDistance = Math.abs(cabs.get(j).getMyXCoord()-passengers.get(i).getMyXCoord()) + Math.abs(cabs.get(j).getMyYCoord()-passengers.get(i).getMyYCoord());
                    if (tempDistance < minDistance) {
                        minDistance = tempDistance;
                        minIndex = j;
                    }
                }
                System.out.println("Cab " + cabs.get(minIndex).getMyName() + " dispatched to passenger " + passengers.get(i).getMyName() + " distance " + minDistance);
                cabs.remove(minIndex);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Cab 2 dispatched to passenger A distance 8.499999999999996
Cab 0 dispatched to passenger B distance 6.299999999999997
Cab 9 dispatched to passenger C distance 31.60000000000001
Cab 6 dispatched to passenger D distance 30.700000000000003
Cab 7 dispatched to passenger E distance 17.5
Cab 3 dispatched to passenger F distance 94.3
Cab 8 dispatched to passenger G distance 101.4
Cab 1 dispatched to passenger H distance 11.9
Cab 4 dispatched to passenger I distance 91.0
Cab 5 dispatched to passenger J distance 172.89999999999998
 */