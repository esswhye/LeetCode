package septchallenge;

import java.util.Arrays;
import java.util.List;

/*

LeetCode 139. Word Break

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 */
public class WordBreak {
    public static void main(String[] args) {
        wordBreak("leetcode", Arrays.asList("leet", "code"));
    }

    //DP
    public static boolean wordBreak(String s, List<String> wordDict) {

        //int maxLen = wordDict.stream().max(Comparator.comparingInt(str -> str.charAt(str.length() - 1))).get().length();
        int maxLen = 0;
        for (String str : wordDict
        ) {
            maxLen = Math.max(maxLen, str.length());
        }

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int end = 0; end <= n; end++) {
            for (int start = 0; start < end; start++) {
                if (end - start > maxLen) {
                    continue;
                }
                //dp[start] if true previous word is found
                if (dp[start] && wordDict.contains(s.substring(start, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }
        System.out.println(dp[n]);
        return dp[n];
    }
}
