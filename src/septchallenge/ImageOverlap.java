package septchallenge;

/* 835
Two images A and B are given, represented as binary, square matrices of the same size.  (A binary matrix has only 0s and 1s as values.)

We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.

(Note also that a translation does not include any kind of rotation.)

What is the largest possible overlap?

Example 1:

Input: A = [[1,1,0],
            [0,1,0],
            [0,1,0]]
       B = [[0,0,0],
            [0,1,1],
            [0,0,1]]
Output: 3
Explanation: We slide A to right by 1 unit and down by 1
 */


public class ImageOverlap {

    public static void main(String[] args) {

        int[][] a = new int[][]{{1, 1, 0}, {0, 1, 0}, {0, 1, 0}};
        int[][] b = new int[][]{{0, 0, 0}, {0, 1, 1}, {0, 0, 1}};


        System.out.println(Math.max(largestOverlap(a, b), largestOverlap(b, a)));
    }

    public static int largestOverlap(int[][] A, int[][] B) {
        int count = 0, n = A.length;

        //Iterate each x shift
        for (int x = 0; x < n; x++) {
            //Iterate all possible shifts in x position current x ,y+1
            for (int y = 0; y < n; y++) {
                int temp = 0;
                for (int i = x; i < n; i++) {
                    for (int j = y; j < n; j++) {
                        if (A[i][j] == 1 && B[i - x][j - y] == 1) {
                            temp++;
                        }
                    }
                }
                count = Math.max(count, temp);
            }

        }

        return count;
    }
}
