class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] Dp = new int[amount + 1];
        Arrays.fill(Dp , -1);
        int ans = minCoins(coins , amount , Dp);
        return ans != Integer.MAX_VALUE ?  ans :  -1;

    }
    private int minCoins(int []coins , int amount , int[]Dp){
        if(amount == 0)return 0;
        if(amount<0) return Integer.MAX_VALUE;
        if(Dp[amount] !=-1) return Dp[amount];
        int min  = Integer.MAX_VALUE;
        for(int i = 0; i<coins.length;i++){
            int val = minCoins(coins , amount - coins[i] , Dp);
            if(val != Integer.MAX_VALUE){
                min = Math.min(min , val+1);
            }
        }
        return Dp[amount] = min;
    }
}