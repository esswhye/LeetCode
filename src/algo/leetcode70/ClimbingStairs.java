package algo.leetcode70;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs2(45));
    }

    // Time Exceeded
    public static int climbStairs(int n) {

        return climbRecursive(n, 0);
    }

    public static int climbStairs2(int n) {
        int[] ways = new int[n + 1];
        ways[0] = 1;
        ways[1] = 1;

        if (n < 1) {
            return 1;
        }

        for (int i = 2; i < ways.length; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }

        return ways[n];
    }


    //Slow
    public static int climbRecursive(int n, int result) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return climbRecursive(n - 1, result) + climbRecursive(n - 2, result);
    }
}
