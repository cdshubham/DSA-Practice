package DP;

public class GoldMine {

    // 1. Brute Force (Recursive)
    public int bruteForce(int[][] mine, int i, int j) {
        int m = mine.length, n = mine[0].length;

        if (i < 0 || i >= m || j >= n) return 0; // out of bounds

        if (j == n - 1) return mine[i][j]; // last column

        int rightUp = bruteForce(mine, i - 1, j + 1);
        int right = bruteForce(mine, i, j + 1);
        int rightDown = bruteForce(mine, i + 1, j + 1);

        return mine[i][j] + Math.max(right, Math.max(rightUp, rightDown));
    }

    // 2. Memoization (Top-Down DP)
    public int memoization(int[][] mine, int i, int j, int[][] dp) {
        int m = mine.length, n = mine[0].length;

        if (i < 0 || i >= m || j >= n) return 0;
        if (j == n - 1) return mine[i][j];

        if (dp[i][j] != -1) return dp[i][j];

        int rightUp = memoization(mine, i - 1, j + 1, dp);
        int right = memoization(mine, i, j + 1, dp);
        int rightDown = memoization(mine, i + 1, j + 1, dp);

        return dp[i][j] = mine[i][j] + Math.max(right, Math.max(rightUp, rightDown));
    }

    // 3. Tabulation (Bottom-Up DP)
    public int tabulation(int[][] mine) {
        int m = mine.length, n = mine[0].length;
        int[][] dp = new int[m][n];

        // Fill last column
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = mine[i][n - 1];
        }

        // Fill table from right to left
        for (int j = n - 2; j >= 0; j--) {
            for (int i = 0; i < m; i++) {
                int right = dp[i][j + 1];
                int rightUp = (i > 0) ? dp[i - 1][j + 1] : 0;
                int rightDown = (i < m - 1) ? dp[i + 1][j + 1] : 0;

                dp[i][j] = mine[i][j] + Math.max(right, Math.max(rightUp, rightDown));
            }
        }

        // Answer is max from first column
        int maxGold = 0;
        for (int i = 0; i < m; i++) {
            maxGold = Math.max(maxGold, dp[i][0]);
        }
        return maxGold;
    }

    // 4. Space Optimized (Only keep two columns at a time)
    public int spaceOptimized(int[][] mine) {
        int m = mine.length, n = mine[0].length;
        int[] next = new int[m];

        // Initialize with last column
        for (int i = 0; i < m; i++) {
            next[i] = mine[i][n - 1];
        }

        // Process from right to left
        for (int j = n - 2; j >= 0; j--) {
            int[] curr = new int[m];
            for (int i = 0; i < m; i++) {
                int right = next[i];
                int rightUp = (i > 0) ? next[i - 1] : 0;
                int rightDown = (i < m - 1) ? next[i + 1] : 0;
                curr[i] = mine[i][j] + Math.max(right, Math.max(rightUp, rightDown));
            }
            next = curr;
        }

        int maxGold = 0;
        for (int val : next) {
            maxGold = Math.max(maxGold, val);
        }
        return maxGold;
    }

    public static void main(String[] args) {
        GoldMine gm = new GoldMine();

        int[][] mine = {
            {1, 3, 1, 5},
            {2, 2, 4, 1},
            {5, 0, 2, 3},
            {0, 6, 1, 2}
        };

        int m = mine.length, n = mine[0].length;

        // 1. Brute Force (check all starting rows)
        int bruteAns = 0;
        for (int i = 0; i < m; i++) {
            bruteAns = Math.max(bruteAns, gm.bruteForce(mine, i, 0));
        }
        System.out.println("Brute Force: " + bruteAns);

        // 2. Memoization
        int[][] dp = new int[m][n];
        for (int[] row : dp) java.util.Arrays.fill(row, -1);
        int memoAns = 0;
        for (int i = 0; i < m; i++) {
            memoAns = Math.max(memoAns, gm.memoization(mine, i, 0, dp));
        }
        System.out.println("Memoization: " + memoAns);

        // 3. Tabulation
        System.out.println("Tabulation: " + gm.tabulation(mine));

        // 4. Space Optimized
        System.out.println("Space Optimized: " + gm.spaceOptimized(mine));
    }
}
