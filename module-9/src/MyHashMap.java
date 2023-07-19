public class MyHashMap<K, V> implements MyCollection {
    private Node<K, V>[] nodes;
    private int size;
    private int CAPACITY = 16;

    public MyHashMap() {
        nodes = new Node[CAPACITY];
    }

    private int indexForKey(K key) {
        return key == null ? 0 : Math.abs(key.hashCode() % CAPACITY);
    }

    public void put(K key, V value) {
        if (size == nodes.length) {
            CAPACITY = CAPACITY * 2;
            Node<K, V>[] newNodes = new Node[CAPACITY];

            for (Node<K, V> node : nodes) {
                if (node != null) {
                    newNodes[indexForKey(node.key)] = node;
                }
            }

            nodes = newNodes;
        }

        int index = indexForKey(key);

        if (nodes[index] == null) {
            nodes[index] = new Node<>(key, value);
            size++;
            return;
        }

        Node<K, V> node = nodes[index];

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
        int index = indexForKey(key);

        Node<K, V> node = nodes[index];

        while (node != null && !node.key.equals(key)) {
            node = node.next;
        }

        return node == null ? null : node.value;
    }

    public void remove(K key) {
        int index = indexForKey(key);
        Node<K, V> node = nodes[index];

        if (node == null) {
            return;
        }

        if (node.key.equals(key)) {
            nodes[index] = node.next;
            size--;
            return;
        }

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
        nodes = new Node[CAPACITY];
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
