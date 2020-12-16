package dec2020;

//80. Remove Duplicates from Sorted Array II
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {

        int count = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                count = 1;
                nums[result++] = nums[i];
            } else if (count < 2) {
                nums[result++] = nums[i];
                count++;
            }
        }

        return result;
    }
}
