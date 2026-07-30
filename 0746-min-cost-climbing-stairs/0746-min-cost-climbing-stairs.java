class Solution {
    int n = 0;

    public int minCostClimbingStairs(int[] cost) {
        n = cost.length;
        int Dp[] = new int[n+1];
        Arrays.fill(Dp , -1);
        Dp[0] = cost[0];
        Dp[1] = cost[1];
        minCostClimbingStairsUtil(cost, n ,Dp);
        
        return Dp[n];
    }

    private int minCostClimbingStairsUtil(int[] cost, int i,  int[] Dp) {
        if (i < 0)
            return 0;
        if(Dp[i] !=-1) return Dp[i];
        int thisStCost = i == n ? 0 : cost[i];
        int cost1 =thisStCost + minCostClimbingStairsUtil(cost , i - 1 , Dp);
        int cost2 =thisStCost + minCostClimbingStairsUtil(cost , i - 2 , Dp);
        return Dp[i] =  Math.min(cost1, cost2);
    }
}