public class PaintHouseII {
    // Approach 1: Simple Recursive
    public int minCostRecursive(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int k = costs[0].length;
        int minCost = Integer.MAX_VALUE;
        for (int color = 0; color < k; color++) {
            minCost = Math.min(minCost, minCostRecursiveHelper(costs, n - 1, color, -1));
        }
        return minCost == Integer.MAX_VALUE ? 0 : minCost;
    }
    
    private int minCostRecursiveHelper(int[][] costs, int index, int color, int prevColor) {
        if (index < 0) return 0;
        
        int cost = costs[index][color];
        if (index == 0) return prevColor == -1 || prevColor != color ? cost : Integer.MAX_VALUE;
        
        int minPrevCost = Integer.MAX_VALUE;
        for (int prev = 0; prev < costs[0].length; prev++) {
            if (prev != color) {
                minPrevCost = Math.min(minPrevCost, minCostRecursiveHelper(costs, index - 1, prev, color));
            }
        }
        
        return minPrevCost == Integer.MAX_VALUE ? Integer.MAX_VALUE : cost + minPrevCost;
    }

    // Approach 2: Memoization (Top-Down DP)
    public int minCostMemoization(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int k = costs[0].length;
        Integer[][][] memo = new Integer[n][k][k + 1];
        int minCost = Integer.MAX_VALUE;
        for (int color = 0; color < k; color++) {
            minCost = Math.min(minCost, minCostMemoizationHelper(costs, n - 1, color, -1, memo));
        }
        return minCost == Integer.MAX_VALUE ? 0 : minCost;
    }
    
    private int minCostMemoizationHelper(int[][] costs, int index, int color, int prevColor, Integer[][][] memo) {
        if (index < 0) return 0;
        if (memo[index][color][prevColor + 1] != null) return memo[index][color][prevColor + 1];
        
        int cost = costs[index][color];
        if (index == 0) return prevColor == -1 || prevColor != color ? cost : Integer.MAX_VALUE;
        
        int minPrevCost = Integer.MAX_VALUE;
        for (int prev = 0; prev < costs[0].length; prev++) {
            if (prev != color) {
                minPrevCost = Math.min(minPrevCost, minCostMemoizationHelper(costs, index - 1, prev, color, memo));
            }
        }
        
        return memo[index][color][prevColor + 1] = minPrevCost == Integer.MAX_VALUE ? Integer.MAX_VALUE : cost + minPrevCost;
    }

    // Approach 3: Tabulation (Bottom-Up DP)
    public int minCostTabulation(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        
        // Initialize first house
        for (int j = 0; j < k; j++) {
            dp[0][j] = costs[0][j];
        }
        
        // Fill dp table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int minPrev = Integer.MAX_VALUE;
                for (int prev = 0; prev < k; prev++) {
                    if (prev != j) {
                        minPrev = Math.min(minPrev, dp[i - 1][prev]);
                    }
                }
                dp[i][j] = costs[i][j] + (minPrev == Integer.MAX_VALUE ? 0 : minPrev);
            }
        }
        
        // Find minimum cost for the last house
        int minCost = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            minCost = Math.min(minCost, dp[n - 1][j]);
        }
        return minCost == Integer.MAX_VALUE ? 0 : minCost;
    }

    // Approach 4: Space-Optimized Tabulation
    public int minCostOptimized(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int k = costs[0].length;
        int[] dp = new int[k];
        
        // Initialize first house
        for (int j = 0; j < k; j++) {
            dp[j] = costs[0][j];
        }
        
        // Process each house
        for (int i = 1; i < n; i++) {
            int[] newDp = new int[k];
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            int min1Index = -1;
            
            // Find the minimum and second minimum costs from the previous row
            for (int j = 0; j < k; j++) {
                if (dp[j] < min1) {
                    min2 = min1;
                    min1 = dp[j];
                    min1Index = j;
                } else if (dp[j] < min2) {
                    min2 = dp[j];
                }
            }
            
            // Update costs for current house
            for (int j = 0; j < k; j++) {
                newDp[j] = costs[i][j] + (j == min1Index ? min2 : min1);
            }
            dp = newDp;
        }
        
        // Find minimum cost in the last row
        int minCost = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            minCost = Math.min(minCost, dp[j]);
        }
        return minCost == Integer.MAX_VALUE ? 0 : minCost;
    }

    // Main method for testing
    public static void main(String[] args) {
        PaintHouseII solver = new PaintHouseII();
        int[][] costs = {
            {1, 5, 3},
            {2, 9, 4},
            {3, 5, 2}
        };
        
        System.out.println("Recursive: " + solver.minCostRecursive(costs));
        System.out.println("Memoization: " + solver.minCostMemoization(costs));
        System.out.println("Tabulation: " + solver.minCostTabulation(costs));
        System.out.println("Space-Optimized: " + solver.minCostOptimized(costs));
    }
}