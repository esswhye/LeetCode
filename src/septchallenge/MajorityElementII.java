package septchallenge;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 229. Majority Element II
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * <p>
 * Note: The algorithm should run in linear time and in O(1) space.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: [3]
 * Example 2:
 * <p>
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 */
public class MajorityElementII {

    public static void main(String[] args) {
        majorityElement(new int[]{3, 3, 3, 1, 2, 3, 3, 2, 2, 1, 2});
    }

    public static List<Integer> majorityElement(int[] nums) {


        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        int gauge = nums.length / 3;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        Set<Integer> mySet = new HashSet<Integer>();
        for (Integer t : nums) {
            mySet.add(t);
        }

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (Integer t : mySet) {
            if (hashMap.get(t) > gauge)
                result.add(t);
        }

        return result;

    }
}
