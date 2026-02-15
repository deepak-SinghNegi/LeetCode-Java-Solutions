class Solution {
    public int minOperations(int[] nums) {
        int flip = 0;
        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i] == 0) {
                    nums[i] = 1;
                    nums[i+1] = nums[i+1] > 0 ? 0 : 1;
                    nums[i+2] = nums[i+2] > 0 ? 0 : 1;
                
                flip++;
            }
        }
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum == nums.length ? flip : -1;
    }
}