package Q1;

import DataStructures.DoublyLinkedList;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog1061h {
    public static void main(String[] args) {
        var myList = new DoublyLinkedList<String>();
        String choice = "";
        try {
            var file = new Scanner(new File("Langdat/prg1061h.dat"));

            while (file.hasNext()) {
                choice = file.next();
                System.out.println(":::" + choice);
                if (choice.substring(0, 1).equals("A")) {
                    myList.addSorted(choice.substring(1));
                } else if (choice.substring(0, 1).equals("D")) {
                    myList.remove(choice.substring(1));
                } else if (choice.substring(0, 1).equals("P")) {
                    myList.print();
                }
                myList.print();
            }
            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
