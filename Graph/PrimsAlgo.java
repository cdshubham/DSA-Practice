import java.util.*;

public class PrimsAlgo {
    int vertices;
    List<List<Edge>> adj;

    // Constructor
    PrimsAlgo(int v) {
        vertices = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add weighted edge
    public void addEdge(int src, int dest, int wt) {
        adj.get(src).add(new Edge(dest, wt));
        adj.get(dest).add(new Edge(src, wt)); // undirected
    }

    // Dijkstra’s Algorithm
    public void dijkstra(int src) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair rem = pq.poll();

            for (Edge e : adj.get(rem.node)) {
                if (dist[rem.node] + e.wt < dist[e.dest]) {
                    dist[e.dest] = dist[rem.node] + e.wt;
                    pq.add(new Pair(e.dest, dist[e.dest]));
                }
            }
        }

        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println(src + " -> " + i + " = " + dist[i]);
        }
    }

    // Prim’s Algorithm (MST)
    public void prims() {
        boolean[] visited = new boolean[vertices];
        PriorityQueue<PrimPair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);

        pq.add(new PrimPair(0, -1, 0)); // node, parent, weight

        int mstWeight = 0;
        List<String> mstEdges = new ArrayList<>();

        while (!pq.isEmpty()) {
            PrimPair rem = pq.poll();

            if (visited[rem.node]) continue;
            visited[rem.node] = true;

            if (rem.parent != -1) {
                mstWeight += rem.wt;
                mstEdges.add(rem.parent + " - " + rem.node + " @ " + rem.wt);
            }

            for (Edge e : adj.get(rem.node)) {
                if (!visited[e.dest]) {
                    pq.add(new PrimPair(e.dest, rem.node, e.wt));
                }
            }
        }

        System.out.println("MST edges:");
        for (String edge : mstEdges) {
            System.out.println(edge);
        }
        System.out.println("Total weight of MST = " + mstWeight);
    }

    // Helper class for edges
    static class Edge {
        int dest, wt;
        Edge(int dest, int wt) {
            this.dest = dest;
            this.wt = wt;
        }
    }

    // Helper for Dijkstra PQ
    static class Pair {
        int node, wt;
        Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    // Helper for Prim’s PQ
    static class PrimPair {
        int node, parent, wt;
        PrimPair(int node, int parent, int wt) {
            this.node = node;
            this.parent = parent;
            this.wt = wt;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        PrimsAlgo g = new PrimsAlgo(5);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 3, 6);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 8);
        g.addEdge(1, 4, 5);
        g.addEdge(2, 4, 7);
        g.addEdge(3, 4, 9);

        System.out.println("=== Dijkstra ===");
        g.dijkstra(0);

        System.out.println("\n=== Prim’s MST ===");
        g.prims();
    }
}
