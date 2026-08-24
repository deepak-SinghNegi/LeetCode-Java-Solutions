class Solution {
    int[] prefix;
    int n =0;
    Integer Dp[];
    public int stoneGameVIII(int[] stones) {
        n = stones.length;
        prefix = new int [n+1];
        Dp = new Integer [n+1];
        for(int i = 1; i <= n; i++){
            prefix[i] = stones[i-1]+prefix[i-1];
        } 
        return helper(2);
    }
    int helper(int i){
        if(i == n)
            return prefix[i];
        if(Dp[i] != null) return Dp[i];
        int take=  prefix[i] - helper(i+1);
        int skip = helper(i+1);
        return Dp[i] = Math.max(take , skip);
    }
}