package Q2;

import DataStructures.Queue;
import DataStructures.QueueStack;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog1060hQueue {
    public static void main(String[] args) {
        try {
            Queue<Double>[] list = new Queue[5];
            var file = new Scanner(new File("Langdat/REPLACE.dat"));

            while (file.hasNext()) {

            }
            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
