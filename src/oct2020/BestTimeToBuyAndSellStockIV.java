package oct2020;

public class BestTimeToBuyAndSellStockIV {


    public static void main(String[] args) {

    }

    Integer[][][] dp;

    public int maxProfit(int k, int[] prices) {
        dp = new Integer[prices.length + 1][k + 1][2];
        return helper(prices, 0, 1, 0, k);
    }

    private int helper(int[] prices, int i, int buy, int txCount, int k) {

        if (i >= prices.length || txCount >= k) {
            return 0;
        }
        if (dp[i][txCount][buy] != null) {
            return dp[i][txCount][buy];
        }
        if (buy == 1) {
            return dp[i][txCount][buy] = Math.max(-prices[i] + helper(prices, i + 1, 0, txCount, k), helper(prices, i + 1, buy, txCount, k));
        } else {
            return dp[i][txCount][buy] = Math.max(prices[i] + helper(prices, i + 1, 1, txCount + 1, k), helper(prices, i + 1, buy, txCount, k));
        }


    }
}
