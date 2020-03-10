package algo.leetcode1304;

public class Solution {

    //(-2,2,-1,1,0)
    public static void main(String[] args) {
        int[] result = sumZero(6);
        for (int i:result
             ) {
            System.out.println(i);
        }
    }
    public static int[] sumZero(int n) {
        int[] result = new int[n];
        if(n == 1)
        {
            result[0] = 0;
            return result;
        }

        int start = n/2;

        //Even
        int i = 0;
        if(n%2==0) {
            while (i < n) {
              result[i] = start;
              result[++i] = -start;
              start--;
              i++;
            }
        }
        //Odd
        else {
            while(i<n-1)
            {
                result[i] = start;
                result[++i] = -start;
                start--;
                i++;
            }
            result[n-1] = 0;
        }
        return result;
    }
}
