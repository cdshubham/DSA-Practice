class Node<K, V> {
    K key;
    V value;
    Node<K, V> next; // for handling collisions using chaining

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class MyHashMap<K, V> {
    private Node<K, V>[] buckets;
    private int capacity = 16; // default size
    private int size = 0;

    public MyHashMap() {
        buckets = new Node[capacity];
    }

    private int getBucketIndex(K key) {
        return key == null ? 0 : Math.abs(key.hashCode()) % capacity;
    }

    // Put key-value pair
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        Node<K, V> head = buckets[index];

        // Check if key exists, update value
        while (head != null) {
            if ((head.key == null && key == null) || (head.key != null && head.key.equals(key))) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Insert new node at the beginning of the list
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;
    }

    // Get value by key
    public V get(K key) {
        int index = getBucketIndex(key);
        Node<K, V> head = buckets[index];

        while (head != null) {
            if ((head.key == null && key == null) || (head.key != null && head.key.equals(key))) {
                return head.value;
            }
            head = head.next;
        }
        return null; // not found
    }

    // Remove key-value pair
    public V remove(K key) {
        int index = getBucketIndex(key);
        Node<K, V> head = buckets[index];
        Node<K, V> prev = null;

        while (head != null) {
            if ((head.key == null && key == null) || (head.key != null && head.key.equals(key))) {
                if (prev != null) {
                    prev.next = head.next;
                } else {
                    buckets[index] = head.next;
                }
                size--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }

    public int size() {
        return size;
    }
}
public class Main {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        System.out.println(map.get("Two")); // Output: 2
        map.remove("Two");
        System.out.println(map.get("Two")); // Output: null
    }
}
