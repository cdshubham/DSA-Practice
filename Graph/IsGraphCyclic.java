import java.util.*;

public class IsGraphCyclic {
    private int vertices;
    private List<Integer>[] adj;
    private boolean isDirected; // flag to differentiate between directed & undirected

    // Constructor
    public Graph(int v, boolean isDirected) {
        this.vertices = v;
        this.isDirected = isDirected;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    // Add edge
    public void addEdge(int src, int dest) {
        adj[src].add(dest);
        if (!isDirected) {
            adj[dest].add(src); // for undirected
        }
    }

    /* ===========================================================
       =============  CYCLE DETECTION METHODS ====================
       =========================================================== */

    // ----------- For Undirected Graph (DFS) -----------
    public boolean isCyclicUndirected() {
        if (isDirected) {
            throw new UnsupportedOperationException("Graph is directed. Use isCyclicDirected().");
        }

        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (dfsCycleUndirected(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsCycleUndirected(int node, boolean[] visited, int parent) {
        visited[node] = true;

        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                if (dfsCycleUndirected(neighbor, visited, node)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true; // back edge → cycle
            }
        }
        return false;
    }

    // ----------- For Directed Graph (DFS + Recursion Stack) -----------
    public boolean isCyclicDirected() {
        if (!isDirected) {
            throw new UnsupportedOperationException("Graph is undirected. Use isCyclicUndirected().");
        }

        boolean[] visited = new boolean[vertices];
        boolean[] recStack = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (dfsCycleDirected(i, visited, recStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsCycleDirected(int node, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adj[node]) {
            if (!visited[neighbor] && dfsCycleDirected(neighbor, visited, recStack)) {
                return true;
            } else if (recStack[neighbor]) {
                return true; // found cycle
            }
        }

        recStack[node] = false; // backtrack
        return false;
    }

    /* ===========================================================
       ================== MAIN TEST ==============================
       =========================================================== */
    public static void main(String[] args) {
        // ---------- Undirected Graph Example ----------
        Graph undirected = new Graph(4, false);
        undirected.addEdge(0, 1);
        undirected.addEdge(1, 2);
        undirected.addEdge(2, 0);
        undirected.addEdge(2, 3);

        System.out.println("Undirected Graph Cycle? " + undirected.isCyclicUndirected());

        // ---------- Directed Graph Example ----------
        Graph directed = new Graph(4, true);
        directed.addEdge(0, 1);
        directed.addEdge(1, 2);
        directed.addEdge(2, 0); // creates cycle
        directed.addEdge(2, 3);

        System.out.println("Directed Graph Cycle? " + directed.isCyclicDirected());
    }
}
