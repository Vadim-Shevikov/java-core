public class MyHashMap<K, V> {
    private Node<K, V> head;
    private int size;

    public void put(K key, V value) {
        if (head == null) {
            head = new Node<>(key, value);
            size++;
            return;
        }

        Node<K, V> node = head;

        while (node.next != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }

        if (node.key.equals(key)) {
            node.value = value;
            return;
        }

        node.next = new Node<>(key, value);
        size++;
    }

    public V get(K key) {
        Node<K, V> node = head;

        while (node != null && !node.key.equals(key)) {
            node = node.next;
        }

        return node == null ? null : node.value;
    }

    public void remove(K key) {
        if (head == null) return;

        if (head.key.equals(key)) {
            head = head.next;
            size--;
            return;
        }

        Node<K, V> node = head;

        while (node.next != null) {
            if (node.next.key.equals(key)) {
                node.next = node.next.next;
                size--;
                return;
            }
            node = node.next;
        }
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
