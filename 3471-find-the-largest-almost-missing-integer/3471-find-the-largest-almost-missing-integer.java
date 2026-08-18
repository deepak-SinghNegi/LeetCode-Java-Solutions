class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[51];
        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }
        if (k == 1) {
            int max = -1;
            for (int i = 0; i < n; i++) {
                if (nums[i] > max && freq[nums[i]] == 1) {
                    max = nums[i];
                }

            }
            return max;
        } else if (k == n) {
            int max = -1;
            for (int i = 0; i < n; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }

            }
            return max;
        } else {
            int f = 0;
            int e = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] == nums[0])
                    f++;
                if (nums[i] == nums[n - 1])
                    e++;

            }
            if (f > 1 && e == 1)
                return nums[n - 1];
            if (f == 1 && e > 1)
                return nums[0];
            return f == 1 && e == 1 ? Math.max(nums[0], nums[n - 1]) : -1;
        }
    }
}