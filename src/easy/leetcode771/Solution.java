package easy.leetcode771;

//You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
//
//        The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
//
//        Example 1:
//
//        Input: J = "aA", S = "aAAbbbb"
//        Output: 3
//        Example 2:
//
//        Input: J = "z", S = "ZZ"
//        Output: 0
public class Solution {
    public static void main(String[] args) {
        String J = "aB";
        String S = "aabb231";
        numJewelsInStones(J,S);
    }

    public static int numJewelsInStones(String J, String S) {
        int count = 0;
        for(int i = 0; i<J.length(); i++)
        {
            for(int n=0; n<S.length(); n++)
            {
                if(J.charAt(i)==S.charAt(n))
                    count++;
            }
        }
        return count;
    }
}
//https://leetcode.com/problems/jewels-and-stones/discuss/113553/C%2B%2BJavaPython-Set-Solution-O(J-%2B-S)
//[C++/Java/Python] Set Solution O(J + S)
//public int numJewelsInStones(String J, String S) {
//        int res = 0;
//        Set setJ = new HashSet();
//        for (char j: J.toCharArray())
//        setJ.add(j);
//        for (char s: S.toCharArray())
//        if (setJ.contains(s)) res++;
//        return res;
//        }