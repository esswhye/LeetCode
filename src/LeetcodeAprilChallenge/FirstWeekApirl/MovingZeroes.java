package LeetcodeAprilChallenge.FirstWeekApirl;

public class MovingZeroes {
    /*
    Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    Example:

    Input: [0,1,0,3,12]
    Output: [1,3,12,0,0]
    Note:

    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.

    283. Move Zeroes
    */

//    static int[] nums = ;

    public static void main(String[] args) {
        moveZeroes2(new int[]{0, 1, 0, 3, 12});
    }

    public static void moveZeroes(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int countZero = 0;
            if (nums[i] == 0) {
                int zeroI = i;
                for (int j = zeroI + 1; j < nums.length - countZero; j++) {
                    if (nums[j] != 0) {
                        int temp = nums[zeroI];
                        nums[zeroI] = nums[j];
                        nums[j] = temp;
                    } else {
                        j++;
                        if (j < nums.length && nums[j] != 0) {
                            int temp = nums[zeroI];
                            nums[zeroI] = nums[j];
                            nums[j] = temp;
                        }
                    }
                    zeroI++;
                }
                countZero++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void moveZeroes2(int[] nums) {
        //Zero Index pointer
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
                j++;
            }
        }
    }

}
