class Solution {
    public double findMaxAverage(int[] nums, int k) {   if(nums.length==1)return nums[0];
        int val=0;
        for(int i=0;i<k;i++){
            val+=nums[i];
        }
        double ans = (double)val/k;
        for(int i=k;i<nums.length;i++){
            val = (val - nums[i-k])+nums[i];
            ans = Math.max((double)val/k,ans);
        }
       
    return ans;
    }
}