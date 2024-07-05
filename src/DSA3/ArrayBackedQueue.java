package DSA3;

import java.util.Arrays;

public class ArrayBackedQueue<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int size;

    public static void main(String[] args) {
        ArrayBackedQueue<Object> queue = new ArrayBackedQueue<>();
        queue.add(1);
        queue.add("Two");
        queue.add(3.0);
        System.out.println(queue);
        System.out.println(queue.peek());
        queue.remove();
        System.out.println(queue.peek());
        queue.remove();
        System.out.println(queue.peek());
        queue.remove();
    }

    public ArrayBackedQueue() {
        this.data = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public ArrayBackedQueue(T[] array) {
        this.data = Arrays.copyOf(array, array.length);
        this.size = array.length;
    }

    public void add(T object) {
        ensureCapacity();
        data[size++] = object;
    }

    public void remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        System.arraycopy(data, 1, data, 0, --size);
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return (T) data[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(data, size));
    }
}
