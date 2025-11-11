package DynamicProgramming;

public class ClimbingStairsWithJump {
    public static void main(String[] args) {
        int n = 5; // Example input

        System.out.println("Naive Recursion: " + climbStairsRecursive(n));
        System.out.println("Memoization: " + climbStairsMemo(n, new int[n + 1]));
        System.out.println("Tabulation: " + climbStairsTab(n));
        System.out.println("Space Optimized: " + climbStairsOptimized(n));
    }

    // 1. Naive Recursion
    public static int climbStairsRecursive(int n) {
        if (n == 0) return 1;
        int totalWays = 0;
        for (int jump = 1; jump <= 3; jump++) {
            if (n - jump >= 0) {
                totalWays += climbStairsRecursive(n - jump);
            }
        }
        return totalWays;
    }

    // 2. Recursion + Memoization
    public static int climbStairsMemo(int n, int[] dp) {
        if (n == 0) return 1;
        if (dp[n] != 0) return dp[n];
        int totalWays = 0;
        for (int jump = 1; jump <= 3; jump++) {
            if (n - jump >= 0) {
                totalWays += climbStairsMemo(n - jump, dp);
            }
        }
        dp[n] = totalWays;
        return totalWays;
    }

    // 3. Tabulation (Bottom-Up DP)
    public static int climbStairsTab(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; // 1 way to stay at ground
        for (int i = 1; i <= n; i++) {
            for (int jump = 1; jump <= 3; jump++) {
                if (i - jump >= 0) {
                    dp[i] += dp[i - jump];
                }
            }
        }
        return dp[n];
    }

    // 4. Space Optimized Iterative
    public static int climbStairsOptimized(int n) {
        if (n == 0) return 1;
        int a = 1, b = 0, c = 0; // previous 3 steps: a=dp[i-1], b=dp[i-2], c=dp[i-3]
        for (int i = 1; i <= n; i++) {
            int curr = a + b + c;
            c = b;
            b = a;
            a = curr;
        }
        return a;
    }
}
