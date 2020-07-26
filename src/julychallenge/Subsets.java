package julychallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class Subsets {
    public static void main(String[] args) {

        subsets(new int[]{1, 2, 3});
    }

    public static List<List<Integer>> subsets(int[] nums) {

        if (nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        doSubsets(nums, 0, result, new ArrayList<>());


        return null;
    }

    private static void doSubsets(int[] nums, int i, List<List<Integer>> result, ArrayList<Object> list) {
        if (i == nums.length) {
            result.add(new ArrayList<>());
            return;
        }
        doSubsets(nums, i + 1, result, list);

        list.add(nums[i]);
        doSubsets(nums, i + 1, result, list);

    }


}
