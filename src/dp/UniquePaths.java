package dp;


public class UniquePaths {
    public static void main(String[] args) {
        // System.out.println(uniquePaths(3, 4));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 0, 0},}));
        System.out.println(maxProfit(new int[][]{{0, 2, 2, 50},
                {3, 1, 1, 100},
                {4, 4, 2, 0},}));
        System.out.println(pathOfMaxProfit(new int[][]{{0, 2, 2, 50},
                {3, 1, 1, 100},
                {4, 4, 2, 0},}));

        System.out.println(1234%100);
    }

    /*
Problem:
	Unique Paths
	A robot is located at the top-left corner of a m * n grid (marked 'S' in the diagram below).
	The robot can only move either down or right at any point in time.
	The robot is trying to reach the bottom-right corner of the grid (marked 'E' in the diagram below).
	How many possible unique paths are there?
	+---+---+---+---+
	| S |   |   |   |
	+---+---+---+---+
	|   |   |   |   |
	+---+---+---+---+
	|   |   |   | E |
	+---+---+---+---+
	Above is a 3 x 4 grid. How many possible unique paths are there?
*/
    //F(i,j) = F(i-1,j) + F(i,j-1)
    //i > 0
    //j > 0
    public static int uniquePaths(int m, int n) {

        int dp[][] = new int[m][n];

        //Base case 1 way
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else if (i > 0) {
                    dp[i][j] = dp[i - 1][j];
                } else if (j > 0) {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }


    /*
Problem:
	Unique Paths with Obstales
	A robot is located at the top-left corner of a m x n grid (marked 'S' in the diagram below).
	The robot can only move either down or right at any point in time.
	The robot is trying to reach the bottom-right corner of the grid (marked 'E' in the diagram below).
	Now consider if some obstacles are added to the grids.
	How many unique paths would there be?
	+---+---+---+---+
	| S |   |   |   |
	+---+---+---+---+
	|   | 1 | 1 | 1 |
	+---+---+---+---+
	|   |   |   | E |
	+---+---+---+---+
	An obstacle and empty space is marked as 1 and 0 respectively in the grid.
*/
    public static int uniquePathsWithObstacles(int grid[][]) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        //base
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i > 0 && j > 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else if (i > 0) {
                    dp[i][j] = dp[i - 1][j];
                } else if (j > 0) {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }


        return dp[m - 1][n - 1];
    }

    /*
Problem:
	Maximum Profit in a Grid
	A robot is located at the top-left corner of a m x n grid (marked 'S' in the diagram below).
	The robot can only move either down or right at any point in time.
	The robot is trying to reach the bottom-right corner of the grid (marked 'E' in the diagram below).
	Each cell contains a coin the robot can collect.
	What is the maximum profit the robot can accumulate?
	+---+---+---+---+
	| S | 2 | 2 | 1 |
	+---+---+---+---+
	| 3 | 1 | 1 | 1 |
	+---+---+---+---+
	| 4 | 4 | 2 | E |
	+---+---+---+---+
*/

    public static int maxProfit(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                } else if (i > 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else if (j > 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }
            }
        }

//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[i].length; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        return dp[m - 1][n - 1];
    }

    public static int pathOfMaxProfit(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                } else if (i > 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else if (j > 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }
            }
        }

        int[][] path = new int[m][n];

        getPath(dp, m - 1, n - 1, path);


        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[i].length; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }


        return dp[m - 1][n - 1];
    }

    public static int[][] getPath(int dp[][], int i, int j, int[][] path) {
        if (i == 0 & j == 0) {
            //path[i][j] = dp[i][j];
            return path;
        } else if (i == 0) {
            getPath(dp, i, j - 1, path);
        } else if (j == 0) {
            getPath(dp, i - 1, j, path);
        } else {
            if (dp[i - 1][j] > dp[i][j - 1]) {
                getPath(dp, i - 1, j, path);
            } else {
                getPath(dp, i, j - 1, path);
            }
        }
        path[i][j] = dp[i][j];
        return path;
    }


}
