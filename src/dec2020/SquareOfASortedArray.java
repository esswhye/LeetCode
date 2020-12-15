package dec2020;

import java.util.Arrays;

//977. Squares of a Sorted Array
public class SquareOfASortedArray {


    public int[] sortedSquares(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) Math.pow(nums[i], 2);
        }

        Arrays.sort(nums);

        return nums;
    }

}
