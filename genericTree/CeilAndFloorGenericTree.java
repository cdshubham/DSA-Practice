import java.util.*;

class Node {
    int data;
    List<Node> children = new ArrayList<>();
    Node(int data) { this.data = data; }
}

public class CeilAndFloorGenericTree {
    static int ceil = Integer.MAX_VALUE;
    static int floor = Integer.MIN_VALUE;

    // DFS traversal to find ceil and floor
    public static void ceilAndFloor(Node node, int data) {
        if (node.data > data && node.data < ceil) {
            ceil = node.data;
        }
        if (node.data < data && node.data > floor) {
            floor = node.data;
        }

        for (Node child : node.children) {
            ceilAndFloor(child, data);
        }
    }

    // Tree builder from array (null means end of children)
    public static Node construct(Integer[] arr) {
        Stack<Node> st = new Stack<>();
        Node root = null;

        for (Integer val : arr) {
            if (val == null) {
                st.pop();
            } else {
                Node node = new Node(val);
                if (!st.isEmpty()) {
                    st.peek().children.add(node);
                } else {
                    root = node;
                }
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

        int target = 65;
        ceilAndFloor(root, target);

        System.out.println("Ceil of " + target + ": " + (ceil == Integer.MAX_VALUE ? "Not Found" : ceil));
        System.out.println("Floor of " + target + ": " + (floor == Integer.MIN_VALUE ? "Not Found" : floor));
    }
}
