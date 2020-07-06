package julychallenge;
/*
You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

        Given n, find the total number of full staircase rows that can be formed.

        n is a non-negative integer and fits within the range of a 32-bit signed integer.

        Example 1:

        n = 5

        The coins can form the following rows:
        ¤
        ¤ ¤
        ¤ ¤

        Because the 3rd row is incomplete, we return 2.
        Example 2:

        n = 8

        The coins can form the following rows:
        ¤
        ¤ ¤
        ¤ ¤ ¤
        ¤ ¤

        Because the 4th row is incomplete, we return 3.
*/

public class ArrangingCoins {

    int rows;

    public static void main(String[] args) {

        ArrangingCoins arrangingCoins = new ArrangingCoins();

        System.out.println(arrangingCoins.arrangeCoins(8));
    }

    public int arrangeCoins(int n) {
        return findExactRows(n, 1);
    }

    public int findExactRows(int n, int row) {
        if (n < row) {
            return row - 1;
        }

        if (n - (n - row) == row) {
            rows = findExactRows(n - row, ++row);
        }

        return rows;
    }

    public int arrangeCoins2(int n) {

        int no = n;
        int rows;

        while (no > this.rows) {

        }


        return findExactRows(n, 1);
    }

}
