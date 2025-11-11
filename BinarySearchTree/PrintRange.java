package BinarySearchTree;

public class PrintRange {
    private class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    // Print all nodes in the given range [low, high]
    public void printInRange(int low, int high) {
        printInRange(root, low, high);
    }

    private void printInRange(Node node, int low, int high) {
        if (node == null) return;

        // If current node value > low, explore left subtree
        if (node.data > low) {
            printInRange(node.left, low, high);
        }

        // If current node lies in the range, print it
        if (node.data >= low && node.data <= high) {
            System.out.print(node.data + " ");
        }

        // If current node value < high, explore right subtree
        if (node.data < high) {
            printInRange(node.right, low, high);
        }
    }
}
