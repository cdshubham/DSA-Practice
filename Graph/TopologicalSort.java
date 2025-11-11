import java.util.*;

public class TopologicalSort {
    int vertices;
    List<List<Edge>> adj;

    // Constructor
    TopologicalSort(int v) {
        vertices = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add directed edge with weight
    public void addEdge(int src, int dest, int wt) {
        adj.get(src).add(new Edge(dest, wt));
    }

    // ----------- TOPOLOGICAL SORT (DFS) -----------
    public List<Integer> topoSortDFS() {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfsTopo(i, visited, st);
            }
        }

        List<Integer> order = new ArrayList<>();
        while (!st.isEmpty()) {
            order.add(st.pop());
        }
        return order;
    }

    private void dfsTopo(int src, boolean[] visited, Stack<Integer> st) {
        visited[src] = true;

        for (Edge e : adj.get(src)) {
            if (!visited[e.dest]) {
                dfsTopo(e.dest, visited, st);
            }
        }
        st.push(src);
    }

    // ----------- TOPOLOGICAL SORT (Kahn’s Algorithm BFS) -----------
    public List<Integer> topoSortKahn() {
        int[] indegree = new int[vertices];

        // compute indegrees
        for (int i = 0; i < vertices; i++) {
            for (Edge e : adj.get(i)) {
                indegree[e.dest]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        List<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            order.add(node);

            for (Edge e : adj.get(node)) {
                indegree[e.dest]--;
                if (indegree[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }

        if (order.size() != vertices) {
            System.out.println("Graph is not a DAG (contains cycle)");
            return new ArrayList<>();
        }

        return order;
    }

    // Edge class
    static class Edge {
        int dest, wt;
        Edge(int dest, int wt) {
            this.dest = dest;
            this.wt = wt;
        }
    }

    // Main for testing
    public static void main(String[] args) {
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2, 1);
        g.addEdge(5, 0, 1);
        g.addEdge(4, 0, 1);
        g.addEdge(4, 1, 1);
        g.addEdge(2, 3, 1);
        g.addEdge(3, 1, 1);

        System.out.println("Topological Sort (DFS): " + g.topoSortDFS());
        System.out.println("Topological Sort (Kahn’s): " + g.topoSortKahn());
    }
}
