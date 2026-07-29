class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        if(n2 < n1){
            return findMedianSortedArrays(nums2 , nums1);
        }
        int low = 0;
        int high = n1 ;
        while(low <= high){
            int n1Part = low + (high - low)/2;
            int n2Part = (n1 + n2 + 1) / 2 - n1Part;
            int nums1Left = n1Part == 0 ? min : nums1[n1Part - 1];
            int nums1Right = n1Part >= n1 ? max : nums1[n1Part];
            int nums2Left = n2Part == 0 ? min : nums2[n2Part - 1]; 
            int nums2Right = n2Part >= n2 ? max : nums2[n2Part];

            if(nums1Left <= nums2Right && nums2Left <= nums1Right){
                if((n1 + n2) % 2 != 0){
                    return Math.max(nums1Left , nums2Left);
                }
                else{
                    return (Math.max(nums1Left , nums2Left) + Math.min(nums1Right , nums2Right))/2.0;
                }
            } 
            else if(nums1Left > nums2Right){
                high = n1Part - 1;
            }
            else{
                low = n1Part + 1;
            }
        }
        return 0.0;
    }
}