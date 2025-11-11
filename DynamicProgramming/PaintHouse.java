public class PaintHouse {
    // Approach 1: Simple Recursive
    public int minCostRecursive(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;
        return Math.min(
            Math.min(
                minCostRecursiveHelper(costs, n - 1, 0),
                minCostRecursiveHelper(costs, n - 1, 1)
            ),
            minCostRecursiveHelper(costs, n - 1, 2)
        );
    }
    
    private int minCostRecursiveHelper(int[][] costs, int index, int color) {
        if (index < 0) return 0;
        
        int cost = costs[index][color];
        if (index == 0) return cost;
        
        // Choose the minimum cost from the previous house with different colors
        if (color == 0) { // Red
            return cost + Math.min(
                minCostRecursiveHelper(costs, index - 1, 1), // Blue
                minCostRecursiveHelper(costs, index - 1, 2)  // Green
            );
        } else if (color == 1) { // Blue
            return cost + Math.min(
                minCostRecursiveHelper(costs, index - 1, 0), // Red
                minCostRecursiveHelper(costs, index - 1, 2)  // Green
            );
        } else { // Green
            return cost + Math.min(
                minCostRecursiveHelper(costs, index - 1, 0), // Red
                minCostRecursiveHelper(costs, index - 1, 1)  // Blue
            );
        }
    }

    // Approach 2: Memoization (Top-Down DP)
    public int minCostMemoization(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;
        Integer[][] memo = new Integer[n][3];
        return Math.min(
            Math.min(
                minCostMemoizationHelper(costs, n - 1, 0, memo),
                minCostMemoizationHelper(costs, n - 1, 1, memo)
            ),
            minCostMemoizationHelper(costs, n - 1, 2, memo)
        );
    }
    
    private int minCostMemoizationHelper(int[][] costs, int index, int color, Integer[][] memo) {
        if (index < 0) return 0;
        if (memo[index][color] != null) return memo[index][color];
        
        int cost = costs[index][color];
        if (index == 0) return memo[index][color] = cost;
        
        if (color == 0) {
            return memo[index][color] = cost + Math.min(
                minCostMemoizationHelper(costs, index - 1, 1, memo),
                minCostMemoizationHelper(costs, index - 1, 2, memo)
            );
        } else if (color == 1) {
            return memo[index][color] = cost + Math.min(
                minCostMemoizationHelper(costs, index - 1, 0, memo),
                minCostMemoizationHelper(costs, index - 1, 2, memo)
            );
        } else {
            return memo[index][color] = cost + Math.min(
                minCostMemoizationHelper(costs, index - 1, 0, memo),
                minCostMemoizationHelper(costs, index - 1, 1, memo)
            );
        }
    }

    // Approach 3: Tabulation (Bottom-Up DP)
    public int minCostTabulation(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int[][] dp = new int[n][3];
        
        // Initialize first house
        for (int j = 0; j < 3; j++) {
            dp[0][j] = costs[0][j];
        }
        
        // Fill dp table
        for (int i = 1; i < n; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]); // Red
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]); // Blue
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]); // Green
        }
        
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }

    // Approach 4: Space-Optimized Tabulation
    public int minCostOptimized(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;
        
        int prevRed = costs[0][0];
        int prevBlue = costs[0][1];
        int prevGreen = costs[0][2];
        
        for (int i = 1; i < n; i++) {
            int currRed = costs[i][0] + Math.min(prevBlue, prevGreen);
            int currBlue = costs[i][1] + Math.min(prevRed, prevGreen);
            int currGreen = costs[i][2] + Math.min(prevRed, prevBlue);
            prevRed = currRed;
            prevBlue = currBlue;
            prevGreen = currGreen;
        }
        
        return Math.min(prevRed, Math.min(prevBlue, prevGreen));
    }

    // Main method for testing
    public static void main(String[] args) {
        PaintHouse solver = new PaintHouse();
        int[][] costs = {
            {17, 2, 17},
            {16, 16, 5},
            {14, 3, 19}
        };
        
        System.out.println("Recursive: " + solver.minCostRecursive(costs));
        System.out.println("Memoization: " + solver.minCostMemoization(costs));
        System.out.println("Tabulation: " + solver.minCostTabulation(costs));
        System.out.println("Space-Optimized: " + solver.minCostOptimized(costs));
    }
}