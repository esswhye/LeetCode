package septchallenge;

import java.util.ArrayList;
import java.util.List;

/*
A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.



Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.


Note:

S will have length in range [1, 500].
S will consist of lowercase English letters ('a' to 'z') only.

 */
public class PartitionLabels {
    public static void main(String[] args) {

        partitionLabels("ababcbacadefegdehijhklij");
    }

    public static List<Integer> partitionLabels(String S) {
        // Result store here and return
        List<Integer> outputArr = new ArrayList<>();

        // Store last index of every encountered alphabets
        int lastIndices[] = new int[26];

        for (int i = 0; i < S.length(); i++) {
            //Get S.charAt(i)-'a' get the char element
            //will store lastIndices['b'] = i;
            lastIndices[S.charAt(i) - 'a'] = i;
        }

        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            //lastIndices[S.charAt(i)-'a'] get the char element eg. S["abc"] int lastIndices[0,1,2];
            end = Math.max(end, lastIndices[S.charAt(i) - 'a']);

            //reaches the end of the last occurring letter
            if (end == i) {
                //end+1 to get the string length of the last occurring letter
                outputArr.add((end - start) + 1);
                start = end + 1;
            }
        }


        return outputArr;
    }
}
