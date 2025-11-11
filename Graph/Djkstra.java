import java.util.*;

public class Djkstra {
    int vertices;
    List<List<Edge>> adj;

    // Constructor
    Djkstra(int v) {
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

        // Print shortest distances
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println(src + " -> " + i + " = " + dist[i]);
        }
    }

    // Helper class for edges
    static class Edge {
        int dest, wt;
        Edge(int dest, int wt) {
            this.dest = dest;
            this.wt = wt;
        }
    }

    // Helper class for priority queue
    static class Pair {
        int node, wt;
        Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Djkstra g = new Djkstra(5);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 7);
        g.addEdge(2, 4, 3);
        g.addEdge(3, 4, 1);

        g.dijkstra(0);
    }
}
