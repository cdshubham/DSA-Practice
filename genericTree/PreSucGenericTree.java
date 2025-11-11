import java.util.*;

class Node {
    int data;
    List<Node> children = new ArrayList<>();
    Node(int data) {
        this.data = data;
    }
}

public class PreSucGenericTree {
    static Node root;
    static Node predecessor = null;
    static Node successor = null;
    static Node prev = null;

    // Preorder traversal to find predecessor & successor
    public static void findPreSuc(Node node, int data) {
        if (node == null) return;

        // if previous node was target, then current node is successor
        if (prev != null && prev.data == data && successor == null) {
            successor = node;
        }

        // if current node is target, then prev is predecessor
        if (node.data == data && predecessor == null) {
            predecessor = prev;
        }

        prev = node; // update prev before going deeper

        for (Node child : node.children) {
            findPreSuc(child, data);
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
        root = construct(arr);

        int data = 120;  // element for which predecessor & successor needed
        findPreSuc(root, data);

        System.out.println("Predecessor of " + data + ": " + (predecessor != null ? predecessor.data : "null"));
        System.out.println("Successor of " + data + ": " + (successor != null ? successor.data : "null"));
    }
}
