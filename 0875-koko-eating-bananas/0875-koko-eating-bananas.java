class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = -1;
        for (int val : piles) {
            right = Math.max(right, val);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEat(mid, piles, h)) {

                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean canEat(int k, int[] arr, int h) {
        int hr = 0;
        for (int i = 0; i < arr.length; i++) {

            hr += (arr[i] + k - 1) / k;
            if (hr > h)
                return false;

        }
        return true;
    }
}