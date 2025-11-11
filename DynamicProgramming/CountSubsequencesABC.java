package DynamicProgramming;

public class CountSubsequencesABC {
    // Approach 1: Simple Recursive
    public long countSubsequencesRecursive(String s) {
        return countSubsequencesRecursiveHelper(s, 0, 0);
    }
    
    private long countSubsequencesRecursiveHelper(String s, int index, int state) {
        if (index == s.length()) {
            return state == 3 ? 1 : 0; // Valid if we reached state 3 (C collected)
        }
        
        long ways = 0;
        // Skip current character
        ways += countSubsequencesRecursiveHelper(s, index + 1, state);
        
        // Include current character if it matches the expected state
        if (state == 0 && s.charAt(index) == 'A') {
            ways += countSubsequencesRecursiveHelper(s, index + 1, 1);
        } else if (state == 1 && s.charAt(index) == 'B') {
            ways += countSubsequencesRecursiveHelper(s, index + 1, 2);
        } else if (state == 2 && s.charAt(index) == 'C') {
            ways += countSubsequencesRecursiveHelper(s, index + 1, 3);
        }
        
        return ways;
    }

    // Approach 2: Memoization (Top-Down DP)
    public long countSubsequencesMemoization(String s) {
        Long[][] memo = new Long[s.length()][4];
        return countSubsequencesMemoizationHelper(s, 0, 0, memo);
    }
    
    private long countSubsequencesMemoizationHelper(String s, int index, int state, Long[][] memo) {
        if (index == s.length()) {
            return state == 3 ? 1 : 0;
        }
        if (memo[index][state] != null) return memo[index][state];
        
        long ways = countSubsequencesMemoizationHelper(s, index + 1, state);
        if (state == 0 && s.charAt(index) == 'A') {
            ways += countSubsequencesMemoizationHelper(s, index + 1, 1, memo);
        } else if (state == 1 && s.charAt(index) == 'B') {
            ways += countSubsequencesMemoizationHelper(s, index + 1, 2, memo);
        } else if (state == 2 && s.charAt(index) == 'C') {
            ways += countSubsequencesMemoizationHelper(s, index + 1, 3, memo);
        }
        
        return memo[index][state] = ways;
    }

    // Approach 3: Tabulation (Bottom-Up DP)
    public long countSubsequencesTabulation(String s) {
        int n = s.length();
        long[][] dp = new long[n + 1][4];
        dp[0][0] = 1; // Empty string starts at state 0
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 4; j++) {
                // Skip current character
                dp[i][j] = dp[i - 1][j];
                
                // Include current character based on state
                char c = s.charAt(i - 1);
                if (j == 0 && c == 'A') {
                    dp[i][1] += dp[i - 1][0];
                } else if (j == 1 && c == 'B') {
                    dp[i][2] += dp[i - 1][1];
                } else if (j == 2 && c == 'C') {
                    dp[i][3] += dp[i - 1][2];
                }
            }
        }
        
        return dp[n][3];
    }

    // Approach 4: Space-Optimized Tabulation
    public long countSubsequencesOptimized(String s) {
        long[] dp = new long[4];
        dp[0] = 1; // Start with empty string
        
        for (int i = 0; i < s.length(); i++) {
            long[] newDp = new long[4];
            // Copy previous states
            for (int j = 0; j < 4; j++) {
                newDp[j] = dp[j];
            }
            // Update based on current character
            char c = s.charAt(i);
            if (c == 'A') {
                newDp[1] += dp[0];
            } else if (c == 'B') {
                newDp[2] += dp[1];
            } else if (c == 'C') {
                newDp[3] += dp[2];
            }
            dp = newDp;
        }
        
        return dp[3];
    }

    // Main method for testing
    public static void main(String[] args) {
        CountSubsequencesABC solver = new CountSubsequencesABC();
        String s = "ABCABC";
        
        System.out.println("Recursive: " + solver.countSubsequencesRecursive(s));
        System.out.println("Memoization: " + solver.countSubsequencesMemoization(s));
        System.out.println("Tabulation: " + solver.countSubsequencesTabulation(s));
        System.out.println("Space-Optimized: " + solver.countSubsequencesOptimized(s));
    }
}