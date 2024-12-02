package Q2;

import DataStructures.Queue;
import DataStructures.QueueStack;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog602bQueue {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog602b.dat"));
            Queue<Double>[] list = new Queue[3];
            double account = 0;
            double hours = 0.0;
            double code = 0;
            double total = 0.0;
            System.out.println("Account number\tHours\tCode\tTotal");
            total = 0;
            for (int i = 0; i < 3; i++) {
                list[i] = new Queue<Double>();
            }
            while (file.hasNext()) {
                list[0].enqueue(file.nextDouble());
                list[1].enqueue(file.nextDouble());
                list[2].enqueue(file.nextDouble());
            }
            int size = list[0].size();
            for (int i = 0; i < size; i++) {
                account = list[0].peek();
                list[0].dequeue();
                hours = list[1].peek();
                list[1].dequeue();
                code = list[2].peek();
                list[2].dequeue();
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
/*
Account number	Hours	Code	Total
1825.0	3.25	0.0	200.0
14063.0	17.06	1.0	661.8
17185.0	7.93	1.0	396.5
19111.0	12.0	2.0	700.0
20045.0	5.0	1.0	250.0
21352.0	5.84	0.0	242.0
22841.0	27.9	2.0	1087.0
23051.0	1.55	2.0	350.0
29118.0	15.02	0.0	550.6
 */