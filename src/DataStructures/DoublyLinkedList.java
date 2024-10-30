package DataStructures;

public class DoublyLinkedList<T extends Comparable<T>> {
    private class Node implements Comparable<Node> {
        T data;
        Node prev;
        Node next;

        Node(T data) {
            this.data = data;
            prev = null;
            next = null;
        }

        public int compareTo(Node o) {
            return data.compareTo(o.data);
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T element) {
        var temp = new Node(element);
        if (head == null) {
            head = temp;
        } else {
            tail.next = temp;
            temp.prev = tail;
        }
        tail = temp;
        size++;
    }

    public void addFront(T element) {
        var temp = new Node(element);
        if(head == null) {
            head = temp;
        } else {
            temp.next = head;
            head.prev = temp;
        }
        head = temp;
        size++;
    }

    public void insert(int index, T element) {

    }

    public void addSorted(T element) {
        //TODO
        int lcv = 0;
        var current = head;
        while (lcv < size-1 && current.data.compareTo(element) < 0) {
            lcv++;
            current = current.next;
        }

    }

    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        //Todo: the rest
        var current = head;
        if (index == 0) {
            head = head.next;
        } else if (index == size-1) {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = null;
        } else {
            for (int lcv = 0; lcv < index; lcv++) {
                current = current.next;
            }
            current.prev.next = current.next;
        }
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current.data;
    }

    public void set(int index, T element) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        //Todo the rest
        var current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = element;
    }

    public void print() {
        for (Node current = head; current != null; current = current.next) {
            System.out.print(current.data + " ");
        }
        System.out.println();
    }

    public void printReverse() {
        for (Node current = tail; current != null; current = current.prev) {
            System.out.print(current.data + " ");
        }
        System.out.println();
    }

    public int size() {return size;}
    public boolean isEmpty() { return size == 0; }

}
