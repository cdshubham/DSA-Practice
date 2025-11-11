import java.util.*;

// Node class
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

// BST Implementation with Target Sum Pair methods
public class BSTTargetSum {
    Node root;

    // Constructor: build BST from sorted array
    public BSTTargetSum(int[] arr, int lo, int hi) {
        if (lo > hi) return;
        int mid = (lo + hi) / 2;
        Node node = new Node(arr[mid]);

        if (root == null) root = node;
        insert(root, arr, lo, hi); // fill rest of BST
    }

    private void insert(Node root, int[] arr, int lo, int hi) {
        if (lo > hi) return;
        int mid = (lo + hi) / 2;
        if (arr[mid] != root.data) add(root, arr[mid]);
        insert(root, arr, lo, mid - 1);
        insert(root, arr, mid + 1, hi);
    }

    // Add node in BST
    public void add(Node node, int val) {
        if (val < node.data) {
            if (node.left == null) node.left = new Node(val);
            else add(node.left, val);
        } else if (val > node.data) {
            if (node.right == null) node.right = new Node(val);
            else add(node.right, val);
        }
    }

    // ================== TARGET SUM PAIR APPROACHES ==================

    // 1. Naive O(n²)
    public void targetSumPairNaive(Node root, int target) {
        List<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        for (int i = 0; i < inorder.size(); i++) {
            for (int j = i + 1; j < inorder.size(); j++) {
                if (inorder.get(i) + inorder.get(j) == target) {
                    System.out.println(inorder.get(i) + " + " + inorder.get(j));
                }
            }
        }
    }

    // 2. Two-pointer on inorder O(n)
    public void targetSumPairTwoPointer(Node root, int target) {
        List<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        int i = 0, j = inorder.size() - 1;
        while (i < j) {
            int sum = inorder.get(i) + inorder.get(j);
            if (sum == target) {
                System.out.println(inorder.get(i) + " + " + inorder.get(j));
                i++; j--;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
    }

    // 3. HashSet Approach
    public void targetSumPairHashSet(Node root, int target) {
        HashSet<Integer> set = new HashSet<>();
        targetSumPairHashSetHelper(root, target, set);
    }

    private void targetSumPairHashSetHelper(Node node, int target, HashSet<Integer> set) {
        if (node == null) return;

        int complement = target - node.data;
        if (set.contains(complement)) {
            System.out.println(node.data + " + " + complement);
        }
        set.add(node.data);

        targetSumPairHashSetHelper(node.left, target, set);
        targetSumPairHashSetHelper(node.right, target, set);
    }

    // 4. Optimized Iterators (O(h) space)
    public void targetSumPairIterators(Node root, int target) {
        Stack<Node> leftStack = new Stack<>();
        Stack<Node> rightStack = new Stack<>();

        pushLeft(root, leftStack);
        pushRight(root, rightStack);

        Node left = getNextLeft(leftStack);
        Node right = getNextRight(rightStack);

        while (left != null && right != null && left.data < right.data) {
            int sum = left.data + right.data;
            if (sum == target) {
                System.out.println(left.data + " + " + right.data);
                left = getNextLeft(leftStack);
                right = getNextRight(rightStack);
            } else if (sum < target) {
                left = getNextLeft(leftStack);
            } else {
                right = getNextRight(rightStack);
            }
        }
    }

    // Helper functions for inorder and iterators
    private void getInorder(Node node, List<Integer> list) {
        if (node == null) return;
        getInorder(node.left, list);
        list.add(node.data);
        getInorder(node.right, list);
    }

    private void pushLeft(Node node, Stack<Node> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    private void pushRight(Node node, Stack<Node> stack) {
        while (node != null) {
            stack.push(node);
            node = node.right;
        }
    }

    private Node getNextLeft(Stack<Node> stack) {
        if (stack.isEmpty()) return null;
        Node node = stack.pop();
        pushLeft(node.right, stack);
        return node;
    }

    private Node getNextRight(Stack<Node> stack) {
        if (stack.isEmpty()) return null;
        Node node = stack.pop();
        pushRight(node.left, stack);
        return node;
    }

    // ================== MAIN DRIVER ==================
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70}; // BST elements
        BSTTargetSum bst = new BSTTargetSum(arr, 0, arr.length - 1);

        int target = 70;

        System.out.println("Naive Approach:");
        bst.targetSumPairNaive(bst.root, target);

        System.out.println("\nTwo Pointer Approach:");
        bst.targetSumPairTwoPointer(bst.root, target);

        System.out.println("\nHashSet Approach:");
        bst.targetSumPairHashSet(bst.root, target);

        System.out.println("\nIterator Approach:");
        bst.targetSumPairIterators(bst.root, target);
    }
}
