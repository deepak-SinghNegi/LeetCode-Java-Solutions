class Solution {
     public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int [] rhsMatch = new int[n + 1];
        int j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                rhsMatch[i] = rhsMatch[i + 1] + 1;
                j--;
            }
            else{
                rhsMatch[i] = rhsMatch[i+1];
            }
        }
        int i = j = 0;
        boolean canChange = true;
        int[] seq = new int[m];

        while (i < n) {
            if (word1.charAt(i) == word2.charAt(j)) {
                seq[j++] = i;
            } else if (canChange && rhsMatch[i + 1] >= m - j - 1) {
                canChange = false;
                seq[j++] = i;
            }
            i++;
            if (j >= m)
                return seq;

        }
        return j >= m ?seq: new int[] {};
    }
}