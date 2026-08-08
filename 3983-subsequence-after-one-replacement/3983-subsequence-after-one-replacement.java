class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n > m)
            return false;
        if (n == 0)
            return true;

        int i = m - 1;
        int j = n - 1;
        int[] rhsMatch = new int[m + 1];
        while (i >= 0) {
            if (j >= 0 && t.charAt(i) == s.charAt(j)) {
                rhsMatch[i] = rhsMatch[i + 1] + 1;
                j--;
            } else {
                rhsMatch[i] = rhsMatch[i + 1];
            }
            i--;

        }
        i = j = 0;
        if (rhsMatch[0] == n)
            return true;
        boolean canChange = true;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            } else if (canChange && n - i - 1 <= rhsMatch[i + 1]) {
                canChange = false;
                i++;
            }
            j++;
        }
        return i >= n;
    }

}