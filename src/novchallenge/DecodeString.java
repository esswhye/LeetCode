package novchallenge;

import java.util.Stack;

/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.

For example, there won't be input like 3a or 2[4].

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
Example 4:

Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"
*/
public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeStringV2("abc3[cd]xyz"));
    }

    public static String decodeStringV2(String s) {

        Stack<Integer> counts = new Stack<>();
        Stack<String> result = new Stack<>();

        StringBuilder res = new StringBuilder();
        int index = 0;

        while (index < s.length()) {

            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = 10 * count + (s.charAt(index) - '0');
                    index += 1;
                }
                counts.push(count);
            } else if (s.charAt(index) == '[') {
                result.push(res.toString());
                res = new StringBuilder();
                index++;
            } else if (s.charAt(index) == ']') {
                StringBuilder temp = new StringBuilder(result.pop());
                int count = counts.pop();
                temp.append(String.valueOf(res).repeat(Math.max(0, count)));
                res = temp;
                index++;

            } else {
                res.append(s.charAt(index));
                index++;
            }

        }

        return res.toString();
    }


    public static String decodeString(String s) {

        StringBuilder number = new StringBuilder();

        StringBuilder result = new StringBuilder();
        int initial = 0;

        for (int i = 0; i < s.length(); i++) {

            //find number in the String
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                for (int j = i; j < s.length(); j++) {
                    if (Character.isDigit(s.charAt(j))) {
                        number.append(s.charAt(j));
                    }
                    if (s.charAt(j) == '[') {
                        initial = j;
                    } else if (s.charAt(j) == ']') {
                        int num = Integer.parseInt(number.toString());
                        String addNum = s.substring(initial + 1, j).repeat(num);
                        number.setLength(0);
                        result.append(addNum);
                        i = j;
                        break;
                    }
                }
                continue;
            }
            result.append(c);

        }

        return result.toString();
    }
}
