package Q2;

import DataStructures.CircularDeqeue;
import DataStructures.CircularLinkedList;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Pelican526CircleDeque {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/Marquee.dat"));

            while (file.hasNext()) {
                var list = new CircularDeqeue<String>();
                int shift = file.nextInt();
                file.nextLine();
                String line = file.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    list.enqueueFront(line.substring(i, i+1));
                }
                //list.print();
                for (int lcv = 0; lcv < shift+2; lcv++) {
                    list.enqueueFront(list.peekBack());
                    list.dequeueBack();
                }
                for (int i = 0; i < 40; i++) {
                    System.out.print(list.peekBack());
                    list.enqueueFront(list.peekBack());
                    list.dequeueBack();
                }
                System.out.println();
            }
            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
.85  VIGN 14.82  MOT 26.27  JDSU 1.95  P
 IBM 12.66  COK 11.86  AL 22.00  VSSL 22
P 23.27  CSCO 19.86  ZW 12.75  BTDF 22.9
 */