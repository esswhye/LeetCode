package novchallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicCalculatorII {


    public static void main(String[] args) {
        solution("33+2*2");
    }

    public static int calculate(String s) {

        int result = 0;
        s = s.replaceAll("\\s+", "");
        int[] bucket = new int[2];

        int countAddSub = 0;
        int countMultiDivi = 0;

        List<Integer> multiDiviPos = new ArrayList<>();
        List<Integer> addSubPos = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                bucket[0]++;
                addSubPos.add(i);
                countAddSub++;
            } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                bucket[1]++;
                multiDiviPos.add(i);
                countMultiDivi++;
            }
        }

        int i = 0;
        while (countMultiDivi != 0) {
            if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                int first = i - 1;
                int second = i + 2;
                String test = s.substring(first, second);
                String subStr = helper(test);
                s = s.replace(test, subStr);
                countMultiDivi--;
                i -= 3;
            }
            i++;
        }
        i = 0;
        while (countAddSub != 0) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                int first = i - 1;
                int second = i + 2;
                String test = s.substring(first, second);
                String subStr = helper(test);
                s = s.replace(test, subStr);
                countAddSub--;
                i -= 3;
            }
            i++;
        }

        return result;
    }

    static String helper(String cal) {

        double x = Integer.parseInt(String.valueOf(cal.charAt(0)));
        double y = Integer.parseInt(String.valueOf(cal.charAt(2)));
        char operator = cal.charAt(1);

        switch (operator) {

            case '+': {
                return String.valueOf(x + y);
            }

            case '-': {
                return String.valueOf(x - y);
            }
            case '*': {
                return String.valueOf(x * y);
            }
            case '/': {
                return String.valueOf(x / y);
            }
            default:
                break;

        }
        return "0";
    }

    public static int solution(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> integerStack = new Stack<>();

        int curr = 0;
        char startOp = '+';
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                curr = (curr * 10) + (s.charAt(i) - '0');
            }
            //i == s.length() - 1 check the last curr number
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {

                if (startOp == '+') {
                    integerStack.push(curr);
                } else if (startOp == '-') {
                    integerStack.push(-curr);
                } else if (startOp == '*') {
                    integerStack.push(integerStack.pop() * curr);
                } else if (startOp == '/') {
                    integerStack.push(integerStack.pop() / curr);
                }
                curr = 0;
                startOp = s.charAt(i);

            }
        }

        int sum = 0;
        while (!integerStack.isEmpty()) {
            sum += integerStack.pop();
        }
        return sum;

    }


}
