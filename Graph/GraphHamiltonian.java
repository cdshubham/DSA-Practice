import java.util.*;

public class GraphHamiltonian {
    private int vertices;
    private int[][] adjMatrix;

    // Constructor
    public GraphHamiltonian(int v) {
        this.vertices = v;
        adjMatrix = new int[v][v];
    }

    // Add edge (undirected graph)
    public void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1;
    }

    // ================= Hamiltonian Path =================
    public void hamiltonianPaths() {
        int[] path = new int[vertices];
        Arrays.fill(path, -1);

        for (int start = 0; start < vertices; start++) {
            path[0] = start;
            backtrackHamiltonian(path, 1, start, false);
        }
    }

    // ================= Hamiltonian Cycle =================
    public void hamiltonianCycles() {
        int[] path = new int[vertices];
        Arrays.fill(path, -1);

        path[0] = 0; // start from vertex 0
        backtrackHamiltonian(path, 1, 0, true);
    }

    // Backtracking function
    private void backtrackHamiltonian(int[] path, int pos, int start, boolean isCycle) {
        if (pos == vertices) {
            // If cycle check required → last must connect to first
            if (!isCycle || adjMatrix[path[pos - 1]][path[0]] == 1) {
                printPath(path, isCycle);
            }
            return;
        }

        for (int v = 0; v < vertices; v++) {
            if (isSafe(v, path, pos)) {
                path[pos] = v;
                backtrackHamiltonian(path, pos + 1, start, isCycle);
                path[pos] = -1; // backtrack
            }
        }
    }

    // Check if vertex can be added to path
    private boolean isSafe(int v, int[] path, int pos) {
        // Must be adjacent to previous
        if (adjMatrix[path[pos - 1]][v] == 0) return false;

        // Should not already be in path
        for (int i = 0; i < pos; i++) {
            if (path[i] == v) return false;
        }
        return true;
    }

    // Print Path
    private void printPath(int[] path, boolean isCycle) {
        System.out.print((isCycle ? "Hamiltonian Cycle: " : "Hamiltonian Path: "));
        for (int v : path) {
            System.out.print(v + " ");
        }
        if (isCycle) System.out.print(path[0]); // close the cycle
        System.out.println();
    }

    // ================= TEST =================
    public static void main(String[] args) {
        GraphHamiltonian g = new GraphHamiltonian(5);

        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);

        System.out.println("All Hamiltonian Paths:");
        g.hamiltonianPaths();

        System.out.println("\nAll Hamiltonian Cycles:");
        g.hamiltonianCycles();
    }
}
