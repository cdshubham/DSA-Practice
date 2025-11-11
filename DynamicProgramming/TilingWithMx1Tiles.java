public class TilingWithMx1Tiles {
    // Approach 1: Simple Recursive
    public long countTilingsRecursive(int n, int m) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (n < m) return 1; // Only vertical tiles possible if n < m
        
        // Place one vertical tile (2x1, reduces n by 1)
        long vertical = countTilingsRecursive(n - 1, m);
        // Place two horizontal tiles (2xM, reduces n by M)
        long horizontal = countTilingsRecursive(n - m, m);
        
        return vertical + horizontal;
    }

    // Approach 2: Memoization (Top-Down DP)
    public long countTilingsMemoization(int n, int m) {
        if (n < 0) return 0;
        Long[] memo = new Long[n + 1];
        return countTilingsMemoizationHelper(n, m, memo);
    }
    
    private long countTilingsMemoizationHelper(int n, int m, Long[] memo) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (n < m) return 1;
        if (memo[n] != null) return memo[n];
        
        long vertical = countTilingsMemoizationHelper(n - 1, m, memo);
        long horizontal = countTilingsMemoizationHelper(n - m, m, memo);
        
        return memo[n] = vertical + horizontal;
    }

    // Approach 3: Tabulation (Bottom-Up DP)
    public long countTilingsTabulation(int n, int m) {
        if (n < 0) return 0;
        long[] dp = new long[n + 1];
        
        dp[0] = 1; // Empty grid
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1]; // Vertical tile
            if (i >= m) {
                dp[i] += dp[i - m]; // Two horizontal tiles
            }
        }
        
        return dp[n];
    }

    // Approach 4: Space-Optimized Tabulation
    public long countTilingsOptimized(int n, int m) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        
        long[] dp = new long[m];
        dp[0] = 1; // Base case for n=0
        
        for (int i = 1; i <= n; i++) {
            long curr = dp[(i - 1) % m]; // Vertical tile
            if (i >= m) {
                curr += dp[(i - m) % m]; // Horizontal tiles
            }
            dp[i % m] = curr;
        }
        
        return dp[n % m];
    }

    // Main method for testing
    public static void main(String[] args) {
        TilingWithMx1Tiles solver = new TilingWithMx1Tiles();
        int n = 4;
        int m = 2; // Example with M=2 (dominoes)
        
        System.out.println("Recursive: " + solver.countTilingsRecursive(n, m));
        System.out.println("Memoization: " + solver.countTilingsMemoization(n, m));
        System.out.println("Tabulation: " + solver.countTilingsTabulation(n, m));
        System.out.println("Space-Optimized: " + solver.countTilingsOptimized(n, m));
    }
}