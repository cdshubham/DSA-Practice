package DP;

public class ClimbingStairsWithJump {

    // 1. Brute Force (Recursive)
    public int bruteForce(int idx, int n, int[] jumps) {
        if (idx == n) return 1; // reached top
        if (idx > n) return 0;  // overshoot

        int ways = 0;
        for (int jump = 1; jump <= jumps[idx]; jump++) {
            ways += bruteForce(idx + jump, n, jumps);
        }
        return ways;
    }

    // 2. Memoization (Top-Down DP)
    public int memoization(int idx, int n, int[] jumps, int[] dp) {
        if (idx == n) return 1;
        if (idx > n) return 0;
        if (dp[idx] != -1) return dp[idx];

        int ways = 0;
        for (int jump = 1; jump <= jumps[idx]; jump++) {
            ways += memoization(idx + jump, n, jumps, dp);
        }
        return dp[idx] = ways;
    }

    // 3. Tabulation (Bottom-Up DP)
    public int tabulation(int n, int[] jumps) {
        int[] dp = new int[n + 1];
        dp[n] = 1; // 1 way to stay at top

        for (int i = n - 1; i >= 0; i--) {
            int ways = 0;
            for (int jump = 1; jump <= jumps[i] && i + jump <= n; jump++) {
                ways += dp[i + jump];
            }
            dp[i] = ways;
        }
        return dp[0];
    }

    // 4. Optimized Tabulation (only valid if jumps[i] is bounded small, else same as tabulation)
    // Not much space optimization possible here because jumps vary per step

    public static void main(String[] args) {
        ClimbingStairsWithJump csj = new ClimbingStairsWithJump();

        int n = 6; // top step
        int[] jumps = {3, 3, 0, 2, 2, 3}; // max jump allowed from each step

        // 1. Brute Force
        System.out.println("Brute Force: " + csj.bruteForce(0, n, jumps));

        // 2. Memoization
        int[] dp = new int[n + 1];
        java.util.Arrays.fill(dp, -1);
        System.out.println("Memoization: " + csj.memoization(0, n, jumps, dp));

        // 3. Tabulation
        System.out.println("Tabulation: " + csj.tabulation(n, jumps));
    }
}
