package algo.leetcode1370;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Input: s = "aaaabbbbcccc"
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.sortString("aaaabbbbcccc"));

    }
    public String sortString(String s)
    {


        StringBuilder result = new StringBuilder();
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }

        while(result.length()<s.length())
        {
            for(int i=0; i<26; i++){
                if(freq[i]>0){
                    result.append((char)('a'+i));
                    freq[i]--;
                }
            }
            for(int i=25; i>=0; i--){
                if(freq[i]>0){
                    result.append((char)('a'+i));
                    freq[i]--;
                }
            }
        }


        return result.toString();
    }
}
