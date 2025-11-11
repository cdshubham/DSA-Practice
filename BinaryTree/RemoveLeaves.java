class Node {
    int data;
    Node left, right;
    Node(int data) { this.data = data; }
}

public class RemoveLeaves {

    public static Node removeLeaves(Node node) {
        if (node == null) return null;

        // If node is a leaf, return null to remove it
        if (node.left == null && node.right == null) {
            return null;
        }

        // Recur for left and right subtrees
        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);

        return node; // return current node
    }

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
        root.right.left = new Node(7);

        System.out.println("Original Tree:");
        display(root);

        root = removeLeaves(root);

        System.out.println("\nTree after removing leaves:");
        display(root);
    }
}
