package septchallenge;

import java.util.ArrayList;
import java.util.List;

/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {
    public static void main(String[] args) {

        combinationSum3(3, 9);

    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        //Start value should be 1. 1-9
        helperSum(arr, result, k, n, 1);
        return result;
    }

    private static void helperSum(List<Integer> arr, List<List<Integer>> result, int k, int n, int startValue) {
        if (n < 0) {
            return;
        }
        if (k == arr.size() && (n == 0)) {
            result.add(new ArrayList<>(arr));
            return;

        }
        //Try all the combination 1 - 9 and use backtrack
        for (int i = startValue; i < 10; i++) {
            arr.add(i);
            //                                    startValue dont increment i else the prev rec i will be incremented
            helperSum(arr, result, k, n - i, i + 1);
            arr.remove(arr.size() - 1);
        }

    }

}
