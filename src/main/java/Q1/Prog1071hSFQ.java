package Q1;

import DataStructures.Queue;
import DataStructures.QueueStack;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog1071hSFQ {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/bginvtry.txt"));
            QueueStack<Double>[] list = new QueueStack[10];
            int code = 0;
            int quantity = 0;
            double value = 0;
            while (file.hasNext()) {
                code = file.nextInt();
                System.out.print(code + " ");
                quantity = file.nextInt();
                System.out.print(quantity + " ");
                value = file.nextDouble();
                System.out.print(value + " ");
                for (int lcv = 0; lcv < quantity; lcv++) {
                    if (list[code-1] == null) {
                        list[code-1] = new QueueStack<Double>();
                    }
                    list[code-1].push(value);
                }
                System.out.println();
            }


            file = new Scanner(new File("Langdat/buysell.txt"));
            String firstChar = "";
            while (file.hasNext()) {
                firstChar = file.next();
                code = file.nextInt();
                quantity = file.nextInt();
                if (firstChar.equals("B")) {
                    value = file.nextDouble();
                    for (int i = 0; i < quantity; i++) {
                        list[code-1].push(value);
                    }
                }else if (firstChar.equals("S")) {
                    for (int i = 0; i < quantity; i++) {
                        list[code-1].pop();
                    }
                }
            }
            System.out.println();
            int listConst = 0;
            int count = 0;
            double val = 0;
            for (int lcv = 0; lcv < list.length; lcv++) {
                listConst = list[lcv].size();
                count = 1;
                val = list[lcv].peek();
                list[lcv].pop();
                for (int i = 1; i < listConst; i++) {
                    if (list[lcv].peek() != val) {
                        System.out.println((lcv + 1) + " " + count + " " + val);
                        count = 0;
                    }
                    val = list[lcv].peek();
                    count++;
                    list[lcv].pop();
                }
                System.out.println((lcv + 1) + " " + count + " " + val);
            }
            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
1 50 1298.0
2 50 107.5
3 100 248.85
4 5000 1.07
5 20 489.75
6 5 586.24
7 30 84.23
8 600 24.73
9 1500 19.99
10 15 238.99

1 13 1298.0
2 2 111.25
3 15 275.55
3 72 248.85
4 750 1.1
4 5000 1.07
5 20 510.25
5 2 489.75
6 4 586.24
7 10 87.5
7 30 84.23
8 600 24.73
9 10 21.25
9 1000 19.99
10 15 250.0
10 9 238.99
 */