package dp;

import java.util.HashMap;

public class Fibonacci {

    public static void main(String[] args) {

        HashMap<Integer, Integer> dict = new HashMap<>();

        System.out.println(topBottom(66, dict));
        System.out.println(bottomUp(66));
    }

    //Recursion and Memoization
    public static int topBottom(int n, HashMap<Integer, Integer> dict) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (dict.containsKey(n)) {
            return dict.get(n);
        }

        int fibOfN = topBottom(n - 1, dict) + topBottom(n - 2, dict);
        dict.put(n, fibOfN);

        return fibOfN;
    }


    //Always start from bottm to up using iteration keeping track of subproblems forward
    public static int bottomUp(int n) {
        if (n == 0 || n == 1)
            return n;

        int[] dp = new int[n + 1];

        //base case
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {

            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    //bottom up (backward)
    //  ----->f(i+2)
    //  |
    //f(i)
    //  |
    //  ----->f(i+1)
    //
    public static int bottomUpBackWard(int n) {
        if (n == 0 || n == 1)
            return n;

        int[] dp = new int[n + 2];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 1; i < n; i++) {
            dp[i + 1] += dp[i]; // dp[i] is solved uise it to solve other subproblems
            dp[i + 2] += dp[i];
        }
        return dp[n];
    }
}
