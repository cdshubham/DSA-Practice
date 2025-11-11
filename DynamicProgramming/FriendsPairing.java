public class FriendsPairing {
    // Approach 1: Simple Recursive
    public long countPairingsRecursive(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        // Current friend stays alone
        long alone = countPairingsRecursive(n - 1);
        // Current friend pairs with one of the remaining (n-1) friends
        long paired = (n - 1) * countPairingsRecursive(n - 2);
        
        return alone + paired;
    }

    // Approach 2: Memoization (Top-Down DP)
    public long countPairingsMemoization(int n) {
        if (n <= 0) return 0;
        Long[] memo = new Long[n + 1];
        return countPairingsMemoizationHelper(n, memo);
    }
    
    private long countPairingsMemoizationHelper(int n, Long[] memo) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (memo[n] != null) return memo[n];
        
        long alone = countPairingsMemoizationHelper(n - 1, memo);
        long paired = (n - 1) * countPairingsMemoizationHelper(n - 2, memo);
        
        return memo[n] = alone + paired;
    }

    // Approach 3: Tabulation (Bottom-Up DP)
    public long countPairingsTabulation(int n) {
        if (n <= 0) return 0;
        long[] dp = new long[n + 1];
        
        dp[0] = 0;
        dp[1] = 1;
        if (n >= 2) dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }
        
        return dp[n];
    }

    // Approach 4: Space-Optimized Tabulation
    public long countPairingsOptimized(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        long prev2 = 1; // For n=1
        long prev1 = 2; // For n=2
        
        for (int i = 3; i <= n; i++) {
            long curr = prev1 + (i - 1) * prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }

    // Main method for testing
    public static void main(String[] args) {
        FriendsPairing solver = new FriendsPairing();
        int n = 4;
        
        System.out.println("Recursive: " + solver.countPairingsRecursive(n));
        System.out.println("Memoization: " + solver.countPairingsMemoization(n));
        System.out.println("Tabulation: " + solver.countPairingsTabulation(n));
        System.out.println("Space-Optimized: " + solver.countPairingsOptimized(n));
    }
}