public class MaxSumNonAdjacent {
    // Approach 1: Simple Recursive
    public int maxSumRecursive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return maxSumRecursiveHelper(nums, nums.length - 1);
    }
    
    private int maxSumRecursiveHelper(int[] nums, int index) {
        if (index < 0) return 0;
        if (index == 0) return nums[0];
        
        // Include current element and skip the previous one
        int include = nums[index] + maxSumRecursiveHelper(nums, index - 2);
        // Exclude current element
        int exclude = maxSumRecursiveHelper(nums, index - 1);
        
        return Math.max(include, exclude);
    }

    // Approach 2: Memoization (Top-Down DP)
    public int maxSumMemoization(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Integer[] memo = new Integer[nums.length];
        return maxSumMemoizationHelper(nums, nums.length - 1, memo);
    }
    
    private int maxSumMemoizationHelper(int[] nums, int index, Integer[] memo) {
        if (index < 0) return 0;
        if (index == 0) return nums[0];
        if (memo[index] != null) return memo[index];
        
        int include = nums[index] + maxSumMemoizationHelper(nums, index - 2, memo);
        int exclude = maxSumMemoizationHelper(nums, index - 1, memo);
        
        return memo[index] = Math.max(include, exclude);
    }

    // Approach 3: Tabulation (Bottom-Up DP)
    public int maxSumTabulation(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        
        return dp[n - 1];
    }

    // Approach 4: Space-Optimized Tabulation
    public int maxSumOptimized(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            int curr = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }

    // Main method for testing
    public static void main(String[] args) {
        MaxSumNonAdjacent solver = new MaxSumNonAdjacent();
        int[] nums = {5, 5, 10, 100, 10, 5};
        
        System.out.println("Recursive: " + solver.maxSumRecursive(nums));
        System.out.println("Memoization: " + solver.maxSumMemoization(nums));
        System.out.println("Tabulation: " + solver.maxSumTabulation(nums));
        System.out.println("Space-Optimized: " + solver.maxSumOptimized(nums));
    }
}