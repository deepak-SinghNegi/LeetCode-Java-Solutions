class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return lcsUtil(s1, s2, dp, m - 1, n - 1);
    }

    private int lcsUtil(String s1, String s2, int[][] dp, int m, int n) {
        if (m < 0 || n < 0)
            return 0;
        if (dp[m][n] != -1)
            return dp[m][n];
        if (s1.charAt(m) == s2.charAt(n)) {
            return dp[m][n] = lcsUtil(s1, s2, dp, m - 1, n - 1) + 1;
        } else {
            return dp[m][n] = Math.max(lcsUtil(s1, s2, dp, m - 1, n), lcsUtil(s1, s2, dp, m, n - 1));
        }
    }
}