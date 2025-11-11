import java.util.*;

class Node {
    int data;
    List<Node> children = new ArrayList<>();
    Node(int data) { this.data = data; }
}

public class DiameterGenericTree {
    static int diameter = 0;

    // Function to calculate height and update diameter
    public static int height(Node node) {
        if (node == null) return -1;

        int deepest = -1;
        int secondDeepest = -1;

        for (Node child : node.children) {
            int h = height(child);
            if (h > deepest) {
                secondDeepest = deepest;
                deepest = h;
            } else if (h > secondDeepest) {
                secondDeepest = h;
            }
        }

        // Update diameter
        diameter = Math.max(diameter, deepest + secondDeepest + 2);

        return deepest + 1;
    }

    // Construct tree from array (null = end of children)
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

        height(root);

        System.out.println("Diameter of Generic Tree: " + diameter);
    }
}
