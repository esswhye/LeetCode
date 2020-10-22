package oct2020;

public class HouseRobberII {
    public static void main(String[] args) {

        HouseRobberII houseRobberII = new HouseRobberII();
        int total = houseRobberII.rob(new int[]{2, 3, 2});

        System.out.println(total);
    }

    public int rob(int[] nums) {

        if (nums.length == 1) return nums[0];

        int start = helper(nums, 0, nums.length - 2);
        int start2 = helper(nums, 1, nums.length - 1);

        return Math.max(start, start2);
    }

    public int helper(int[] nums, int start, int end) {

//        int[] dp = new int[nums.length + 1];
//
//        dp[0] = 0;
//        dp[1] = nums[start];

        int prevTwo = 0;
        int prevOne = 0, max = 0;

        for (int i = start; i <= end; i++) {
//            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);

            max = Math.max(prevTwo + nums[i], prevOne);
            prevTwo = prevOne;
            prevOne = max;
        }
//        return dp[end];
        return max;
    }
}
