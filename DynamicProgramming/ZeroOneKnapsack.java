package DynamicProgramming;

public class ZeroOneKnapsack {
    // Approach 1: Simple Recursive
    public int knapsackRecursive(int[] weights, int[] values, int capacity, int n) {
        return knapsackRecursiveHelper(weights, values, capacity, n - 1);
    }
    
    private int knapsackRecursiveHelper(int[] weights, int[] values, int capacity, int index) {
        if (index < 0 || capacity <= 0) return 0;
        
        // Exclude the current item
        int exclude = knapsackRecursiveHelper(weights, values, capacity, index - 1);
        
        // Include the current item if possible
        int include = 0;
        if (weights[index] <= capacity) {
            include = values[index] + knapsackRecursiveHelper(weights, values, capacity - weights[index], index - 1);
        }
        
        return Math.max(include, exclude);
    }

    // Approach 2: Memoization (Top-Down DP)
    public int knapsackMemoization(int[] weights, int[] values, int capacity, int n) {
        Integer[][] memo = new Integer[n][capacity + 1];
        return knapsackMemoizationHelper(weights, values, capacity, n - 1, memo);
    }
    
    private int knapsackMemoizationHelper(int[] weights, int[] values, int capacity, int index, Integer[][] memo) {
        if (index < 0 || capacity <= 0) return 0;
        if (memo[index][capacity] != null) return memo[index][capacity];
        
        int exclude = knapsackMemoizationHelper(weights, values, capacity, index - 1, memo);
        int include = 0;
        if (weights[index] <= capacity) {
            include = values[index] + knapsackMemoizationHelper(weights, values, capacity - weights[index], index - 1, memo);
        }
        
        return memo[index][capacity] = Math.max(include, exclude);
    }

    // Approach 3: Tabulation (Bottom-Up DP)
    public int knapsackTabulation(int[] weights, int[] values, int capacity, int n) {
        int[][] dp = new int[n + 1][capacity + 1];
        
        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][capacity];
    }

    // Approach 4: Space-Optimized Tabulation
    public int knapsackOptimized(int[] weights, int[] values, int capacity, int n) {
        int[] dp = new int[capacity + 1];
        
        // Iterate over each item
        for (int i = 0; i < n; i++) {
            // Iterate from capacity down to weight[i] to avoid overwriting
            for (int w = capacity; w >= weights[i]; w--) {
                dp[w] = Math.max(dp[w], values[i] + dp[w - weights[i]]);
            }
        }
        return dp[capacity];
    }

    // Main method for testing
    public static void main(String[] args) {
        ZeroOneKnapsack solver = new ZeroOneKnapsack();
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;
        int n = values.length;
        
        System.out.println("Recursive: " + solver.knapsackRecursive(weights, values, capacity, n));
        System.out.println("Memoization: " + solver.knapsackMemoization(weights, values, capacity, n));
        System.out.println("Tabulation: " + solver.knapsackTabulation(weights, values, capacity, n));
        System.out.println("Space-Optimized: " + solver.knapsackOptimized(weights, values, capacity, n));
    }
}