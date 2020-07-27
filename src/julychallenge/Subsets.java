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

        List<List<Integer>> result = subsets(new int[]{1, 5, 3});
        result.stream().forEach(System.out::println);
        System.out.println(result.size());
        int size = result.size();
        System.out.println(size);
        result.add(new ArrayList<>());
        System.out.println(result.size());
        System.out.println(size);
    }

    public static List<List<Integer>> subsets(int[] nums) {

        if (nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = iterSubsets(nums);
        List<List<Integer>> result2 = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();

        recSubsets(nums, 0, subSet, result2);

        return result;
    }

    private static void recSubsets(int[] nums, int pos, List<Integer> subSet, List<List<Integer>> result2) {

        result2.add(new ArrayList<>(subSet));
        for (int i = pos; i < nums.length; i++) {
            subSet.add(nums[i]);
            recSubsets(nums, i + 1, subSet, result2);

            //backtracking
            subSet.remove(subSet.size() - 1);
        }

    }

    public static List<List<Integer>> iterSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //get all the single digit elem
            int size = result.size();

            //loop thru single< digit elements
            for (int j = 0; j < size; j++) {

                //result.add(new ArrayList<>(result.get(j)));
                //Initializing new Array copy instead of pointing
                /*
                because in line 15 ith element is taken ,so in line 17 to delete that element and proceed forwad.
                so basically that line use to not cosider ith element
                 */
                List<Integer> list = new ArrayList<>(result.get(j));
                result.add(list);
                result.get(result.size() - 1).add(nums[i]);
            }

        }
        return result;
    }


}
