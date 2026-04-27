class Solution {
    public int climbStairs(int n) {
        int[] Dp = new int[n+1];
        
        return helper(n , Dp);
    }
    int helper(int n , int Dp[]){
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(Dp[n] != 0) return Dp[n];

        return Dp[n] = helper(n - 1 , Dp) + helper(n - 2 , Dp);
    }
}