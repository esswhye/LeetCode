package easy.leetcode1323;

public class Solution {
    public static void main(String[] args) {
       // System.out.println(maximum69Number(9999));
       maximum69NumberV2(9669);
    }

    public static int maximum69Number (int num) {

        String stringNum = String.valueOf(num);
        stringNum = stringNum.replaceFirst("6","9");
        /*
        for(int i = 0; i<stringNum.length(); i++)
        {
            System.out.println(stringNum.charAt(i));
            if(stringNum.charAt(i)==9){
                continue;
            }else if(stringNum.charAt(i)!=9)
            {
                stringNum = stringNum.replaceFirst("6","9");
                break;
            }
        }*/

        num = Integer.parseInt(stringNum);

        //output 9969
        return num;
    }

    public static int maximum69NumberV2 (int num)
    {
        for(int i = (int)(Math.log10(num)+1); i>=1; i-- )
        {
            int numDigits =(int) (Math.pow(10,i-1));
            if(num/numDigits%10!=9){
                num += (numDigits*3);
                System.out.println(num);
                break;
            }

        }
        return num;
    }
}
