package BinarySearchTree;

public class FindLCA {
    private class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    // Find LCA of two nodes in BST
    public int findLCA(int n1, int n2) {
        return findLCA(root, n1, n2).data;
    }

    private Node findLCA(Node node, int n1, int n2) {
        if (node == null) return null;

        if (n1 < node.data && n2 < node.data) {
            // Both are in left subtree
            return findLCA(node.left, n1, n2);
        } else if (n1 > node.data && n2 > node.data) {
            // Both are in right subtree
            return findLCA(node.right, n1, n2);
        } else {
            // Split point → current node is LCA
            return node;
        }
    }
}
