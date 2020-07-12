package julychallenge;
/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
 */

public class HammingDistance {

    public static void main(String[] args) {

        System.out.println(hammingDistance(1, 4));
    }

    public static int hammingDistance(int x, int y) {

        //XOR
        int number = x ^ y;
        int distance = 0;

        while (number != 0) {

            /*
            byte[] buffer;
            if (buffer[6].ToString().EndsWith("1"))
            {
                //do stuff
            }
             */

            //find the value of  last bit
            int last = number % 2;
            if (last == 1) {
                distance++;
            }
            number = number >> 1;


        }

        return distance;
    }
}
