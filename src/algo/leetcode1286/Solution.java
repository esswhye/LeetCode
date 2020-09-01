package algo.leetcode1286;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        CombinationIterator combinationIterator = new CombinationIterator("abc", 2);
       // combinationIterator.list.forEach(System.out::println);
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.next());



    }

}

class CombinationIterator {
    List<String> list;
    int pointer;

    public CombinationIterator(String characters, int combinationLength) {
        list = new ArrayList<>();
        pointer = 0;

        generateAll(characters.toCharArray(), 0, combinationLength, new ArrayList<>());
    }

    private void generateAll(char[] arr, int pos, int len, ArrayList<Character> temp) {
        if (len == 0) {
            StringBuilder sb = new StringBuilder();
            for (char c : temp) {
                sb.append(c);
            }
            list.add(sb.toString());
            return;
        }

        for (int i = pos; i < arr.length; i++) {
            temp.add(arr[i]);
            generateAll(arr, i + 1, len - 1, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public String next() {
        if (!hasNext()) {
            return null;
        }

        return list.get(pointer++);

    }

    public boolean hasNext() {
        return pointer < list.size();
    }

}
