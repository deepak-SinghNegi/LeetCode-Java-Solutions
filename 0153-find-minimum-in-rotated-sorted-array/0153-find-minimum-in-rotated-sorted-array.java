class Solution {
    public int findMin(int[] nums) {
        int l = 0; int r = nums.length - 1;
        int min = nums[0];
        while(l <= r){
            int m = l+(r-l)/2;
            if(nums[m] < nums[l]){
                min = min < nums[m] ? min : nums[m];
                r = m- 1;
            }
            else {
                min = min < nums[l] ? min : nums[l];
                l = m + 1;
            }
        }
        return min;
    }
}