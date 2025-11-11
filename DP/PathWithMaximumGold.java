package DP;

public class PathWithMaximumGold {

    // Directions: up, down, left, right
    private static final int[][] DIRS = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    // 1. Brute Force DFS (Backtracking)
    public int bruteForce(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxGold = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    maxGold = Math.max(maxGold, dfs(grid, i, j));
                }
            }
        }
        return maxGold;
    }

    private int dfs(int[][] grid, int i, int j) {
        // If out of bounds or no gold
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        int gold = grid[i][j];
        grid[i][j] = 0; // mark visited

        int max = 0;
        for (int[] dir : DIRS) {
            int ni = i + dir[0], nj = j + dir[1];
            max = Math.max(max, dfs(grid, ni, nj));
        }

        grid[i][j] = gold; // backtrack
        return gold + max;
    }

    // 2. Memoization (DFS + caching states)
    // Note: Memoization is tricky here because path validity depends on visited cells.
    // But we can cache per cell if we ignore visited restrictions (approximation).
    public int memoization(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) java.util.Arrays.fill(row, -1);

        int maxGold = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    maxGold = Math.max(maxGold, dfsMemo(grid, i, j, dp));
                }
            }
        }
        return maxGold;
    }

    private int dfsMemo(int[][] grid, int i, int j, int[][] dp) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        if (dp[i][j] != -1) return dp[i][j];

        int gold = grid[i][j];
        grid[i][j] = 0;

        int max = 0;
        for (int[] dir : DIRS) {
            max = Math.max(max, dfsMemo(grid, i + dir[0], j + dir[1], dp));
        }

        grid[i][j] = gold;
        return dp[i][j] = gold + max;
    }

    // 3. Tabulation (Not practical for backtracking state space)
    // Path constraints make tabulation infeasible here.
    // Usually, DFS + backtracking is the standard solution.

    public static void main(String[] args) {
        PathWithMaximumGold solver = new PathWithMaximumGold();

        int[][] grid = {
            {0, 6, 0},
            {5, 8, 7},
            {0, 9, 0}
        };

        // 1. Brute Force DFS
        System.out.println("Brute Force DFS: " + solver.bruteForce(grid));

        // 2. Memoization DFS (approximate, not exact in all cases)
        System.out.println("Memoization DFS: " + solver.memoization(grid));
    }
}
