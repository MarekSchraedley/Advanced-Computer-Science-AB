package DataStructures;

public class QueueStack<T extends Comparable<T>> {
    protected Queue queue;
    public QueueStack() {
        queue = new Queue<T>();
    }

    public void push(T element) {
        queue.enqueue(element);
    }

    public T pop() {
        T element = null;
        if (queue.size() > 0) {
            for (int lcv = 0; lcv < queue.size()-1; lcv++) {
                queue.enqueue(queue.peek());
                queue.dequeue();
            }
            element = queue.peek();
            queue.dequeue();
        }


    }
}
