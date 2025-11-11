
import java.util.Arrays;

public class BestTimeToBuyAndSellStockVariations {
    // Variation 1: At most one transaction
    public int maxProfitOneTransaction(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int n = prices.length;
        int[] dp = new int[n];
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return dp[n - 1];
    }

    // Variation 2: Unlimited transactions
    public int maxProfitUnlimitedTransactions(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int n = prices.length;
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    // Variation 3: Unlimited transactions with transaction fee
    public int maxProfitWithFee(int[] prices, int fee) {
        if (prices == null || prices.length <= 1) return 0;
        int n = prices.length;
        int cash = 0; // Max profit without holding stock
        int hold = -prices[0]; // Max profit while holding stock
        for (int i = 1; i < n; i++) {
            int temp = cash;
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, temp - prices[i]);
        }
        return cash;
    }

    // Variation 4: Unlimited transactions with cooldown
    public int maxProfitWithCooldown(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int n = prices.length;
        int[] sell = new int[n];
        int[] buy = new int[n];
        buy[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(buy[i - 1], (i >= 2 ? sell[i - 2] : 0) - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[n - 1];
    }

    // Variation 5: At most two transactions
    public int maxProfitTwoTransactions(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int n = prices.length;
        int[][] dp = new int[n][3]; // dp[i][j]: max profit at day i with j transactions left
        for (int[] row : dp) Arrays.fill(row, -1);
        return maxProfitKTransactionsHelper(prices, 0, 2, dp); // Using helper from Variation 6 with k=2
    }

    private int maxProfitKTransactionsHelper(int[] prices, int index, int transLeft, int[][] dp) {
        if (transLeft == 0 || index == prices.length) return 0;
        if (dp[index][transLeft] != -1) return dp[index][transLeft];
        
        // Skip current day
        int skip = maxProfitKTransactionsHelper(prices, index + 1, transLeft, dp);
        // Buy or sell depending on if transLeft is even or odd (but simplified for max profit)
        int profit = 0;
        for (int j = index + 1; j < prices.length; j++) {
            if (prices[j] > prices[index]) {
                profit = Math.max(profit, prices[j] - prices[index] + maxProfitKTransactionsHelper(prices, j + 1, transLeft - 1, dp));
            }
        }
        return dp[index][transLeft] = Math.max(skip, profit);
    }

    // Variation 6: At most k transactions
    public int maxProfitKTransactions(int[] prices, int k) {
        if (prices == null || prices.length <= 1 || k <= 0) return 0;
        int n = prices.length;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                int min = Integer.MAX_VALUE;
                for (int p = 1; p < i; p++) {
                    min = Math.min(min, prices[p - 1] - dp[p - 1][j - 1]);
                }
                if (min != Integer.MAX_VALUE) {
                    dp[i][j] = Math.max(dp[i][j], prices[i - 1] - min);
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    // Main method for testing
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockVariations solver = new BestTimeToBuyAndSellStockVariations();
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int fee = 1;
        int k = 2;
        
        System.out.println("One Transaction: " + solver.maxProfitOneTransaction(prices));
        System.out.println("Unlimited Transactions: " + solver.maxProfitUnlimitedTransactions(prices));
        System.out.println("Unlimited with Fee: " + solver.maxProfitWithFee(prices, fee));
        System.out.println("Unlimited with Cooldown: " + solver.maxProfitWithCooldown(prices));
        System.out.println("Two Transactions: " + solver.maxProfitTwoTransactions(prices));
        System.out.println("K Transactions: " + solver.maxProfitKTransactions(prices, k));
    }
}