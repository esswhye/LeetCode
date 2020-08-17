package augchallenge;

import java.util.Arrays;

/*
H-Index

Solution
Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia:
"A scientist has index h if h of his/her N papers have at least h citations each,
 and the other N − h papers have no more than h citations each."

Example:

Input: citations = [3,0,6,1,5]
Output: 3
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
             received 3, 0, 6, 1, 5 citations respectively.
             Since the researcher has 3 papers with at least 3 citations each and the remaining
             two with no more than 3 citations each, her h-index is 3.
 */
public class H_Index {
    public static void main(String[] args) {
        hIndex(new int[]{3, 0, 6, 1, 5});
    }
//     1 2|3 4 5
    //[0,1,3,5,6]
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length, i;

        for (i = 1; i <= citations.length; i++) {
            if(citations[n-i]<i)
                break;
        }
        return i-1;


    }
}
