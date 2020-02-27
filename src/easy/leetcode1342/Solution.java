package easy.leetcode1342;

class Solution {

    public static void main(String args[])
    {

        System.out.println(numberOfSteps(14));
    }
    public static int numberOfSteps (int num) {
        //Return back 0
        int count = 0;
        return numberOfStepsCount(num,count);
    }
    public static int numberOfStepsCount(int num, int count){
        if(num==0)
        {
            return count;
        }
        //Even number /
        else if(num%2==0)
        {
            System.out.println(num + " is even; divide by 2 and obtain " + num/2);
            count++;
            num /= 2;
            return numberOfStepsCount(num,count);
        }
        //Odd Number -
        else {
            System.out.println(num + " is odd; subtract 1 and obtain "+ (num - 1) + ".");
            num-=1;
            count++;

            return numberOfStepsCount(num,count);
        }
    }
}