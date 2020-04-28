package LeetcodeAprilChallenge.FirstWeekApirl;
/*
Given an integer array arr, count element x such that x + 1 is also in arr.

If there're duplicates in arr, count them seperately.

Example 1:

Input: arr = [1,2,3]
Output: 2
Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
Example 2:

Input: arr = [1,1,3,3,5,5,7,7]
Output: 0
Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
Example 3:

Input: arr = [1,3,2,3,5,0]
Output: 3
Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
Example 4:

Input: arr = [1,1,2,2]
Output: 2
Explanation: Two 1s are counted cause 2 is in arr.

Constraints:

1 <= arr.length <= 1000
0 <= arr[i] <= 1000
 */

import java.util.*;

public class CountingElements {

    public static void main(String[] args) {
        System.out.println(countElements(new int[]{1, 1, 4, 3}));
    }

    public static int countElements(int[] arr) {

        int result = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                List<Integer> newList = new ArrayList<>();
                newList.add(arr[i]);
                map.put(arr[i], newList);
            } else {
                map.get(arr[i]).add(arr[i]);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (map.containsKey(entry.getKey() + 1)) {
                if (entry.getValue().size() > map.get(entry.getKey() + 1).size()) {
                    result += entry.getValue().size();
                } else {
                    result += (Math.min(entry.getValue().size(), map.get(entry.getKey() + 1).size()));
                }
            }
        }

        return result;
    }
}
