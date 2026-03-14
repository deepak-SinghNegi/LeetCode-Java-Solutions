class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int sum = 0;
        int minLen = nums.length +1;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {
                minLen = Math.min(r - l + 1 , minLen);
                sum -= nums[l++];
            }
        }
        return minLen == nums.length +1 ? 0 : minLen;
    }
}