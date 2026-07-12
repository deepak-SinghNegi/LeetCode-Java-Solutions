class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (m < n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0;
        int high = n;

        while (low <= high) {
            int partitionX = low + (high - low) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;
            int leftS = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int rightS = partitionX >= n ? Integer.MAX_VALUE : nums1[partitionX];
            int leftL = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int rightL = partitionY == m ? Integer.MAX_VALUE : nums2[partitionY];
            if (leftS <= rightL && leftL <= rightS) {
                if ((m + n) % 2 != 0)
                    return Math.max(leftS, leftL);
                else {
                    return (Math.max(leftS, leftL) + Math.min(rightS, rightL)) / 2.0;
                }
            } else if (leftS > rightL) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        return 0.0;
    }
}