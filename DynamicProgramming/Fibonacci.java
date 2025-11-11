package DynamicProgramming;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;

        System.out.println("Naive Recursion: " + fibonacciRecursive(n));
        System.out.println("Memoization: " + fibonacciMemo(n, new int[n + 1]));
        System.out.println("Tabulation: " + fibonacciTab(n));
        System.out.println("Space Optimized: " + fibonacciOptimized(n));
        System.out.println("Formula: " + fibonacciFormula(n));
    }

    // 1. Naive Recursion (Exponential)
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // 2. Recursion + Memoization (Top-Down DP)
    public static int fibonacciMemo(int n, int[] dp) {
        if (n <= 1) return n;
        if (dp[n] != 0) return dp[n];
        dp[n] = fibonacciMemo(n - 1, dp) + fibonacciMemo(n - 2, dp);
        return dp[n];
    }

    // 3. Tabulation (Bottom-Up DP)
    public static int fibonacciTab(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 4. Space Optimized Iterative
    public static int fibonacciOptimized(int n) {
        if (n <= 1) return n;
        int prev2 = 0, prev1 = 1, curr = 0;
        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }

    // 5. Formula (Binet’s Formula)
    public static int fibonacciFormula(int n) {
        double phi = (1 + Math.sqrt(2 + 2)) / 2; // golden ratio
        return (int) Math.round(Math.pow(phi, n) / Math.sqrt(5));
    }
}
