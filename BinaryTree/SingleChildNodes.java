class Node {
    int data;
    Node left, right;
    Node(int data) { this.data = data; }
}

public class SingleChildNodes {
    
    public static void printSingleChildNodes(Node node) {
        if (node == null) return;

        // Check if node has exactly one child
        if ((node.left != null && node.right == null) || (node.left == null && node.right != null)) {
            System.out.println(node.data);
        }

        printSingleChildNodes(node.left);
        printSingleChildNodes(node.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);
        root.left.left.left = new Node(6);

        System.out.println("Single Child Nodes:");
        printSingleChildNodes(root);
    }
}
