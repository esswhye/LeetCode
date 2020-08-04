package augchallenge;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 * <p>
 * Input: "race a car"
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * s consists only of printable ASCII characters.
 */
public class ValidPalindrome {

    public static void main(String[] args) {


        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;

        while (start < end) {
            while (start < end && !(Character.isLetterOrDigit(s.charAt(start))))
                start++;
            while (start < end && !(Character.isLetterOrDigit(s.charAt(end)))) end--;
            if (start < end && Character.toLowerCase(s.charAt(start++)) != Character.toLowerCase(s.charAt(end--)))
                return false;
        }
        return true;
    }

    public static boolean isPalindromeV2(String s) {
        String[] words = s.split("[ \n\t\r.,;:!?(){]");
        String removedDeliWord = s.replaceAll("[ \n\t\r.,;:!?(){]", "");
        int reversedIndex = removedDeliWord.length() - 1;
        for (String subWord : words
        ) {
            System.out.println(s.substring(reversedIndex, removedDeliWord.length() - subWord.length()));
            //subWord.equalsIgnoreCase(s.substring(reversedIndex, subWord.length()));
        }

        return true;
    }

    public static String reverse(String word) {
        char[] chs = word.toCharArray();

        int i = 0, j = chs.length - 1;
        while (i < j) {
            // swap chs[i] and chs[j]
            char t = chs[i];
            chs[i] = chs[j];
            chs[j] = t;
            i++;
            j--;
        }
        return String.valueOf(chs);
    }
}
