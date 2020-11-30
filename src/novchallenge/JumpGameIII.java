package novchallenge;

import java.util.LinkedList;
import java.util.Queue;

//1306
public class JumpGameIII {

    public static void main(String[] args) {
        System.out.println(canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
    }

    public static boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int point = queue.remove();

                if (point - arr[point] >= 0) {
                    if (arr[point - arr[point]] == 0) {
                        return true;
                    } else if (arr[point - arr[point]] > 0) {
                        queue.add(point - arr[point]);
                    }
                }
                if (point + arr[point] < arr.length) {
                    if (arr[point + arr[point]] == 0) {
                        return true;
                    } else if (arr[point + arr[point]] > 0) {
                        queue.add(point + arr[point]);
                    }
                }
                //Searched before
                arr[point] = -1;
                size--;
            }
        }
        return false;
    }
}