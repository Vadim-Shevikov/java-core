public class MyStack<T> extends MyArrayList<T> {
    public void push(T value) {
        super.add(value);
    }

    public T peek() {
        if (this.size() == 0) {
            throw new RuntimeException("Stack is empty");
        }
        return get(size() - 1);
    }

    public T pop() {
        T value = peek();
        remove(size() - 1);
        return value;
    }
}
