package Q1;

import DataStructures.Queue;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Prog1060bQueue {
    public static void main(String[] args) {
        boolean cont = true;
        var file = new Scanner(System.in);
        var queue = new Queue<Integer>();
        String letter = "";
        int number = 0;
        while (cont) {
            System.out.print("Enter task A)dd, D)elete, E)xit ");
            letter = file.next();
            if (letter.equals("A")) {
                System.out.print("Enter number ");
                number = file.nextInt();
                queue.enqueue(number);
            } else if (letter.equals("D")) {
                System.out.print("Enter number ");
                number = file.nextInt();
                for (int lcv = 0; lcv < queue.size(); lcv++) {
                    if (queue.peek().equals(number)) {
                        queue.dequeue();
                        lcv--;
                    } else {
                        queue.enqueue(queue.peek());
                        queue.dequeue();
                    }
                }
            } else if (letter.equals("E")) {
                cont = false;
            }
            System.out.println("This is the list");
            for (int lcv = 0; lcv < queue.size(); lcv++) {
                System.out.print(queue.peek() + " ");
                queue.enqueue(queue.peek());
                queue.dequeue();
            }
            System.out.println();
        }
    }
}
/*
Enter task A)dd, D)elete, E)xit A
Enter number 10
This is the list
10
Enter task A)dd, D)elete, E)xit A
Enter number 15
This is the list
10 15
Enter task A)dd, D)elete, E)xit A
Enter number 2
This is the list
10 15 2
Enter task A)dd, D)elete, E)xit D
Enter number 10
This is the list
15 2
Enter task A)dd, D)elete, E)xit D
Enter number 2
This is the list
15
Enter task A)dd, D)elete, E)xit D
Enter number 15
This is the list

Enter task A)dd, D)elete, E)xit A
Enter number 7
This is the list
7
Enter task A)dd, D)elete, E)xit D
Enter number 8
This is the list
7
Enter task A)dd, D)elete, E)xit A
Enter number 12
This is the list
7 12
Enter task A)dd, D)elete, E)xit D
Enter number 12
This is the list
7
Enter task A)dd, D)elete, E)xit E
This is the list
7
 */