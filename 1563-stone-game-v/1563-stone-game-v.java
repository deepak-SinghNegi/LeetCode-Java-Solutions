class Solution {
    int[][] Dp;

    public int stoneGameV(int[] stoneVal) {
        int n = stoneVal.length;
        Dp = new int[n + 1][n + 1];
        for (int[] arr : Dp) {
            Arrays.fill(arr, -1);
        }
        int prefix[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + stoneVal[i - 1];
        }
        return helper(prefix, 1, n);
    }

    private int helper(int prefix[], int l, int r) {
        if (l == r)
            return 0;
        if (Dp[l][r] != -1)
            return Dp[l][r];
        int sum = 0;
        for (int mid = l; mid < r; mid++) {
            int leftSum = prefix[mid] - prefix[l - 1];
            int rightSum = prefix[r] - prefix[mid];
            if (leftSum < rightSum) {
                sum = Math.max(leftSum + helper(prefix, l, mid), sum);
            } else if (rightSum < leftSum) {
                sum = Math.max(rightSum + helper(prefix, mid + 1, r), sum);
            } else {
                sum = Math.max(sum, Math.max(helper(prefix, l, mid), helper(prefix, mid + 1, r)) + leftSum);
            }
        }
        return Dp[l][r] = sum;
    }
}