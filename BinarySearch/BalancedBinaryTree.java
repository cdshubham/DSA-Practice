class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class BalancedBinaryTree {

    // --------- Naive Approach (O(n²)) ---------
    public static boolean isBalanced(Node root) {
        if (root == null) return true;

        int lh = height(root.left);
        int rh = height(root.right);

        if (Math.abs(lh - rh) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }


    // --------- Optimized Approach (O(n)) ---------
    static class BalancePair {
        int height;
        boolean isBalanced;
    }

    public static BalancePair isBalancedOptimized(Node node) {
        if (node == null) {
            BalancePair bp = new BalancePair();
            bp.height = 0;
            bp.isBalanced = true;
            return bp;
        }

        BalancePair left = isBalancedOptimized(node.left);
        BalancePair right = isBalancedOptimized(node.right);

        BalancePair myPair = new BalancePair();
        myPair.height = Math.max(left.height, right.height) + 1;
        myPair.isBalanced = left.isBalanced && right.isBalanced &&
                            Math.abs(left.height - right.height) <= 1;

        return myPair;
    }


    // --------- Main Driver ---------
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.left.left.left = new Node(60); // makes it unbalanced

        System.out.println("Naive Check: " + isBalanced(root));
        System.out.println("Optimized Check: " + isBalancedOptimized(root).isBalanced);
    }
}
