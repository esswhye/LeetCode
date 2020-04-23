package LeetcodeAprilChallenge.FirstWeekApirl;

import java.util.HashMap;
import java.util.Map;

/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

        Note:

        Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

        Example 1:

        Input: [2,2,1]
        Output: 1
        Example 2:

        Input: [4,1,2,1,2]
        Output: 4
*/
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
    }

    public static int singleNumber(int[] nums) {
        int result;
        //int[] resultArray = new int [nums.length];
        Map<Integer,Integer> resultMap = new HashMap<>();

        for(int i = 0; i<nums.length; i++)
        {
           if(!resultMap.containsKey(nums[i]))
           {
               resultMap.put(nums[i],nums[i]);
           }else
           {
                resultMap.remove(nums[i]);
           }
        }

        return resultMap.keySet().stream().findFirst().get().intValue();
    }
}
