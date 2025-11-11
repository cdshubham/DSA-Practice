import java.util.*;

class Node {
    int data;
    List<Node> children = new ArrayList<>();

    Node(int data) { this.data = data; }
}

class Pair {
    Node node;
    int state; // -1 = not visited, otherwise index of child processed

    Pair(Node node, int state) {
        this.node = node;
        this.state = state;
    }
}

public class IterativePrePostGenericTre {

    public static void iterativePrePost(Node root) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, -1));

        StringBuilder preOrder = new StringBuilder();
        StringBuilder postOrder = new StringBuilder();

        while (!stack.isEmpty()) {
            Pair top = stack.peek();

            if (top.state == -1) {
                // Preorder: first time we see the node
                preOrder.append(top.node.data).append(" ");
                top.state++;
            } else if (top.state < top.node.children.size()) {
                // Process child
                Node child = top.node.children.get(top.state);
                stack.push(new Pair(child, -1));
                top.state++;
            } else {
                // Postorder: all children processed
                postOrder.append(top.node.data).append(" ");
                stack.pop();
            }
        }

        System.out.println("Preorder: " + preOrder);
        System.out.println("Postorder: " + postOrder);
    }

    // Construct generic tree from array (null indicates end of children)
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

        iterativePrePost(root);
    }
}
