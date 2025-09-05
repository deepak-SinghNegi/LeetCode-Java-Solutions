class Solution {
    public int findPath(int [][]Dp,int [][]nums,int n,int m){
        if(m<0||n<0)return  0;
        if(Dp[n][m]!=-1) return Dp[n][m];
        if(nums[n][m]==1)return 0 ;
        if(m==0&&n==0) return 1;
        
        

        

        return Dp[n][m] = findPath(Dp, nums, n-1, m)+findPath(Dp, nums, n, m-1);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid[0].length;
        int n = obstacleGrid.length;
        int[][]Dp = new int[n][m];
        for(int []row : Dp){
            Arrays.fill(row, -1);
        }
       return findPath(Dp, obstacleGrid,n-1,m-1); 
    }
}