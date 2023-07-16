public class MyQueue<T> extends MyArrayList<T> {
    private final int index = 0;

    public T peek() {
        if (this.size() == 0) {
            throw new RuntimeException("Queue is empty");
        }

        return get(index);
    }

    public T poll() {
        T value = peek();
        remove(index);
        return value;
    }
}