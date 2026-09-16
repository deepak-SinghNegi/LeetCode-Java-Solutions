class Solution {

    static final int MOD = 1_000_000_007;

    Integer[][][] dp;

    public int numberOfSets(int n, int k) {

        dp = new Integer[n][k + 1][2];

        return helper(0, k, 0, n);
    }

    private int helper(int i, int k, int drawing, int n) {

        if (k == 0) {
            return 1;
        }

     
        if (i == n) {
            return 0;
        }

        if (dp[i][k][drawing] != null) {
            return dp[i][k][drawing];
        }

        long ans;

        if (drawing == 1) {

          
            long continueSegment =
                    helper(i + 1, k, 1, n);

            long endSegment =
                    helper(i, k - 1, 0, n);

            ans = (continueSegment + endSegment) % MOD;

        } else {

           
            long skip =
                    helper(i + 1, k, 0, n);

           
            long start =
                    helper(i + 1, k, 1, n);

            ans = (skip + start) % MOD;
        }

        return dp[i][k][drawing] = (int) ans;
    }
}