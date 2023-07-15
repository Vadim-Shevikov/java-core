public class MyArrayList<T> {
    private static final int DEFAULT_ARRAY_LENGTH = 8;
    private Object[] array = new Object[DEFAULT_ARRAY_LENGTH];
    private int size;

    public void add(T value) {
        if (size == array.length) {
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }

        array[size] = value;
        size++;
    }

    public void remove(int index) {
        if ( index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException("Index Error");
        }

        this.size = 0;
        Object[] newArray = new Object[array.length];

        for (int i = 0; i < array.length; i++) {
            if (index == i || array[i] == null) {
                continue;
            }
            newArray[this.size] = array[i];
            this.size++;
        }


        this.array = newArray;
    }

    public void clear() {
        this.array = new Object[DEFAULT_ARRAY_LENGTH];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if ( index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException("Index Error");
        }

        return (T) this.array[index];
    }
}
