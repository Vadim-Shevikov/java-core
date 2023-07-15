public class MyStack<T> {
    private static final int DEFAULT_ARRAY_LENGTH = 8;
    private Object[] array = new Object[DEFAULT_ARRAY_LENGTH];
    private int size = 0;

    public void push(T value) {
        if (size == array.length) {
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        array[size] = value;
        size++;
    }

    public void remove(int index) {
        if ( index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException("Index Error");
        }

        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null;
        size--;
    }

    public void clear() {
        array = new Object[DEFAULT_ARRAY_LENGTH];
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (size == 0) {
            throw new RuntimeException("Stack is empty");
        }
        return (T) array[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new RuntimeException("Stack is empty");
        }
        T value = (T) array[size - 1];
        array[size - 1] = null;
        size--;
        return value;
    }
}
