class Solution {
    public int uniquePaths(int m, int n) {
        int [][] memo = new int[m+1][n+1];
        
        for(int i = 0; i< n;i++) memo[0][i] = 0;
        for(int i = 0; i< m;i++) memo[i][0] = 0;
        memo[1][1] = 1;
        return helper(memo , m , n);
    }
    private int helper(int[][] memo , int m , int n){
        if(m==0 || n == 0 ) return memo[m][n];
        if(m ==1 && n == 1) return memo[m][n];
        if(memo[m][n] != 0) return memo[m][n];

        memo[m][n] = helper( memo ,m-1 , n) + helper(memo , m, n-1);
        return memo[m][n];
    }
}