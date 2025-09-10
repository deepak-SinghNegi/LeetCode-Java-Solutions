class Solution {
    public int findMin(int m, int n, int[][]Dp,int [][] grid){
        if(m==0&&n==0){
            return grid[0][0];
        }
       
        if(Dp[m][n]!=-1)return Dp[m][n];
        int up=(m>0)?findMin( m-1,  n,Dp,grid):Integer.MAX_VALUE;
        int left=(n>0)?findMin( m,  n-1,Dp,grid):Integer.MAX_VALUE;
        return Dp[m][n]=grid[m][n]+Math.min(left,up);
        
    }
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int [][] Dp = new int[row][col];
        for (int[] arr: Dp) {
            Arrays.fill(arr, -1);
            
        }
        return findMin(row-1, col-1, Dp, grid);
    }
}