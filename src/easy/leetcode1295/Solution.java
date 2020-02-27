package easy.leetcode1295;

import java.util.ArrayList;
import java.util.List;

//Given an array nums of integers, return how many of them contain an even number of digits.
//
//
//        Example 1:
//
//        Input: nums = [12,345,2,6,7896]
//        Output: 2
//        Explanation:
//        12 contains 2 digits (even number of digits).
//        345 contains 3 digits (odd number of digits).
//        2 contains 1 digit (odd number of digits).
//        6 contains 1 digit (odd number of digits).
//        7896 contains 4 digits (even number of digits).
//        Therefore only 12 and 7896 contain an even number of digits.
//        Example 2:
//
//        Input: nums = [555,901,482,1771]
//        Output: 1
//        Explanation:
//        Only 1771 contains an even number of digits.
public class Solution {
    public static void main(String[] args) {
        findNumbers(new int[]{437,315,322,431,686,264,442});
    }
    public static int findNumbers(int[] nums) {
        int result=0,digit = 0;

        for (int n : nums) {
            while(n!=0)
            {
                digit++;
                n/=10;
                System.out.println(n);
            }
            if(digit%2==0)
            {
                result++;
            }
            digit=0;
        }
        System.out.println(result);
        return result;
    }
}
