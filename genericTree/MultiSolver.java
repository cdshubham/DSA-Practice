package genericTree;

import java.util.*;

class Node {
    int data;
    List<Node> children = new ArrayList<>();
    Node(int data) {
        this.data = data;
    }
}

class HeapMover {
    int size = 0;
    int height = 0;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    boolean found = false;

    Node predecessor = null;
    Node successor = null;
    Node prev = null;

    int floor = Integer.MIN_VALUE;
    int ceil = Integer.MAX_VALUE;
}

public class MultiSolver {
    static Node root;

    public static void multiSolver(Node node, int depth, int data, HeapMover mover) {
        // size
        mover.size++;

        // min and max
        mover.min = Math.min(mover.min, node.data);
        mover.max = Math.max(mover.max, node.data);

        // height
        mover.height = Math.max(mover.height, depth);

        // find data
        if (node.data == data) {
            mover.found = true;
        }

        // predecessor & successor
        if (mover.prev != null && mover.successor == null && mover.prev.data == data) {
            mover.successor = node;
        }
        if (mover.predecessor == null && node.data == data) {
            mover.predecessor = mover.prev;
        }
        mover.prev = node;

        // floor & ceil
        if (node.data > data && node.data < mover.ceil) {
            mover.ceil = node.data;
        }
        if (node.data < data && node.data > mover.floor) {
            mover.floor = node.data;
        }

        for (Node child : node.children) {
            multiSolver(child, depth + 1, data, mover);
        }
    }

    // Example Tree Builder
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
        Integer[] arr = {10, 20, 50, null, 60, null, null, 30, 70, null, 80, 110, null, 120, null, null, 90, null, null, 40, 100, null, null, null};
        root = construct(arr);

        HeapMover mover = new HeapMover();
        int data = 120; // element to search for
        multiSolver(root, 0, data, mover);

        System.out.println("Size: " + mover.size);
        System.out.println("Min: " + mover.min);
        System.out.println("Max: " + mover.max);
        System.out.println("Height: " + mover.height);
        System.out.println("Found: " + mover.found);
        System.out.println("Predecessor: " + (mover.predecessor != null ? mover.predecessor.data : "null"));
        System.out.println("Successor: " + (mover.successor != null ? mover.successor.data : "null"));
        System.out.println("Floor of " + data + ": " + mover.floor);
        System.out.println("Ceil of " + data + ": " + mover.ceil);
    }
}