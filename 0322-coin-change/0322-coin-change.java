
class Solution {
    public int MinCoin(int []arr,int amount ,int[] Dp){
        
          if (amount ==0){
            return 0;
        }
        if(amount<=-1) return Integer.MAX_VALUE;
        if(Dp[amount]!=-1) return Dp[amount];
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            int ref = MinCoin(arr,amount-arr[i],Dp);
            if(ref!=Integer.MAX_VALUE){
                    min = Math.min(ref+1,min);
            }

        }
        
        return Dp[amount]=min;
    }

    public int coinChange(int[] coins, int amount) {
        int[] Dp = new int[amount + 1];
        Arrays.fill(Dp, -1); 

         int ans = MinCoin(coins, amount, Dp);

        return (ans == Integer.MAX_VALUE) ? -1 : ans; 
    }
    
}



