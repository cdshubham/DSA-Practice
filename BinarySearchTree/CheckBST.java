package BinarySearchTree;

class Node {
    int data;
    Node left, right;
    Node(int data) { this.data = data; }
}


class CheckBST2 {

    // Check if tree is BST
    public static boolean isBST(Node node, int min, int max) {
        if (node == null) return true;

        if (node.data < min || node.data > max) {
            return false;
        }

        return isBST(node.left, min, node.data) &&
               isBST(node.right, node.data, max);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right = new Node(8);
        root.right.left = new Node(12);
        root.right.right = new Node(20);

        boolean result = isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("Is BST? " + result);
    }
}

class CheckBSTInorder {
    static Integer prev = null;

    public static boolean isBST(Node node) {
        if (node == null) return true;

        if (!isBST(node.left)) return false;

        if (prev != null && node.data <= prev) {
            return false;
        }
        prev = node.data;

        return isBST(node.right);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.left = new Node(6); // ❌ This breaks BST rule

        System.out.println("Is BST? " + isBST(root));
    }
}
