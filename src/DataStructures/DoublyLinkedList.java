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
        var newNode = new Node(element);
        var current = head;
        if (head == null) {
            head = newNode;
        } else {

            while (current.next != null && current.data.compareTo(element) < 0) {
                current = current.next;
            }
            if (current.next != null) {
                if (current.prev == null) {
                    current.prev = newNode;
                    newNode.next = current;
                    head = newNode;
                } else {
                    newNode.next = current;
                    newNode.prev = current.prev;
                    current.prev.next = newNode;
                    current.prev = newNode;
                }
            } else {
                current.next = newNode;
                newNode.prev = current;
                tail = newNode;

            }
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

    public void remove(T element) {
        var current = head;
        while (current != null && !(current.data.equals(element))) {
            current = current.next;
        }
        if (current != null) {
            if (current.prev == null) {
                head = current.next;
                current.next.prev = null;
            }
            else if (current.next == null) {
                tail = current.prev;
                current.prev.next = null;

            }
            else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
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
