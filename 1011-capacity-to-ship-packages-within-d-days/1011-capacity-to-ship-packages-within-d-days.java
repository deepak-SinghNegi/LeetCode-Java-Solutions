class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int val : weights) {
            left  = Math.max(left , val);
            right += val;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(mid, weights, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean canShip(int k, int[] arr, int d) {
        int day = 1;
        int cw = 0;
        for (int w : arr) {
            if (cw + w > k) {
                day++;
                cw = 0;
            }
            cw += w;
            if (day > d)
                return false;

        }
        return true;
    }
}