package julychallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class ThreeSum {

    public static void main(String[] args) {

        threeSum(new int[]{-1, 0, 1, 2, -1, -4});


    }

    static Function<List<List<Integer>>, Integer> threeSummy = (x) -> {

        return null;
    };

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumII(nums, i, result);
            }
        }

        return result;

    }

    static void twoSumII(int[] nums, int i, List<List<Integer>> result) {
        int lo = i + 1;
        int hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0 || (lo > i + 1 && nums[lo] == nums[lo - 1])) {
                ++lo;
                //check that if "hi" within the array and move back <
            } else if (sum > 0 || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
                --hi;
            } else {
                result.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
            }
        }
    }
}
