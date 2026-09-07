class Solution {
    public int distinctSubseqII(String s) {
        int M = 1000_000_007;
        int n = s.length();
        
        int dup [] = new int [26];
        int prev [] = new int [n+1];
        int[]Dp = new int[n+1];
        Dp[0] = 1;
        for(int i = 1; i<=n;i++){
            int idx = s.charAt(i - 1) - 'a';
            prev[i] = dup[idx];
            dup[idx] =i; 
        }
        for(int i = 1; i<=n;i++){
            int total = (Dp[i -1]*2)%M;
            if(prev[i] != 0){
                total = (total - Dp[prev[i] - 1] + M) % M;
               
            }
            Dp[i] = total;
            
            
        }
       return (Dp[n] - 1 +M)%M;
    }
}