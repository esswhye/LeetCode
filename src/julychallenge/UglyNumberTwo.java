package julychallenge;
/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:

1 is typically treated as an ugly number.
n does not exceed 1690.
 */

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UglyNumberTwo {

    public static void main(String[] args) {
        System.out.println(4 % 2);

        findPrime(0, 1000);

        System.out.println(uglyNumber(14));
        System.out.println(nthUglyNumber(10));
        System.out.println(nthUglyNumber2(10));
        System.out.println(nthUglyNumber3(10));

    }

    public static boolean uglyNumber(int n) {

        if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }

        return (n == 1);

    }

    public static int nthUglyNumber(int n) {

        boolean isPrime = true;

        List<Integer> nUglyNumbers = new ArrayList<>();

        int i = 1;
        while (nUglyNumbers.size() != n) {

            isPrime = uglyNumber(i);
            if (isPrime) {
                nUglyNumbers.add(i);
            }
            i++;
        }

        return --i;
    }

    public static int nthUglyNumber2(int n) {
        List<Integer> twoPrimeFactor = new ArrayList<>();
        List<Integer> threePrimeFactor = new ArrayList<>();
        List<Integer> fivePrimeFactor = new ArrayList<>();
        Set<Integer> mySet = new HashSet<Integer>();
        for (int i = 1; i <= n; i++) {
            twoPrimeFactor.add((i * 2));
            threePrimeFactor.add(i * 3);
            fivePrimeFactor.add(i * 5);
        }

        List<Integer> joined = new ArrayList<>();

        joined = Stream.concat(twoPrimeFactor.stream(), threePrimeFactor.stream()).collect(Collectors.toList());
        joined = Stream.concat(joined.stream(), fivePrimeFactor.stream()).collect(Collectors.toList());
        joined.add(1);
        //mySet = joined.stream().sorted((o1, o2) -> o1.compareTo(o2)).collect(Collectors.toSet());
        mySet = joined.stream().collect(Collectors.toSet());
        joined = mySet.stream().collect(Collectors.toList());
        Collections.sort(joined);

        return joined.get(n - 1);
    }

    public static int nthUglyNumber3(int n) {
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        for (int i = 1; i < n; i++) {

            int min = Math.min(Math.min(uglyNumbers[p2] * 2, uglyNumbers[p3] * 3), uglyNumbers[p5] * 5);
            uglyNumbers[i] = min;
            if (uglyNumbers[i] == uglyNumbers[p2] * 2) {
                p2++;
            }
            if (uglyNumbers[i] == uglyNumbers[p3] * 3) {
                p3++;
            }
            if (uglyNumbers[i] == uglyNumbers[p5] * 5) {
                p5++;
            }
        }

        return uglyNumbers[uglyNumbers.length - 1];

    }


    public static List<Integer> findPrime(int start, int end) {

        List<Integer> primeN = new ArrayList<>();

        if (start < 2) {
            primeN.add(1);
            start = 2;
        }
        for (int i = start; i < end; i++) {

            boolean isPrime = true;

            int nthHalf = i / 2;
            for (int j = 2; j <= nthHalf; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primeN.add(i);
            }

        }
        return primeN;
    }
}
