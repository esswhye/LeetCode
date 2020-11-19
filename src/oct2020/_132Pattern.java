package oct2020;

/*
132 Pattern
Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.

Follow up: The O(n^2) is trivial, could you come up with the O(n logn) or the O(n) solution?



Example 1:

Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.
Example 2:

Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:

Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].


Constraints:

n == nums.length
1 <= n <= 104
-109 <= nums[i] <= 109
 */
public class _132Pattern {

    public static void main(String[] args) {
        System.out.println(find132pattern(new int[]{3, 5, 0, 3, 4}));
    }

    public static boolean find132pattern(int[] nums) {
        int n = nums.length;
        int leftMin = nums[0];
        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                if (nums[k] > leftMin && nums[j] > nums[k]) {
                    System.out.println(leftMin + " " + nums[j] + " " + nums[k]);
                    return true;
                }
            }
            leftMin = Math.min(nums[j], leftMin);
        }
        return false;
    }
}
