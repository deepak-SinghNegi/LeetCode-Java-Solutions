class Solution {
    Integer Dp [][];
    int n = 0;
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        Dp = new Integer [n+1][n+1];
        return helper(nums, 0, -1);
    }

    private int helper(int[] nums, int i, int j) {
        if (i >= n) {
            return 0;
        }
        if(j < 0){
            int c1 = 1 + helper(nums, i + 1, i);
            int c2 = helper(nums, i + 1, j);
            return Dp[i][j+1] =  Math.max(c1, c2);
        }
        if(Dp[i][j+1] != null) return Dp[i][j+1];

        else if (nums[j] < nums[i]) {
            int c1 = 1 + helper(nums, i + 1, i);
            int c2 = helper(nums, i + 1, j);
            return Dp[i][j+1] =  Math.max(c1, c2);
        }
        return Dp[i][j+1] =  helper(nums, i + 1, j);

    }
}