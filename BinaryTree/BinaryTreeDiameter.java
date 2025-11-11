class Node {
    int data;
    Node left, right;
    Node(int data) { this.data = data; }
}

public class BinaryTreeDiameter {

    static class DiaPair {
        int height;
        int diameter;

        DiaPair(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    // Function to compute diameter
    public static DiaPair diameter(Node node) {
        if (node == null) return new DiaPair(-1, 0);

        DiaPair left = diameter(node.left);
        DiaPair right = diameter(node.right);

        int height = Math.max(left.height, right.height) + 1;

        int diaThroughRoot = left.height + right.height + 2;
        int dia = Math.max(diaThroughRoot, Math.max(left.diameter, right.diameter));

        return new DiaPair(height, dia);
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

        DiaPair result = diameter(root);
        System.out.println("\nDiameter of tree: " + result.diameter);
    }
}
