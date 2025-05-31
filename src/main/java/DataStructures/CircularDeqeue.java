package DataStructures;

public class CircularDeqeue<T extends Comparable<T>> extends CircularLinkedList<T>   {

    public CircularDeqeue() { super();}
     public void enqueueBack(T element) {
         var newNode = new Node(element);
         if (head == null) {
             head = newNode;
             head.next = head;
         } else {
             Node current = head;
             while (current.next != head) {
                 current = current.next;
             }
             current.next = newNode;
             newNode.next = head;
             head = newNode;
         }
         size++;
     }

     public void enqueueFront(T element) {
        super.add(element);
     }
     public void dequeueFront() {
        if (head != null) {
            if (size() == 1) {
                head = null;
            } else {
                Node current = head;
                while (current.next.next != head) {
                    current = current.next;
                }
                current.next = head;
            }
            size--;
        }
     }

     public void dequeueBack() {
         if (head != null) {
             if (size() == 1) {
                 head = null;
             } else {
                 Node current = head;
                 while (current.next != head) {
                     current = current.next;
                 }
                 head = head.next;
                 current.next = head;
             }
             size--;
         }
     }

     public T peekFront() {
         Node current = head;
         while (current.next != head) {
             current = current.next;
         }
         return current.data;
     }

     public  T peekBack() {
        return head.data;
     }
}
