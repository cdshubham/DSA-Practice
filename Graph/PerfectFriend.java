import java.util.*;

public class PerfectFriend {
    int vertices;
    List<List<Edge>> adj;

    // Constructor
    PerfectFriend(int v) {
        vertices = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add undirected edge
    public void addEdge(int src, int dest) {
        adj.get(src).add(new Edge(dest));
        adj.get(dest).add(new Edge(src));
    }

    // -------- Perfect Friends Problem --------
    public int perfectFriends() {
        boolean[] visited = new boolean[vertices];
        List<Integer> componentSizes = new ArrayList<>();

        // Step 1: Find connected components
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                List<Integer> comp = new ArrayList<>();
                dfsComponent(i, visited, comp);
                componentSizes.add(comp.size());
            }
        }

        // Step 2: Count valid pairs (across different components)
        int result = 0;
        for (int i = 0; i < componentSizes.size(); i++) {
            for (int j = i + 1; j < componentSizes.size(); j++) {
                result += componentSizes.get(i) * componentSizes.get(j);
            }
        }
        return result;
    }

    // DFS helper to collect one connected component
    private void dfsComponent(int src, boolean[] visited, List<Integer> comp) {
        visited[src] = true;
        comp.add(src);

        for (Edge e : adj.get(src)) {
            if (!visited[e.dest]) {
                dfsComponent(e.dest, visited, comp);
            }
        }
    }

    // Helper Edge class
    static class Edge {
        int dest;
        Edge(int dest) {
            this.dest = dest;
        }
    }

    // Main for testing
    public static void main(String[] args) {
        PerfectFriend g = new PerfectFriend(7);
        g.addEdge(0, 1);
        g.addEdge(2, 3);
        g.addEdge(4, 5);
        g.addEdge(5, 6);

        System.out.println("Perfect Friends Pair Count = " + g.perfectFriends());
    }
}
