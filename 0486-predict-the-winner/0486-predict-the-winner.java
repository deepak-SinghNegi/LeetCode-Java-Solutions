class Solution {

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        if (n <= 2)
            return true;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int p1 = pwUtil(nums, 0, n - 1, 0);
        return p1 >= sum - p1;

    }

    private int pwUtil(int[] nums, int i, int n, int p1) {

        if (i > n) {
            return 0;
        }
        int i_take = nums[i] + Math.min(pwUtil(nums, i + 2, n, p1), pwUtil(nums, i + 1, n - 1, p1));
        int n_take = nums[n] + Math.min(pwUtil(nums, i + 1, n - 1, p1), pwUtil(nums, i, n - 2, p1));
        ;

        return Math.max(i_take, n_take);

    }
}