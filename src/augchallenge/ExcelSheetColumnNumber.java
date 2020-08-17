package augchallenge;

/*
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701
 */
public class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        System.out.println(titleToNumber("AAB"));
    }

    /*
    Since this is most likely a learning assignment,
    I'll give you a hint: all UNICODE code points for the letters of the Latin alphabet are ordered alphabetically.
    If the code of a is some number N, then the code of b is N+1, the code of c is N+2, and so on; the code of Z is N+26.
     */
    public static int titleToNumber(String s) {
        // s = s.toLowerCase();

        int result = 0;
        int count = s.length() - 1;
        // N + 26^N eg. BAC = B*(26^3(placing) + A*(26^1) + C*(26^0)
        // 1*(10^placing)
        for (int i = 0; i < s.length(); i++) {
            int elementChar = s.charAt(i) - 'A' + 1;
            result += (elementChar * Math.pow(26, count--));
        }

        for (char c:s.toCharArray()
             ) {
            System.out.println(c);
        }


        return result;
    }

}
