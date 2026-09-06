class Solution {
    int Dp[][];

    public int numDistinct(String s, String t) {
        Dp = new int[s.length() + 1][t.length()+1];
        for(int [] arr : Dp){
            Arrays.fill(arr , -1);
        }
        
        return helper(s , t , 0 , 0);
    }

    private int helper(String s, String t, int i, int j) {
        if (j == t.length()) {
                return 1;
            
        }
        if (i >= s.length())
            return 0;
        if (Dp[i][j] != -1)
            return Dp[i][j];
        if (s.charAt(i) == t.charAt(j)) {
            int val1 = helper(s, t, i + 1, j + 1);
            int val2 = helper(s, t, i + 1, j);
            return Dp[i][j] = val1 + val2;
        }
        return Dp[i][j] = helper(s, t, i + 1, j);
    }
}