package DynamicProgramming;


public class ArrangeBuildings {
    // Approach 1: Simple Recursive
    public long arrangeBuildingsRecursive(int n) {
        long oneSide = countBinaryStringsRecursiveHelper(n, 0);
        return oneSide * oneSide; // Square for both sides
    }
    
    private long countBinaryStringsRecursiveHelper(int n, int lastDigit) {
        if (n == 0) return 1;
        
        // If last position was a building (1), can only place a space (0)
        if (lastDigit == 1) {
            return countBinaryStringsRecursiveHelper(n - 1, 0);
        }
        
        // If last position was a space (0), can place a space (0) or building (1)
        return countBinaryStringsRecursiveHelper(n - 1, 0) + 
               countBinaryStringsRecursiveHelper(n - 1, 1);
    }

    // Approach 2: Memoization (Top-Down DP)
    public long arrangeBuildingsMemoization(int n) {
        Long[][] memo = new Long[n + 1][2];
        long oneSide = countBinaryStringsMemoizationHelper(n, 0, memo);
        return oneSide * oneSide;
    }
    
    private long countBinaryStringsMemoizationHelper(int n, int lastDigit, Long[][] memo) {
        if (n == 0) return 1;
        if (memo[n][lastDigit] != null) return memo[n][lastDigit];
        
        if (lastDigit == 1) {
            return memo[n][lastDigit] = countBinaryStringsMemoizationHelper(n - 1, 0, memo);
        }
        
        return memo[n][lastDigit] = countBinaryStringsMemoizationHelper(n - 1, 0, memo) +
                                    countBinaryStringsMemoizationHelper(n - 1, 1, memo);
    }

    // Approach 3: Tabulation (Bottom-Up DP)
    public long arrangeBuildingsTabulation(int n) {
        if (n == 0) return 1;
        
        long[][] dp = new long[n + 1][2];
        dp[0][0] = 1; // Empty string ending with space
        dp[0][1] = 1; // Empty string ending with building
        
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1]; // Ending with space: from space or building
            dp[i][1] = dp[i - 1][0]; // Ending with building: from space only
        }
        
        long oneSide = dp[n][0] + dp[n][1];
        return oneSide * oneSide;
    }

    // Approach 4: Space-Optimized Tabulation (Fibonacci-like)
    public long arrangeBuildingsOptimized(int n) {
        if (n == 0) return 1;
        
        long endWithSpace = 1; // Strings of length 0 ending with space
        long endWithBuilding = 1; // Strings of length 0 ending with building
        
        for (int i = 1; i <= n; i++) {
            long newEndWithSpace = endWithSpace + endWithBuilding; // Space can follow space or building
            long newEndWithBuilding = endWithSpace; // Building can only follow space
            endWithSpace = newEndWithSpace;
            endWithBuilding = newEndWithBuilding;
        }
        
        long oneSide = endWithSpace + endWithBuilding;
        return oneSide * oneSide;
    }

    // Main method for testing
    public static void main(String[] args) {
        ArrangeBuildings solver = new ArrangeBuildings();
        int n = 4;
        
        System.out.println("Recursive: " + solver.arrangeBuildingsRecursive(n));
        System.out.println("Memoization: " + solver.arrangeBuildingsMemoization(n));
        System.out.println("Tabulation: " + solver.arrangeBuildingsTabulation(n));
        System.out.println("Space-Optimized: " + solver.arrangeBuildingsOptimized(n));
    }
}