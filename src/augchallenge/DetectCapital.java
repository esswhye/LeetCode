package augchallenge;

import java.util.stream.Stream;

/*
Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
 */
public class DetectCapital {
    public static void main(String[] args) {

    }

    public static boolean detectCapitalUse(String word) {

        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                count++;
            }
        }

        boolean onlyFirstCap = Character.isUpperCase(word.charAt(0)) && count == 1;

        boolean allSmall = count == 0;

        boolean allCaps = count == word.length();

        if (onlyFirstCap || allSmall || allCaps)
            return true;

        return false;
    }


}
