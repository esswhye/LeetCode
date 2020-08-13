package augchallenge;

/*
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

Example 1:

Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.


Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.

 */


import java.util.LinkedList;
import java.util.Queue;

//Store rotten in a queue , count the number of fresh
public class RottenOranges {

    public static void main(String[] args) {
        int i = orangesRotting(new int[][]{{0, 2, 2}});
        System.out.println(i);
    }

    public static int orangesRotting(int[][] grid) {

        Queue<Pair<Integer, Integer>> rotten = new LinkedList<>();
        int timeTaken = 0, fresh = 0;

        //Scanning all the oranges, add rotten to queue, count number of fresh oranges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    rotten.add(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        while (!rotten.isEmpty()) {

            int size = rotten.size();

            //convert all rotten's adjacent to rotten
            for (int i = 0; i < size; i++) {
                int x = rotten.peek().getFirst();
                int y = rotten.peek().getSecond();
                rotten.remove();
                //top
                //first condition is to check whether the element is on the grid[0](top)
                // we can just skip this since top of grid[0] doenst have anything
                if (x > 0 && grid[x - 1][y] == 1) {

                    grid[x - 1][y] = 2;
                    rotten.add(new Pair<>(x - 1, y));
                    fresh--;
                }
                ;

                //left
                if (y > 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    rotten.add(new Pair<>(x, y - 1));
                    fresh--;
                }

                //bottom
                if (x < grid.length - 1 && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    rotten.add(new Pair<>(x + 1, y));
                    fresh--;
                }

                //right
                if (y < grid[0].length - 1 && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    rotten.add(new Pair<>(x, y + 1));
                    fresh--;
                }
            }

            //If its able to contaminate , go for 1 more loop
            if (!rotten.isEmpty()) {
                timeTaken++;
            }
        }


        return fresh == 0 ? timeTaken : -1;

    }
}
