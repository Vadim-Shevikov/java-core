public class Main {
    static private final int count = 1000000;

    public static void main(String[] args) {
        Main.showMyArrayListExample();
        Main.showMyLinkedListExample();
        Main.showMyQueueExample();
        Main.showMyStackExample();
        Main.showMyHashMapExample();
    }

    static void showListExamples(MyList<Integer> collection) {
        for (int i = 0; i < count; i++) {
            collection.add(i);
        }

        System.out.println("size = " + collection.size());
        System.out.println("get element with 23 index = " + collection.get(23));

        collection.remove(23);

        System.out.println("get element with 23 index after remove previous value = " + collection.get(23));
        System.out.println("size = " + collection.size());

        collection.clear();

        System.out.println("size after clear = " + collection.size());
        System.out.println("=========================================");
    }
    static void showMyArrayListExample() {
        System.out.println(" ");
        System.out.println("Task1. MyArrayList Example");

        MyList<Integer> collection = new MyArrayList<>();

        Main.showListExamples(collection);
    }
    static void showMyLinkedListExample() {
        System.out.println(" ");
        System.out.println("Task2. MyLinkedList Example");

        MyList<Integer> collection = new MyLinkedList<>();

        Main.showListExamples(collection);
    }

    static void showMyQueueExample() {
        System.out.println(" ");
        System.out.println("Task3. MyQueue Example");

        MyQueue<Integer> collection = new MyQueue<>();

        for (int i = 0; i < count; i++) {
            collection.add(i);
        }

        System.out.println("size = " + collection.size());
        System.out.println("peek = " + collection.peek());

        System.out.println("poll = " + collection.poll());

        System.out.println("peek after poll = " + collection.peek());
        System.out.println("size = " + collection.size());

        collection.clear();

        System.out.println("size after clear = " + collection.size());
        System.out.println("=========================================");
    }
    static void showMyStackExample() {
        System.out.println(" ");
        System.out.println("Task4. MyStack Example");

        MyStack<Integer> collection = new MyStack<>();

        for (int i = 0; i < count; i++) {
            collection.push(i);
        }

        System.out.println("size = " + collection.size());
        System.out.println("peek = " + collection.peek());

        System.out.println("poll = " + collection.pop());

        System.out.println("peek after poll = " + collection.peek());
        System.out.println("size = " + collection.size());

        collection.remove(collection.size() - 1);

        System.out.println("size after remove last index = " + collection.size());
        System.out.println("peek = " + collection.peek());

        collection.clear();

        System.out.println("size after clear = " + collection.size());
        System.out.println("=========================================");
    }
    static void showMyHashMapExample() {
        System.out.println(" ");
        System.out.println("Task5. MyHashMap Example");

        MyHashMap<String,Integer> collection = new MyHashMap<>();

        for (int i = 0; i < count; i++) {
            collection.put("Index" + i, i);
        }


        System.out.println("size = " + collection.size());
        System.out.println("get element with key `Index23` = " + collection.get("Index23"));

        collection.remove("Index23");

        System.out.println("size after remove `Index23` = " + collection.size());

        collection.clear();

        System.out.println("size after clear = " + collection.size());

        System.out.println("=========================================");
    }
}
