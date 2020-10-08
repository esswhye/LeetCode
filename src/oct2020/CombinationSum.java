package oct2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



Example 1:
39. Combination Sum
//Backtrack
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
Example 4:

Input: candidates = [1], target = 1
Output: [[1]]
Example 5:

Input: candidates = [1], target = 2
Output: [[1,1]]
 */
public class CombinationSum {

    public static void main(String[] args) {
        combinationSum(new int[]{2, 3, 5}, 8);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();

        /*
        for (int i = 0; i < candidates.length; i++) {
            List<Integer> subCombi = new ArrayList<>();
            helper(candidates[i], subCombi, result, candidates, target);
        }*/
        List<Integer> subCombi = new ArrayList<>();
        helper(0, subCombi, result, candidates, target, 0);
        return result;
    }

    private static void helper(int start, List<Integer> subCombi, List<List<Integer>> result, int[] candidates, int target, int total) {
        //int total = subCombi.stream().reduce(Integer::sum).orElse(0);

        if (total == target) {
            result.add(new ArrayList<Integer>(subCombi));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] + total > target) break;
            subCombi.add(candidates[i]);
            helper(i, subCombi, result, candidates, target, total + candidates[i]);
            subCombi.remove(subCombi.size() - 1);
        }

        /*
        else if (total < target) {
            subCombi.add(index);
            helper(index, subCombi, result, candidates, target);
        }
         */
    }

}
