
public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> current;
    private int size;

    public void add (T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
        } else {
            current.setNext(newNode);
            newNode.setPrev(current);
        }

        current = newNode;
        size++;
    }

    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index Error");
        }
    }

    public void remove(int index) {
        checkIndex(index);

        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        size--;

        if (currentNode == head) {
            head = currentNode.getNext();

            if (head != null) {
                head.setPrev(null);
            }
            return;
        }

        if (currentNode == current) {
            current = currentNode.getPrev();
            current.setNext(null);
            return;
        }

        currentNode.getPrev().setNext(currentNode.getNext());
        currentNode.getNext().setPrev(currentNode.getPrev());
    }

    public void clear() {
        head = null;
        current = null;
        size = 0;
    }

    public T get(int index) {
        checkIndex(index);

        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        return currentNode.getValue();
    }

    private static class Node<T> {
        private Node<T> prev;
        private final T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public T getValue() {
            return value;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }
}
