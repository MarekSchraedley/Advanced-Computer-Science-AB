package DataStructures;

public class LinkedList<T extends Comparable<T>> {
    private class Node implements Comparable<Node> {
        T data;
        Node next;

        Node(T value) {
            data = value;
            next = null;
        }
        public int compareTo(Node o) {return data.compareTo(o.data); }
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public boolean add(T element) {
        var newNode = new Node(element);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    public T remove(int index) {
        T old;
        if (index == 0) {
            old = head.data;
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) current = current.next;
            old = current.next.data;
            current.next = current.next.next;
        }
        size--;
        return old;
    }

    public T get(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) { current = current.next;}
        return current.data;
    }

    public T set(int index, T element) {
        T old;
        Node current = head;
        for (int i = 0; i < index; i++) { current = current.next;}
        old = current.data;
        current.data = element;
        return old;
    }

    public void print() {
        for (Node current = head; current != null; current = current.next)
            System.out.print(current.data + " ");
        System.out.println();
    }
    public int size() {return size;}
    public boolean isEmpty() {return size == 0; }

    public T getFront() {
        return head.data;

    }

    public T getLast() {
        var current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    public T getByIndex(int spot) {
        Node current = head;
        int count = 0;
        while (count < spot && current != null) {
            count++;
            current = current.next;
        }
        if (current == null) {
            return null;
        } else {
            return current.data;
        }
    }

    public void removeFirst() {
        head = head.next;
    }

    public void removeLast() {
        var current = head;
        while (current.next != null) {
            current = current.next;
        }
        current = null;
    }


    public void removeIndex(int pos) {
        Node current = head;
        int count = 0;
        while (count < pos-1 && current != null) {
            count++;
            current = current.next;
        }
        if (current.next != null && current.next.next != null) {
            current.next = current.next.next;
        }
        else if (count == 0) {
            head = head.next;
        } else if (current.next.next == null) {
            current.next = null;
        }


    }

    public void clear() {
        head = null;
    }

    public boolean contains(T n) {
        var current = head;
        while (current.next != null) {
            if (current.data == n) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public IntLinkedList getReverse() {
        var current = head;
        LinkedList myList = new LinkedList();
        while (current.next != null) {
            myList.addFront(current.data);
            current = current.next;
        }
        return myList;
    }

    public double avg() {
        var current = head;
        int average = 0;
        while (current.next != null) {
            average += current.data;
            current = current.next;
        }
        return  average/getCount();
    }

    public int min() {
        var current = head;
        int min = current.data;
        while (current.next != null) {
            if (current.data < min) {
                min = current.data;
            }
            current = current.next;
        }
        return min;
    }

    public int max() {
        var current = head;
        int max = current.data;
        while (current.next != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }
        return max;
    }

    public int indexOfMax() {
        var current = head;
        int max = max();
        int count = 0;
        while (current.next != null) {
            if (current.data == max) {
                return count;
            }
            current = current.next;
            count++;
        }
        return -1;
    }

    public int lastIndexOfMax() {
        var current = head;
        int max = max();
        int count = 0;
        int index = -1;
        while (current.next != null) {
            if (current.data == max) {
                index = count;
            }
            current = current.next;
            count++;
        }
        return index;
    }

    public void sort() {

    }

    public int remove58() {
        var current = head;
        int count = 0;
        while (current.next.next != null) {
            if (current.next.data == 58) {
                current.next = current.next.next;
                count++;
            } else {
                current = current.next;
            }
        }
        return count;
    }

    public int getEvenCount() {
        var current = head;
        int count = 0;
        while (current.next != null) {
            if (current.data % 2 == 0) {
                count++;
            }
        }
        return count;
    }


    public void removeOdds() {
        var current = head;
        while (current.next.next != null) {
            if (current.next.data % 2 == 1) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }
}
