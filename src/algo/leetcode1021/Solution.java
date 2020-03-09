package algo.leetcode1021;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        String st = "(()())(())";
        Solution s = new Solution();
        System.out.println(s.removeOuterParenthesesV3(st));

    }

    public String removeOuterParentheses(String S) {
        int count = 1;
        int firstPos = 0;
        char[] cArray = S.toCharArray();
        StringBuilder result = new StringBuilder();
        boolean isOpened = false;
        for (int i = 1; i < cArray.length; i++) {
            if (cArray[i] == '(') {
                count++;
            } else if (cArray[i] == ')') {
                count--;
            }

            if (count > 1 && !isOpened) {
                firstPos = i;
                isOpened = true;
            }

            if (count == 0 && isOpened) {
                result.append(S, firstPos, i);

                isOpened = false;
            }
        }
        return result.toString();
    }

    public String removeOuterParenthesesV2(String S) {
        StringBuilder builder = new StringBuilder();
        Stack<Character> s = new Stack<Character>();
        int l = -1;
        for(int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);
            if(ch == '('){
                s.push(ch);
                if(l == -1) l = i;
            }else{
                s.pop();
            }
            if(s.isEmpty()){
                builder.append(S.substring(l+1, i));
                l = -1;
            }
        }
        return builder.toString();
    }

    public String removeOuterParenthesesV3(String S) {
        StringBuilder s = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && opened++ > 0) s.append(c);
            if (c == ')' && opened-- > 1) s.append(c);
        }
        return s.toString();

    }
}