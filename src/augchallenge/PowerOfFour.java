package augchallenge;

/*
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

        Example 1:

        Input: 16
        Output: true

        Example 2:

        Input: 5
        Output: false

        Follow up: Could you solve it without loops/recursion?
 */
public class PowerOfFour {

    public static void main(String[] args) {
        isPowerOfFourV2(12);


    }

    //Brute Force
    public static boolean isPowerOfFour(int num) {
        if (1 == num)
            return true;

        if (num % 2 != 0)
            return false;

        int re = 0;

        while (num > 10) {
            re = num % 4;
            num /= 4;
            if (re > 0) {
                return false;
            }
        }
        return num == 4;
    }

    //Using Binary
    // 16 =  10000 >> 2 100|00 >> 1|00 >> 1 == true;
    // 12 = 1000 >> 10|00 >> |10 >> 0
    public static boolean isPowerOfFourV2(int num) {

        return (num > 0) && ((num & (num - 1)) == 0) && (num % 3 == 1);
        /*
        int n = num, count = 0;

        while (n > 1) {
            n >>= 2;
            count += 2;
        }
        //System.out.println(n + " " + count + " " + num);
        //System.out.println(n <<= 4);
        return (n << count) == num;

         */
    }
}
