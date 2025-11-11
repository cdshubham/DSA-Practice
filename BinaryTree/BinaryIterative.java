import java.util.*;

// Node class
class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}

public class BinaryIterative {
    Node root;

    // Construct example tree
    public void buildExample() {
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(60);
    }

    // Iterative Preorder Traversal
    public void iterativePreorder() {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.print(curr.data + " ");

            // Push right first so left is processed first
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
    }

    // Iterative Inorder Traversal
    public void iterativeInorder() {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    // Iterative Postorder Traversal
    public void iterativePostorder() {
        if (root == null) return;
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            Node curr = stack1.pop();
            stack2.push(curr);
            if (curr.left != null) stack1.push(curr.left);
            if (curr.right != null) stack1.push(curr.right);
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " ");
        }
    }

    // Level-order traversal
    public void levelOrder() {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
    }

    public static void main(String[] args) {
        BinaryIterative bt = new BinaryIterative();
        bt.buildExample();

        System.out.print("Iterative Preorder: ");
        bt.iterativePreorder();
        System.out.println();

        System.out.print("Iterative Inorder: ");
        bt.iterativeInorder();
        System.out.println();

        System.out.print("Iterative Postorder: ");
        bt.iterativePostorder();
        System.out.println();

        System.out.print("Level Order: ");
        bt.levelOrder();
    }
}
