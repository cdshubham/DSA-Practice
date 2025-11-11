import java.util.*;

// Node class
class Node {
    int data;
    List<Node> children;

    Node(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }
}

// Generic Tree class implementing Iterable
class GenericTreeIterable implements Iterable<Node> {
    Node root;

    // Build tree using scanner input
    public void buildTree(Scanner sc) {
        System.out.print("Enter root value: ");
        root = new Node(sc.nextInt());
        buildTreeRec(root, sc);
    }

    private void buildTreeRec(Node parent, Scanner sc) {
        System.out.print("Enter number of children for " + parent.data + ": ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value of child " + (i + 1) + " of " + parent.data + ": ");
            Node child = new Node(sc.nextInt());
            parent.children.add(child);
            buildTreeRec(child, sc);
        }
    }

    // Pre-order iterator
    @Override
    public Iterator<Node> iterator() {
        return new Iterator<>() {
            Stack<Node> stack = new Stack<>();

            {
                if (root != null) stack.push(root);
            }

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public Node next() {
                if (!hasNext()) throw new NoSuchElementException();
                Node current = stack.pop();
                // Push children in reverse order so leftmost child comes out first
                List<Node> children = current.children;
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
                return current;
            }
        };
    }

    // Display tree (for verification)
    public void display(Node node) {
        if (node == null) return;
        System.out.print(node.data + " -> ");
        for (Node child : node.children) System.out.print(child.data + " ");
        System.out.println();
        for (Node child : node.children) display(child);
    }

    // Main driver
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GenericTreeIterable tree = new GenericTreeIterable();
        tree.buildTree(sc);

        System.out.println("\nTree Display:");
        tree.display(tree.root);

        System.out.println("\nIterating tree using Iterable (Pre-order):");
        for (Node node : tree) {
            System.out.print(node.data + " ");
        }
    }
}
