class Solution {
    public int robbing(int[] nums , int i, int[]Dp){
        if(i>=nums.length)return 0;
        if(Dp[i]!=-1) return Dp[i];
        int steal =nums[i] + robbing(nums, i+2,Dp); 
        int skip = robbing(nums, i+1,Dp); 
        return Dp[i] = Math.max(skip,steal);
    }
    public int rob(int[] nums) {
        int [] Dp = new int[nums.length+1];
        Arrays.fill(Dp, -1);
        return robbing(nums, 0,Dp);
    }
}