import java.util.*;

// Node of a generic tree
class Node {
    int data;
    List<Node> children;  // any number of children

    Node(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }
}

public class GenericTreeImplimentation {
    Node root;

    // Build tree using user input
    public void buildTree(Scanner sc) {
        System.out.print("Enter root value: ");
        int val = sc.nextInt();
        root = new Node(val);
        buildTreeRec(root, sc);
    }

    private void buildTreeRec(Node parent, Scanner sc) {
        System.out.print("Enter number of children for " + parent.data + ": ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value of child " + (i + 1) + " of " + parent.data + ": ");
            int val = sc.nextInt();
            Node child = new Node(val);
            parent.children.add(child);
            buildTreeRec(child, sc);
        }
    }

    // ✅ Size of the tree (total number of nodes)
    public int size(Node node) {
        if (node == null) return 0;
        int s = 1; // count current node
        for (Node child : node.children) {
            s += size(child);
        }
        return s;
    }

    // ✅ Display tree in a simple format
    public void display(Node node) {
        if (node == null) return;

        StringBuilder sb = new StringBuilder(node.data + " -> ");
        for (Node child : node.children) {
            sb.append(child.data).append(" ");
        }
        System.out.println(sb);

        for (Node child : node.children) {
            display(child);
        }
    }

    // ✅ Height of the tree
    public int height(Node node) {
        if (node == null) return -1;
        int h = -1;
        for (Node child : node.children) {
            h = Math.max(h, height(child));
        }
        return h + 1;
    }

    // ✅ Preorder Traversal
    public void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        for (Node child : node.children) {
            preOrder(child);
        }
    }

    // ✅ Postorder Traversal
    public void postOrder(Node node) {
        if (node == null) return;
        for (Node child : node.children) {
            postOrder(child);
        }
        System.out.print(node.data + " ");
    }

    // ✅ Level-order traversal
    public void levelOrder(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node node = q.poll();
            System.out.print(node.data + " ");
            q.addAll(node.children);
        }
    }

    public void levelOrderLinewise(Node root) {
    if (root == null) return;
    Queue<Node> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
        int size = q.size();
        for (int i = 0; i < size; i++) {
            Node node = q.poll();
            System.out.print(node.data + " ");
            q.addAll(node.children);
        }
        System.out.println(); // end of level
    }
}

    public void levelOrderLinewiseTwoQueues(Node root) {
    if (root == null) return;
    Queue<Node> mainQ = new LinkedList<>();
    Queue<Node> childQ = new LinkedList<>();

    mainQ.add(root);

    while (!mainQ.isEmpty()) {
        Node node = mainQ.poll();
        System.out.print(node.data + " ");

        for (Node child : node.children) {
            childQ.add(child);
        }

        if (mainQ.isEmpty()) {
            System.out.println();
            Queue<Node> temp = mainQ;
            mainQ = childQ;
            childQ = temp;
        }
    }
}

    public void levelOrderLinewiseMarker(Node root) {
    if (root == null) return;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    q.add(null); // marker for end of level

    while (!q.isEmpty()) {
        Node node = q.poll();
        if (node == null) {
            System.out.println();
            if (!q.isEmpty()) q.add(null);
        } else {
            System.out.print(node.data + " ");
            q.addAll(node.children);
        }
    }
}

    // Return node with maximum value
    public Node maxNode(Node node) {
        if (node == null) return null;

        Node max = node; // assume current node is max

        for (Node child : node.children) {
            Node childMax = maxNode(child);
            if (childMax.data > max.data) {
                max = childMax;
            }
        }

        return max;
    }

    // Zigzag Level Order Traversal
    public void levelOrderZigzag(Node root) {
        if (root == null) return;

        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();
        boolean leftToRight = true;

        currentLevel.push(root);

        while (!currentLevel.isEmpty()) {
            Node node = currentLevel.pop();
            System.out.print(node.data + " ");

            if (leftToRight) {
                for (Node child : node.children) {
                    nextLevel.push(child);
                }
            } else {
                // reverse order of children
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    nextLevel.push(node.children.get(i));
                }
            }

            if (currentLevel.isEmpty()) {
                System.out.println(); // new line for each level
                leftToRight = !leftToRight; // switch direction
                Stack<Node> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
    }

    // Function to mirror the tree
    public void mirror(Node node) {
        if (node == null) return;

        // Mirror all children first (postorder style)
        for (Node child : node.children) {
            mirror(child);
        }

        // Reverse the children list to mirror the structure
        Collections.reverse(node.children);
    }

    // Function to remove leaves from generic tree
    public static void removeLeaves(Node node) {
        // traverse children from end to avoid index shift
        for (int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);

            // if child is a leaf, remove it
            if (child.children.size() == 0) {
                node.children.remove(i);
            }
        }

        // recursive call for non-leaf children
        for (Node child : node.children) {
            removeLeaves(child);
        }
    }
    /////////////////////
    public static void linearize(Node node) {
        // linearize all children first
        for (Node child : node.children) {
            linearize(child);
        }

        // while more than one child
        while (node.children.size() > 1) {
            Node last = node.children.remove(node.children.size() - 1);
            Node secondLast = node.children.get(node.children.size() - 1);

            Node tail = getTail(secondLast);  // costly operation
            tail.children.add(last);
        }
    }

    private static Node getTail(Node node) {
        while (node.children.size() == 1) {
            node = node.children.get(0);
        }
        return node;
    }
    //////////////////////
    //////////////////////
    public static Node linearizeEfficient(Node node) {
        if (node.children.size() == 0) {
            return node; // tail is node itself
        }

        // linearize last child
        Node lastTail = linearizeEfficient(node.children.get(node.children.size() - 1));

        // process all other children from 2nd last to 0
        while (node.children.size() > 1) {
            Node last = node.children.remove(node.children.size() - 1);
            Node secondLast = node.children.get(node.children.size() - 1);

            Node secondLastTail = linearizeEfficient(secondLast);
            secondLastTail.children.add(last);
        }

        return lastTail;
    }
    /////////////////////
    ////////////////////////////////
    static ArrayList<Node> preorderList = new ArrayList<>();

    public static void preorder(Node node) {
        preorderList.add(node);
        for (Node child : node.children) {
            preorder(child);
        }
    }

    public static void linearizeUsingPreorder(Node root) {
        preorderList.clear();
        preorder(root);

        for (int i = 0; i < preorderList.size() - 1; i++) {
            Node curr = preorderList.get(i);
            curr.children.clear();
            curr.children.add(preorderList.get(i + 1));
        }

        preorderList.get(preorderList.size() - 1).children.clear();
    }
    /////////////////////////////////
    
    ////////Find Element 1
    public static boolean find(Node node, int data) {
        if (node.data == data) {
            return true;
        }
        for (Node child : node.children) {
            if (find(child, data)) {
                return true;
            }
        }
        return false;
    }

    ///////////Find Element 2 (Iterative)
    public static boolean findIterative(Node root, int data) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.data == data) {
                return true;
            }
            for (Node child : node.children) {
                q.add(child);
            }
        }
        return false;
    }

    ///////////Find Element 3 (DFS Iterative)
    public static boolean findDFS(Node root, int data) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node.data == data) {
                return true;
            }
            for (Node child : node.children) {
                stack.push(child);
            }
        }
        return false;
    }

    // Node to Root Path
    public static List<Integer> nodeToRootPath(Node node, int data) {
        if (node.data == data) {
            List<Integer> path = new ArrayList<>();
            path.add(node.data);
            return path;
        }

        for (Node child : node.children) {
            List<Integer> path = nodeToRootPath(child, data);
            if (path.size() > 0) {
                path.add(node.data);
                return path;
            }
        }

        return new ArrayList<>();
    }

    // Node to Root Path 2 (using boolean return type)
    public static boolean nodeToRootPath2(Node node, int data, List<Integer> path) {
        if (node.data == data) {
            path.add(node.data);
            return true;
        }

        for (Node child : node.children) {
            if (nodeToRootPath2(child, data, path)) {
                path.add(node.data);
                return true;
            }
        }

        return false;
    }

    // Node to Root Path 3 (Iterative)
    public static List<Integer> nodeToRootPathIterative(Node root, int data) {
        Map<Node, Node> parent = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        parent.put(root, null);

        Node target = null;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.data == data) {
                target = node;
                break;
            }
            for (Node child : node.children) {
                parent.put(child, node);
                q.add(child);
            }
        }

        List<Integer> path = new ArrayList<>();
        while (target != null) {
            path.add(target.data);
            target = parent.get(target);
        }
        return path;
    }

    // Lowest Common Ancestor (LCA)
    public static int lca(Node root, int d1, int d2) {
        List<Integer> p1 = nodeToRootPath(root, d1);
        List<Integer> p2 = nodeToRootPath(root, d2);

        int i = p1.size() - 1;
        int j = p2.size() - 1;

        int lca = -1;
        while (i >= 0 && j >= 0 && p1.get(i).equals(p2.get(j))) {
            lca = p1.get(i);
            i--;
            j--;
        }
        return lca;
    }

    // Optimized LCA (single traversal)
    public static Node lcaOptimized(Node node, int d1, int d2) {
        if (node == null) return null;
        if (node.data == d1 || node.data == d2) return node;

        int count = 0;
        Node temp = null;
        for (Node child : node.children) {
            Node res = lcaOptimized(child, d1, d2);
            if (res != null) {
                count++;
                if (count == 2) return node; // both found in different subtrees
                temp = res;
            }
        }
        return temp;
    }

    //////////////////Distance between two nodes
    public static int depth(Node node, int data) {
        if (node.data == data) return 0;
        for (Node child : node.children) {
            int d = depth(child, data);
            if (d != -1) return d + 1;
        }
        return -1; // not found
    }

    public static int distance(Node root, int d1, int d2) {
        int lcaVal = lca(root, d1, d2); // use path-based or optimized LCA

        int d1Depth = depth(root, d1);
        int d2Depth = depth(root, d2);
        int lcaDepth = depth(root, lcaVal);

        return d1Depth + d2Depth - 2 * lcaDepth;
    }
    //////////////////
     
    ///////////////////////Are two trees similar in shape
    public static boolean areSimilar(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        for (int i = 0; i < n1.children.size(); i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(i);
            if (!areSimilar(c1, c2)) {
                return false;
            }
        }

        return true;
    }
    ///////////////////////////
    
    ////////////////////////////Are two trees mirror images
    public static boolean areMirror(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        int size = n1.children.size();
        for (int i = 0; i < size; i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(size - 1 - i);

            if (!areMirror(c1, c2)) {
                return false;
            }
        }
        return true;
    }
    ////////////////////////

    ////////////////////////////Is tree symmetric
    public static boolean isSymmetric(Node node) {
        return areMirror(node, node);
    }

    public static boolean areMirror(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        int size = n1.children.size();
        for (int i = 0; i < size; i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(size - 1 - i);

            if (!areMirror(c1, c2)) {
                return false;
            }
        }
        return true;
    }
    //////////////////////////
    
    ////////////////////////////
    // Main driver
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GenericTreeImplimentation tree = new GenericTreeImplimentation(); // ✅ fixed class name

        // Build tree
        tree.buildTree(sc);

        System.out.println("\nTree Display:");
        tree.display(tree.root);

        System.out.println("\nSize of tree: " + tree.size(tree.root));
        System.out.println("Height of tree: " + tree.height(tree.root));

        System.out.print("Preorder Traversal: ");
        tree.preOrder(tree.root);
        System.out.println();

        System.out.print("Postorder Traversal: ");
        tree.postOrder(tree.root);
        System.out.println();

        System.out.print("Levelorder Traversal: ");
        tree.levelOrder(tree.root);
    }
}
