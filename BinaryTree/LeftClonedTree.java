
class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}

public class LeftClonedTree {
    Node root;

    // Build example tree
    public void buildExample() {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
    }

    // Transform to left-cloned tree
    public Node createLeftClonedTree(Node node) {
        if (node == null) return null;

        Node leftCloned = createLeftClonedTree(node.left);
        Node rightCloned = createLeftClonedTree(node.right);

        Node newNode = new Node(node.data);
        newNode.left = leftCloned;

        node.left = newNode;
        node.right = rightCloned;

        return node;
    }

    // Display tree (preorder)
    public void display(Node node) {
        if (node == null) return;
        String str = "";
        str += node.left != null ? node.left.data + " <- " : ". <- ";
        str += node.data;
        str += node.right != null ? " -> " + node.right.data : " -> .";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) {
        LeftClonedTree tree = new LeftClonedTree();
        tree.buildExample();

        System.out.println("Original Tree:");
        tree.display(tree.root);

        tree.root = tree.createLeftClonedTree(tree.root);

        System.out.println("\nLeft Cloned Tree:");
        tree.display(tree.root);
    }
}
