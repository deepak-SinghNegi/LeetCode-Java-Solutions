class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int m = nums.length;
        int t = 0;
        for(int i : nums) t+=i;
        int Dp[][]  = new int[m+1][t*2+1];
        for(int [] arr : Dp){
            Arrays.fill(arr , -1);
        }
        return findTargetSumWaysUtil(nums , Dp , target , 0 , 0,Dp[0].length / 2);
    }
    private int findTargetSumWaysUtil(int []nums , int [][] Dp , int target , int currSum ,int i , int t){
        if(i >= nums.length ) 
        return (currSum == target) ? 1 : 0;
        if(Dp[i][currSum +t] !=-1) return Dp[i][currSum +t];
        return Dp[i][currSum +t] = findTargetSumWaysUtil(nums , Dp , target , currSum + nums[i] , i+1 , t) +  findTargetSumWaysUtil(nums , Dp , target , currSum - nums[i] , i+1 , t); 
    }
}