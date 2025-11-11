package DynamicProgramming;

public class CoinChangeCombination {
    // Approach 1: Simple Recursive
    public int countCombinationsRecursive(int[] coins, int amount) {
        return countCombinationsRecursiveHelper(coins, amount, coins.length - 1);
    }
    
    private int countCombinationsRecursiveHelper(int[] coins, int amount, int index) {
        if (amount == 0) return 1;
        if (amount < 0 || index < 0) return 0;
        
        // Include the current coin or exclude it
        return countCombinationsRecursiveHelper(coins, amount - coins[index], index) +
               countCombinationsRecursiveHelper(coins, amount, index - 1);
    }

    // Approach 2: Memoization (Top-Down DP)
    public int countCombinationsMemoization(int[] coins, int amount) {
        Integer[][] memo = new Integer[coins.length][amount + 1];
        return countCombinationsMemoizationHelper(coins, amount, coins.length - 1, memo);
    }
    
    private int countCombinationsMemoizationHelper(int[] coins, int amount, int index, Integer[][] memo) {
        if (amount == 0) return 1;
        if (amount < 0 || index < 0) return 0;
        if (memo[index][amount] != null) return memo[index][amount];
        
        memo[index][amount] = countCombinationsMemoizationHelper(coins, amount - coins[index], index, memo) +
                              countCombinationsMemoizationHelper(coins, amount, index - 1, memo);
        return memo[index][amount];
    }

    // Approach 3: Tabulation (Bottom-Up DP)
    public int countCombinationsTabulation(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        
        // Base case: there is one way to make amount 0 (empty combination)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        
        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }

    // Approach 4: Space-Optimized Tabulation
    public int countCombinationsOptimized(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // One way to make amount 0
        
        // Iterate over each coin
        for (int coin : coins) {
            // Update dp for all amounts from coin to target
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }

    // Main method for testing
    public static void main(String[] args) {
        CoinChangeCombination solver = new CoinChangeCombination();
        int[] coins = {1, 2, 5};
        int amount = 5;
        
        System.out.println("Recursive: " + solver.countCombinationsRecursive(coins, amount));
        System.out.println("Memoization: " + solver.countCombinationsMemoization(coins, amount));
        System.out.println("Tabulation: " + solver.countCombinationsTabulation(coins, amount));
        System.out.println("Space-Optimized: " + solver.countCombinationsOptimized(coins, amount));
    }
}