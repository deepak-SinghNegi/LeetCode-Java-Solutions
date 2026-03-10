class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxOr |= nums[i];
        }

        return helper(0, nums, maxOr, 0);
    }

    private int helper(int i, int[] nums, int target, int val) {
        if (i == nums.length) {
            if (val != target)
                return 0;
            if (val == target) {
                return 1;
            }
        }
        int newVal = val | nums[i];
        return helper(i + 1, nums, target, newVal) + helper(i + 1, nums, target, val);

    }
}