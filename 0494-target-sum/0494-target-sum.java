class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums , target , 0 , 0);
    }
    private int helper(int [] nums , int target , int i , int sum){
        if(i >= nums.length){
            if(sum == target) return 1;
            else return 0;
        }
        return helper(nums , target , i +1 , sum - nums[i]) + helper(nums , target , i +1 , sum + nums[i]);  
    }
}