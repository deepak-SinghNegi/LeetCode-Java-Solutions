class Solution {
    public int paths(int n,int m, int[][]Dp){
        if(m==0||n==0) return 0;
        if(m==1||n==1) return 1;
        if(Dp[m][n]!=-1) return Dp[m][n];

        return Dp[m][n] = paths(n-1,m,Dp)+paths(n, m-1, Dp);
    }
    public int uniquePaths(int m, int n) {
         int[][] Dp = new int[n + 1][m + 1];
        for (int[] row : Dp) {
            Arrays.fill(row, -1);
        }
        return paths(m,n,Dp);
    }
}