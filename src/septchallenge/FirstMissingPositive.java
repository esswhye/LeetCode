package septchallenge;

import java.util.HashSet;
import java.util.Set;

/*

41. First Missing Positive
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Follow up:

Your algorithm should run in O(n) time and uses constant extra space.
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositiveV2(new int[]{1, 3, -1, 0}));
        //System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        //System.out.println(firstMissingPositiveV2(new int[]{7, 8, 9, 11, 99, 1}));
        //System.out.println(firstMissingPositiveV2(new int[]{1, 2, 0, 0, 0, 0, 0, 0, 3, 7}));
    }

    //TC = O(n)
    //SC = O(n)
    public static int firstMissingPositive(int[] nums) {

        if (nums.length == 0) {
            return 1;
        }

        Set<Integer> hashSet = new HashSet<>();
        int max = nums[0];
        hashSet.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                hashSet.add(nums[i]);
                max = Math.max(nums[i], max);
            }
        }

        if (max > 0) {
            for (int i = 1; i < max; i++) {
                if (!hashSet.contains(i)) {
                    return i;
                }
            }
            return max + 1;
        } else {
            return 1;
        }
    }

    public static int firstMissingPositiveV2(int[] nums) {
        int i = 0, n = nums.length;
        //n will be the gap missing number will be 1 to n+1
        while (i < n) {
            //If not more than 0 and less than N and its check its position -1(lenght-1)
            // Arrange em from nums in n

            if ((nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1])) {
                System.out.println(nums[i - 1]);
                System.out.println(nums[i] + " " + nums[nums[i] - 1]);
                System.out.println(nums[i] != nums[nums[i] - 1]);
                int a = i;
                int b = nums[i] - 1;
                int temp = nums[i];
                nums[a] = nums[b];
                nums[b] = temp;
            } else {
                i++;
            }
        }

        i = 0;

        while (i < n) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
            i++;
        }
        return n + 1;
    }


}
