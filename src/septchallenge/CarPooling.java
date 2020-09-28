package septchallenge;

import java.util.Arrays;

/**
 * 1094. Car Pooling
 * You are driving a vehicle that has capacity empty seats initially available for passengers.  The vehicle only drives east (ie. it cannot turn around and drive west.)
 * <p>
 * Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains information about the i-th trip: the number of passengers that must be picked up, and the locations to pick them up and drop them off.  The locations are given as the number of kilometers due east from your vehicle's initial location.
 * <p>
 * Return true if and only if it is possible to pick up and drop off all passengers for all the given trips.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 4
 * Output: false
 * Example 2:
 * <p>
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 5
 * Output: true
 * Example 3:
 * <p>
 * Input: trips = [[2,1,5],[3,5,7]], capacity = 3
 * Output: true
 * Example 4:
 * <p>
 * Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
 * Output: true
 * <p>
 * Constraints:
 * <p>
 * trips.length <= 1000
 * trips[i].length == 3
 * 1 <= trips[i][0] <= 100
 * 0 <= trips[i][1] < trips[i][2] <= 1000
 * 1 <= capacity <= 100000
 */
public class CarPooling {
    public static void main(String[] args) {
        System.out.println(carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4));
    }

    public static boolean carPooling(int[][] trips, int capacity) {

        //Bucket
        int meter[] = new int[1001];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < trips.length; i++) {
            int thisTempCap = trips[i][0];
            int thisStartDes = trips[i][1];
            int thisEndDes = trips[i][2];

            meter[thisStartDes] += thisTempCap;
            meter[thisEndDes] -= thisTempCap;

            min = Math.min(min, thisStartDes);
            max = Math.max(max, thisEndDes);

        }

        int tempCap = 0;

        for (int i = min; i <= max; i++) {
            tempCap += meter[i];
            if (tempCap > capacity) {
                return false;
            }
        }


        return true;
    }

}
