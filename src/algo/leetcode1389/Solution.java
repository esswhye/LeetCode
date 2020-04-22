package algo.leetcode1389;
/*
Example 1:

        Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
        Output: [0,4,1,3,2]
        Explanation:
        nums       index     target
        0            0        [0]
        1            1        [0,1]
        2            2        [0,1,2]
        3            2        [0,1,3,2]
        4            1        [0,4,1,3,2]

*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] result = createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1});
        for(int i = 0; i < result.length; i++)
        {
            System.out.println(result[i]);
        }


    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i!=index[i]) {
                list.add(index[i], nums[i]);
            } else
                list.add(nums[i]);
        }

        return list.stream().mapToInt(x -> x).toArray();
    }
}
