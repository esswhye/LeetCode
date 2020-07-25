package LeetcodeAprilChallenge.FirstWeekApirl;

/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
53
 */

public class MaximumSubArray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4, -10, 100}));

        int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4, -10, 100};
        int max = maxSubArrayDivideConquer(array, 0, array.length - 1);
        System.out.println(max);

    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = max;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static int maxSubArray2(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static int maxSubArray3(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public static int maxSubArray4(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (sum < 0) {
                sum = 0;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static int maxSubArrayDivideConquer(int[] nums, int l, int r) {
        //Base
        if (l == r) {
            return nums[l];
        }
        //Find mid
        int m = (l + r) / 2;

        //Break them into sub
        int maxLeft = maxSubArrayDivideConquer(nums, l, m);
        int maxRight = maxSubArrayDivideConquer(nums, m + 1, r);

        //Solve the problem
        int maxCross = maxSubCrossingSum(nums, l, m, r);
        return Math.max(Math.max(maxLeft, maxRight), maxCross);
    }

    public static int maxSubCrossingSum(int[] nums, int l, int m, int r) {


        //Mid to Left << --- |

        int maxLeft = Integer.MIN_VALUE, sum = 0;

        for (int i = m; i >= l; i--) {
            sum += nums[i];
            if (sum > maxLeft) {
                maxLeft = sum;
            }
        }

        //Mid to Right | -- >>

        int maxRight = Integer.MIN_VALUE;
        sum = 0;

        for (int i = m + 1; i <= r; i++) {
            sum += nums[i];
            if (sum > maxRight) {
                maxRight = sum;
            }
        }
        //Sum of Mid cross   _<<  +  >>_
        int cross = maxLeft + maxRight;

        //Left or Right
        int maxLeftOrRight = Math.max(maxLeft, maxRight);


        return Math.max(cross, maxLeftOrRight);


    }

}
