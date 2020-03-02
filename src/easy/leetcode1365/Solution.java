package easy.leetcode1365;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {

        int[] nums = {8,1,2,2,3};

        int[] integerList = Solution.smallerNumbersThanCurrentV2(nums);

        Arrays.stream(integerList).forEach(System.out::print);

    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        //8,1,2,2,3
        int result[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }

    //equ1n0x
    public static int[] smallerNumbersThanCurrentV2(int[] nums) {
        int[] count = new int[101];
        int[] res = new int[nums.length];

        for (int i =0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        for (int i = 1 ; i <= 100; i++) {
            count[i] = count[i] + count[i-1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                res[i] = 0;
            else
                res[i] = count[nums[i] - 1];
        }

        return res;
    }




}