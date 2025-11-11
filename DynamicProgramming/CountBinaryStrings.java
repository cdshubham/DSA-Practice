package DynamicProgramming;

public class CountBinaryStrings {
    // Approach 1: Simple Recursive
    public int countBinaryStringsRecursive(int n) {
        return countBinaryStringsRecursiveHelper(n, 0);
    }
    
    private int countBinaryStringsRecursiveHelper(int n, int lastDigit) {
        if (n == 0) return 1;
        
        // If last digit was 1, we can only add 0
        if (lastDigit == 1) {
            return countBinaryStringsRecursiveHelper(n - 1, 0);
        }
        
        // If last digit was 0 (or start), we can add 0 or 1
        return countBinaryStringsRecursiveHelper(n - 1, 0) + countBinaryStringsRecursiveHelper(n - 1, 1);
    }

    // Approach 2: Memoization (Top-Down DP)
    public int countBinaryStringsMemoization(int n) {
        Integer[][] memo = new Integer[n + 1][2];
        return countBinaryStringsMemoizationHelper(n, 0, memo);
    }
    
    private int countBinaryStringsMemoizationHelper(int n, int lastDigit, Integer[][] memo) {
        if (n == 0) return 1;
        if (memo[n][lastDigit] != null) return memo[n][lastDigit];
        
        if (lastDigit == 1) {
            return memo[n][lastDigit] = countBinaryStringsMemoizationHelper(n - 1, 0, memo);
        }
        
        return memo[n][lastDigit] = countBinaryStringsMemoizationHelper(n - 1, 0, memo) +
                                    countBinaryStringsMemoizationHelper(n - 1, 1, memo);
    }

    // Approach 3: Tabulation (Bottom-Up DP)
    public int countBinaryStringsTabulation(int n) {
        if (n == 0) return 1;
        
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 1; // Empty string ending with 0
        dp[0][1] = 1; // Empty string ending with 1 (base case adjustment)
        
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1]; // Ending with 0: can come from 0 or 1
            dp[i][1] = dp[i - 1][0]; // Ending with 1: can only come from 0
        }
        
        return dp[n][0] + dp[n][1];
    }

    // Approach 4: Space-Optimized Tabulation (Fibonacci-like)
    public int countBinaryStringsOptimized(int n) {
        if (n == 0) return 1;
        
        int endWithZero = 1; // Strings of length 0 ending with 0
        int endWithOne = 1;  // Strings of length 0 ending with 1
        
        for (int i = 1; i <= n; i++) {
            int newEndWithZero = endWithZero + endWithOne; // Ending with 0: from 0 or 1
            int newEndWithOne = endWithZero; // Ending with 1: from 0 only
            endWithZero = newEndWithZero;
            endWithOne = newEndWithOne;
        }
        
        return endWithZero + endWithOne;
    }

    // Main method for testing
    public static void main(String[] args) {
        CountBinaryStrings solver = new CountBinaryStrings();
        int n = 4;
        
        System.out.println("Recursive: " + solver.countBinaryStringsRecursive(n));
        System.out.println("Memoization: " + solver.countBinaryStringsMemoization(n));
        System.out.println("Tabulation: " + solver.countBinaryStringsTabulation(n));
        System.out.println("Space-Optimized: " + solver.countBinaryStringsOptimized(n));
    }
}