package septchallenge;

import java.util.*;

public class LargestTimeForGivenDigits {


    static int max = -1;

    public static void main(String[] args) {
        System.out.println(largestTimeFromDigits(new int[]{1, 2, 3, 4}));

    }

    //http://www.sunshine2k.de/articles/coding/permutations/permutations.html
    //Reference https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
    public static String largestTimeFromDigits(int[] A) {

        dfs(A, 0);

        if (max == -1) {
            return "";
        } else {
            //convert back minutes to hr:min and return
            //System.out.println(max);
            return String.format("%02d:%02d", max / 60, max % 60);
        }

    }

    private static void dfs(int[] a, int index) {
        //Condition to stop at the end
        if (index == a.length) {
            //start from the end
            buildTime(a);
            return;
        }
        //iterate every N's j's
        for (int i = index; i < a.length; i++) {
            //Left
            swap(a, i, index);
            dfs(a, index + 1);
            // reach end of recursive tree for one particular combination then you need to back track to previous state to check other possible combinations.
            // So we are doing second swap.
            swap(a, i, index);
        }
    }

    //get the N's combination , build(total minutes) and compare the Max stored previously
    private static void buildTime(int[] arr) {
        int hour = arr[0] * 10 + arr[1];
        int minute = arr[2] * 10 + arr[3];

        if (hour < 24 && minute < 60) {
            max = Math.max(max, (hour * 60) + minute);
        }
    }

    //Swap the index with index + 1
    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }


}
