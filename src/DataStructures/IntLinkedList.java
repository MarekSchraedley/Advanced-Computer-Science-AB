package DataStructures;

import java.util.Iterator;

public class IntLinkedList implements Iterable<Integer> {
    private class Node {
        int data;
        Node next;


        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private Node head;

    public IntLinkedList() { head = null; }

    public void addFront(int data) {
        var newNode = new Node(data);
        newNode.next = head;
        head = newNode;

    }

    public void addLast(int data) {
        var newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        var current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }


    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
           private Node current = head;

           public boolean hasNext() {return current != null;}

            public Integer next() {
               int data = current.data;
               current = current.next;
               return data;
            }
        };
    }

    public int getCount() {
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public boolean add(int num, int spot) {
        var newNode = new Node(spot);
        Node current = head;
        int count = 0;
        if (spot == 0) {
            newNode.next = head;
            head = newNode;
        }
        while (count < spot && current != null) {
            count++;
            current = current.next;
        }
        if (current == null) {return false;}
        else {
            newNode.next = current.next;
            current.next = newNode;
            return true;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getFront() {
        return head.data;

    }

    public int getLast() {
        var current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    public int getByIndex(int spot) {
        var newNode = new Node(spot);
        Node current = head;
        int count = 0;
        while (count < spot && current != null) {
            count++;
            current = current.next;
        }
        if (current == null) {
            return -1;
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
    public int countLess10()  {
        var current = head;
        int count = 0;
        while (current.next != null) {
            if (current.data < 10) {
                count++;
            }
            current = current.next;
        }
        return count;
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

    public boolean contains(int n) {
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
        IntLinkedList myList = new IntLinkedList();
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
