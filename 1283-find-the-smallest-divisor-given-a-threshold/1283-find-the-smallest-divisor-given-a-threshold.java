class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 1000000;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sdUtil(mid, nums, threshold)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean sdUtil(int div, int[] nums, int thrs) {
        int sum = 0;
        for (int num : nums) {
            if (num % div == 0)
                sum += (num / div);
            else
                sum += ((num / div) + 1);
        }

        return sum <= thrs;
    }
}