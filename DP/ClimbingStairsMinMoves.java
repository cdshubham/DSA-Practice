package DP;

import java.util.*;

public class ClimbingStairsMinMoves {
    // Approach 1: Simple Recursive
    public int minMovesRecursive(int[] jumps, int n) {
        return minMovesRecursiveHelper(0, n, jumps);
    }
    
    private int minMovesRecursiveHelper(int curr, int n, int[] jumps) {
        if (curr == n) return 0;
        if (curr > n || jumps[curr] == 0) return Integer.MAX_VALUE;
        
        int minMoves = Integer.MAX_VALUE;
        for (int jump = 1; jump <= jumps[curr]; jump++) {
            int next = curr + jump;
            int moves = minMovesRecursiveHelper(next, n, jumps);
            if (moves != Integer.MAX_VALUE) {
                minMoves = Math.min(minMoves, moves + 1);
            }
        }
        return minMoves;
    }

    // Approach 2: Memoization (Top-Down DP)
    public int minMovesMemoization(int[] jumps, int n) {
        Integer[] memo = new Integer[n + 1];
        int result = minMovesMemoizationHelper(0, n, jumps, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private int minMovesMemoizationHelper(int curr, int n, int[] jumps, Integer[] memo) {
        if (curr == n) return 0;
        if (curr > n || jumps[curr] == 0) return Integer.MAX_VALUE;
        if (memo[curr] != null) return memo[curr];
        
        int minMoves = Integer.MAX_VALUE;
        for (int jump = 1; jump <= jumps[curr]; jump++) {
            int next = curr + jump;
            int moves = minMovesMemoizationHelper(next, n, jumps, memo);
            if (moves != Integer.MAX_VALUE) {
                minMoves = Math.min(minMoves, moves + 1);
            }
        }
        return memo[curr] = minMoves;
    }

    // Approach 3: Tabulation (Bottom-Up DP)
    public int minMovesTabulation(int[] jumps, int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            if (jumps[i] == 0) continue;
            for (int jump = 1; jump <= jumps[i] && i + jump <= n; jump++) {
                if (dp[i + jump] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i + jump] + 1);
                }
            }
        }
        return dp[0] == Integer.MAX_VALUE ? -1 : dp[0];
    }

    // Approach 4: BFS (Graph-Based)
    public int minMovesBFS(int[] jumps, int n) {
        if (n == 0) return 0;
        
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        
        queue.offer(0);
        visited[0] = 0;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == n) return visited[curr];
            
            for (int jump = 1; jump <= jumps[curr] && curr + jump <= n; jump++) {
                int next = curr + jump;
                if (visited[next] == Integer.MAX_VALUE) {
                    visited[next] = visited[curr] + 1;
                    queue.offer(next);
                }
            }
        }
        return -1;
    }

    // Main method for testing
    public static void main(String[] args) {
        ClimbingStairsMinMoves solver = new ClimbingStairsMinMoves();
        int[] jumps = {2, 3, 1, 1, 4}; // Example: jumps[i] is max jump from step i
        int n = jumps.length - 1; // Target step
        System.out.println("Recursive: " + solver.minMovesRecursive(jumps, n));
        System.out.println("Memoization: " + solver.minMovesMemoization(jumps, n));
        System.out.println("Tabulation: " + solver.minMovesTabulation(jumps, n));
        System.out.println("BFS: " + solver.minMovesBFS(jumps, n));
    }
}
