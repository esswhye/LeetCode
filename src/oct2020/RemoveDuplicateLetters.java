package oct2020;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        removeDuplicateLetters("bbcca");
    }

    public static String removeDuplicateLetters(String s) {

        int[] lastIndex = new int[26];
        boolean[] seen = new boolean[26];
        StringBuilder res = new StringBuilder();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';

            if (seen[c]) continue;
            while (!st.isEmpty() && st.peek() > c && i < lastIndex[st.peek()]) {
                seen[st.pop()] = false;
            }
            st.push(c);
            seen[c] = true;
        }

        while (!st.isEmpty()) {
            res.append((char) (st.pop() + 'a'));
        }


        return res.reverse().toString();

        /*
        Set<Character> origSet = new LinkedHashSet<Character>();
        StringBuilder concat = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (origSet.add(s.charAt(i))) {
                concat.append(s.charAt(i));
            }
        }


        return "";

         */
    }


}
