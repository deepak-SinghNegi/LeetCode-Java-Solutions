class Solution {

    private boolean isPalindrome(String s, int i, int j, Boolean[][] dp) {
        if (i >= j) return true;

        if (dp[i][j] != null) return dp[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = isPalindrome(s, i + 1, j - 1, dp);
        }

        return dp[i][j] = false;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        Boolean[][] dp = new Boolean[n][n];

        String longest = "";

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= i; j--) {

                if (isPalindrome(s, i, j, dp)) {
                    if (j - i + 1 > longest.length()) {
                        longest = s.substring(i, j + 1);
                    }
                }
            }
        }
        return longest;
    }
}