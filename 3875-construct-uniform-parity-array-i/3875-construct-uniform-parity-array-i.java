class Solution {
    int nums2[];
    int n;

    public boolean uniformArray(int[] nums1) {
        n = nums1.length;
        nums2 = new int[n];
        boolean canEven = true;
        boolean canOdd = true;
        for (int i = 0; i < n; i++) {
            canEven &= even(nums1, nums1[i], i);
            canOdd &= odd(nums1, nums1[i], i);
        }
        return canEven || canOdd;

    }

    private boolean even(int[] nums1, int val, int idx) {
        for (int i = 0; i < n; i++) {
            if (i == idx)
                continue;
            if (nums1[idx] % 2 == 0)
                return true;
            else if ((nums1[idx] - nums1[i]) % 2 == 0)
                return true;
        }
        return nums1[idx] %2 == 0;
    }

    private boolean odd(int[] nums1, int val, int idx) {
        for (int i = 0; i < n; i++) {
            if (i == idx)
                continue;
            if (nums1[idx] % 2 != 0)
                return true;
            else if ((nums1[idx] - nums1[i]) % 2 != 0)
                return true;
        }
        return nums1[idx] %2 != 0;
    }
}