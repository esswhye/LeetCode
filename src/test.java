public class test {
    public static void main(String[] args) {
        //System.out.println(rec(9));
        System.out.println(Math.pow(10,2));
        System.out.println(4%2);
    }

    public static int rec(int n) {
        if (n <= 1) {
            return n;
        }
        n = rec(n - 1) + rec(n - 2);

        return n;


    }
}
