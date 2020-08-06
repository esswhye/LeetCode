package augchallenge;

import java.util.*;

public class FindAllDuplicates {
    /*
    Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

     */
    public static void main(String[] args) {
        findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}).stream().forEach(System.out::println);
    }

    public static List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                result.add(nums[i]);
            }
            set.add(nums[i]);
        }

        return result;
    }
}
