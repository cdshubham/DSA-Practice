import java.util.*;

class Node {
    int data;
    List<Node> children = new ArrayList<>();
    Node(int data) { this.data = data; }
}

public class MaxSubTreeNode {
    static int maxSum = Integer.MIN_VALUE;
    static Node maxNode = null;

    // Function to calculate subtree sum
    public static int subtreeSum(Node node) {
        int sum = node.data;
        for (Node child : node.children) {
            sum += subtreeSum(child);
        }

        // Update max
        if (sum > maxSum) {
            maxSum = sum;
            maxNode = node;
        }

        return sum;
    }

    // Construct generic tree from array (null = end of children)
    public static Node construct(Integer[] arr) {
        Stack<Node> st = new Stack<>();
        Node root = null;

        for (Integer val : arr) {
            if (val == null) {
                st.pop();
            } else {
                Node node = new Node(val);
                if (!st.isEmpty()) st.peek().children.add(node);
                else root = node;
                st.push(node);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] arr = {10, 20, 50, null, 60, null, null, 
                         30, 70, null, 80, 110, null, 120, null, null, 
                         90, null, null, 40, 100, null, null, null};
        Node root = construct(arr);

        subtreeSum(root);

        System.out.println("Node with maximum subtree sum: " + maxNode.data);
        System.out.println("Maximum subtree sum: " + maxSum);
    }
}
