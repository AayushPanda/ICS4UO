package QuickEasyLoans;

import java.util.Arrays;

public class LLQueue<T> {

    private Node<T> head;

    // Main method for testing the GenericQueue class
    public static void main(String[] args) {
        // Create a GenericQueue of Objects
        LLQueue<Object> queue = new LLQueue<>();
        queue.add(1);
        queue.add("Two");
        queue.add(3.0);
        System.out.println(queue.toString());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }
    // Constructor for an empty GenericQueue
    public LLQueue() {
        this.head = null;
    }

    public LLQueue(T object) {
        this.head = new Node<>(object, null);
    }

    // Convert an array of objects to a GenericQueue
    public static <R> LLQueue<R> toQueue(R[] objects) {
        LLQueue<R> queue = new LLQueue<>();
        Arrays.stream(objects).forEach(queue::add);
        return queue;
    }

    // Convert a string to a GenericQueue of Characters
    public static LLQueue<Character> toQueue(String string) {
        return LLQueue.toQueue(string.chars().mapToObj(c -> (char) c).toArray(Character[]::new));
    }

    // add an object into the GenericQueue
    public void add(T object) {
        if (this.isEmpty()) {
            this.head = new Node<>(object, null);
        } else {
            Node<T> current = this.head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new Node<>(object, null));
        }
    }

    // remove an object from the GenericQueue
    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T object = this.head.getObject();
        this.head = this.head.getNext();
        return object;
    }

    // Peek at the front object of the GenericQueue without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return this.head.getObject();
    }

    // Check if the GenericQueue is empty
    public boolean isEmpty() {
        return this.head == null;
    }

    // Equals method that compares two queues of any type
    public static <R> boolean equals(LLQueue<R> queue1, LLQueue<R> queue2) {
        LLQueue<R> copy1 = queue1.copy();
        LLQueue<R> copy2 = queue2.copy();

        while (!copy1.isEmpty() && !copy2.isEmpty()) {
            if (!copy1.remove().equals(copy2.remove())) {
                return false;
            }
        }

        return copy1.isEmpty() && copy2.isEmpty();
    }

    // Create a copy of the GenericQueue
    public LLQueue<T> copy() {
        LLQueue<T> copyQueue = new LLQueue<>();
        LLQueue<T> tempQueue = new LLQueue<>();

        while (!this.isEmpty()) {
            T object = this.remove();
            tempQueue.add(object);
            copyQueue.add(object);
        }

        while (!tempQueue.isEmpty()) {
            this.add(tempQueue.remove());
        }

        return copyQueue;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = this.head;
        while (current != null) {
            sb.append(current.getObject().toString());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        return sb.toString();
    }

    public Node<T> getHead() {
        return head;
    }
}
