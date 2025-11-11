class Node {
    int data;
    Node left, right;
    Node(int data) { this.data = data; }
}

public class BinaryTreeTilt {
    static int totalTilt = 0;

    // Helper function to compute tilt
    public static int computeTilt(Node node) {
        if (node == null) return 0;

        int leftSum = computeTilt(node.left);
        int rightSum = computeTilt(node.right);

        int nodeTilt = Math.abs(leftSum - rightSum);
        totalTilt += nodeTilt;

        return leftSum + rightSum + node.data;
    }

    // Display tree
    public static void display(Node node) {
        if (node == null) return;
        String str = "";
        str += node.left != null ? node.left.data : ".";
        str += " <- " + node.data + " -> ";
        str += node.right != null ? node.right.data : ".";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println("Tree:");
        display(root);

        computeTilt(root);
        System.out.println("\nTotal Tilt of Binary Tree: " + totalTilt);
    }
}
