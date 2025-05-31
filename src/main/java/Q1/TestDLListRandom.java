package Q1;

import DataStructures.DoublyLinkedList;

public class TestDLListRandom {
    public static void main(String[] args) {
        var list = new DoublyLinkedList<Integer>();
        for (int i = 0; i < 20; i++) {
            list.add((int) (Math.random() * 100)); //Todo: change to addsorted
        }
        list.print();
        list.printReverse();
        //Todo test the rest of the dll methods
    }
}
