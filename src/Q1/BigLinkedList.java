package Q1;
import DataStructures.IntLinkedList;
public class BigLinkedList {
    public static void main(String[] args) {
        var list = new IntLinkedList();
        for (int i = 0; i < 200; i++) {
            list.addFront((int) (Math.random()*100 + 1));
            // TODO: the rest
        }
        var iter = list.iterator();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");
        System.out.println();

        list.addFront(5);
        list.print();
        list.addLast(5);
        System.out.println(list.getCount());
        list.add(100, 5);
        System.out.println(list.isEmpty());
        list.print();
        System.out.println(list.getFront());
        System.out.println(list.getLast());
        System.out.println(list.getByIndex(100));
        list.removeFirst();
        list.removeLast();
        System.out.println(list.countLess10());
        list.removeIndex(100);
        System.out.println(list.contains(100));
        var newlist = list.getReverse();
        newlist.print();
        var iter2 = newlist.iterator();
        System.out.println(list.avg());
        System.out.println(list.min());
        System.out.println(list.max());
        System.out.println(list.indexOfMax());
        System.out.println(list.lastIndexOfMax());
        list.sort();
        list.print();
        System.out.println(list.remove58());
        System.out.println(list.getEvenCount());
        list.removeOdds();
        list.print();
        list.clear();

    }

}
