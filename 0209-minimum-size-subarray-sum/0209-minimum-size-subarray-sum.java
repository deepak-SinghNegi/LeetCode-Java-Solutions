class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 1;
        int r = nums.length;
        int[] prifix = new int[nums.length];
        prifix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prifix[i] = nums[i] + prifix[i - 1];
        }
        if(prifix[r-1] < target) return 0;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (canSub(prifix, mid, target)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        return r;
    }

    private boolean canSub(int[] prifix, int mid, int target) {
        int sum = 0;
        for (int i = 0; i + mid <= prifix.length; i++) {
            int r = i + mid - 1;
            sum = i == 0 ? prifix[r] : prifix[r] - prifix[i - 1];
            if (sum >= target) {
                return true;
            }

        }
        return false;
    }
}