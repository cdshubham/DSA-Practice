import java.util.*;

public class SpreadInfection {
    private int vertices;
    private List<List<Integer>> adj;

    // Constructor
    public SpreadInfection(int v) {
        this.vertices = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add undirected edge
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // Spread infection from src in given time t
    public int spreadInfection(int src, int time) {
        boolean[] visited = new boolean[vertices];
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(src, 1)); // starting node infected at time 1
        visited[src] = true;
        int count = 0;

        while (!q.isEmpty()) {
            Pair rem = q.poll();

            if (rem.time > time) break; // stop if time exceeded
            count++;

            for (int nbr : adj.get(rem.node)) {
                if (!visited[nbr]) {
                    visited[nbr] = true;
                    q.add(new Pair(nbr, rem.time + 1));
                }
            }
        }

        return count;
    }

    // Helper class to store node and infection time
    class Pair {
        int node;
        int time;

        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    // Example run
    public static void main(String[] args) {
        SpreadInfection g = new SpreadInfection(7);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);
        g.addEdge(5, 6);

        int infected = g.spreadInfection(0, 3);
        System.out.println("Nodes infected in time 3 = " + infected);
    }
}
