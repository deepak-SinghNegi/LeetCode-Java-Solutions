class Solution {
    int[][] Dp ;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int sum = 0;
        for (int stn : piles) {
            sum += stn;
        }
        Dp = new int [n+1][n+1];
        int alice = helper(piles, 0, n - 1);
        return alice > sum - alice;
    }

    private int helper(int[] piles, int i, int j) {
        if (i > j) {
            return 0;
        }
        if(Dp[i][j] != 0) return Dp[i][j];
        int s_take = piles[i] + Math.min(helper(piles, i + 2, j), helper(piles, i + 1, j - 1));
        int e_take = piles[j] + Math.min(helper(piles, i + 1, j - 1), helper(piles, i, j - 2));
        return Dp[i][j] =  Math.max(s_take, e_take);
    }
}