package DynamicProgramming;

import java.util.*;

public class ClimbStairWithMinimumMoves {
    public static void main(String[] args) {
        int[] moves = {1, 3, 5, 2, 1, 4}; // Example input

        System.out.println("Naive Recursion: " + minMovesRecursive(moves, 0));
        System.out.println("Memoization: " + minMovesMemo(moves, 0, new int[moves.length]));
        System.out.println("Tabulation: " + minMovesTab(moves));
        System.out.println("Space Optimized: " + minMovesOptimized(moves));
    }

    // 1. Naive Recursion (Exponential)
    public static int minMovesRecursive(int[] moves, int idx) {
        if (idx >= moves.length - 1) return 0; // reached end
        int minMoves = Integer.MAX_VALUE;
        for (int jump = 1; jump <= moves[idx]; jump++) {
            if (idx + jump < moves.length) {
                int sub = minMovesRecursive(moves, idx + jump);
                if (sub != Integer.MAX_VALUE) minMoves = Math.min(minMoves, sub + 1);
            }
        }
        return minMoves;
    }

    // 2. Recursion + Memoization (Top-Down DP)
    public static int minMovesMemo(int[] moves, int idx, int[] dp) {
        if (idx >= moves.length - 1) return 0;
        if (dp[idx] != 0) return dp[idx];

        int minMoves = Integer.MAX_VALUE;
        for (int jump = 1; jump <= moves[idx]; jump++) {
            if (idx + jump < moves.length) {
                int sub = minMovesMemo(moves, idx + jump, dp);
                if (sub != Integer.MAX_VALUE) minMoves = Math.min(minMoves, sub + 1);
            }
        }
        dp[idx] = minMoves;
        return minMoves;
    }

    // 3. Tabulation (Bottom-Up DP)
    public static int minMovesTab(int[] moves) {
        int n = moves.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // starting point

        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (int jump = 1; jump <= moves[i]; jump++) {
                if (i + jump < n) {
                    dp[i + jump] = Math.min(dp[i + jump], dp[i] + 1);
                }
            }
        }
        return dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1];
    }

    // 4. Space Optimized (Greedy approach similar to jump game)
    public static int minMovesOptimized(int[] moves) {
        int n = moves.length;
        int jumps = 0, farthest = 0, end = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + moves[i]);
            if (i == end) {
                jumps++;
                end = farthest;
            }
        }
        return end >= n - 1 ? jumps : -1;
    }
}
