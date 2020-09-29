package dp;


//Combinatories
public class ClimbingStairs {

    /*
    Problem:
        Climbing Stairs

        You are climbing a starcase. It takes n steps to reach to the top.
        Each time you can either climb 1 or 2 steps.
        In how many distinct ways can you climb to the top?
     */

    /*
        1 Define Objective function
            f(i) is the number of distinct ways to reach the i-th stair.
        2 Identify Base Cases
            f(0) = 1, f(1) = 1
        3 Recurrence Relation
            f(n) = f(n-1) + f(n-2)
        4 Order of Computation
            bottom-up
        5 Location of the ans
    */

    public static void main(String[] args) {
        System.out.println(climbingStairs(9));
        System.out.println(climbingStairsV3(9, 2));
        System.out.println(climbStairsKStepsSkipRed(7, 3, new boolean[]{false, true, false, true, true, false, false, false}));
        System.out.println(paidStaircaseV2(3, new int[]{0, 3, 2, 4}));

    }

    public static int climbingStairs(int n) {
        //TC = O(n)
        //SC = 0(n)
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int climbingStairsV2(int n) {
        //TC = O(n)
        //SC = 0(1)
        //[1,1,2,3]
        // a,b,c
        //   a,b,c
        int[] dp = new int[n + 1];
        int a = 1;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return dp[n];
    }

    //3 Step
    /*
        1 Define Objective function
            f(i) is the number of distinct ways to reach the i-th stair.
        2 Identify Base Cases
            f(0) = 1, f(1) = 1, f(2) = 2
        3 Recurrence Relation
            f(n) = f(n-1) + f(n-2) + f(n-3)
        4 Order of Computation
            bottom-up
        5 Location of the ans
    */
    public static int climbingStairsV3(int n) {
        //TC = O(n)
        //SC = 0(n)
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    //k th Step
    /*
        1 Define Objective function
            f(i) is the number of distinct ways to reach the i-th stair by making 1 to k th step.
        2 Identify Base Cases
            f(0) = 1, f(1) = 1,
        3 Recurrence Relation
            f(n) = f(n-1) + f(n-2) + f(n-3)
        4 Order of Computation
            bottom-up
        5 Location of the ans
    */
    public static int climbingStairsV3(int n, int k) {
        //TC = O(nk)
        //SC = 0(n)
        int[] dp = new int[k];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < k; j++) {
                if (i - j < 0) {
                    continue;
                }
                dp[i % k] += dp[(i - j) % k];
            }
        }
        return dp[n % k];
    }


    /*
    Problem:
        Climbing Stairs (k steps, space optimized, skip red steps)

        You are climbing a stair case. It takes n step to reach to the top.
        Each time you can climb 1..k steps. You are not allowed to step on red stairs.
        In how many distinct ways can you climb to the top?


     */
    public static int climbStairsKStepsSkipRed(int n, int k, boolean[] stairs) {

        int[] dp = new int[k];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < k; j++) {
                if (i - j < 0) {
                    continue;
                }
                if (stairs[i - 1]) {
                    dp[i % k] = 0;
                } else {
                    dp[i % k] += dp[(i - j) % k];
                }

            }
        }
        return dp[n % k];
    }

    /*
    Problem:
        Paid Staircase

        You are climbing a paid staircase. It takes n steps to reach to the top and you have to pay p[i] to step on the i-th stair.
        Each time you can climb 1 or 2 steps.
        What's the cheapest amount you have to pay to get to the top of the staircase?

        1 Define Objective function
            f(n) is the total price to pay to reach the i-th stair by making 1 to k th step.
        2 Identify Base Cases
            f(0) = 0 , f(1) = p[1],
        3 Recurrence Relation
            f(n) = f(n) + min(f(n-1),f(n-2))
        4 Order of Computation
            bottom-up
        5 Location of the ans
            f(n)
     */

    public static int paidStaircase(int n, int[] p) {

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = p[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = p[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return dp[n];
    }


    public static int paidStaircaseV2(int n, int[] p) {
        //SC = O(1)
        //int[] dp = new int[n + 1];
        int a = 0;
        int b = p[1];
        int c = 0;
        for (int i = 2; i <= n; i++) {
            c = p[i] + Math.min(a, b);
            a = b;
            b = c;
        }

        return c;
    }

}

/*
    getArrayB = john_cut(A)
    BST node = new BST(getArrayB)
    return BSTlookup(node);
 */
