package dec2020;


import java.util.HashMap;
import java.util.Map;


//1010. Pairs of Songs With Total Durations Divisible by 60
public class PairsOfSongWithTotalDurationsDivisible {
    public static void main(String[] args) {

    }

    public int numPairsDivisibleBy60(int[] time) {

        int count = 0;

        Map<Integer, Integer> partners = new HashMap<>();
        for (int pieceTime : time) {
            int t = pieceTime % 60;

            if (t == 0) {
                count += partners.getOrDefault(t, 0);
            } else {
                count += partners.getOrDefault(60 - t, 0);
            }
            partners.put(t, partners.getOrDefault(t, 0) + 1);

        }

        return count;
    }
}
