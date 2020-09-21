package septchallenge;

import java.util.ArrayList;
import java.util.List;

/**
 * 1291. Sequential Digits
 * An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
 * <p>
 * Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: low = 100, high = 300
 * Output: [123,234]
 * Example 2:
 * <p>
 * Input: low = 1000, high = 13000
 * Output: [1234,2345,3456,4567,5678,6789,12345]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 10 <= low <= high <= 10^9
 */
public class SequentialDigits {
    public static void main(String[] args) {
        sequentialDigits(100, 3000);
    }

    public static List<Integer> sequentialDigits(int low, int high) {

        String digits = "123456789";
        List<Integer> result = new ArrayList<>();

        int nl = Integer.toString(low).length();
        int nh = Integer.toString(high).length();

        for (int i = nl; i <= nh; ++i) {
            for (int j = 0; j < 10 - i; ++j) {
                int num = Integer.parseInt(digits.substring(j, j + i));
                if (num >= low && num <= high)
                    result.add(num);
            }
        }


        return result;
    }
}
