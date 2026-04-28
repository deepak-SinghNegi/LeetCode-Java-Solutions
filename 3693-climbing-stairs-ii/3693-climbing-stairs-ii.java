class Solution {
    int cost = Integer.MAX_VALUE;

    public int climbStairs(int n, int[] costs) {
        Integer Dp[]= new Integer [n+1];
        int arr[] = new int [n +1];
        for(int i = 1; i<arr.length; i++){
            arr[i] = costs[i-1];
        }
       return  helper(n, arr, 0 , Dp);
        
    }
    int helper(int n , int[] costs , int i , Integer [] Dp){
        if(i >=n)return 0;
        if(Dp[i] != null) return Dp[i];
        int minCost = Integer.MAX_VALUE;
        for(int j = 1; j<= 3; j++){
            if (i + j > n) continue;
            int x = costs[i+j] + j*j + helper(n , costs , i+j , Dp);

            minCost =  Math.min(minCost , x);
        }
     return Dp[i] = minCost;
    }

    
}