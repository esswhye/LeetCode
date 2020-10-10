public class test {
    public static void main(String[] args) {
        //System.out.println(rec(9));
        //System.out.println(Math.pow(10, 2));
        // System.out.println(4 % 2);
//        System.out.println(5 ^ 25);
//        String hello = "GGAG";
//        long occ = hello.chars().filter(ch -> ch == 'G').count();
//        System.out.println(22 % 4);
//        System.out.println(10 % 7);
        reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});

    }

    public static int rec(int n) {
        if (n <= 1) {
            return n;
        }
        n = rec(n - 1) + rec(n - 2);

        return n;
    }

    public String search(int[] A, int target) {
        int start = 0, end = A.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (A[mid] == target)
                return "yes";

            if (A[start] <= A[mid]) {
                if (target >= A[start] && target < A[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            if (A[mid] <= A[end]) {
                if (target > A[mid] && target <= A[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return "no";
    }

    public static void reverseString(char[] s) {

        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[(s.length - 1) - i];
            s[(s.length - 1) - i] = temp;

        }
        System.out.println(s);
    }
}
