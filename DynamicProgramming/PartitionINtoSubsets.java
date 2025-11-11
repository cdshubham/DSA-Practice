

public class PartitionIntoSubsets {
    // Approach 1: Simple Recursive
    public long countPartitionsRecursive(int n, int k) {
        if (n < k || k <= 0 || n <= 0) return 0;
        if (k == 1 || n == k) return 1;
        
        // Include nth element in one of the k subsets or create a new subset with nth element
        return k * countPartitionsRecursive(n - 1, k) + countPartitionsRecursive(n - 1, k - 1);
    }

    // Approach 2: Memoization (Top-Down DP)
    public long countPartitionsMemoization(int n, int k) {
        if (n < k || k <= 0 || n <= 0) return 0;
        Long[][] memo = new Long[n + 1][k + 1];
        return countPartitionsMemoizationHelper(n, k, memo);
    }
    
    private long countPartitionsMemoizationHelper(int n, int k, Long[][] memo) {
        if (n < k || k <= 0 || n <= 0) return 0;
        if (k == 1 || n == k) return 1;
        if (memo[n][k] != null) return memo[n][k];
        
        return memo[n][k] = k * countPartitionsMemoizationHelper(n - 1, k, memo) +
                            countPartitionsMemoizationHelper(n - 1, k - 1, memo);
    }

    // Approach 3: Tabulation (Bottom-Up DP)
    public long countPartitionsTabulation(int n, int k) {
        if (n < k || k <= 0 || n <= 0) return 0;
        
        long[][] dp = new long[n + 1][k + 1];
        
        // Base cases: k=1 (one subset) and n=k (each element in its own subset)
        for (int i = 1; i <= n; i++) {
            dp[i][1] = 1;
            if (i <= k) dp[i][i] = 1;
        }
        
        // Fill dp table
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= Math.min(i, k); j++) {
                dp[i][j] = j * dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }
        
        return dp[n][k];
    }

    // Approach 4: Space-Optimized Tabulation
    public long countPartitionsOptimized(int n, int k) {
        if (n < k || k <= 0 || n <= 0) return 0;
        
        long[] dp = new long[k + 1];
        
        // Base case for k=1
        dp[1] = 1;
        
        // Iterate for each n
        for (int i = 1; i <= n; i++) {
            long[] newDp = new long[k + 1];
            newDp[1] = 1; // One subset for any i
            if (i <= k) newDp[i] = 1; // i elements in i subsets
            
            for (int j = 2; j <= Math.min(i, k); j++) {
                newDp[j] = j * dp[j] + dp[j - 1];
            }
            dp = newDp;
        }
        
        return dp[k];
    }

    // Main method for testing
    public static void main(String[] args) {
        PartitionIntoSubsets solver = new PartitionIntoSubsets();
        int n = 4;
        int k = 2;
        
        System.out.println("Recursive: " + solver.countPartitionsRecursive(n, k));
        System.out.println("Memoization: " + solver.countPartitionsMemoization(n, k));
        System.out.println("Tabulation: " + solver.countPartitionsTabulation(n, k));
        System.out.println("Space-Optimized: " + solver.countPartitionsOptimized(n, k));
    }
}
