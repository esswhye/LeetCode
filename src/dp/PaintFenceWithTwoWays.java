package dp;

/*
Problem:
    Paint Fence With Two colours

    There is a fence with n posts, each post can be painted with either green or blue color.
    You have to paint all the posts such that no more than two adjacent fence posts have the same color.
    Return the total number of ways you can paint the fence.

 */
public class PaintFenceWithTwoWays {
    public static void main(String[] args) {
        numWays(4);
    }

    public static int numWays(int n) {

        int[][] dp = new int[n + 1][2];

        // green = 1
        // blkue = 0
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[2][0] = 2;
        dp[2][1] = 2;

        for (int i = 3; i <= n; i++) {
            for (int j = 0; j <= 1; j++) {
                dp[i][j] = dp[i - 1][1 - j] + dp[i - 2][1 - j];
            }
        }
        System.out.println(dp[n][0] + dp[n][1]);
        return dp[n][0] + dp[n][1];
    }
}
