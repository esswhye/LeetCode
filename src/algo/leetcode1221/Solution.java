package algo.leetcode1221;



public class Solution {

    public static void main(String[] args) {
        String s = "RLLLLRRRLR";
        Solution ss = new Solution();
        System.out.println(ss.balancedStringSplit(s));
    }


    public int balancedStringSplit(String s)
    {
        int count = 0, curr = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'R')
                curr--;
            else
                curr++;
            if(curr == 0)
                ++count;
        }
        return count;
    }




    public int testBalancedStringSplit(String s) {
        int count = 0;
        String splitString;
        int startCharEle=0;
        char start = s.charAt(0);
        int i = 1;
        /*
        for (int i = 1; i < s.length(); i++) {

            if (start != s.charAt(i)) {
                i = s.indexOf(start, i);
                if(i<0)
                {
                    splitString = s.substring(startCharEle, s.length()-1);
                    count += checkBalance(splitString);
                    break;
                }
                splitString = s.substring(startCharEle, i);
                count += checkBalance(splitString);
                startCharEle = i;

            }
        }
        */
        while(s.length()>1)
        {
            if(start != s.charAt(i))
            {
                i = s.indexOf(start, i);
                if(i<0)
                {
                    count+=checkBalance(s);
                    break;
                }
                splitString = s.substring(startCharEle, i);
                s = s.substring(i);
                count += checkBalance(splitString);
                startCharEle = i;
                i = 0;
            }
            i++;
        }

        return count;
    }

    public int checkBalance(String add)
    {
        if(add.length()%2>0)
        {
            return 0;
        }
        int countR = 0;
        int countL = 0;
        char charL = 'L';

        for (char c: add.toCharArray()
             ) {
            if(c==charL)
            {
                countL++;
            }else{
                countR++;
            }
        }
        return countR==countL?1:0;
    }
}
