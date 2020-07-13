package julychallenge;

/*
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.



Example:

Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16
 */

public class IslandPerimeter {

    public static void main(String[] args) {

        int[][] island = {{0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};

        System.out.println(islandPerimeter(island));
    }

    public static int islandPerimeter(int[][] grid) {

        int perimeter = 0;
        int up, down, left, right;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0) {
                        up = 0;
                    } else {
                        up = grid[i - 1][j];
                    }
                    if (j == 0) {
                        left = 0;
                    } else {
                        left = grid[i][j - 1];
                    }
                    if (i == rows - 1) {
                        down = 0;
                    } else {
                        down = grid[i + 1][j];
                    }

                    if (j == cols - 1) {
                        right = 0;
                    } else {
                        right = grid[i][j + 1];
                    }

                    perimeter += 4 - (up + left + down + right);
                }

            }
        }

        return perimeter;
    }
}
