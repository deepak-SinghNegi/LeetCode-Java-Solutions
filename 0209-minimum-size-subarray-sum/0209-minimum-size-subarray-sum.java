class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int sum = 0;
        int minLen = -1;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {
                minLen = r - l + 1;
                sum -= nums[l++];
            }
        }
        return minLen == -1 ? 0 : minLen;
    }
}