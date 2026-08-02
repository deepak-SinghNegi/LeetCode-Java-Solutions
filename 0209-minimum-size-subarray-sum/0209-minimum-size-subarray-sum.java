class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minSize = nums.length;
        int l = 0;
        int sum = 0;
        boolean flag = false;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {
                flag = true;
                minSize = Math.min(minSize, r - l + 1);
                sum -= nums[l++];
            }
        }
        return flag ? minSize : 0;
    }
}