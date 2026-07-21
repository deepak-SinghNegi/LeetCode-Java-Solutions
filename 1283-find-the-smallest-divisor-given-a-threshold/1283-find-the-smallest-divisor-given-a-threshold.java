class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int low = 1;
        int high = 0;

        for (int num : nums)
            high = Math.max(high, num);

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isPossible(mid, nums, threshold))
                high = mid - 1;
            else
                low = mid + 1;
        }

        return low;
    }

    private boolean isPossible(int div, int[] nums, int threshold) {

        int sum = 0;

        for (int num : nums) {

            sum += (num + div - 1) / div;

            if (sum > threshold)
                return false;
        }

        return true;
    }
}