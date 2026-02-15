class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int flip = 0;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) {
                nums[i] = 1;
                nums[i + 1] = nums[i + 1] > 0 ? 0 : 1;
                nums[i + 2] = nums[i + 2] > 0 ? 0 : 1;

                flip++;
            }
        }
    
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums[n - 1] == n ? flip : -1;
    }
}