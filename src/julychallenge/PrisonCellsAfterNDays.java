package julychallenge;


/*
There are 8 prison cells in a row, and each cell is either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the following rules:

If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
Otherwise, it becomes vacant.
(Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)

We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.

Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)



Example 1:

Input: cells = [0,1,0,1,1,0,0,1], N = 7
Output: [0,0,1,1,0,0,0,0]
Explanation:
The following table summarizes the state of the prison on each day:
Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
Day 7: [0, 0, 1, 1, 0, 0, 0, 0]

Example 2:

Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
Output: [0,0,1,1,1,1,1,0]


Note:

cells.length == 8
cells[i] is in {0, 1}
1 <= N <= 10^9


 */

import java.util.*;

public class PrisonCellsAfterNDays {

    public static void main(String[] args) {

        prisonAfterNDays3(new int[]{1, 0, 0, 1, 0, 0, 0, 1}, 2);


    }

    //Time exceeded Brute Force n+n
    public static int[] prisonAfterNDays(int[] cells, int N) {

        int[] localDay = new int[8];

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < cells.length - 1; j++) {


                if (cells[j - 1] == cells[j + 1]) {
                    localDay[j] = 1;
                } else {
                    localDay[j] = 0;
                }
            }
            localDay[0] = 0;
            localDay[localDay.length - 1] = 0;
            cells = localDay.clone();
        }


        return cells;
    }

    public static int[] prisonAfterNDays2(int[] cells, int N) {

        /*
        eg.
        3 states a,b,c
        a -> b , b - > c , c -> a
        after 15 iterations ,  15 mod 3 = 0  stop at a
         */

        HashSet<String> combinations = new HashSet<>();

        int size = 0;
        boolean flag = false;

        for (int i = 0; i < N; i++) {

            int[] today = todayCell(cells);

            String str = Arrays.toString(today);

            if (!combinations.contains(str)) {
                combinations.add(str);
                size++;
            } else {
                flag = true;
                break;
            }

            cells = today;
        }
        if (flag) {
            N = N % size;
            for (int i = 1; i < N; i++) {
                cells = todayCell(cells);
            }
        }

        return cells;
    }

    public static int[] prisonAfterNDays3(int[] cells, int N) {

        /*
        eg.
        3 states a,b,c
        a -> b , b - > c , c -> a
        after 15 iterations ,  15 mod 3 = 0  stop at a
         */

        HashMap<String, int[]> combo = new HashMap<>();
        int size = 0;
        boolean flag = false;
        List<String> listStr = new ArrayList<>();
        listStr.add(Arrays.toString(cells));
        for (int i = 0; i < N; i++) {

            int[] today = todayCell(cells);

            String str = Arrays.toString(today);

            if (!combo.containsKey(str)) {
                listStr.add(str);
                combo.put(str, today);
                size++;
            } else {
                flag = true;
                break;
            }

            cells = today;
        }
        if (flag) {
            if (N % size == 0) {
                String key = listStr.get(size);
                cells = combo.get(key);
            } else {
                N = N % size;
                String key = listStr.get(N);
                cells = combo.get(key);
            }
        }

        return cells;
    }

    public static int[] todayCell(int[] cells) {

        //By initializing a new array all elements will be 0 hence first and last will be 0
        int[] today = new int[cells.length];

        for (int j = 1; j < cells.length - 1; j++) {
            if (cells[j - 1] == cells[j + 1]) {
                today[j] = 1;
            }
        }

        return today;
    }


}
