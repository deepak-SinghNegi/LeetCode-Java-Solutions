class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int f, int r) {
        while (f < r) {
            int temp = nums[f];
            nums[f] = nums[r];
            nums[r] = temp;
            f++;
            r--;
        }
    }
}