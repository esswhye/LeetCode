package septchallenge;

import java.util.*;

public class BullsAndCows {
    public static void main(String[] args) {

        //System.out.println(getHint("1807", "7810"));
        //System.out.println(getHint("1123", "0111"));
        System.out.println(getHintV2("11", "10"));
        System.out.println(getHintV2("8578605648", "3675352465"));

    }

    public static String getHint(String secret, String guess) {

        //Digits 0-9 add frequency
        int s[] = new int[9];

        int g[] = new int[9];

        int bull = 0;
        int cow = 0;

        for (int i = 0; i < secret.length(); i++) {
            char cs = secret.charAt(i);
            char cg = guess.charAt(i);
            if (cs == cg) {
                bull++;
            } else {
                s[cs - '0']++;
                g[cg - '0']++;
            }
        }

        for (int i = 0; i < guess.length(); i++) {
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
