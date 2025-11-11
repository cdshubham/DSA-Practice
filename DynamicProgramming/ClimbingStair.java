package DynamicProgramming;

public class ClimbingStair {
    public static void main(String[] args) {
        int n = 5; // Example input

        System.out.println("Naive Recursion: " + climbStairsRecursive(n));
        System.out.println("Memoization: " + climbStairsMemo(n, new int[n + 1]));
        System.out.println("Tabulation: " + climbStairsTab(n));
        System.out.println("Space Optimized: " + climbStairsOptimized(n));
    }

    // 1. Naive Recursion (Exponential)
    public static int climbStairsRecursive(int n) {
        if (n <= 1) return 1;
        return climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
    }

    // 2. Recursion + Memoization (Top-Down DP)
    public static int climbStairsMemo(int n, int[] dp) {
        if (n <= 1) return 1;
        if (dp[n] != 0) return dp[n];
        dp[n] = climbStairsMemo(n - 1, dp) + climbStairsMemo(n - 2, dp);
        return dp[n];
    }

    // 3. Tabulation (Bottom-Up DP)
    public static int climbStairsTab(int n) {
        if (n <= 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1; // 1 way to stay at ground
        dp[1] = 1; // 1 way to reach step 1
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 4. Space Optimized Iterative
    public static int climbStairsOptimized(int n) {
        if (n <= 1) return 1;
        int prev2 = 1, prev1 = 1, curr = 0;
        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}
