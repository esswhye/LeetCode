package septchallenge;

import java.util.HashMap;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * <p>
 * Example 1:
 * <p>
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 * <p>
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 * <p>
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Example 4:
 * <p>
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
 */

public class WordPattern {

    public static void main(String[] args) {
        System.out.println(wordPatternV2("aabb", "dog dog dog dog"));
    }

    public static boolean wordPattern(String pattern, String str) {


        //List<Pair<Character, String>> pairList = new ArrayList<>();
        String[] strSplit = str.split(" ");
        HashMap<String, Pair<Character, String>> hashMap = new HashMap<>();
        HashMap<Character, String> anim = new HashMap<>();
        if (pattern.length() != strSplit.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            // pairList.add(new Pair<>(pattern.charAt(i), strSplit[i]));

            if (hashMap.containsKey(strSplit[i])) {
                if (pattern.charAt(i) != hashMap.get(strSplit[i]).getFirst()) {
                    return false;
                }
            }
            if (hashMap.containsKey(anim.get(pattern.charAt(i))) && !hashMap.get(anim.get(pattern.charAt(i))).getSecond().equals(strSplit[i])) {
                return false;
            }
            hashMap.put(strSplit[i], new Pair<Character, String>(pattern.charAt(i), strSplit[i]));
            anim.put(pattern.charAt(i), strSplit[i]);
        }
        return true;
    }


    // I didnt know hashmap has containValue method...
    public static boolean wordPatternV2(String pattern, String str) {

        String[] strSplit = str.split(" ");
        HashMap<Character, String> hashMap = new HashMap<>();
        if (pattern.length() != strSplit.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            if (hashMap.containsKey(pattern.charAt(i))) {
                if (!hashMap.get(pattern.charAt(i)).equals(strSplit[i])) {
                    return false;
                }
            } else if (hashMap.containsValue(strSplit[i])) {
                return false;
            }
            hashMap.put(pattern.charAt(i), strSplit[i]);
        }

        return true;
    }
}


class Pair<T, V> {
    private T first;
    private V second;

    public Pair(T first, V second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public V getSecond() {
        return second;
    }

    public void setSecond(V second) {
        this.second = second;
    }
}
