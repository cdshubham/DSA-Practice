public class TilingWithDominoes {
    // Approach 1: Simple Recursive
    public long countTilingsRecursive(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        // Place one vertical domino (covers 2x1, recurse on n-1)
        long vertical = countTilingsRecursive(n - 1);
        // Place two horizontal dominoes (covers 2x2, recurse on n-2)
        long horizontal = countTilingsRecursive(n - 2);
        
        return vertical + horizontal;
    }

    // Approach 2: Memoization (Top-Down DP)
    public long countTilingsMemoization(int n) {
        if (n <= 0) return 0;
        Long[] memo = new Long[n + 1];
        return countTilingsMemoizationHelper(n, memo);
    }
    
    private long countTilingsMemoizationHelper(int n, Long[] memo) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (memo[n] != null) return memo[n];
        
        long vertical = countTilingsMemoizationHelper(n - 1, memo);
        long horizontal = countTilingsMemoizationHelper(n - 2, memo);
        
        return memo[n] = vertical + horizontal;
    }

    // Approach 3: Tabulation (Bottom-Up DP)
    public long countTilingsTabulation(int n) {
        if (n <= 0) return 0;
        long[] dp = new long[n + 1];
        
        dp[0] = 0; // No valid tiling for n=0
        dp[1] = 1; // One vertical domino
        if (n >= 2) dp[2] = 2; // One vertical + one vertical or two horizontal
        
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }

    // Approach 4: Space-Optimized Tabulation
    public long countTilingsOptimized(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        long prev2 = 1; // For n=1
        long prev1 = 2; // For n=2
        
        for (int i = 3; i <= n; i++) {
            long curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }

    // Main method for testing
    public static void main(String[] args) {
        TilingWithDominoes solver = new TilingWithDominoes();
        int n = 4;
        
        System.out.println("Recursive: " + solver.countTilingsRecursive(n));
        System.out.println("Memoization: " + solver.countTilingsMemoization(n));
        System.out.println("Tabulation: " + solver.countTilingsTabulation(n));
        System.out.println("Space-Optimized: " + solver.countTilingsOptimized(n));
    }
}