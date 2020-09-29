package dp;

public class SumOfN {
    public static void main(String[] args) {

        // F((n-1)+n)
        System.out.println(nSumDP(5));

    }

    public static int sum(int num) {
        if (num == 1)
            return 1;

        return num += sum(num - 1);
    }

    public static int nSumDP(int num) {

        //Memoized/Cached result
        int[] dp = new int[num + 1];
        dp[0] = 0;

        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i - 1] + i;
        }

        return dp[num];
    }
}
