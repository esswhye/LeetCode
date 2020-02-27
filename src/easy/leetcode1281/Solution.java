package easy.leetcode1281;

//Given an integer number n, return the difference between the product of its digits and the sum of its digits.
//
//
//        Example 1:
//
//        Input: n = 234
//        Output: 15
//        Explanation:
//        Product of digits = 2 * 3 * 4 = 24
//        Sum of digits = 2 + 3 + 4 = 9
//        Result = 24 - 9 = 15
//        Example 2:
//
//        Input: n = 4421
//        Output: 21
//        Explanation:
//        Product of digits = 4 * 4 * 2 * 1 = 32
//        Sum of digits = 4 + 4 + 2 + 1 = 11
//        Result = 32 - 11 = 21
public class Solution {

    public static void main(String args[]){
       int n =4421;
       subtractProductAndSum(n);
////        int first = n%10;
////        int second = n/10%10;
////        int third = n/100%10;

    }
    public static int subtractProductAndSum(int n) {
        int multiplyResult = 1;
        int sumResult = 0;

        while(n!=0)
        {
            System.out.print(n%10 + " ");
            multiplyResult*=n%10;
            sumResult+=n%10;
            n = n/10;
        }
        System.out.print("*= " + multiplyResult);
        System.out.print(" += " + sumResult + "\n");
        System.out.println("-= "+ (multiplyResult-sumResult));
        return  multiplyResult-sumResult;

    }

    private static int multiplyProduct(int n) {
        int multiplyResult =1;
        while(n!=0){
            System.out.print(n%10 + " ");
            multiplyResult*=n%10;
            n = n/10;
        }
        System.out.print("*=" + multiplyResult + "\n");
        return multiplyResult;
    }

    private static int sumProduct(int n) {
        int sumResult = 0;
        while(n!=0){
            System.out.print(n%10 + " ");
            sumResult+=n%10;
            n = n/10;
        }
        System.out.print("+=" + sumResult + " \n");
        return sumResult;
    }


}
