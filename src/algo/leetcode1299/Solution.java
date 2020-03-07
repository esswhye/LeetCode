package algo.leetcode1299;


public class Solution {

    public static void main(String[] args) {

        int[] arr = {17,18,5,4,6,1};
        replaceElements(arr);
    }

    public static int[] replaceElements(int[] arr) {

        int max = arr[arr.length-1];
        int[] result = new int[arr.length];
        result[arr.length-1] = -1;
        //Start from the last 2nd.
        for(int i = arr.length-2; i>=0; i--)
        {
            result[i] = max;

            if(max<arr[i])
            {
                max = arr[i];
            }
        }
        return result;
    }

}
