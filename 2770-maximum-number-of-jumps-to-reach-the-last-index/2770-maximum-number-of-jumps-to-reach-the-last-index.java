class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] Dp = new int[n];
        Arrays.fill(Dp, -2);
        Dp[n - 1] = 0;
        return helper(nums, Dp, target, 0);
    }

    private int helper(int[] nums, int[] Dp, int t, int i) {
        if (Dp[i] != -2)
            return Dp[i];
        int ans = -1;
        for (int j = i + 1; j < nums.length; j++) {
            if (Math.abs(nums[i] - nums[j]) <= t) {
                int next = helper(nums, Dp, t, j);
                if (next != -1) {
                    ans = Math.max(ans, 1 + next);
                }
            }
        }
        return Dp[i] = ans;
    }
}