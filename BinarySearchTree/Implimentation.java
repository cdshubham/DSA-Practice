package BinarySearchTree;

public class Implimentation {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    // Constructor: build balanced BST from sorted array
    public Implimentation(int[] arr) {
        root = construct(arr, 0, arr.length - 1);
    }

    private Node construct(int[] arr, int lo, int hi) {
        if (lo > hi) return null;

        int mid = (lo + hi) / 2;
        Node node = new Node(arr[mid]);

        node.left = construct(arr, lo, mid - 1);
        node.right = construct(arr, mid + 1, hi);

        return node;
    }

    // Display tree
    public void display() {
        display(root);
    }

    private void display(Node node) {
        if (node == null) return;

        String str = "";
        str += (node.left == null ? "." : node.left.data) + " <- " + node.data + " -> " +
                (node.right == null ? "." : node.right.data);
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    // Size of BST
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        return size(node.left) + size(node.right) + 1;
    }

    // Sum of all nodes
    public int sum() {
        return sum(root);
    }

    private int sum(Node node) {
        if (node == null) return 0;
        return sum(node.left) + sum(node.right) + node.data;
    }

    // Max in BST
    public int max() {
        return max(root);
    }

    private int max(Node node) {
        if (node.right != null) return max(node.right);
        return node.data;
    }

    // Min in BST
    public int min() {
        return min(root);
    }

    private int min(Node node) {
        if (node.left != null) return min(node.left);
        return node.data;
    }

    // Find element
    public boolean find(int val) {
        return find(root, val);
    }

    private boolean find(Node node, int val) {
        if (node == null) return false;

        if (val < node.data) return find(node.left, val);
        else if (val > node.data) return find(node.right, val);
        else return true;
    }

    // Add node
    public void add(int val) {
        root = add(root, val);
    }

    private Node add(Node node, int val) {
        if (node == null) return new Node(val);

        if (val < node.data) node.left = add(node.left, val);
        else if (val > node.data) node.right = add(node.right, val);
        // duplicate ignored
        return node;
    }

    // Remove node
    public void remove(int val) {
        root = remove(root, val);
    }

    private Node remove(Node node, int val) {
        if (node == null) return null;

        if (val < node.data) {
            node.left = remove(node.left, val);
        } else if (val > node.data) {
            node.right = remove(node.right, val);
        } else {
            // node found
            if (node.left != null && node.right != null) {
                // replace with max from left
                int lmax = max(node.left);
                node.data = lmax;
                node.left = remove(node.left, lmax);
                return node;
            } else if (node.left != null) {
                return node.left;
            } else if (node.right != null) {
                return node.right;
            } else {
                return null;
            }
        }
        return node;
    }

    // MAIN
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70};
        Implimentation bst = new Implimentation(arr);

        System.out.println("Display Tree:");
        bst.display();

        System.out.println("\nSize: " + bst.size());
        System.out.println("Sum: " + bst.sum());
        System.out.println("Max: " + bst.max());
        System.out.println("Min: " + bst.min());

        System.out.println("\nFind 40: " + bst.find(40));
        System.out.println("Find 100: " + bst.find(100));

        bst.add(25);
        System.out.println("\nAfter adding 25:");
        bst.display();

        bst.remove(40);
        System.out.println("\nAfter removing 40:");
        bst.display();
    }
}
