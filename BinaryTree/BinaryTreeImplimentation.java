import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class BinaryTreeImplimentation {
    Node root;

    // Construct tree from array (null = no node)
    public BinaryTreeImplimentation(Integer[] arr) {
        root = construct(arr);
    }

    private Node construct(Integer[] arr) {
        if (arr.length == 0) return null;

        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            Node curr = q.poll();

            // Left child
            if (i < arr.length && arr[i] != null) {
                curr.left = new Node(arr[i]);
                q.add(curr.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != null) {
                curr.right = new Node(arr[i]);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    // Display (simple)
    public void display(Node node) {
        if (node == null) return;
        String str = "";
        str += (node.left != null ? node.left.data : ".") + " <- " + node.data + " -> " +
               (node.right != null ? node.right.data : ".");
        System.out.println(str);
        display(node.left);
        display(node.right);
    }

    // Size
    public int size(Node node) {
        if (node == null) return 0;
        return size(node.left) + size(node.right) + 1;
    }

    // Sum
    public int sum(Node node) {
        if (node == null) return 0;
        return sum(node.left) + sum(node.right) + node.data;
    }

    // Max
    public int max(Node node) {
        if (node == null) return Integer.MIN_VALUE;
        return Math.max(node.data, Math.max(max(node.left), max(node.right)));
    }

    // Height
    public int height(Node node) {
        if (node == null) return -1; // edges count, use 0 if node count
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    // Traversals
    public void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public void levelOrder(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            System.out.print(node.data + " ");
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
    }

    // Main
    public static void main(String[] args) {
        // Example: Build binary tree from array
        Integer[] arr = {10, 20, 30, 40, 50, null, 60, null, null, 70, 80};
        BinaryTreeImplimentation bt = new BinaryTreeImplimentation(arr);

        System.out.println("Tree Display:");
        bt.display(bt.root);

        System.out.println("\nSize: " + bt.size(bt.root));
        System.out.println("Sum: " + bt.sum(bt.root));
        System.out.println("Max: " + bt.max(bt.root));
        System.out.println("Height: " + bt.height(bt.root));

        System.out.print("\nPreorder: ");
        bt.preorder(bt.root);
        System.out.print("\nInorder: ");
        bt.inorder(bt.root);
        System.out.print("\nPostorder: ");
        bt.postorder(bt.root);
        System.out.print("\nLevel Order: ");
        bt.levelOrder(bt.root);
    }
}
