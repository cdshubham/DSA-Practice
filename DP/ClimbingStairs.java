package DP;

public class ClimbingStairs {

    // 1. Brute Force (Recursive)
    public int bruteForce(int n) {
        if (n <= 1) return 1; // 1 way to climb 0 or 1 step
        return bruteForce(n - 1) + bruteForce(n - 2);
    }

    // 2. Memoization (Top-Down DP)
    public int memoization(int n, int[] dp) {
        if (n <= 1) return 1;
        if (dp[n] != -1) return dp[n];
        return dp[n] = memoization(n - 1, dp) + memoization(n - 2, dp);
    }

    // 3. Tabulation (Bottom-Up DP)
    public int tabulation(int n) {
        if (n <= 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 4. Space Optimized
    public int spaceOptimized(int n) {
        if (n <= 1) return 1;
        int prev2 = 1, prev1 = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        int n = 5;

        // 1. Brute Force
        System.out.println("Brute Force: " + cs.bruteForce(n));

        // 2. Memoization
        int[] dp = new int[n + 1];
        java.util.Arrays.fill(dp, -1);
        System.out.println("Memoization: " + cs.memoization(n, dp));

        // 3. Tabulation
        System.out.println("Tabulation: " + cs.tabulation(n));

        // 4. Space Optimized
        System.out.println("Space Optimized: " + cs.spaceOptimized(n));
    }
}
