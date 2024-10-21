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
        while (count < pos-1 && current.next != null) {
            count++;
            current = current.next;
        }
        if (current.next != null && current.next.next != null) {
            current.next = current.next.next;
        }
        else if (count == 0) {
            removeFirst();
        } else if (count == getCount()-1) {
            removeLast();
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

    public int indexOfMin() {
        var current = head;
        int min = min();
        int count = 0;
        while (current != null) {
            if (current.data == min) {
                return count;
            }
            current = current.next;
            count++;
        }
        return -1;
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
        while (current != null) {
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
        IntLinkedList list = new IntLinkedList();
        int min = min();
        list.head = new Node(min);
        int minIndex = indexOfMin();
        removeIndex(minIndex);
        while (getCount() != 1) {
            min = min();
            list.addLast(min);
            minIndex = indexOfMin();
            if (minIndex == 0) removeFirst();
            else if (minIndex == getCount()-1) removeLast();
            else removeIndex(minIndex);
        }
        head = list.head;
    }

    public int remove58() {
        var current = head;
        int count58 = 0;
        int count = 0;
        while (current.next != null) {
            if (current.next.data == 58) {
                removeIndex(count+1);
                count58++;
            } else {
                current = current.next;
                count++;
            }
        }
        return count58;
    }

    public int getEvenCount() {
        var current = head;
        int count = 0;
        while (current.next != null) {
            if (current.data % 2 == 0) {
                count++;
            }
            current = current.next;
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
