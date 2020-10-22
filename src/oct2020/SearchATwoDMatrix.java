package oct2020;

import java.sql.Array;
import java.util.Arrays;

public class SearchATwoDMatrix {

    public static void main(String[] args) {
        SearchATwoDMatrix searchATwoDMatrix = new SearchATwoDMatrix();
        System.out.println(searchATwoDMatrix.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 0));
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        boolean isFound = false;
        //On + n Log N
        for (int i = 0; i < matrix.length; i++) {
            if (!isFound) {
                isFound = binarySearch(matrix[i], 0, matrix[i].length - 1, target);
            }
        }

        /*
        while (i < matrix.length) {
            Arrays.binarySearch()
        }
        */
        return isFound;
    }

    //nLogn
    public boolean binarySearch(int[] nums, int l, int r, int target) {

        if (l <= r) {
            int mid = (l + r) / 2;

            if (target == nums[mid]) {
                return true;
            }
            if (target < nums[mid]) {
                return binarySearch(nums, l, mid - 1, target);
            }

            return binarySearch(nums, mid + 1, r, target);
        }
        return false;
    }
}
