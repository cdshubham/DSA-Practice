package DynamicProgramming;

public class TargetSumSubset {
    // Approach 1: Simple Recursive
    public boolean isSubsetSumRecursive(int[] nums, int target) {
        return isSubsetSumRecursiveHelper(nums, target, nums.length - 1);
    }
    
    private boolean isSubsetSumRecursiveHelper(int[] nums, int target, int index) {
        if (target == 0) return true;
        if (index < 0 || target < 0) return false;
        
        // Include the current element or exclude it
        return isSubsetSumRecursiveHelper(nums, target - nums[index], index - 1) ||
               isSubsetSumRecursiveHelper(nums, target, index - 1);
    }

    // Approach 2: Memoization (Top-Down DP)
    public boolean isSubsetSumMemoization(int[] nums, int target) {
        Boolean[][] memo = new Boolean[nums.length][target + 1];
        return isSubsetSumMemoizationHelper(nums, target, nums.length - 1, memo);
    }
    
    private boolean isSubsetSumMemoizationHelper(int[] nums, int target, int index, Boolean[][] memo) {
        if (target == 0) return true;
        if (index < 0 || target < 0) return false;
        if (memo[index][target] != null) return memo[index][target];
        
        // Include or exclude the current element
        memo[index][target] = isSubsetSumMemoizationHelper(nums, target - nums[index], index - 1, memo) ||
                              isSubsetSumMemoizationHelper(nums, target, index - 1, memo);
        return memo[index][target];
    }

    // Approach 3: Tabulation (Bottom-Up DP)
    public boolean isSubsetSumTabulation(int[] nums, int target) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];
        
        // Empty subset can achieve target sum 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        
        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }

    // Approach 4: Space-Optimized Tabulation
    public boolean isSubsetSumOptimized(int[] nums, int target) {
        int n = nums.length;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Empty subset can achieve sum 0
        
        // Iterate over each number
        for (int i = 0; i < n; i++) {
            // Iterate from target down to nums[i] to avoid overwriting
            for (int j = target; j >= nums[i]; j--) {
                dp[j] |= dp[j - nums[i]];
            }
        }
        return dp[target];
    }

    // Main method for testing
    public static void main(String[] args) {
        TargetSumSubset solver = new TargetSumSubset();
        int[] nums = {3, 34, 4, 12, 5, 2};
        int target = 9;
        
        System.out.println("Recursive: " + solver.isSubsetSumRecursive(nums, target));
        System.out.println("Memoization: " + solver.isSubsetSumMemoization(nums, target));
        System.out.println("Tabulation: " + solver.isSubsetSumTabulation(nums, target));
        System.out.println("Space-Optimized: " + solver.isSubsetSumOptimized(nums, target));
    }
}