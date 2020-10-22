package dp;

public class CoinChange {

    int coinChange(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {

            if (i >= 1) {
                dp[i] += dp[i - 1];
            }
            if (i >= 3) {
                dp[i] += dp[i - 3];
            }
            if (i >= 5) {
                dp[i] += dp[i - 5];
            }
            if (i >= 10) {
                dp[i] += dp[i - 10];
            }
            //dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 5] + dp[i - 10];
        }

        return dp[n];

    }

    int coinChange(int n, int[] coins) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int coin = 0; coin < coins.length; coin++) {
                if (i - coins[coin] >= 0) {
                    dp[i] += dp[i - coins[coin]];
                }
            }
        }

        return dp[n];

    }
}
