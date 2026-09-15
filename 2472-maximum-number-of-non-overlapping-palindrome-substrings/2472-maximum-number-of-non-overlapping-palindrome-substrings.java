import java.util.Arrays;

class Solution {
    private Integer[] memo;

    public int maxPalindromes(String s, int k) {
        memo = new Integer[s.length()];
        return helper(s, k, 0);
    }

    private int helper(String s, int k, int idx) {
        if (idx >= s.length()) {
            return 0;
        }
        if (memo[idx] != null) {
            return memo[idx];
        }

        int ans = helper(s, k, idx + 1);

        for (int len = k; len <= k + 1 && idx + len <= s.length(); len++) {
            if (isPalindrome(s, idx, idx + len - 1)) {
                ans = Math.max(ans, 1 + helper(s, k, idx + len));
                break;
            }
        }

        return memo[idx] = ans;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}