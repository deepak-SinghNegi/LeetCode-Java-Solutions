class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int minArr[] = new int[n];
        int maxArr[] = new int[n];
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < n; i++) {
            maxArr[i] = max = Math.max(max, nums[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            minArr[i] = min = Math.min(min, nums[i]);
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (maxArr[i] - minArr[i] <= k)
                ans = ans == -1 ? i : Math.min(ans , i);
        }
        return ans;
    }
}