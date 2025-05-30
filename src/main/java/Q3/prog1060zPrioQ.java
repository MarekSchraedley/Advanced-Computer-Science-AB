package Q3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import DataStructures.PriorityQueue;

class Job implements Comparable<Job> {
    public int job;
    public char priority;

    public Job(int job, char priority) {
        this.job = job;
        this.priority = priority;
    }

    public String toString() { return priority + " " + job; }
    public int compareTo(Job other) {
        if (this.priority != other.priority) {
            //compare priorities ("A" highest, "C" lowest)
            return Character.compare(this.priority, other.priority);
        } else {
            return Integer.compare(this.job, other.job);
        }
    }
}

public class prog1060zPrioQ {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/REPLACE.dat"));
            var pq = new PriorityQueue<Job>(true); //minheap = true;
            while (file.hasNext()) {
                String info = file.next();
                char command = info.charAt(0);
                if (command =='W') {
                    //TODO (write out)
                } else if (command == 'P') {
                    //TODO (pop)
                } else { // Add
                    char priority = info.charAt(1);
                    int job = Integer.parseInt(info.substring(2));
                    pq.enqueue(new Job(job, priority));
                }
            }
            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
