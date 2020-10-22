package oct2020;

/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Follow up:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?


Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]


Constraints:

1 <= nums.length <= 2 * 104
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
 */
public class RotateArray {

    public static void main(String[] args) {
        rotateV3(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);

    }

    public static void rotate(int[] nums, int k) {


        k = k % nums.length;


        int[] back = new int[k + 1];
        int[] head = new int[nums.length - k - 1];
        for (int i = 0; i < back.length; i++) {
            back[i] = nums[i];
        }

        for (int i = k + 1; i < nums.length; i++) {
            head[(i - k) - 1] = nums[i];
        }

        //int[] join = new int[nums.length];

        for (int i = 0; i < head.length; i++) {
            nums[i] = head[i];
        }

        for (int i = 0; i < back.length; i++) {
            nums[head.length + i] = back[i];
        }

    }

    public static void rotateV2(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[(i + k) % n] = arr[i];
        }

        System.out.println();
    }

    public static void rotateV3(int[] nums, int k) {

        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

        System.out.println();
    }

    public static void reverse(int[] nums, int start, int end) {
//        for (int i = start; i <= end / 2; i++) {
//            int temp = nums[i];
//            nums[i] = nums[end - i];
//            nums[end - i] = temp;
//        }

        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }


}

