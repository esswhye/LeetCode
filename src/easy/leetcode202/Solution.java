package easy.leetcode202;

import java.util.HashSet;
import java.util.Set;

//TODO - NEXT
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isHappyV2(20));
    }

    public boolean isHappy(int n) {

        if(cal(n) == 1)
            return true;
        else
            return false;
    }

    public int cal(int n)
    {
        if(n == 1)
        {
            return 1;
        }
        if(n==4)
        {
            return 4;
        }

        int result = 0;

        for(int i = (int)(Math.log10(n)+1); i>=1; i-- )
        {
            int numDigits =(int) (Math.pow(10,i-1));

            result+=(int)Math.pow(n/numDigits%10,2);

        }
        /*
        while(n > 0){
            result += (int) Math.pow(n%10, 2);
            n /= 10;
        }*/
        return cal(result);
    }

    public boolean isHappyV2(int n){

        Set<Integer> integerSet = new HashSet<>();
        while(n!=1){
            if(integerSet.contains(n))
            {
                return false;
            }
            integerSet.add(n);
            int sum = 0;
            while(n>0){
                sum+= Math.pow(n%10,2);
                n/=10;
            }
            if (sum ==1)
            {
                return true;
            }
            n = sum;
        }
        return true;

    }




}
