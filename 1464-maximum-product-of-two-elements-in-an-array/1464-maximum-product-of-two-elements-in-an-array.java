class Solution {
    public int maxProduct(int[] nums) {

        int val1 = 0;
        int val2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 > val1) {
                val2 = val1;
                val1 = nums[i] - 1;
            } else if (nums[i] - 1 > val2) {
                val2 = nums[i] - 1;
            }
        }
        return val1 * val2;
    }
}