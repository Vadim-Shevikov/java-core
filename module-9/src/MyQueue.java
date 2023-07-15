public class MyQueue<T> {
    private static final int DEFAULT_ARRAY_LENGTH = 8;
    private Object[] array = new Object[DEFAULT_ARRAY_LENGTH];
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    public void add(T value) {
        if (size == array.length) {
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, head, newArray, 0, size - head);
            System.arraycopy(array, 0, newArray, size - head, tail);
            array = newArray;
            head = 0;
            tail = size;
        }
        array[tail] = value;
        tail = (tail + 1) % array.length;
        size++;
    }

    public void clear() {
        array = new Object[DEFAULT_ARRAY_LENGTH];
        head = tail = size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }
        return (T) array[head];
    }

    public T poll() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }
        T value = (T) array[head];
        array[head] = null;
        head = (head + 1) % array.length;
        size--;
        return value;
    }
}