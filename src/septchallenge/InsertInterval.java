package septchallenge;

import java.util.ArrayList;
import java.util.List;

//57. Insert Interval
/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class InsertInterval {

    public static void main(String[] args) {

        int result[][] = insert(new int[][]{{1, 5}}, new int[]{2, 3});
        System.out.println(result);
    }


    //intervals = [[x,x],[x,x],[x,x]]
    //newIntervals can have 1 single array. eg [x,x]
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) {

            //return an empty array if newInterval and intervals length is 0 or if intervals length is 0 and newInterval is 1
            return new int[][]{newInterval};
        }

        List<int[]> arr = new ArrayList<>();
        //int[][] insertedInterval = new int[intervals.length + 1][intervals[0].length];
        //Insert new Interval and intervals into a new list, if Interval is <= insert in.
        boolean inserted = false;
        for (int i = 0; i < intervals.length; i++) {
            if (!inserted && newInterval[0] <= intervals[i][0]) {
                arr.add(newInterval);
                //      insertedInterval[i] = newInterval;
                inserted = true;
            }
            arr.add(intervals[i]);
            //insertedInterval[i] = intervals[i];
        }
        //above loops might not insert newInterval inside if newInterval[0] > intervals[0][0] only 1 array in intervals
        if (!inserted) {
            arr.add(newInterval);
        }
        /*
        if (insertedInterval[1][0] == 0) {
            insertedInterval[1] = newInterval;
        }
        */
        return mergeInterval(arr);
    }

    private static int[][] mergeInterval(List<int[]> insertedInterval) {
        List<int[]> mergedInterval = new ArrayList<>();

        int[] candidate = insertedInterval.get(0);
        for (int i = 1; i < insertedInterval.size(); i++) {
            int[] temp = insertedInterval.get(i);
            if (temp[0] <= candidate[1]) {
                int[] merge = new int[]{Math.min(candidate[0], temp[0]), Math.max(candidate[1], temp[1])};
                candidate = merge;
            } else {
                //temp>candidate
                mergedInterval.add(candidate);
                //Store previous interval outside
                candidate = temp;
            }
        }

        //Last element wont get push.
        mergedInterval.add(candidate);

        return mergedInterval.toArray(new int[0][]);
    }
}
