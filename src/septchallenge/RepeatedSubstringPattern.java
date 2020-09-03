package septchallenge;

import java.util.HashMap;
import java.util.Map;

/*
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.



Example 1:

Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
Example 2:

Input: "aba"
Output: False
Example 3:

Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class RepeatedSubstringPattern {

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPatternV3("abcabc"));
    }

    public static boolean repeatedSubstringPattern(String s) {

        int index = 0, end = 1;//, otherEnd = 4;
        boolean result = false;

        while (end <= s.length() / 2) {
            String firstSubstring = s.substring(index, end);
            String secondSubstring = s.substring(end, end + firstSubstring.length());
            if (firstSubstring.equals(secondSubstring)) {
                System.out.println(s.substring(index, end));
                result = true;
                end++;
            } else {
                end++;
                result = false;
                //otherEnd = end + firstSubstring.length();
            }
        }

        return result;
    }

    public static boolean repeatedSubstringPatternV2(String s) {

        HashMap<String, String> storeSubstring = new HashMap<>();
        for (int i = 1; i <= s.length() / 2; i++) {
            storeSubstring.put(s.substring(0, i), s.substring(0, i));
        }
        for (Map.Entry<String, String> pair : storeSubstring.entrySet()) {

            int start = 0, counter = 0;
            int end = pair.getValue().length() + start;

            while (end <= s.length()) {
                String subString = s.substring(start, end);
                if (!pair.getValue().equals(subString)) {
                    break;
                }
                start += pair.getValue().length();
                end = start + pair.getValue().length();
                counter++;
            }
            if (counter == (s.length() / pair.getValue().length()) && (s.length() % pair.getValue().length() == 0)) {
                return true;
            }
            counter = 0;

        }
        return false;
    }

    public static boolean repeatedSubstringPatternV3(String s) {

        int n = s.length();

        //abcabc = length = 6  initial stringLength/2=L i=0
        //012345
        //i  l
        //^  ^   = i++ l=l+i
        // if the loop ended with i+l at the end we can assume that it contains multiple substring
        //using 2 pointer

        for (int l = n / 2; l > 0; l--) {
            if (n % l == 0) {
                int i = 0;
                while (i + l < n && s.charAt(i) == s.charAt(i + l)) {
                    i++;
                }
                if (i + l == n)
                    return true;
            }
        }
        return false;


    }

}
