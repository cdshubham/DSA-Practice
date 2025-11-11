import java.util.*;

class Node {
    int data;
    List<Node> children = new ArrayList<>();
    Node(int data) { this.data = data; }
}

public class KthLargestGenericTree {
    static int floor; // used to track floor in each iteration

    // Find floor of given data
    public static void getFloor(Node node, int data) {
        if (node.data < data && node.data > floor) {
            floor = node.data;
        }
        for (Node child : node.children) {
            getFloor(child, data);
        }
    }

    // Kth largest element
    public static int kthLargest(Node root, int k) {
        int factor = Integer.MAX_VALUE; // start with +∞
        int kthLargest = -1;

        for (int i = 0; i < k; i++) {
            floor = Integer.MIN_VALUE;
            getFloor(root, factor);
            kthLargest = floor;
            factor = floor;
        }

        return kthLargest;
    }

    // Construct generic tree from array (null means end of children)
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

        int k = 3;
        System.out.println(k + "th largest element: " + kthLargest(root, k));
    }
}