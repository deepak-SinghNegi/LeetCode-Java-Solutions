class Solution {
    int n = -1;
    int Dp[][][];

    public int stoneGameII(int[] piles) {
        n = piles.length;
        Dp = new int[2][n + 1][n + 1];
        for (int[][] mat : Dp) {
            for (int[] arr : mat) {
                Arrays.fill(arr, -1);
            }
        }
        return aliceScore(piles, 0, 0, 1);
    }

    private int aliceScore(int[] piles, int person, int i, int m) {
        if (i >= n)
            return 0;
        if (Dp[person][i][m] != -1)
            return Dp[person][i][m];
        int res = person == 0 ? -1 : Integer.MAX_VALUE;
        int stone = 0;
        for (int x = 1; x <= Math.min(n - i, m * 2); x++) {
            stone += piles[i + x - 1];
            if (person == 0) {
                res = Math.max(res, stone + aliceScore(piles, 1, i + x, Math.max(x, m)));
            } else {
                res = Math.min(res, aliceScore(piles, 0, i + x, Math.max(x, m)));
            }
        }
        return Dp[person][i][m] = res;
    }
}