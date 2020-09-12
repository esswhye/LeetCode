package septchallenge;

import java.util.*;

public class BullsAndCows {
    public static void main(String[] args) {

        //System.out.println(getHint("1807", "7810"));
        //System.out.println(getHint("1123", "0111"));
        System.out.println(getHint("11", "10"));
        System.out.println(getHint("8578605648", "3675352465"));

    }

    public static String getHint(String secret, String guess) {

        //Digits 0-9 add frequency buckets
        int s[] = new int[10];

        int g[] = new int[10];

        int bull = 0;
        int cow = 0;

        for (int i = 0; i < secret.length(); i++) {
            char cs = secret.charAt(i);
            char cg = guess.charAt(i);
            //Get all same digit same letter and increment
            if (cs == cg) {
                bull++;
            } else {
                //count each digit frequency individually
                s[cs - '0']++;
                g[cg - '0']++;
            }
        }


        //Example Frequency S[0] = 2 >>> found digit '0' in secret
        // G[0] = 3 >>> found 3 digit '0' in guess
        // if S and G is more than 1 means guess digit was found in secret
        for (int i = 0; i < s.length; i++) {
            cow += Math.min(s[i], g[i]);
        }

        return String.format("%sA%sB", bull, cow);
    }


    public static String getHintV2(String secret, String guess) {

        int bull = 0;
        int cow = 0;
        //<digit|frequency>
        Map<Character, Integer> map = new HashMap<>();


        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else {
                //Put in map if secret!=guess
                map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            char g = guess.charAt(i);

            if (secret.charAt(i) == g || !map.containsKey(g) || map.get(g) <= 0)
                //secret doesnt contain guess letter or secret == guest or map.get(0) less than equals to 0 skip 1 iter
                continue;

            //Guess contains Secret letter >> decrease each letter,frequency(found letter in secret) increment cow
            map.put(g, map.get(g) - 1);
            cow++;
        }


        return String.format("%sA%sB", bull, cow);
    }


}
