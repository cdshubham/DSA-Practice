package BinarySearch;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class LargestBSTSubTree {

    // Helper Pair
    static class BSTPair {
        boolean isBST;
        int min;
        int max;
        int size;
        Node root; // root of largest BST subtree
    }

    public static BSTPair largestBST(Node node) {
        if (node == null) {
            BSTPair bp = new BSTPair();
            bp.isBST = true;
            bp.min = Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;
            bp.size = 0;
            bp.root = null;
            return bp;
        }

        BSTPair lp = largestBST(node.left);
        BSTPair rp = largestBST(node.right);

        BSTPair myPair = new BSTPair();
        myPair.isBST = lp.isBST && rp.isBST &&
                       (node.data >= lp.max && node.data <= rp.min);

        myPair.min = Math.min(node.data, Math.min(lp.min, rp.min));
        myPair.max = Math.max(node.data, Math.max(lp.max, rp.max));

        if (myPair.isBST) {
            myPair.size = lp.size + rp.size + 1;
            myPair.root = node;
        } else {
            if (lp.size > rp.size) {
                myPair.size = lp.size;
                myPair.root = lp.root;
            } else {
                myPair.size = rp.size;
                myPair.root = rp.root;
            }
        }

        return myPair;
    }

    // Driver
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(60);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        BSTPair ans = largestBST(root);
        System.out.println("Largest BST Subtree Root: " + ans.root.data);
        System.out.println("Size of Largest BST: " + ans.size);
    }
}
