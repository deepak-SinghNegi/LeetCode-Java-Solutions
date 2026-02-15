class Solution {
    public int pivotInteger(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        for (int i = 1; i < n; i++) {
            nums[i] = i + 1;
            System.out.print(nums[i] + " ");
        }
        int l = 0;
        int r = n - 1;
        int lSum = nums[l];
        int rSum = nums[r];
        while (l < r) {
            if (rSum > lSum) {
                l++;
                lSum += nums[l];
            } else {
                r--;
                rSum += nums[r];
            }
        }
        return lSum == rSum ? l + 1 : -1;

    }
}