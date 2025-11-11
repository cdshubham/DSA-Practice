package DynamicProgramming;

import java.util.*;

public class MinimumCostPathAll {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] cost = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        System.out.println("Naive Recursion: " + minCostRecursive(cost, 0, 0));
        System.out.println("Memoization: " + minCostMemo(cost, 0, 0, new int[n][m]));
        System.out.println("Tabulation: " + minCostTab(cost));
        System.out.println("Space Optimized: " + minCostSpaceOptimized(cost));
    }

    // 1. Naive Recursion
    public static int minCostRecursive(int[][] cost, int i, int j) {
        int n = cost.length;
        int m = cost[0].length;
        if (i >= n || j >= m) return Integer.MAX_VALUE; // out of bounds
        if (i == n - 1 && j == m - 1) return cost[i][j]; // reached destination

        int right = minCostRecursive(cost, i, j + 1);
        int down = minCostRecursive(cost, i + 1, j);

        return cost[i][j] + Math.min(right, down);
    }

    // 2. Recursion + Memoization (Top-Down DP)
    public static int minCostMemo(int[][] cost, int i, int j, int[][] dp) {
        int n = cost.length;
        int m = cost[0].length;
        if (i >= n || j >= m) return Integer.MAX_VALUE;
        if (i == n - 1 && j == m - 1) return cost[i][j];
        if (dp[i][j] != 0) return dp[i][j];

        int right = minCostMemo(cost, i, j + 1, dp);
        int down = minCostMemo(cost, i + 1, j, dp);

        dp[i][j] = cost[i][j] + Math.min(right, down);
        return dp[i][j];
    }

    // 3. Tabulation (Bottom-Up DP)
    public static int minCostTab(int[][] cost) {
        int n = cost.length;
        int m = cost[0].length;
        int[][] dp = new int[n][m];

        dp[0][0] = cost[0][0];

        // first row
        for (int j = 1; j < m; j++) dp[0][j] = dp[0][j - 1] + cost[0][j];

        // first column
        for (int i = 1; i < n; i++) dp[i][0] = dp[i - 1][0] + cost[i][0];

        // rest of the grid
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = cost[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n - 1][m - 1];
    }

    // 4. Space Optimized (using 1D array)
    public static int minCostSpaceOptimized(int[][] cost) {
        int n = cost.length;
        int m = cost[0].length;
        int[] dp = new int[m];

        dp[0] = cost[0][0];

        // first row
        for (int j = 1; j < m; j++) dp[j] = dp[j - 1] + cost[0][j];

        // rest of the rows
        for (int i = 1; i < n; i++) {
            dp[0] += cost[i][0]; // first column
            for (int j = 1; j < m; j++) {
                dp[j] = cost[i][j] + Math.min(dp[j], dp[j - 1]);
            }
        }

        return dp[m - 1];
    }
}
