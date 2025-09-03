class Solution {
    boolean ans(int[] Dp,int [] nums,int indx){
        if(indx>=nums.length-1) return true;
        if(nums[indx]==0) return false;
        if(Dp[indx]!=-1) return Dp[indx]==1;
        for(int i=1;i<=nums[indx];i++){
            if(ans(Dp,nums,indx+i)){
                Dp[indx]=1;
                return true;
            }
        }
        return false;
    }
    public boolean canJump(int[] nums) {
        int[] Dp = new int [nums.length];
        Arrays.fill(Dp,-1);
        return ans(Dp,nums,0);
    }
}