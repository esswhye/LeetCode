package septchallenge;

/*
Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

Example 1:
Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Note:

0 < nums.length <= 50000.
0 < nums[i] < 1000.
0 <= k < 10^6.
 */
public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100);
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        //2 pivot being and end
        int begin = 0, end = 0, result = 0, product = 1, arrayLength = nums.length;

        while (end < arrayLength) {
            //Move the end forward
            product *= nums[end];

            while (product >= k && begin < end)
                // Move begin to +1
                product /= nums[begin++];
            // Update after moving begin cause we are finding all the valid solution
            result += (end - begin) + 1; // 1 is itself + n *...
            end++;
        }

        System.out.println(result);
        return result;


    }
}
