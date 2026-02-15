class Solution {
    public int minOperations(int[] nums) {
        int flip = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < i + 3 && i + 3 <= nums.length; j++) {
                    nums[j] = nums[j] > 0 ? 0 : 1;
                }
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