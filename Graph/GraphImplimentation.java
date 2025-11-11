import java.util.*;

public class GraphImplimentation {
    private int vertices; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency list

    // Constructor
    public GraphImplimentation(int v) {
        vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // Add edge (undirected graph by default, change as needed)
    public void addEdge(int src, int dest) {
        adj[src].add(dest);
        adj[dest].add(src); // remove this line for directed graph
    }

    /* ================= DFS ================= */

    // 1. DFS Recursive
    public void dfsRecursive(int start) {
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS Recursive starting from " + start + ": ");
        dfsUtil(start, visited);
        System.out.println();
    }

    private void dfsUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    // 2. DFS Iterative (using stack)
    public void dfsIterative(int start) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        System.out.print("DFS Iterative starting from " + start + ": ");
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                visited[node] = true;
                System.out.print(node + " ");
                // push neighbors (reverse order to maintain correct sequence)
                for (int i = adj[node].size() - 1; i >= 0; i--) {
                    int neighbor = adj[node].get(i);
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        System.out.println();
    }
    
    // Get all connected components
    public void connectedComponents() {
        boolean[] visited = new boolean[vertices];
        List<List<Integer>> components = new ArrayList<>();

        for (int v = 0; v < vertices; v++) {
            if (!visited[v]) {
                List<Integer> component = new ArrayList<>();
                dfsComponent(v, visited, component);  // using DFS
                components.add(component);
            }
        }

        // Print all components
        System.out.println("Connected Components of the Graph:");
        for (int i = 0; i < components.size(); i++) {
            System.out.println("Component " + (i + 1) + ": " + components.get(i));
        }
    }

    // DFS helper for connected components
    private void dfsComponent(int node, boolean[] visited, List<Integer> component) {
        visited[node] = true;
        component.add(node);

        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                dfsComponent(neighbor, visited, component);
            }
        }
    }


    /* ================= BFS ================= */

    // 1. BFS Normal
    public void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        System.out.print("BFS starting from " + start + ": ");
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int neighbor : adj[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // 2. BFS Level Order
    public void bfsLevelOrder(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        System.out.println("BFS Level Order starting from " + start + ": ");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                System.out.print(node + " ");
                for (int neighbor : adj[node]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
            System.out.println(); // new line for each level
        }
    }

    // 3. BFS for Shortest Path in Unweighted Graph
    public void bfsShortestPath(int start) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj[node]) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[node] + 1;
                    queue.add(neighbor);
                }
            }
        }

        System.out.println("Shortest Path from " + start + " to all nodes:");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Node " + i + " -> Distance: " + dist[i]);
        }
    }

    /* ================= MAIN TEST ================= */
    public static void main(String[] args) {
        GraphImplimentation g = new GraphImplimentation(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);

        g.dfsRecursive(0);
        g.dfsIterative(0);

        g.bfs(0);
        g.bfsLevelOrder(0);
        g.bfsShortestPath(0);
    }
}
