package oct2020;

import java.util.Arrays;

/*
[[1,4],[3,6],[2,8]]
[[1,4],[2,3]]
[[0,10],[5,12]]
[[3,10],[4,10],[5,11]]
[[1,2],[1,4],[3,4]]
[[34335,39239],[15875,91969],[29673,66453],[53548,69161],[40618,93111]]
[[97744,99177],[9782,42547],[21210,35161],[31377,85790],[53330,82476],[59552,64449],[4177,4511],[22686,79581],[7900,55898],[70317,75508],[48660,60445],[4175,59106],[64406,97296],[2547,35392],[24716,42920],[69598,78736],[74744,91826],[66305,69290],[34631,95035],[23099,86779],[23707,83804],[84597,91731],[76336,97281],[4507,19729],[68007,87741],[47660,72540],[20096,72534],[79422,89929],[66650,94270],[17827,46319],[5584,44234],[52418,53669],[29550,79734],[4525,37837],[26458,54655],[10550,97776],[19571,49453],[62428,94877],[41642,76480],[22741,44283],[40915,83070],[41016,59403],[49628,97532],[2874,25053],[902,4508],[17388,46321],[64582,70841],[27836,36686],[29291,82231],[34819,96651]]
 */
public class RemoveCoveredIntervals {

    public static void main(String[] args) {
        removeCoveredIntervalsV2(new int[][]{{1, 2}, {1, 4}, {3, 4}, {3, 10}, {4, 10}, {5, 11}});
    }

    public static int removeCoveredIntervals(int[][] intervals) {
        int result = intervals.length;
        int size = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < size; i++) {
            //{2,8},{3,6}
            for (int j = i + 1; j < size; j++) {
                if ((intervals[i][1] - intervals[i][0]) == (intervals[j][1] - intervals[j][0])) continue;
                //intervals[i][0] >= intervals[j][0] && intervals[i][1] <= intervals[j][1]
                if (intervals[i][0] >= intervals[j][0] && intervals[i][1] <= intervals[j][1]) {
                    result--;
                    break;
                }
            }
        }
        System.out.println(result);


        return result;
    }

    public static int removeCoveredIntervalsV2(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int result = 0;
        int max = 0;
        for (int[] i : intervals) {
            //Means prior is covering the i
            if (max >= i[1]) {
                //Numbers of how many removed
                result++;
            } else {
                max = i[1];
            }
        }


        return intervals.length - result;
    }

    public static int removeCoveredIntervalsV3(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
        int result = 0;
        int size = intervals.length;
        int[] curr = new int[]{-1, -1};
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if ((intervals[i][1] - intervals[i][0]) == (intervals[j][1] - intervals[j][0])) continue;
                if (intervals[i][0] >= intervals[j][0] && intervals[i][1] <= intervals[j][1]) {
                    result++;
                    break;
                }
            }
        }

        return size - result;
    }
}
