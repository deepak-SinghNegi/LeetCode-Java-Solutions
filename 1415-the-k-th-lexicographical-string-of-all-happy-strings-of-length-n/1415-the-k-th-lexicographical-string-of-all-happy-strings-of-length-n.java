class Solution {
    int count = 0;
    String ans = "";

    public String getHappyString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        helper(sb , n , k , '\0');
        return ans;
    }

    private void helper(StringBuilder sb, int n, int k, char prev) {
        if (!ans.equals(""))
            return;
        if (sb.length() >= n) {
            count++;
            if (count == k) {
                ans = sb.toString();
            }
            return;

        }
        for (char ch : new char[] { 'a', 'b', 'c' }) {
            if (ch == prev)
                continue;

            sb.append(ch);
            helper(sb, n, k, ch);
            sb.deleteCharAt(sb.length() - 1);

        }

    }
}