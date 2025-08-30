class Solution {
    public int maxSubArray(int[] nums) {

        int maximumSubarray = nums[0];
        int sum=nums[0];
        int left = 0;
        for(int right=1;right<nums.length;right++){
            if(nums[right]>sum+nums[right]){
                left = right;
                sum = nums[right];
            }
            else{
                sum+=nums[right];
            }
            maximumSubarray = Math.max(sum,maximumSubarray);

        }
        return maximumSubarray;
    }
}