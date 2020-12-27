package dec2020;

import java.util.HashMap;

//91.
public class DecodeWays {

    int result = 0;
    HashMap<String, Integer> map = null;

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();

        decodeWays.numDecodings("226");
        System.out.println();
    }

    public int numDecodings(String s) {
        map = new HashMap<>();
        find(s);
        return result;
    }

    private void find(String s) {
        if (s.startsWith("0")) {
            return;
        }
        if (s.length() <= 1) {
            result++;
            return;
        }
        if (map.containsKey(s)) {
            result += map.get(s);
            return;
        }

        for (int i = 0; i < Math.min(2, s.length()); i++) {
            int val = Integer.parseInt(s.substring(0, i + 1));
            if (val >= 1 && val <= 26) {
                find(s.substring(i + 1));
            }
            map.put(s.substring(i + 1), result);
        }
    }
}
