import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}

public class BinaryTreePaths {
    Node root;

    // Build an example tree
    public void buildExample() {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
    }

    // 1. Node to Root Path
    public List<Node> nodeToRootPath(Node node, int data) {
        if (node == null) return new ArrayList<>();
        if (node.data == data) {
            List<Node> path = new ArrayList<>();
            path.add(node);
            return path;
        }

        List<Node> left = nodeToRootPath(node.left, data);
        if (!left.isEmpty()) {
            left.add(node);
            return left;
        }

        List<Node> right = nodeToRootPath(node.right, data);
        if (!right.isEmpty()) {
            right.add(node);
            return right;
        }

        return new ArrayList<>();
    }

    // 2. Print nodes k levels down
    public void printKLevelsDown(Node node, int k) {
        if (node == null || k < 0) return;
        if (k == 0) {
            System.out.print(node.data + " ");
            return;
        }
        printKLevelsDown(node.left, k - 1);
        printKLevelsDown(node.right, k - 1);
    }

    // 3. Print nodes k levels far from a given target
    public void printKNodesFar(Node root, int target, int k) {
        nodeToRootPath(root, target).forEach(n -> System.out.println(n.data)); // For debugging path

        printKNodesFarHelper(root, target, k);
    }

    private int printKNodesFarHelper(Node node, int target, int k) {
        if (node == null) return -1;
        if (node.data == target) {
            printKLevelsDown(node, k);
            return 1;
        }

        int ld = printKNodesFarHelper(node.left, target, k);
        if (ld != -1) {
            if (ld == k) System.out.print(node.data + " ");
            else printKLevelsDown(node.right, k - ld - 1);
            return ld + 1;
        }

        int rd = printKNodesFarHelper(node.right, target, k);
        if (rd != -1) {
            if (rd == k) System.out.print(node.data + " ");
            else printKLevelsDown(node.left, k - rd - 1);
            return rd + 1;
        }

        return -1;
    }

    // 4. Print all root-to-leaf paths
    public void printRootToLeafPaths(Node node, List<Integer> path) {
        if (node == null) return;

        path.add(node.data);

        if (node.left == null && node.right == null) {
            System.out.println(path);
        } else {
            printRootToLeafPaths(node.left, path);
            printRootToLeafPaths(node.right, path);
        }

        path.remove(path.size() - 1); // Backtracking
    }

    public static void main(String[] args) {
        BinaryTreePaths bt = new BinaryTreePaths();
        bt.buildExample();

        System.out.println("Node to Root Path for 5:");
        List<Node> path = bt.nodeToRootPath(bt.root, 5);
        path.forEach(n -> System.out.print(n.data + " "));
        System.out.println();

        System.out.println("\nNodes 2 levels down from 2:");
        bt.printKLevelsDown(bt.root.left, 2);
        System.out.println();

        System.out.println("\nNodes 2 levels far from node 2:");
        bt.printKNodesFar(bt.root, 2, 2);
        System.out.println();

        System.out.println("\nRoot to Leaf Paths:");
        bt.printRootToLeafPaths(bt.root, new ArrayList<>());
    }
}
