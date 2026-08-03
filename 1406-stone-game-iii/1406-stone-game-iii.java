class Solution {
    int n = 0;
    int Dp[];
    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;
        Dp = new int[n+1];
        Arrays.fill(Dp , -1);
        int diff = helper(stoneValue, 0);
        return diff > 0 ? "Alice" : diff < 0 ? "Bob" : "Tie";
    }

    private int helper(int[] sv, int i) {
        if (i >= n)
            return 0;

        if(Dp[i]!=-1)return Dp[i];
        int res = Integer.MIN_VALUE;
        int take_one = sv[i] - helper(sv, i + 1);
        res = Math.max(take_one, res);
        if (i + 1 < n) {
            int take_two = sv[i] + sv[i + 1] - helper(sv, i + 2);
            res = Math.max(take_two, res);
        }
        if (i + 2 < n) {
            int take_three = sv[i] + sv[i + 1] + sv[i + 2] - helper(sv, i + 3);
            res = Math.max(take_three, res);
        }
        return Dp[i] =  res;
    }
}