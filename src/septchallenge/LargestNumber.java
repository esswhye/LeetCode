package septchallenge;

import java.util.Arrays;

//179. Largest Number
public class LargestNumber {
    public static void main(String[] args) {

    }

    public static String largestNumber(int[] nums) {

        String resultStr[] = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            resultStr[i] = Integer.toString(nums[i]);
        }

        //Merge Sort Comparable
        Arrays.sort(resultStr, (str1, str2) ->
                (str2 + str1).compareTo(str1 + str2)
        );

        //If first char is a 0 it means its only 0
        if (resultStr[0].charAt(0) == '0') {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for (String str : resultStr
        ) {
            sb.append(str);
        }

        return sb.toString();
    }
}
