class Solution {
    public boolean isMatch(String s, String p) {
        Boolean [][] Dp = new Boolean[s.length()][p.length()];
        return helper(s, p, 0, 0, Dp);
    }

    boolean helper(String s, String p, int i, int j , Boolean[][] Dp) {
        if (i >= s.length() && j >= p.length())
            return true;
        if (j == p.length())
            return false;
        if (i == s.length()) {
            while (j < p.length()) {
                if (p.charAt(j) != '*')
                    return false;
                j++;
            }
            return true;
        }
        if(Dp[i][j] != null) return Dp[i][j];

        char chs = s.charAt(i);
        char chp = p.charAt(j);
        if (chp == chs || chp == '?') {
            return Dp[i][j] = helper(s, p, i + 1, j + 1 , Dp);
        }
        if (chp == '*') {

            return Dp[i][j] = helper(s, p, i, j + 1 , Dp) || helper(s, p, i + 1, j , Dp);

        }
        return false;
    }
}