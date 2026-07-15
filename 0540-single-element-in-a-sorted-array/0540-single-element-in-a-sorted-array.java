class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        if(nums.length == 1) return nums[0];
        if(nums[0]!=nums[1]) return nums[0];
        if(nums[r] != nums[r-1]) return nums[r];
        while(l<=r){
            int mid = l +(r-l)/2;
          
            if( nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])return nums[mid];
            else if((mid%2==1 && nums[mid] == nums[mid-1]) || (mid%2==0 && nums[mid] == nums[mid + 1])) l = mid+1;
            else r = mid-1;
        }
    return -1;
    }
}