 class Solution {
 public int ans(int n , int [] Dp){
      
       if(n==1) return 1;
       if(n==2) return 2;
       if(Dp[n]!=-1)return Dp[n];
       return Dp[n] = ans(n-2, Dp)+ans(n-1,Dp);
       
    }
    public int climbStairs(int n) {
        int [] Dp = new int [n+1];
        Arrays.fill(Dp,-1);
       return ans(n,Dp); 
    }
}