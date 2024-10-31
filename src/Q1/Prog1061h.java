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
                if (choice.equals("A")) {
                    myList.addSorted(file.next());
                } else if (choice.equals("D")) {
                    myList.remove(file.next());
                } else if (choice.equals("P")) {
                    myList.print();
                }
            }
            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
