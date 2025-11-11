
class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}

public class LeftClonedTreeRevert {
    Node root;

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

    // Revert left-cloned tree to original tree
    public Node revertLeftClonedTree(Node node) {
        if (node == null) return null;

        // The left child is the clone; original left child is its left
        Node leftOriginal = revertLeftClonedTree(node.left != null ? node.left.left : null);
        Node rightOriginal = revertLeftClonedTree(node.right);

        node.left = leftOriginal;
        node.right = rightOriginal;

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
        LeftClonedTreeRevert tree = new LeftClonedTreeRevert();

        // Build original tree
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Original Tree:");
        tree.display(tree.root);

        // Transform to left-cloned tree
        tree.root = tree.createLeftClonedTree(tree.root);
        System.out.println("\nLeft Cloned Tree:");
        tree.display(tree.root);

        // Revert back
        tree.root = tree.revertLeftClonedTree(tree.root);
        System.out.println("\nReverted Original Tree:");
        tree.display(tree.root);
    }
}
