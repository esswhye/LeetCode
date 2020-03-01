package easy.leetcode1351;

public class Solution {

    public static void main(String[] args) {

        Solution s = new Solution();


    int grid[][] = { { 4, 3, 2, -1} ,
                     { 3, 2, 1, -1} };

        s.countNegatives(grid);


    }

    public int countNegatives(int[][] grid) {
        int count = 0;

        //looping row
        for(int r = 0; r<grid.length; r++)
        {
            //looping column start from the back (reverse loop)
            for(int c = grid[r].length-1; c>=0; c--)
            {
                if(grid[r][c]<0)
                {
                    count++;
                }
                if(grid[r][c]>=0){
                    break;
                }
                System.out.println(grid[r][c]);


        }
    }
        return count;
    }
    }