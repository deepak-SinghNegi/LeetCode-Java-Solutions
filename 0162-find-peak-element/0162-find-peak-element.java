class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1)return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[nums.length-1] > nums[nums.length - 2]) return nums.length -1;
        int l = 0;
        int r = nums.length - 1;
        while(l <=r){
            int mid  = l +(r-l)/2;
            if(mid>0 && mid < nums.length-1 &&nums[mid] >nums[mid -1] && nums[mid] > nums[mid+1]) return mid;
            else if(nums[mid+1] > nums[mid]){
                l = mid+1;
            }
            else if(nums[mid+1] < nums[mid]) r= mid-1;

        }
        return -1;
    }
}