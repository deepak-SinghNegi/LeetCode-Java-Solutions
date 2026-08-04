class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int n = Math.min(word1.length(), word2.length());
        int i = 0;
        int j = 0;
        while (i < n && j < n) {

            sb.append(word1.charAt(i++));

            sb.append(word2.charAt(j++));
        }
        while (i < word1.length())
            sb.append(word1.charAt(i++));
        while (i < word2.length())
            sb.append(word2.charAt(i++));

        return sb.toString();
    }
}