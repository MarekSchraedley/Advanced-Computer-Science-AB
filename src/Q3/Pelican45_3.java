package Q3;
import DataStructures.Set;

import java.util.HashSet;
import java.util.Iterator;

public class Pelican45_3 {
    public static void main(String[] args) {
       HashSet s1 =  new HashSet<Set>();
       HashSet s2 = new HashSet<Set>();
       String[] list1 = {"Bill", "Larry", "Adolph", "Regina", "Susie"};
       String[] list2 = {"Larry", "Jack", "Alice",  "June", "Benny", "Susie"};
        for (String item : list1) {
            s1.add(item);
        }
        for (String item : list2) {
            s2.add(item);
        }
        s1.retainAll(s2);
        Iterator iter1 = s1.iterator();
        while (iter1.hasNext()) {
            System.out.println(iter1.next());
        }

    }
}
