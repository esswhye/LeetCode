package dec2020;

//1492. The kth Factor of n
public class TheKthFactorOfN {
    public int kthFactor(int n, int k) {

        if (n == 1) {
            return k;
        }

        //List<Integer> factors = new ArrayList<>();

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                //factors.add(i);
                count++;
            }
            if (count == k) {
                return i;
            }
        }
        // if(k>factors.size()){
        //     return -1;
        // }

        //  return factors.get(k-1);
        return -1;
    }
}
