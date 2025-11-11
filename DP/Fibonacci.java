package DP;

public class Fibonacci {

    // 1. Brute Force (Recursive) Approach
    public int bruteForce(int n) {
        if (n <= 1) return n;
        return bruteForce(n - 1) + bruteForce(n - 2);
    }

    // 2. Memoization (Top-Down DP)
    public int memoization(int n, int[] dp) {
        if (n <= 1) return n;
        if (dp[n] != -1) return dp[n]; // already computed
        return dp[n] = memoization(n - 1, dp) + memoization(n - 2, dp);
    }

    // 3. Tabulation (Bottom-Up DP)
    public int tabulation(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 4. Space Optimized DP
    public int spaceOptimized(int n) {
        if (n <= 1) return n;
        int prev2 = 0, prev1 = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        int n = 10;

        // 1. Brute Force
        System.out.println("Brute Force: " + fib.bruteForce(n));

        // 2. Memoization
        int[] dp = new int[n + 1];
        java.util.Arrays.fill(dp, -1);
        System.out.println("Memoization: " + fib.memoization(n, dp));

        // 3. Tabulation
        System.out.println("Tabulation: " + fib.tabulation(n));

        // 4. Space Optimized
        System.out.println("Space Optimized: " + fib.spaceOptimized(n));
    }
}
