package oct2020;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/*
532. K-diff Pairs in an Array
Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

0 <= i, j < nums.length
i != j
a <= b
b - a == k


Example 1:

Input: nums = [3,1,4,1,5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
Example 2:

Input: nums = [1,2,3,4,5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
Example 3:

Input: nums = [1,3,1,5,4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).
Example 4:

Input: nums = [1,2,4,4,3,3,0,9,2,3], k = 3
Output: 2
Example 5:

Input: nums = [-1,-2,-3], k = 1
Output: 2
 */
public class KdiffPairsinanArray {
    public static void main(String[] args) {
//        findPairsv2(new int[]{3, 1, 4, 1, 5}, 2);
//        findPairsv2(new int[]{1, 1, 1, 1, 5}, 4);
//        findPairsv3(new int[]{2, 9, 0, 8, 9, 6, 5, 9, 8, 1, 9, 6, 9, 2, 8, 8, 7, 5, 7, 8, 8, 3, 7, 4, 1, 1, 6, 2, 9, 9, 3, 9, 2, 4, 6, 5, 6, 5, 1, 5, 9, 9, 8, 1, 4, 3, 2, 8, 5, 3, 5, 4, 5, 7, 0, 0, 7, 6, 4, 7, 2, 4, 9, 3, 6, 6, 5, 0, 0, 0, 8, 9, 9, 6, 5, 4, 6, 2, 1, 3, 2, 5, 0, 1, 4, 2, 6, 9, 5, 4, 9, 6, 0, 8, 3, 8, 0, 0, 2, 1}, 1);
//        findPairsv3(new int[]{3, 1, 4, 1, 5}, 2);
        findPairsv2(new int[]{1, 1, 1, 1, 1}, 0);
    }

    public static int findPairs(int[] nums, int k) {


        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        set.stream().forEach(System.out::print);


        int result = 0;
        List<Integer> list = new ArrayList<>();
        //Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1 + i; j < nums.length; j++) {
                if (nums[i] - nums[j] == k || nums[j] - nums[i] == k) {
                    System.out.println(nums[i] + " " + nums[j]);
                    if (list.contains(nums[j]) && list.contains(nums[i]))
                        continue;
                    list.add(nums[i]);
                    list.add(nums[j]);
                    //System.out.println(nums[i] + " " + nums[j]);
                    result++;
                }
            }
        }

        System.out.println(result);
        return result;
    }

    public static int findPairsv2(int[] nums, int k) {
        // Arrays.sort(nums);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);

        }

        Set<Integer> integerSet = hashMap.keySet();


        if (k < 1) {
            for (Integer i : integerSet
            ) {
                if (hashMap.containsKey(i) && hashMap.get(i) > 1) {
                    result++;
                }
            }
            return result;
        }

        for (Integer i : integerSet) {

            if (hashMap.containsKey(i + k)) {
                result++;
            }
        }

        System.out.println(result);
        return result;
    }

    public static int findPairsv3(int[] nums, int k) {

        Set<Integer> uniqueSet = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            if (Arrays.binarySearch(nums, i + 1, n, nums[i] + k) > 0) {
                uniqueSet.add(nums[i]);
            }
        }
        System.out.println(uniqueSet.size());
        return uniqueSet.size();
    }

}
