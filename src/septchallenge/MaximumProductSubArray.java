package septchallenge;

/* 152. Maximum Product Subarray
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaximumProductSubArray {

    public static void main(String[] args) {

        System.out.println(maxProductV2(new int[]{2, 3, -2, 4}));
    }

    public static int maxProduct(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            //start from 0 index
            int product = 1;

            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                max = Math.max(product, max);
            }
        }

        return max;
    }

    public static int maxProductV2(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0], min = nums[0], ans = nums[0];
        //2, 3, -2, 4
        for (int i = 1; i < nums.length; i++) {
            //if its less than max take the element nums[i]
            int tempMax = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(max * nums[i], min * nums[i]));
            max = tempMax;
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
