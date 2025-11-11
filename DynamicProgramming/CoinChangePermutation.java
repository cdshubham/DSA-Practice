package DynamicProgramming;

public class CoinChangePermutation {
    // Approach 1: Simple Recursive
    public int countPermutationsRecursive(int[] coins, int amount) {
        return countPermutationsRecursiveHelper(coins, amount);
    }
    
    private int countPermutationsRecursiveHelper(int[] coins, int amount) {
        if (amount == 0) return 1;
        if (amount < 0) return 0;
        
        int ways = 0;
        // Try each coin as the next coin in the permutation
        for (int coin : coins) {
            ways += countPermutationsRecursiveHelper(coins, amount - coin);
        }
        return ways;
    }

    // Approach 2: Memoization (Top-Down DP)
    public int countPermutationsMemoization(int[] coins, int amount) {
        Integer[] memo = new Integer[amount + 1];
        return countPermutationsMemoizationHelper(coins, amount, memo);
    }
    
    private int countPermutationsMemoizationHelper(int[] coins, int amount, Integer[] memo) {
        if (amount == 0) return 1;
        if (amount < 0) return 0;
        if (memo[amount] != null) return memo[amount];
        
        int ways = 0;
        for (int coin : coins) {
            ways += countPermutationsMemoizationHelper(coins, amount - coin, memo);
        }
        return memo[amount] = ways;
    }

    // Approach 3: Tabulation (Bottom-Up DP)
    public int countPermutationsTabulation(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // One way to make amount 0 (empty permutation)
        
        // For each amount, consider all coins
        for (int j = 1; j <= amount; j++) {
            for (int coin : coins) {
                if (coin <= j) {
                    dp[j] += dp[j - coin];
                }
            }
        }
        return dp[amount];
    }

    // Approach 4: Space-Optimized Tabulation (same as Tabulation for permutations)
    public int countPermutationsOptimized(int[] coins, int amount) {
        // Note: For permutations, the tabulation approach is already space-optimized
        // as it uses a 1D array. This is included for completeness.
        int[] dp = new int[amount + 1];
        dp[0] = 1; // One way to make amount 0
        
        for (int j = 1; j <= amount; j++) {
            for (int coin : coins) {
                if (coin <= j) {
                    dp[j] += dp[j - coin];
                }
            }
        }
        return dp[amount];
    }

    // Main method for testing
    public static void main(String[] args) {
        CoinChangePermutation solver = new CoinChangePermutation();
        int[] coins = {1, 2, 5};
        int amount = 5;
        
        System.out.println("Recursive: " + solver.countPermutationsRecursive(coins, amount));
        System.out.println("Memoization: " + solver.countPermutationsMemoization(coins, amount));
        System.out.println("Tabulation: " + solver.countPermutationsTabulation(coins, amount));
        System.out.println("Space-Optimized: " + solver.countPermutationsOptimized(coins, amount));
    }
}