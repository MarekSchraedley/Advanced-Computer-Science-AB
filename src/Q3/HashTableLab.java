package Q3;


import java.util.LinkedList;

public class HashTableLab {
    static abstract class HashTable<T> {
        protected LinkedList<T>[] table;

        public HashTable(int size) {
            table = new LinkedList[size];
            for (int i = 0; i < size; i++) {
                table[i] = new LinkedList<>();
            }
        }

        protected abstract int hash(T key);

        public void insert(T key) {
            int index = hash(key);
            if (!table[index].contains(key))
                table[index].add(key);
        }

        public boolean search(T key) {
            int index = hash(key);
            return table[index].contains(key);
        }

        public void display() {
            for (int i = 0; i < table.length; i++) {
                System.out.println("Index " + i + ": " + table[i]);
            }

        }
    }
    static class IntHashTable extends HashTable<Integer> {
        public IntHashTable(int size) { super(size);}

        protected int hash(Integer key) {
            return Math.abs(key) % table.length;
        }
    }

    static class StringHashTable extends HashTable<String> {
        public StringHashTable(int size) {super(size);}

        protected int hash(String key) {
            int hash = 0;
            for (char c : key.toCharArray())
                hash = (hash * 31 + c) % table.length;
            return hash;
        }
    }

    public static void main(String[] args) {
        System.out.println("Int hash table:");
        var iTable = new IntHashTable(5);
        iTable.insert(10);
        iTable.insert(15);
        iTable.insert(20);
        iTable.insert(25);
        iTable.insert(30);
        iTable.display();
        System.out.println("Has 20: " + iTable.search(20));
        System.out.println("Has 50: " + iTable.search(50));

        System.out.println("\nString Hash Table:");
        var sTable = new StringHashTable(5);
        sTable.insert("apple");
        sTable.insert("banana");
        sTable.insert("grape");
        sTable.insert("mango");
        sTable.insert("orange");
        sTable.display();
        System.out.println("Has apple:" + sTable.search("apple"));
        System.out.println("Has starfruit:" + sTable.search("starfruit"));

    }
}
