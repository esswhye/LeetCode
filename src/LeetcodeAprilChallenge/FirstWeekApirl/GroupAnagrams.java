package LeetcodeAprilChallenge.FirstWeekApirl;

import java.util.*;

/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.

#49. Group Anagrams
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> hashMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            String temp = strs[i];
            char[] sortString = temp.toCharArray();
            Arrays.sort(sortString);
            String sortedString = new String(sortString);
            if (!hashMap.containsKey(sortedString)) {
                List<String> stringList = new ArrayList<>();
                stringList.add(strs[i]);
                hashMap.put(sortedString, stringList);
            } else {
                hashMap.get(sortedString).add(strs[i]);
            }
        }

        int i = 0;

        for (Map.Entry<String, List<String>> entry : hashMap.entrySet()) {

            result.add(new ArrayList<>());
            for (String s : entry.getValue()) {
                result.get(i).add(s);
            }
            i++;
        }
        return result;
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, Integer> hmap = new HashMap<>();
        int index = 0;
        for (String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String tempStr = new String(temp);
            if (hmap.containsKey(tempStr))
                ans.get(hmap.get(tempStr)).add(str);
            else {
                ans.add(new ArrayList<String>());
                ans.get(index).add(str);
                hmap.put(tempStr, index);
                index++;
            }
        }
        return ans;
    }
}
