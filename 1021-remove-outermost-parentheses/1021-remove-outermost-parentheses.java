class Solution {
    public String removeOuterParentheses(String s) {
        int i = 0;
        int j = 0;
        int l = 0;
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < s.length(); r++) {
            if (s.charAt(r) == '(')
                i++;
            else
                j++;
            if (i == j) {
                sb.append(s.substring(l + 1, r));
                i = 0;
                j = 0;
                l = r + 1;
            }
        }
        return sb.toString();
    }
}