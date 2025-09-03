class Solution {
    // boolean canComplet(int []Dp,int indx,int[] nums){
    //     if(indx>=nums.length-1)return true;
    //     if(nums[indx]==0) return false;
    //     if(Dp[indx]!=-1) return Dp[indx]==1;
    //     for(int i=1;i<=nums[indx];i++){
    //        if (canComplet(Dp,indx+i,nums)){
    //         Dp[indx] = 1;
    //         return true;
    //        }
    //     }
    //     return false ;
    // }
    public boolean canJump(int[] nums) {
        // int [] Dp = new int [nums.length];
        // Arrays.fill(Dp,-1);
        // return canComplet(Dp , 0,nums) ;
        int maxReach = 0;
        for(int i=0;i<nums.length;i++){
            if(maxReach<i) return  false;
            maxReach = Math.max(maxReach,nums[i]+i);
            if(maxReach>=nums.length-1) return true;
        }
        return true;
    }
}