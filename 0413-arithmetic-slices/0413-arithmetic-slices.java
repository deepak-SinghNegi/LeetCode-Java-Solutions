class Solution {
    public int numberOfArithmeticSlices(int[] nums) {

        int n = nums.length;

        if (n < 3)
            return 0;

        int l = 0;
        int count = 0;

        for (int r = 2; r < n; r++) {

            int d1 = nums[r] - nums[r - 1];
            int d2 = nums[r - 1] - nums[r - 2];

            if (d1 != d2) {

                int x = r - l;

                if (x >= 3)
                    count += (x - 2) * (x - 1) / 2;

                l = r - 1;
            }
        }

        int x = n - l;

        if (x >= 3)
            count += (x - 2) * (x - 1) / 2;

        return count;
    }
}