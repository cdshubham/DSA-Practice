import java.util.*;

public class IsGraphBipartite {
    private int vertices;
    private List<Integer>[] adj;

    // Constructor
    public IsGraphBipartite(int v) {
        this.vertices = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    // Add edge (undirected by default, can be changed)
    public void addEdge(int src, int dest) {
        adj[src].add(dest);
        adj[dest].add(src); // comment this line for directed graph
    }

    /* ===========================================================
       =============  BIPARTITE CHECK (BFS + DFS)  ================
       =========================================================== */

    // ----------- BFS Based Bipartite Check -----------
    public boolean isBipartiteBFS() {
        int[] color = new int[vertices];
        Arrays.fill(color, -1);

        for (int start = 0; start < vertices; start++) {
            if (color[start] == -1) {
                if (!bfsCheck(start, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfsCheck(int start, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : adj[node]) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    queue.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false; // same color → not bipartite
                }
            }
        }
        return true;
    }

    // ----------- DFS Based Bipartite Check -----------
    public boolean isBipartiteDFS() {
        int[] color = new int[vertices];
        Arrays.fill(color, -1);

        for (int i = 0; i < vertices; i++) {
            if (color[i] == -1) {
                if (!dfsCheck(i, 0, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfsCheck(int node, int c, int[] color) {
        color[node] = c;

        for (int neighbor : adj[node]) {
            if (color[neighbor] == -1) {
                if (!dfsCheck(neighbor, 1 - c, color)) {
                    return false;
                }
            } else if (color[neighbor] == color[node]) {
                return false; // same color → not bipartite
            }
        }
        return true;
    }

    /* ===========================================================
       ================== MAIN TEST ==============================
       =========================================================== */
    public static void main(String[] args) {
        IsGraphBipartite g1 = new IsGraphBipartite(4);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 0); // even cycle

        System.out.println("Graph 1 Bipartite (BFS)? " + g1.isBipartiteBFS());
        System.out.println("Graph 1 Bipartite (DFS)? " + g1.isBipartiteDFS());

        IsGraphBipartite g2 = new IsGraphBipartite(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 0); // odd cycle → not bipartite

        System.out.println("Graph 2 Bipartite (BFS)? " + g2.isBipartiteBFS());
        System.out.println("Graph 2 Bipartite (DFS)? " + g2.isBipartiteDFS());
    }
}
