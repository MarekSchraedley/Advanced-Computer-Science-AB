package Q2;

import DataStructures.CircularDeqeue;
import DataStructures.Queue;
import DataStructures.QueueStack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Prog1060hQueue {

    public static void printThrough(Queue<String>[] list, int index) {
        String[] names = {"Sub Compact", "Compact", "Midsize", "Wagon", "Luxury"};
        System.out.println("Listing for " + names[index]);


        for (int i = 0; i < list[index].size(); i++) {
            String temp = list[index].peek();
            System.out.print("   " + temp + " ");
            list[index].dequeue();
            list[index].enqueue(temp);
            temp = list[5+index].peek();
            System.out.println(temp);
            list[5+index].dequeue();
            list[5+index].enqueue(temp);

        }
        System.out.println();
    }

    public static void printThrough(Queue<String>[] list, ArrayList<String>[] rented) {
        String[] names = {"Sub Compact", "Compact", "Midsize", "Wagon", "Luxury"};
        System.out.println();
        for (int index = 0; index < 5; index++) {
            System.out.println(names[index]);
            for (int i = 0; i < list[index].size(); i++) {
                String temp = list[index].peek();
                System.out.print("   " + temp + " ");
                list[index].dequeue();
                list[index].enqueue(temp);
                temp = list[5+index].peek();
                System.out.println(temp);
                list[5+index].dequeue();
                list[5+index].enqueue(temp);

            }
        }
        System.out.println("Rented");
        for (int index = 0; index < 5; index++) {
            for (int i = 0; i < rented[index].size(); i++) {
                System.out.print("   " + rented[index].get(i) + " ");
                System.out.println(rented[5+index].get(i));
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {
        try {
            ArrayList<String> chars = new ArrayList<>();
            chars.add("S");
            chars.add("C");
            chars.add("M");
            chars.add("W");
            chars.add("L");
            Queue<String>[] list = new Queue[10];
            for (int lcv = 0; lcv < list.length; lcv++) {
                list[lcv] = new Queue<String>();
            }
            ArrayList<String>[] rented = new ArrayList[10];
            for (int lcv = 0; lcv < rented.length; lcv++) {
                rented[lcv] = new ArrayList<String>();
            }
            var file = new Scanner(new File("Langdat/invntory.dat"));

            while (file.hasNext()) {
                String temp = file.next();
                String character = temp.substring(0, 1);
                String name = temp.substring(1);
                list[chars.indexOf(character)].enqueue(name);
                list[5+chars.indexOf(character)].enqueue(file.next());
            }
            file = new Scanner(new File("Langdat/rates.dat"));
            double[][] Index = new double[5][2];
            for (int lcv = 0; lcv < 5; lcv++) {
                Index[lcv][0] = Double.parseDouble(file.next().substring(1));
                Index[lcv][1] = file.nextDouble();
            }

            file = new Scanner(new File("Langdat/transact.dat"));
            while (file.hasNext()) {
                String temp = file.next();
                String command = temp.substring(0, 1);
                if (command.equals("L")) {
                    printThrough(list, chars.indexOf(temp.substring(1)));
                } else if (command.equals("R")) {
                    int code = chars.indexOf(temp.substring(1));
                    rented[code].add(list[code].peek());
                    rented[5+code].add(list[5+code].peek());
                    list[code].dequeue();
                    list[5+code].dequeue();
                } else if (command.equals("A")) {
                    String[] names = {"Sub Compact", "Compact", "Midsize", "Wagon", "Luxury"};
                    int code = chars.indexOf(temp.substring(1, 2));
                    int days = Integer.parseInt(temp.substring(2));
                    double odometer = file.nextDouble();
                    String name = file.next();
                    int indexTemp = rented[code].indexOf(name);
                    list[code].enqueue(rented[code].get(indexTemp));
                    int prevOdometer = (int) Double.parseDouble(rented[5+code].get(indexTemp));
                    list[5+code].enqueue(Double.toString(odometer));
                    rented[code].remove(indexTemp);
                    rented[5+code].remove(indexTemp);
                    System.out.println();
                    System.out.println("Car " + name);
                    System.out.println("Beginning Mileage " +  prevOdometer + "\nEnding Mileage " + odometer);
                    System.out.println("miles driven " + (odometer-prevOdometer) +" @ " + Index[code][1] + " = " + ((odometer-prevOdometer)*Index[code][1]));
                    System.out.println("days driven " + days + " @ " + Index[code][0] + " = " + (days * Index[code][0]));
                    System.out.println("Cartype " + names[code]);
                    System.out.println("Total amount due: " + (((odometer-prevOdometer)*Index[code][1])+(days * Index[code][0])));
                    System.out.println();
                } else if (command.equals("C")) {
                    printThrough(list, rented);
                }
            }
            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Listing for Sub Compact
   Yugo 3456.3
   Chevette 1710.1
   RX7 4002.1
   Sentra 3007.0

Listing for Compact
   Shadow 831.2
   Topaz 412.5
   Contour 1091.7
   Fiero 1541.4

Listing for Midsize
   Cutlass 930.7
   Mystique 117.4
   LaBaron 831.2
   Cougar 1442.2

Listing for Wagon
   Delta88 2417.7
   Caprice 4522.8
   Bonneville 5100.0

Listing for Luxury
   Cadillac 1234.5
   Lincoln 8400.2
   Corvette 10341.7


Sub Compact
Compact
Midsize
   LaBaron 831.2
   Cougar 1442.2
Wagon
   Caprice 4522.8
   Bonneville 5100.0
Luxury
   Lincoln 8400.2
   Corvette 10341.7
Rented
   Yugo 3456.3
   Chevette 1710.1
   RX7 4002.1
   Sentra 3007.0
   null null
   Shadow 831.2
   Topaz 412.5
   Contour 1091.7
   Fiero 1541.4
   Cutlass 930.7
   Mystique 117.4
   Delta88 2417.7
   Cadillac 1234.5


Car Yugo
Beginning Mileage 3456
Ending Mileage 3640.0
miles driven 184.0 @ 0.22 = 40.48
days driven 2 @ 18.0 = 36.0
Cartype Sub Compact
Total amount due: 76.47999999999999


Car Cadillac
Beginning Mileage 1234
Ending Mileage 2801.2
miles driven 1567.1999999999998 @ 0.37 = 579.8639999999999
days driven 2 @ 34.0 = 68.0
Cartype Luxury
Total amount due: 647.8639999999999


Car Contour
Beginning Mileage 1091
Ending Mileage 2031.7
miles driven 940.7 @ 0.25 = 235.175
days driven 3 @ 20.5 = 61.5
Cartype Compact
Total amount due: 296.675

Listing for Sub Compact

Listing for Compact
   Contour 2031.7

Listing for Midsize
   LaBaron 831.2
   Cougar 1442.2

Listing for Wagon
   Caprice 4522.8
   Bonneville 5100.0

Listing for Luxury
   Lincoln 8400.2
   Corvette 10341.7
   Cadillac 2801.2


Sub Compact
Compact
   Contour 2031.7
Midsize
   LaBaron 831.2
   Cougar 1442.2
Wagon
   Caprice 4522.8
   Bonneville 5100.0
Luxury
   Lincoln 8400.2
   Corvette 10341.7
   Cadillac 2801.2
Rented
   Chevette 1710.1
   RX7 4002.1
   Sentra 3007.0
   null null
   Shadow 831.2
   Topaz 412.5
   Fiero 1541.4
   Cutlass 930.7
   Mystique 117.4
   Delta88 2417.7

 */