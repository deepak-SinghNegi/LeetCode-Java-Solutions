class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        Integer Dp[] = new Integer[n];

        Dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (Dp[j] != null && Math.abs(nums[i] - nums[j]) <= target) {
                    Dp[i] = Dp[i] == null ? Dp[j] + 1 : Math.max(Dp[i], Dp[j] + 1);
                }
            }
        }
        return Dp[0] == null ? -1 : Dp[0];
    }
}