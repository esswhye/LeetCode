package septchallenge;

/*
Best Time to Buy and Sell Stock
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

 */
public class BestTimetoBuyandSellStock {

    public static void main(String[] args) {
        maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }

    //DP
    public static int maxProfit(int[] prices) {

        int[] dp = new int[prices.length + 1];
        dp[0] = 0;
        //dp[1] = prices[0];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {

            int ithProfit = dp[i - 1];
            int profDiff = prices[i] - prices[i - 1];

            dp[i] = Math.max(0, ithProfit + profDiff);
            max = Math.max(dp[i], max);

        }


        return max;
    }

    //Brute
    public static int maxProfitV2(int[] prices) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                max = Math.max(max, prices[i] - min);
            }
        }

        return max;
    }
}
