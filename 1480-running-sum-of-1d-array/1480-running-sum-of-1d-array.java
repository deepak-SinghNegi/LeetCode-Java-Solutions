class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] running = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0)
                running[i] = nums[i];
            else
                running[i] = running[i - 1] + nums[i];

        }
        return running;
    }
}