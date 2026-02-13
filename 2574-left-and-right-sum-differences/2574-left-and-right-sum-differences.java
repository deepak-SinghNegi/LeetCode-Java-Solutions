class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0)
                ans[i] = nums[i];
            else
                ans[i] = ans[i - 1] + nums[i];

        }

        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1)
                right[i] = nums[i];
            else
                right[i] = right[i + 1] + nums[i];

            ans[i] = Math.abs(ans[i] - right[i]);
        }

        return ans;
    }
}