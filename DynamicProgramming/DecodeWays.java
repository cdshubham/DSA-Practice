package DynamicProgramming;

public class DecodeWays {
    // Approach 1: Simple Recursive
    public int numDecodingsRecursive(String s) {
        if (s == null || s.isEmpty()) return 0;
        return numDecodingsRecursiveHelper(s, 0);
    }
    
    private int numDecodingsRecursiveHelper(String s, int index) {
        if (index == s.length()) return 1;
        if (s.charAt(index) == '0') return 0;
        
        // Decode single digit
        int ways = numDecodingsRecursiveHelper(s, index + 1);
        
        // Decode two digits if valid
        if (index + 1 < s.length() && isValidTwoDigit(s, index)) {
            ways += numDecodingsRecursiveHelper(s, index + 2);
        }
        
        return ways;
    }

    // Approach 2: Memoization (Top-Down DP)
    public int numDecodingsMemoization(String s) {
        if (s == null || s.isEmpty()) return 0;
        Integer[] memo = new Integer[s.length()];
        return numDecodingsMemoizationHelper(s, 0, memo);
    }
    
    private int numDecodingsMemoizationHelper(String s, int index, Integer[] memo) {
        if (index == s.length()) return 1;
        if (s.charAt(index) == '0') return 0;
        if (memo[index] != null) return memo[index];
        
        int ways = numDecodingsMemoizationHelper(s, index + 1, memo);
        if (index + 1 < s.length() && isValidTwoDigit(s, index)) {
            ways += numDecodingsMemoizationHelper(s, index + 2, memo);
        }
        
        return memo[index] = ways;
    }

    // Approach 3: Tabulation (Bottom-Up DP)
    public int numDecodingsTabulation(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') return 0;
        
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // Empty string
        dp[1] = 1; // First character (if not '0')
        
        for (int i = 2; i <= n; i++) {
            // Single digit decoding
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            // Two digit decoding
            if (isValidTwoDigit(s, i - 2)) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[n];
    }

    // Approach 4: Space-Optimized Tabulation
    public int numDecodingsOptimized(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') return 0;
        
        int prev2 = 1; // Ways to decode empty string
        int prev1 = 1; // Ways to decode string of length 1
        
        for (int i = 1; i < s.length(); i++) {
            int curr = 0;
            // Single digit decoding
            if (s.charAt(i) != '0') {
                curr += prev1;
            }
            // Two digit decoding
            if (isValidTwoDigit(s, i - 1)) {
                curr += prev2;
            }
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
    
    // Helper method to check if a two-digit number is valid (10 to 26)
    private boolean isValidTwoDigit(String s, int start) {
        if (start >= s.length() - 1) return false;
        int num = Integer.parseInt(s.substring(start, start + 2));
        return num >= 10 && num <= 26;
    }

    // Main method for testing
    public static void main(String[] args) {
        DecodeWays solver = new DecodeWays();
        String s = "226";
        
        System.out.println("Recursive: " + solver.numDecodingsRecursive(s));
        System.out.println("Memoization: " + solver.numDecodingsMemoization(s));
        System.out.println("Tabulation: " + solver.numDecodingsTabulation(s));
        System.out.println("Space-Optimized: " + solver.numDecodingsOptimized(s));
    }
}