class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n == 0) return true;
        int Dp [][] = new int [n+1][m+1];
        for(int i = 1; i<=n;i++){
            for(int j = 1; j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1))
                    Dp[i][j] = 1 + Dp[i-1][j-1];
                else{
                    Dp[i][j] = Math.max(Dp[i-1][j] , Dp[i][j-1]);
                }
                if(Dp[i][j] == n)return true;
            }
        }
        return false;
    }
}