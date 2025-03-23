package Q3;

import DataStructures.Set;
import Q3.prog505a.Cl505a;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Prog402aMap {
    public static class Student implements Comparable<Student> {
        public Integer myID;
        public int myScore;
        public int compareTo(Student thing) {return this.myID.compareTo(thing.myID);}
        public Student(int ID, int score) {
            myID = ID;
            myScore = score;
        }
        public int getMyID() {return myID;}
        public int getMyScore() {return myScore;}
    }
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prg402a.dat"));
            var mySet = new Set<Student>();
            while (file.hasNext()) {
                mySet.insert(new Student(file.nextInt(), file.nextInt()));
            }
            file.close();
            var map = new HashMap<Integer, Integer>();
            var iter = mySet.iterator();
            double average = 0;
            for (int i = 0; i < mySet.size(); i++) {
                var tempIter = iter.next();
                average += tempIter.getMyScore();
                map.put(tempIter.getMyID(), tempIter.getMyScore());
            }
            average /= mySet.size();
            final Double iterAvg = average;
            System.out.println("ID\tScore\tDiff");
            map.forEach((ID, score) -> System.out.println(ID + "\t" + score + "\t" + (score - iterAvg)));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
ID	Score	Diff
321	245	2.3809523809523796
323	245	2.3809523809523796
325	246	3.3809523809523796
104	239	-3.6190476190476204
203	224	-18.61904761904762
301	242	-0.6190476190476204
110	238	-4.61904761904762
207	228	-14.61904761904762
112	239	-3.6190476190476204
208	242	-0.6190476190476204
113	243	0.3809523809523796
305	265	22.38095238095238
306	262	19.38095238095238
115	257	14.38095238095238
116	246	3.3809523809523796
213	229	-13.61904761904762
311	256	13.38095238095238
218	243	0.3809523809523796
123	253	10.38095238095238
222	223	-19.61904761904762
223	230	-12.61904761904762
 */